package com.kh.example.chap03_assist.part01_buffer.model.dao;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferDAO2 {
	public void inputByte() {
	// 목적 :파일에 있는 데이터를 바이트 기반으로 빠르게 읽어오고 싶다
	
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			fis = new FileInputStream("c_buffer.txt");  // 기반
			bis = new BufferedInputStream(fis); // 보조    // 매개변수에 기반담기 → 다형성
			
			int value;
			while ((value = (bis.read())) != -1) {
				System.out.print(value+" ");
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

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream("c_buffer.txt");
			bos = new BufferedOutputStream(fos); // File이 Buffered안에 있기에 버퍼로 사용
			
			bos.write(65); // 보조(bos)가 기반(fos)을 품기 때문에 bos만 써주면 된다 
			byte[] bArr = {66,67,68,69};
			bos.write(bArr); 			 
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bos.close(); // 보조 close()
//				fos.close(); // 기반 close() 
			}catch(IOException e) {
				e.printStackTrace();
			}
		} // 결과값 : ABCDE
	}

////////////////////////////////////////////////////////////////////////////////	
////////////////////////////////////////////////////////////////////////////////	
////////////////////////////////////////////////////////////////////////////////	
	
// try with resoure문
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
	// try with resoure문
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
}