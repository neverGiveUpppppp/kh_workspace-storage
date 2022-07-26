package com.kh.example.chap02_user.controller;
import com.kh.example.chap02_user.model.exception.MyException;

public class UserExceptionController {
	
	// 예외의 상속
	public void method() throws MyException { // 예외 강제 발생시킴
		throw new MyException("곧 수업끝나는 에러"); // String 받는거라  매개변수에 "곧 수업끝나는 에러"
		// MyException class에서 사용자정의 예외로  public MyException(String msg) {
		// 이 부분에서 String으로 받기에 string으로만 넣어줘야한다
		// 또한 
		// 매개변수 있는 생성자(public MyException(String msg))가 있어야하는 이유
		// 에러 오른쪽에 에러에 대한 상세 설명(ex:곧 수업 끝나는 에러)을 넣어주기 위해서 String타입으로 매개변수 있는 생성자가 필요한 것
		// 어떤 에러인지 알려주기 싫으면 매개변수 안넣어줘도 된다
		
	}
	
}
