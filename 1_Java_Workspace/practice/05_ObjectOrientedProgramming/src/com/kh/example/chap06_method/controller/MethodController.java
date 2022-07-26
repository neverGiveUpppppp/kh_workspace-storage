package com.kh.example.chap06_method.controller;
public class MethodController {
	
	// 매개변수 유무와 반환값 유무에 따른 구분
	// 1. 매개변수 X 반환값 X 메소드
	// 2. 매개변수 X 반환값 O 메소드
	// 3. 매개변수 O 반환값 X 메소드
	// 4. 매개변수 O 반환값 O 메소드

	
	// 1.반환값도 없고 매개변수도 없는 메소드
	// 전달 받는 값도 없고 반환할 값도 없는 메소드로 {}안 내용만 수행 후 끝남
	public void method1() {
		System.out.println("1. 매개변수 X 반환값 X 메소드");
		// return 예약어 코드 안썼지만
	}
	
	// 2.매개변수 없고 반환값 있는 메소드
	public int method2() { // error
	// error message : 1)Return type for the method is missing
	//				   2)This method must return a result of type int
	// 에러원인 : int로 반환값 주기로하고 안줘서 에러뜬 것		
	// 해결방법 : return문 추가해도 해결
		
		int num1 = 10;
		int num2 = 3;
		int sum = num1 + num2;
		
// 		다양한 반환값 형식
//		return sum;
//		return num1 + num2;
		return 10 + 3; 	// 변수든 리터럴이든 반환타입이 method2에서 설명한 int타입이면 됨
	}
	
	// 3.매개변수 있고 반환값 없는 메소드
	public void method3(int num1, int num2) {
		System.out.println(num1 + ", " + num2);
	}
	
	// 4. 매개변수 있고 반환값 있는 메소드 
	public int method4(int num1, int num2) {
	// 반환값 준다했는데 안주고 있어서 에러
		
//		return num1+num2;		두 코드 다 가능
		int sum = num1 + num2;
		return sum;			
		
	}
	// 클래스  반환 예시
	public int method5(int num1, int num2) {
		int[] iArr =  {1,2,3};
		System.out.println("메소드컨트롤러 iArr : "+iArr);
		
		return iArr;
	}
	// 반환값이 클래스인 경우
	public User method6() {
		User u = new User("user01","pass01","강건강");
		System.out.println("method6"+u);
		
		return u; // 주소값을 그대로 받아서 유저에게 넘기준 거
	}
}
