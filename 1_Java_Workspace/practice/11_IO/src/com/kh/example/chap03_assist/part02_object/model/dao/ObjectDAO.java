package com.kh.example.chap03_assist.part02_object.model.dao;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.example.chap03_assist.part02_object.model.vo.Member;

public class ObjectDAO {

	public void fileSave() {
		Member[] mArr = {
				new Member("user01","pass01","강건강","kang1@kkk.kkk",25,'남',2349.3),
				new Member("user02","pass02","남나눔","nam1@nnn.nnn",15,'남',1834.6),
				new Member("user03","pass03","도대담","doh1@ddd.ddd",53,'남',3925.1)
		};
		
		// 파일에 객체를 데이터로 쓰고 싶다
		// file OutputStrem
		// 기반 OutputStrem 보조 objectOutputStrem
		try (FileOutputStream fos = new FileOutputStream("d_object.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);){
			
			for(int i=0; i<mArr.length; i++) {
				oos.writeObject(mArr[i]);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
	public void fileOpen() {
		// 목적 : 파일에 있는 데이터를 객체로 읽어오고 싶다
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d_object.txt"));
			
			Member[] mArr = new Member[3];
			for(int i=0; i<mArr.length; i++) {
				mArr[i] = (Member)ois.readObject(); // readObject() 
			} // Member는 최상위클래스Object의 자식 // 자식인 Member로 형변환 (Member)ois.readObject();
				
			for(int i=0; i<mArr.length; i++) {
				System.out.println(mArr[i]);
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) { 			 // 상속관계가 있으면 부모일 수록 아래로 두는게 좋다
			e.printStackTrace();
		} catch (ClassNotFoundException e) { // 상관계가 없을 때는 순서 상관x // IOException과 다른 상속계열 
			e.printStackTrace();
		}
	}
	
	// 
	public void fileOpen2() {
		// 목적 : 파일에 있는 데이터를 객체로 읽어오고 싶다
		// readObject() 리턴값 끝을 알 수가 없어 while조건식 세우기가 애매하다
		
		Member[] mArr = new Member[3];
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d_object.txt"));
			
			int i = 0;
			while(true) {
				mArr[i] = (Member)ois.readObject(); // readObject() 리턴값 끝을 알 수가 없어 while조건식 세우기가 애매하다
				i++; // EOF예외를 활용
			}	
		}catch(EOFException e) {   
			for (int i=0; i < mArr.length; i++) {
				System.out.println(mArr[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) { 			 // 상속관계가 있으면 부모일 수록 아래로 두는게 좋다
			e.printStackTrace();
		} catch (ClassNotFoundException e) { // 상관계가 없을 때는 순서 상관x // IOException과 다른 상속계열 
			e.printStackTrace();
		}
	}
}
