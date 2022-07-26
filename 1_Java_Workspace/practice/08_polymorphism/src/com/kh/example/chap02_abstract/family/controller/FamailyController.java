package com.kh.example.chap02_abstract.family.controller;
import com.kh.example.chap02_abstract.family.model.vo.Baby;
import com.kh.example.chap02_abstract.family.model.vo.Basic;
import com.kh.example.chap02_abstract.family.model.vo.Family;
import com.kh.example.chap02_abstract.family.model.vo.Mother;

public class FamailyController {

	
	public void method() {
//		Family f = new Family(); // error
		// 에러메세지 :Cannot instantiate the type Family
		// 추상클래스라서 직접적인 객체 생성 불가
		// 객체 생성하고 싶으면 상속사용. mother로 해보자
		
		Family m = new Mother();
		Family b = new Baby();
		
//		m.eat();
//		b.sleep(); 
		// 타입이 family이긴 하지만 객체는 오버라이딩 때문 mother와 baby
		// 각각 mother와 baby에 있는 eat과 sleep이 실행 될 것
		// 이 의미는 동적 바인딩이 실행됬다는 의미
		
		// 마더에 있는 eat(), Baby에 있는 sleep() 실행 ->동적바인딩
		
		// 마더나 베이비를 인터페이스를 통해서 받을 수 있음
		// 인터페이스 객체생성 불가 but, 상속통해 객체생성 가능
//		Basic b = new Basic();   // error : 인터페이스, 객체생성 불가 
		Basic m2 = new Mother(); // 상속통해 객체생성
		Basic b2 = new Baby();		
		m2.sleep();
		b2.eat();
		
	
	}
}
