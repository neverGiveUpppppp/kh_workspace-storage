package com.kh.example.chap05_constructor.run;
import java.util.Date;
import com.kh.example.chap05_constructor.model.vo.User;

public class Run {

	public static void main(String[] args) {

		
		User u1 = new User(); // 기본생성자에 오류발생
		u1.inform();		  // 매개변수 있는 생성자 생성 후에 발생
//							  // 매개변수 있는 생성자에는 JVM이 자동으로 생성자 생성안해서 오류발생
							  // 해결책
							  // 해당 이름의 기본생성자를 생성
		System.out.println("u1: "+u1); // 주소값 확인용
		
//		User u2 = new User("user1","pass1"); // error
		User u2 = new User("user1","pass1","pass2"); // 해결
		u2.inform(); // 에러메세지 : The constructor User(String, String) is undefined 
					 // 에러원인 : 실행클래스의 매개변수 생성자에서 값 초기화를 3개 했는데 
					 // new User() 생성자에서는 매개변수를 2개만 줬기 때문에 에러발생
					 // ("user1","pass1","pass2")로 매개변수 하나 더 줄 것
		System.out.println("u2 : "+u2);
		
		
//		User u3 = new User("user2","pass2"); // error
		User u3 = new User("user2", new Date()); // 해결
		u3.inform(); // 에러메세지 : The constructor User(String, String) is undefined
					 // 에러 원인 : 매개변수 수도 맞춰줘야하지만 자료형도 맞춰줘야함
					 // 해결책 : new Date()); 객체를 받는 파라미터를 넣어줌
		System.out.println("u3: "+u3);
	}

}
