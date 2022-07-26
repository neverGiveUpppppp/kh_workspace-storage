package com.kh.example.chap01_poly.test.controller;
import com.kh.example.chap01_poly.test.model.vo.Child1;
import com.kh.example.chap01_poly.test.model.vo.Child2;
import com.kh.example.chap01_poly.test.model.vo.Parent;


// 다형성

public class PolyController {

	// 1. 부모 타입 레퍼런스로 부모 객체를 다룰 때
	// 2. 자식 타입 레퍼런스로 자식 객체를 다룰 때
	// 3. 부모 타입 레퍼런스로 자식 객체를 다룰 때
	// 4. 자식 타입 레퍼런스로 부모 객체를 다룰 때
	
	
	public void method() {
		// 1. 부모 타입 레퍼런스로 부모 객체를 다룰 때		
		System.out.println("1.부모 타입 레퍼런스로 부모 객체를 다룰 때");
		Parent p1 = new Parent();  // 부모 부모  // 
		p1.printParent();
		
		System.out.println();


		// 2. 자식 타입 레퍼런스로 자식 객체를 다룰 때
		System.out.println("2. 자식 타입 레퍼런스로 자식 객체를 다룰 때");
		Child1 c1 = new Child1();  // 자식 자식  //
		c1.printChild1();          // 처음부터 자기가 확장한 메소드
		c1.printParent();          // 상속 받은 메소드 호출 가능
		
		System.out.println();
		
		// 3. 부모 타입 레퍼런스로 자식 객체를 다룰 때
		System.out.println("3. 부모 타입 레퍼런스로 자식 객체를 다룰 때");
		Parent p2 = new Child2();  // 부모 자식  // 다형성적용 업캐스팅
		p2.printParent();          // Child2가 더 범위가 넓어도 parent 영역만큼만 사용가능
		((Child2)p2).printChild2();// 다운 캐스팅 : 부모타입 참조변수를 자식 클래스 타입으로 형변환 
//	(int)(double) 형변환할 때 그 소괄호 () //    -> 자식객체의 멤버에 접근(참조)가능
		
		System.out.println();
		
		// 4. 자식 타입 레퍼런스로 부모 객체를 다룰 때
		System.out.println("4. 자식 타입 레퍼런스로 부모 객체를 다룰 때");
//		Child2 c2 = new Parent();  // 자식 부모  // error   
		// 에러메세지 :ClassCastException
		// Child2 c2 = (Child2)(new Parent());//다른방법1 error
		// Child2 c2 = (Child2)p1;            //다른방법2 error
		
		
	}		
	
	public void method2() {
		
		System.out.println();
		System.out.println("=== 다형성 활용 ===");
		System.out.println();
		
		// 1.객체배열
		// 배열 : <하나의 자료형>의 여러 개 값을 저장할 수 있는 공간
		// 하나의 자료형이라는 단점을 보완하는 기능이 나옴
		// child1 객체와 child2 객체를 저장할 수 있는 4개의 공간 생성
		
		Child1[] ch1Arr = new Child1[4];
		ch1Arr[0] = new Child1(); // 객체타입이 다른 4개의 배열 하나에 담을 수 있을까?(하나의 자료형이 아닌 여러개의 자료형을 담을 수 있을까?)	
//		ch1Arr[1] = new Child2(); // error. 해결책은? 부모타입으로 만들면 됨		
//		ch1Arr[2] = new Child2(); // 객체타입이 다른 4개의 배열을 하나에 담을 수 없지만		
		ch1Arr[3] = new Child1(); // 객체배열 다형성 덕에 가능해짐
		
		//  ↓↓↓↓↓↓ 해결책 다형성 부모 변환 적용 ↓↓↓↓↓↓
		
		// 타입이 부모이고 객체가 자식 - 다형성 적용
		Parent[] pArr = new Parent[4];
		pArr[0] = new Child1(); 
		pArr[1] = new Child2(); 	
		pArr[2] = new Child2(); 	
		pArr[3] = new Child1();
		
		for(int i=0; i<pArr.length; i++) {
			pArr[i].printParent();      // 타입이 부모라서 부모메소드 printParent()만 사용 가능 
		}
		
		// for문 사용 child1,2 각각 printChild 메소드 호출
		// 힌트 : 강제변환 소괄호() 사용
		
		for(int i=0; i<pArr.length; i++) {
//			((Child1)pArr[i]).printChild1(); 
//			((Child2)pArr[i]).printChild2();
		} // Class cast Exception 에러날 확률 높음
		
		// 문제 개선 코드
		for(int i=0; i<pArr.length; i++) {
//			pArr[i].printParent();
			
			// 수업에서 객체자체를 비교해본적은 아직 한번도 없음
			// 객체자체를 비교하기 위한 연산자 : instanceof
			
			// instanceof사용. 내가 지금 비교하고 싶은 레퍼런스 변수를 누구로 써야할까? pArr[i]
			if(pArr[i] instanceof Child1 ) { 
				((Child1)pArr[i]).printChild1(); // Class cast Exception 에러날 확률 높음
			} else if (pArr[i] instanceof Child2){
				((Child2)pArr[i]).printChild2();
			}
		}

				
		for(int i=0; i<pArr.length; i++) {
			pArr[i].print(); 
		} // Parent 4번 찍힐 줄 알았으나, 
		// 결과
		// Child1
		// Child2
		// Child2
		// Child1

		// why?
		// 부모 참조변수에 부모 타입이면 부모 .print만 가져올 줄 알았는데 왜 자식꺼를 가져왔을까?
		// 동적 바인딩과 관련 있는 내용
//		Parent[] pArr = new Parent[4];
//		pArr[0] = new Child1(); 
//		pArr[1] = new Child2(); 이 코드들에서 pArr이 타입이 부모이지만 객체는 자식이므로 
//		pArr[2] = new Child2(); 객체 기준으로 자식클래스로 print()가 작동해서 	
//		pArr[3] = new Child1(); 
		
		// 왜  결과가 Child1,Child2,Child2,Child1일까?
//		pArr[0] = new Child1();  // 여기 코드에서 각 pAr[] 배열값에 Child1 객체를 
//		pArr[1] = new Child2();  // 왼쪽 코드 순서대로 1,2,2,1 순으로 넣어줬기 때문
//		pArr[2] = new Child2(); 	
//		pArr[3] = new Child1(); 
		
	}
	
	// 2.매개변수
	// 노트 참조
	
	
	
}
