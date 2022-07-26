package com.kh.example.chap06_method.run;
import com.kh.example.chap06_method.controller.MethodController;
import com.kh.example.chap06_method.model.vo.Trainee;

public class Run {
	public static void main(String[] args) {

		
		MethodController mc = new MethodController();
		mc.method1(); // 반환타입 void : 반환값 없다
//		String a = mc.method1(); // error
								 // 원인 : 반환값이 없는데 변수에 담는게 불가능
		mc.method2(); 			
		int result = mc.method2();		 // 출력 방법
		System.out.println(result);		 // 방법1.변수 도입
		System.out.println(mc.method2());// 방법2.mc.method2() 직접출력
		
		
		int num1 = 10;
		mc.method3(num1,3); // 변수도 리터럴값도 집어넣기 가능
		
		
		mc.method4(8, 6);
		// 출력코드가 없기에 결과값이 아직 보이진 않는다
		System.out.println(result);
		
		
		// 클래스  반환 예시
	
//		int[] arr = mc.method5();	// 얇은 복사
//		System.out.println("Run arr : "  + arr);
//		
//		for(int i=0; i<arr.length; i++) {
//			sum +=arr[i];
//		}
//		System.out.println(sum);
//		
//		
//		User user = mc.method6();
//		System.out.println("User user : " + user);
//		
//		user.inform();
		
	////////////////////////////////////////////////////////////////	
	////////////////////////////////////////////////////////////////	
	////////////////////////////////////////////////////////////////	
		
		System.out.println();
		System.out.println("=============");
		System.out.println();
		
		Trainee t1 = new Trainee("강건강",'G',"종일",100);
		t1.inform();
		String text = t1.inform();
		System.out.println(text);		// 방법1
		System.out.println(t1.inform()); // 방법2
		
		
		Trainee t2 = new Trainee("강건강",'꽃',"종일",100);
		System.out.println(t2.inform());
		// 엄밀히 말하면 t1과 t2는 다른 학생. 주소값이 다르기 때문
		
		// 필드 초기화는 생성자만 있는게 아님
		// 객체를 가지고서만 하는게 아니라 메서드를 통해서도 초기화 가능
		// 기본 생성자 하나 만들고 이름만 초기화 할 수 있는 메소드를 이용해서 값을 초기화 시킬것
		// 일부 값만 초기화(변경)하고 싶으면 메소드를 사용하면 됨
		// 수정에 관한 기존 메소드가 없기에 우리가 수정하는 메소드를 만들어줘야함
		// 초기화(=수정=세팅)
		// 수정
		
		
		System.out.println("=== 값 변경 ===");
		char classRoom = t2.getClassRoom();
		System.out.println(classRoom);
		t2.setClassRoom('A');
		System.out.println(t2.inform());
		t2.setScore(95); 		 // static 메소드라 노란줄
		Trainee.setScore(95);    // 클래스 호출 방식으로 호출로 해결
		System.out.println(t2.inform());
		
		Trainee.setScore(58.3);
		System.out.println(Trainee.getScore());
		System.out.println(t2.inform());
		
		
		
		
	}

}
