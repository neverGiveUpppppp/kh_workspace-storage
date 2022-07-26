package com.kh.example.person.controller;
import com.kh.example.person.model.vo.Person;

// 객체 배열

public class PersonController {
	
	public void method1() {
		// Person객체가 들어갈 수 있는 5개의 공간 pArr 생성
		Person[] pArr = new Person[5];
		
		for(int i=0; i < pArr.length; i++) {
			System.out.println("pArr["+i+"] : "+pArr[i]);
		}
		
		pArr[0] = new Person();
		pArr[1] = new Person("강건강",25,'남',174.3,67.2);
		pArr[2] = new Person("남나눔",13,'남',162.4,55.2);
		pArr[3] = new Person("도대담",32,'남',183.1,70.2);
		pArr[4] = new Person("류라라",17,'여',162.4,52.1);
		
		
		for(int i=0; i<pArr.length;i++) {
			System.out.println("pArr["+i+"] : "+pArr[i]);
		}
		
		for(int i=0; i<pArr.length; i++) {
			System.out.println(pArr[i].personInfo());
		} // 에러메세지 : java.lang.NullPointerException
		  // 에러원인 : 참조형의 기본값인 null(없는값)을 return으로 반환할려하니 에러
		  // 이 for문 윗줄에 코드를 만들어 값을 넣어줄 것
	}
	
	public void method2() {
		Person[] pArr = {new Person("문미미",28,'여',160.2,58.4),
					     new Person("박보배",42,'여',162.2,44.2),
					     new Person("송성실",23,'남',175.4,82.5)};
		
		for(int i=0; i<pArr.length;i++) {
			System.out.println("pArr["+i+"] : "+pArr[i]);
		}
		
		for(int i=0; i<pArr.length; i++) {
			System.out.println(pArr[i].personInfo());
		}
	}
	
}
