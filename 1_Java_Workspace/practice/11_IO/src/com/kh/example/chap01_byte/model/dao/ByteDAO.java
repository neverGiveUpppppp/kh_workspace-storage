package com.kh.example.chap01_byte.model.dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteDAO {
	public void fileOpen() {
		// 기반 & 보조 스트림 클래스 찾는 법
		// 파일로부터 byte단위로 데이터를 읽어오고 싶다
		// 목적 명료하게 확실히 해야함 -> 글로 정리
		// byte 글씨 들어가면 stream // 데이터 읽어오기 = 입력 = input
		// File Stream 입력=Input --> FileInputStream
		
		
//		FileInputStream fis = new FileInputStream(); // error
		// 에러메세지 : The constructor FileInputStream() is undefined
        // 기본생성자가 아닌 매개변수 생성자이므로 어떤 매개변수가 들어가는지 공식API에서 검색
//		FileInputStream fis = new FileInputStream("a_byte.txt"); // error
		// Unhandled exception type FileNotFoundException
		// 어떤 예외가 떴는지 확인
		// 메소드 말고도 throws를 생성자에서도 가능
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("a_byte.txt");
			
			while(fis.read() != -1) { 
				System.out.print((char)fis.read()+ " "	); // 문자가 나오기 위해 char강제형변환
//				fis.read(); // 이클립스 추천클릭-catch문 추가
			// This method blocks if no input is yet available 
			// 파일크기 알 수 있는 방법x. 마지막에 도착했는지 알 수 있는 방법. -1되면 마지막 도착인지 알 수 있음
			}  //결과값 : b d f c e 
			
			// .read() : Returns:the next byte of data, or -1
			// a_byte.txt의 내용 : abcdefgcde
			// read()는 int 반환. a의 인트값인 97을 반환하고 -1이 아니기에 while문 조건에 따라 true되어
			// 반복문 실행. 다음 b를 프린트문 안 read가 읽어서 98을 반환 그리고 공백 띄어쓰기
			// .read()가 while 조건문에서 하나 print에서 하나 두개 쓰여서  while문 한바퀴에
			// 문자를 두개씩 소모하게 된다. 여기서 첫글자를 while문 조건에 있는 read()가  a를 
			// 그 다음값인 b를 print 안에 있는 read()가 가져가서 while 한바퀴에 문자 두개 소모
			// 다음 c를 가져오는데 c가 99니 while문 계속. d가 출력됨
			// 다음 e를 가져오고 그담 데이터의 바이트니 f출력. 이런식으로 반복해서 e까지 출력
			
			
			// read() 중복사용 해결방법 1
			// 변수 도입
			int value;  // int타입 사용이유 : .read()의 반환값이 int타입이기 때문
			while((value=fis.read()) != -1) { 
				System.out.print((char)value+ " "	);
			}
			// read()가 while 조건문에서 쓰이고 날라감. read()한번 더 사용 필요성.
			// read()의 반환값이 어딘가에 저장만 하면 중복사용 해결가능. 
			// 해결책 : int value; 변수도입
			
			
			// read() 중복사용 해결방법 2
			// byte array 사용
			File f = new File("a_byte.txt");
			int size = (int)f.length();
			byte[] bArr = new byte[size]; 
			// 배열값 안에 어떤 값이 담겨있을까?
			// byte[] bArr 안에는 byte의 기본값0들이 담겨있다
			fis.read(bArr);
			for(int i=0; i <bArr.length;i++) {
				System.out.print((char)bArr[i]+" ");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void fileSave() {
		// 기반 & 보조 스트림 클래스 찾는 법
		// 데이터를 파일에 byte 단위로 쓰고 싶다
		// byte사용=stream, 쓰고싶다=출력=output -->FileOutputStream
		
		FileOutputStream fos = null; // catch문 안에 fos.close()때문에 null;로 하나빼둠
		try {
//			FileOutputStream fos = new FileOutputStream("a_byte.txt");
//			fos = new FileOutputStream("a_byte.txt");
			// 파일이 존재하지 않으면 자동으로 파일 생성
			fos = new FileOutputStream("a_byte.txt",true); // true인자 추가하면 이어쓰기 가능
			
			// write(int b):void
			fos.write(97); //error:IOException 예외처리 안했기에 아래catch()에 IOException추가
						   // 97에 맞는 아스키코드인 a를 write함
			
			// write(byte[] b):void
			byte[] bArr = {98, 99, 100, 101, 102, 103};
			// 아스키코드 변환 : b c d e f g
			// 숫자로 저장 되어있는데 보이는 것만 char로 보이는것.
			fos.write(bArr);
			
			// write(byte[] b, int off, int len):void
			fos.write(bArr, 1, 3); // 1부터 3개를 가지고 오는 것
			
			
		} catch (FileNotFoundException e) { //error : | IOException 추가하니 발생ㅇ
			e.printStackTrace();
		} catch (IOException e) { // fos.write(97);의 예외처리
			e.printStackTrace();
		} finally {
			try {
				fos.close(); // 무조건 닫아줘야한다 // .close()도 throws로 위임
			} catch (IOException e) {
				e.printStackTrace();
			} 
			// fos가 try문 안에 있기에 try문 밖에 FileOutputStream fos = null;로 설정해줄 것
		}
	}	
	public void fileOpen2() {
		try(FileInputStream fis = new FileInputStream("c_byte.txt")){ // error
		// Unhandled exception type IOException thrown by automatic close() invocation on fis
		// 자동 close()되기에 close()의 IOException도 예외처리 해줘야한다.
		// 즉, catch문에 close()용 처리도 하나 있어야하기에 catch문 추가해야함
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void fileSave2() {
		
		try(FileOutputStream fos = new FileOutputStream("c_byte.txt");) {
			// write(int b):void
			fos.write(97); //error:IOException 예외처리 안했기에 아래catch()에 IOException추가
						   // 97에 맞는 아스키코드인 a를 write함
			
			// write(byte[] b):void
			byte[] bArr = {98, 99, 100, 101, 102, 103};
			// 아스키코드 변환 : b c d e f g
			// 숫자로 저장 되어있는데 보이는 것만 char로 보이는것.
			fos.write(bArr);
			
			// write(byte[] b, int off, int len):void
			fos.write(bArr, 1, 3); // 1부터 3개를 가지고 오는 것
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
