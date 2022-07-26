package com.kh.example.chap01_byte.model.dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteDAO2 {
	public void fileOpen() {
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("a_byte.txt");
			
			// read()의 중복사용
			while(fis.read() != -1) { 
				System.out.print((char)fis.read()+ " "	); 
			
			// read() 중복사용 해결방법 1 : 변수 도입
			int value;  // int타입 사용이유 : .read()의 반환값이 int타입이기 때문
			while((value=fis.read()) != -1) { 
				System.out.print((char)value+ " "	);
			}
			
			// read() 중복사용 해결방법 2 : byte array 사용
			File f = new File("a_byte.txt");
			int size = (int)f.length();
			byte[] bArr = new byte[size]; 
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
		
		FileOutputStream fos = null; 
		try {
			fos = new FileOutputStream("a_byte.txt",true); 
			
			// write(int b):void
			fos.write(97); //error:IOException 예외처리 안했기에 아래catch()에 IOException추가
						   // 97에 맞는 아스키코드인 a를 write함
			
			// write(byte[] b):void
			byte[] bArr = {98, 99, 100, 101, 102, 103}; // 숫자로 저장 되어있는데 보이는 것만 char로 보이는것.
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
		}
	}	
	public void fileOpen2() {
		
		try(FileInputStream fis = new FileInputStream("c_byte.txt")){ 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void fileSave2() {
		
		try(FileOutputStream fos = new FileOutputStream("c_byte.txt");) {
			// write(int b):void
			fos.write(97); 
			
			// write(byte[] b):void
			byte[] bArr = {98, 99, 100, 101, 102, 103};
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
