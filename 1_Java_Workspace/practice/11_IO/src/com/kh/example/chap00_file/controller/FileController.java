package com.kh.example.chap00_file.controller;
import java.io.File;
import java.io.IOException;

public class FileController {
	public void method() {
//		File f1 = new File(); // error : file class는 생성자가 매개변수 있는 것만 있음
//		File f1 = new File("test.txt");
//		f1.createNewFile(); // error : IOException 미처리
							//.createNewFile()을 호출했는데 호출한 곳에  IOException처리하라고 에러뜸
		try {				// try catch 직접처리로 해결
			File f1 = new File("test.txt"); // try 밖에 있어도 무관
			f1.createNewFile(); // 파일 경로 지정안하면 프로젝트 최상단에 파일 생성
			
//			File f2 = new File("D:/Dropbox/test.txt");  // 경로지정 방법1
			File f2 = new File("D:\\Dropbox\\test.txt");// 경로지정 방법2
			f2.createNewFile();
			File f2_0 = new File("D:\\df4tet\\test.txt");// error : 런타임에러 
//			f2_0.createNewFile();// 에러메세지 :java.io.IOException: 지정된 경로를 찾을 수 없습니다
			  					// 없는 경로까지 생성해주지는 않는다. 파일만 만들어주는 메소드
								// 없는 경로를 지정하면 에러발생. ex)없는 폴더명 지정하면 에러
			File f3 = new File("D:\\test\\testB");          // 경로만 지정
			File f4 = new File("D:\\test\\testB\\test.txt");// 경로지정 후 파일생성
//			f4.createNewFile(); // error : 런타임에러. 지정 경로 없다고 오류
			f3.mkdirs(); // mk = make, dir = directory // mkdir 단일 mkdirs 복수
//			f3.mkdir();
			f4.createNewFile(); // error : 런타임에러. 지정 경로 없다고 오류
			f4.delete();
			
			System.out.println(f2.exists()); // true
			System.out.println(f3.exists()); // true
			System.out.println(f4.exists()); // false
			System.out.println(f3.isFile()); // false // 파일이냐고 물어서 아니라 false
			
			
			System.out.println("파일명 : "+f1.getName());
			System.out.println("저장 절대 경로 : "+ f1.getAbsolutePath()); // 처음부터 찾아가기에 경로가 풀로 나옴
			System.out.println("저장 상대경로 : "+ f1.getPath());  // 상대경로는 있는 곳에서 출력이기에 파일명만 나옴
			System.out.println("파일 용량 : "+ f1.length());
			System.out.println("f1 상위폴더 : "+ f1.getParent()); // 현재 경로라 상위폴더가 null
			System.out.println("f4 상위폴더  : "+ f4.getParent());
			
			// 결과값
//			파일명 : test.txt
//			저장 절대 경로 : D:\Dropbox\Developer\Java\Java_Workspace\practice\11_IO\test.txt
//			저장 상대경로 : test.txt
//			파일 용량 : 0
//			f1 상위폴더 : null
//			f4 상위폴더  : D:\test\testB
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void method2() { // 에러 없는 실행 메소드
		try {				// try catch 직접처리로 해결
			File f1 = new File("test.txt"); // try 밖에 있어도 무관
			f1.createNewFile(); // 파일 경로 지정안하면 프로젝트 최상단에 파일 생성
			
//			File f2 = new File("D:/Dropbox/test.txt");  // 경로지정 방법1
			File f2 = new File("D:\\test\\testB\\test1.txt");// 경로지정 방법2
			f2.createNewFile();
			
			File f3 = new File("D:\\test\\testA");          // 경로만 지정
			File f4 = new File("D:\\test\\testB\\test2.txt");// 경로지정 후 파일생성
			f3.mkdirs(); // mk = make, dir = directory // mkdir 단일 mkdirs 복수
//			f3.mkdir();
			f4.createNewFile(); 
			f4.delete();
			

		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
}
