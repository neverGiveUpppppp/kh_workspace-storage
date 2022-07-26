package com.kh.example.chap04_Math.controller;

public class MathController {
	public void method() {
		double num = 4.949;
		
		// 클래스 안에는 필드도 많다
		// ex) Math.PI
		
		// Math.PI
		// 필드. 파이값
		double pi = Math.PI; 	// 필드: Math.PI
		System.out.println("파이 : "+pi);
		
		
		// abs
		// 절대값 
		double abs = Math.abs(num);
		System.out.println("절대값 : "+abs); // 절대값이란? 부호를 때고 숫자만 나타내는 숫자 
		Math.abs(-num);
		System.out.println("절대값 : "+abs); // -4.949가 아닌 4.949
		
		// ceil
		// 올림
		double ceil = Math.ceil(num);
		System.out.println("올림 : "+ceil);	 // 5.0
		System.out.println(Math.ceil(3.2));  // 4.0
		
		// round
		// 반올림
		double round = Math.round(num);
		System.out.println("반올림 : "+round); // 5.0
		System.out.println(Math.round(3.2)); // 3.2
		
		// floor
		// 내림
		double floor = Math.floor(num);
		System.out.println("내림 : "+floor); // 4.0
		
		// max
		// 최대값  둘 중에 찾기 
		double max = Math.max(ceil, floor);
		System.out.println("최대값 둘 중에 찾기 : "+max);
		
		// min
		// 최소값 둘 중에 찾기
		double min = Math.min(ceil, floor);
		System.out.println("최소값 둘 중에 찾기 : "+min);
		
		
		
		
		
	}
	
}
