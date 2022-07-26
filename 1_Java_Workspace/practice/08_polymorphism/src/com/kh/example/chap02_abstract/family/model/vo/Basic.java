package com.kh.example.chap02_abstract.family.model.vo;
import java.io.Serializable;
import java.util.List;

public interface Basic extends Cloneable, Serializable, /*List*/{
	// 자바 자체에 있는 인터페이스 Cloneable, Serializable, List
	// 사용자정의 클래스와 자바 자체에 있어 기능을 가지고 있는 클래스가 있는 것처럼 인터페이스 같다
	// 자체에 있어 기능을 가지고 있는 클래스 : ex. println, scanner
	
	// 일반 인터페이스 : 
	// 마커 인터페이스(marker Interface) : 기능구현(메소드) 목적x 어떤 특성만 표시하는게 목적
	// ex) Serializable는 직렬화해주는 기능을 갖고있어라고 특성 표시가 목적
	
//	private int a; // error
	// 에러메세지 
	// Illegal modifier for the interface field Basic.a; 
	// only public, static & final are permitted
	// 일반적 변수 사용 불가. public static final로 변경
	
	// 인터페이스에서의 필드는 항상 상수 필드 : public static final
	
	public static final int A = 10; // 인터페이스에서는 
	String str = "Hello";			// (public static final) 생략가능
	int B = 1;						// (public static final) 생략가능
	
	
//	public void method() { // error
//	} // 에러메세지 : Abstract methods do not specify a body
	  // 인터페이스,앱스트랙트는 불완전이라 몸체(=중괄호)가 없다
	
	
	// abstract 빠져도 에러없이 잘됨. 어차피 인터페이스 안에는 다 추상메소드만 가능해서
	// abstract 자동생략가능
	public void eat();
	public void sleep();
//	void sleep(); 위와 같은 코드 : 인터페이스 내에서 생략가능
	
//	인터페이스끼리 상속 가능
//	인터페이스를 일반 상속구현할 경우 implements 사용
//	인터페이스와 인터페이스끼리의 상속은 extends 사용
	
	
	
}
