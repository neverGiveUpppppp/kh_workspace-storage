package com.kh.example.chap02_Wrapper.controller;

public class WrapperController {

	public void method1() {
		// 기본자료형 Wrapper클래스
		// boxing : 기본자료형을 wrapper'클래스'로 변환
		// unBoxing : wrapper클래스를 기본자료형으로 변환
		
		int num1 = 10;
		Integer integer1 = new Integer(num1); // num1 : 자체를 래퍼클래스로 전환 -> boxing
		int num2 = integer1.intValue();       // num2 : 래퍼클래스를 기본자료형 int로 변환 -> unBoxing
	
		// JDK1.5버젼부터 지원 → autoBoxing, autoUnBoxing
		// 자동박싱,언박싱. 바로 대입적용이 가능케됨
		Integer integer2 = num1; // autoBoxing
		int num3 = integer2;     // autoUnBoxing
	
	}
	
	
	public void method2() {
		
		// 많이 사용하는게 파싱
		// parsing : 문자열을 기본 자료형으로 변환하는 것
		
		// 변환가능한 같은 형태이여야한다
		// ex) 숫자면 숫자끼리. 문자열 "1"을 int 1로 변환 가능
		int i = Integer.parseInt("10");
		double d = Double.parseDouble("박신우");
		// 에러메시지 : java.lang.NumberFormatException: For input string: "박신우"
		// 파싱할 자료형의 형태를 지니지 않아서 나는 에러
		
		
		short s = Short.parseShort("10 ");		// 잦은 실수 요인 : 공백 조심
		float f = Float.parseFloat(" 10");
		boolean b = Boolean.parseBoolean("true");
		byte by = Byte.parseByte("10");
		Long l = Long.parseLong("10");
		// 캐릭터 래퍼클래스에는 파싱기능 존재x -> chatAt()로 대체
				
		
		// 기본 자료형을 문자열로 바꾸는 작업
		String str1 = i + ""; 					  // 방법1. 가장 쉬운 변환.대중적 사용
		String str2 = String.valueOf(s); 		  // 방법2. 값 자체를 가져오는 메소드
		String str3 = Byte.valueOf(by).toString();// 방법3
		
		///////////////////////////////////////////////////////
		int a;
		Integer intCasting = new Integer(a);
		intCasting.intValue(a);
		
		
	}
	
}
