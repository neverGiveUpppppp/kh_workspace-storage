package com.kh.example.chap01_exception.controller;
import java.io.IOException;

public class ExceptionController {
	public void method1() throws IOException {  // 예외 위임
		System.out.println("method1() 호출함...");
		method2();	
		System.out.println("method1() 종료됨...");
	}
	
	public void method2() throws IOException {  // 예외 위임
		System.out.println("method2() 호출함...");
		method3();	// error massage : Unhandled exception type IOException
					// 이유 : method3()에서 method2()인 이곳으로 예외가 위임 되었기에
		System.out.println("method2() 종료됨...");
	}
	
	public void method3() throws IOException {  // 예외 위임
		System.out.println("method3() 호출함...");
		throw new IOException(); // error massage : Unhandled exception type IOException 
//		System.out.println("method3() 종료됨..."); // error massage : Unreachable code
												 // 이유 : 예외 발생시, 그 아래 코드는 실행하지 않음
		// throws IOException을 넣어도 마지막 줄 코드는 여전히 Unreachable code
	}
}
