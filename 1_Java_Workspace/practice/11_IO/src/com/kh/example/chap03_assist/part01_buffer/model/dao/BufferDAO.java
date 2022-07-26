package com.kh.example.chap03_assist.part01_buffer.model.dao;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferDAO {
	public void inputByte() {
	// 목적 :파일에 있는 데이터를 바이트 기반으로 빠르게 읽어오고 싶다
	// 파일→File 바이트기반→stream 버퍼의읽기→input 빠르게→Bufferd => FileinputStream
	// 기반스트림이 바이트면 보조스트림도 바이트이여함  					 =>BufferedInputStream
	
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			fis = new FileInputStream("c_buffer.txt");  // 기반
			bis = new BufferedInputStream(fis); // 보조    // 매개변수에 기반담기 → 다형성
			// BufferedInputStream(InputStream in) 인풋스트림계열의 최상위 클래스 : 모든 기반스트림을 받을 수 있게 최상위클래스를 매개변수에 받는 것(다형성)
			
			// 위와 동일한 한줄 코드
//			BufferedInputStream bis = new BufferedInputStream(new FileInputStream("c_buffer"));
			// "c_buffer" 아직 안만들어서 실행하며 에러날 것
			
			int value;
			while ((value = (bis.read())) != -1) {
				System.out.print(value+" ");
//				System.out.print((char)value+" ");
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bis.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
		
	public void outputByte() {
		// 목적 : 파일에 바이트기반으로 데이터를 빠르게 쓰고 싶다
		// 파일→File 바이트기반→Stream 빠르게→Buffered 쓰기→output 
		// => 기반 FileOutputStream & 보조 BufferdOutputStream
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream("c_buffer.txt");
			bos = new BufferedOutputStream(fos); // File이 Buffered안에 있기에 버퍼로 사용
//				BufferdOutputStream bos = new BufferdOutputStream(new FileOutputStream("c_buffer"));
			
			bos.write(65); // 보조(bos)가 기반(fos)을 품기 때문에 bos만 써주면 된다 
			byte[] bArr = {66,67,68,69}; // 아스키코드 : 65 66 67 68 69 => ABCDE
			bos.write(bArr); 			 
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bos.close(); // 보조스트림 BufferedOutputStream의 close()
				fos.close(); // 기반스트림 FileOutputStream의 close() 
				// 보조스트림을 닫아주면 기반도 자동으로 닫힘. 즉, 기반은 안닫아도 알아서 닫히므로 안써도 된다
			}catch(IOException e) {
				e.printStackTrace();
			}
		} // 결과값 : ABCDE
	}
	
////////////////////////////////////////////////////////////////////////////////	
////////////////////////////////////////////////////////////////////////////////	
////////////////////////////////////////////////////////////////////////////////	
	
	// try with resoure문 - 바이트
	public void outputByte2() {
		try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("c2_buffer.txt"));){
			bos.write(65); // 보조(bos)가 기반(fos)을 품기 때문에 bos만 써주면 된다 
			byte[] bArr = {66,67,68,69}; // 아스키코드 : 65 66 67 68 69 => ABCDE
			bos.write(bArr); 	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// try with resoure문 - 바이트
	public void intputByte2() {
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(("c2_buffer.txt")))) {

			int value;
			while((value=bis.read()) != -1) {
				System.out.print(value+" ");
//				System.out.print((char)value+" ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
	
	public void outputChar() {
		// 목적 : 파일에 문자 기반으로 데이터를 빠르게 쓰고 싶다
		// 파일→File 문자→Writer 빠르게→Buffered 
		// => 기반 FileWriter & 보조 BufferedWriter
		
		BufferedWriter bw = null;
		try {
			FileWriter fw = new FileWriter("d_char.txt");
			bw = new BufferedWriter(fw);
			
			bw.write("안녕하세요\n");
			bw.write("반갑습니다\n");
			bw.write("건강하세요\n");
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void inputChar() {
		// 목적 : 파일에 쓰인 데이터를 문자 기반으로 빠르게 읽고 싶다
		// 파일→File 문자→no stream 빠르게→Buffered 읽다→Reader
		// => 기반 FileReader & 보조 BufferdReader
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("d_char.txt"));
			
			br.readLine();
			// Returns:A String containing the contents of the line, 
			// not includingany line-termination characters, 
			// or null if the end of the stream has been reached
			// (줄 종료 문자를 포함하지 않는 줄의 내용을 포함하는 String 또는 스트림의 끝에 도달한 경우 null)
			// 성능 뿐아니라 리드라인을 쓸려고 버퍼드리더로 감싸기도 한다
			
			String value;
			while((value=br.readLine()) != null) { // .readline은 값이 없을 때까지 반환하고 없으면 null 반환
				System.out.println(value);		   // 때문에 null값 나오면 멈추라는 while조건
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
	
	


	// try with resoure - 문자
	public void inputChar2() {
		
		try (BufferedReader br = new BufferedReader(new FileReader("d_char.txt"))){
		
			String value;
			while((value=br.readLine()) != null) { // .readline은 값이 없을 때까지 반환하고 없으면 null 반환
				System.out.println(value);
			}
		}catch(FileNotFoundException e) { // 이 catch문을 지워도 아래 IOException이  FileNotFoundException의
			e.printStackTrace();		  // 부모이기 때문에 함께 예외처리 가능
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void outputChar2() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("d_char.txt"))){
			
			bw.write("안녕하세요\n");
			bw.write("반갑습니다\n");
			bw.write("건강하세요\n");
			
		}catch(IOException e) {
			e.printStackTrace();
		} // close() 안한다고 반드시 에러나는건 아님. 자원낭비 일 뿐
		
	}
//   public void outputChar2() {
//	      try(FileWriter fw = new FileWriter("c_buffer.txt");
//	            BufferedWriter bw = new BufferedWriter(fw);) {
//	         bw.write("안녕하세요\n");
//	         bw.write("반갑습니다\n");
//	         bw.write("건강하세요\n");
//	      } catch (IOException e) {
//	         e.printStackTrace();
//	      } 
//	   }
//	  public void inputChar2() {
//	    try(BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"));) {
//	       String value;
//	       while((value=br.readLine()) != null) {
//	          System.out.print(value);
//	       }
//	    } catch(FileNotFoundException e) { 
//	       e.printStackTrace();
//	    } catch (IOException e) {
//	       e.printStackTrace();
//	    } 
//	    // catch절 작성 시 유의 사항 : 상속 관계를 고려해서 작성 -> 아래로 갈수록 부모 예외의 매개변수가 있어야 함
//	    //       첫 catch부터 Exception에 대해 작성을 하면, 아래 아무 catch절도 사용 x
//	 }

}
