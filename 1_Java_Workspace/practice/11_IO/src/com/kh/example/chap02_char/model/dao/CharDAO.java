package com.kh.example.chap02_char.model.dao;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharDAO {
	public void fileOpen() {
		
		// 목적 : 파일로부터 문자 단위로 데이터를 읽어오고 싶다
		// File 단위가 문자라 (stream x) 읽어온다 = reader ->FileReader
		
		try {
			// FileReader(String fileName)
			FileReader fr = new FileReader("b_char.txt"); // error 예외처리할것 FileNotFoundException
			int value;		// .read()의 반환값이 int기 때문에 int사용
			while((value = fr.read()) != -1) {
				System.out.print((char)value+ " "); // char형변환 안하면 숫자나와서 형변환해줌
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void fileSave() {
		
		// 목적 : 데이터를 파일에 문자 단위로 쓰고 싶다
		// file 위가 문자라 (stream x) 쓰고싶다=writer ->FileWriter
		
		FileWriter fw = null;
		try {
			fw = new FileWriter("b_char.txt");
			fw.write("와! IO 재밌다~!");
			fw.write('A');
			char[] cArr = {'a','p','p','l','e'};
			fw.write(cArr); // .close() 안해줘서 파일 기록이 안됐다. 
			// 바이기반은 용량이 적어서 close()안해도 나온 것이나 문자기반은 무겁기 때문
		}catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		} // FileWriter fw = null; 부터 finally문 안에 close()까지 많이 쓰는 정형화된 패턴
		
		
	}
	public void fileOpen2() {
		try(FileReader fr = new FileReader("c_char.txt");){
			int value;		// .read()의 반환값이 int기 때문에 int사용
			while((value = fr.read()) != -1) {
				System.out.print((char)value+ " "); // char형변환 안하면 숫자나와서 형변환해줌
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void fileSave2() {
		try(FileWriter fw = new FileWriter("c_char.txt");){ 
			// FileWriter는 생성자 생성부터 IOException을 throws(위임)하고 있다
			// ->FileWriter 내부에 예외 위임(throws) 기능 포함
			fw.write("와! IO 재밌다~!");
			fw.write('A');
			char[] cArr = {'a','p','p','l','e'};
			fw.write(cArr); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
