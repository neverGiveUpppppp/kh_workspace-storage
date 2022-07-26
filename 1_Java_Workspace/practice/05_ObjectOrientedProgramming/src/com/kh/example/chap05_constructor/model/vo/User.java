package com.kh.example.chap05_constructor.model.vo;
import java.util.Date;

// 5.생성자(constructor)

// 1)기본생성자
// 2)매개변수 있는 생성자

//public class User {
//	private String userId;		// 필드
//	private String userPwd;
//	private String userName;
//	private Date enrollDate;
//
//
//	
//	// 1)기본 생성자
//	public User() {
//		
//	}
//	
//	// 2)매개변수 있는 생성자
//	public User(String id, String pwd, String name) { // 외부에서 값을 받아올 매개변수 지정
//		this.userId = id;	 // 초기화
//		this.userPwd = pwd;
//		this.userName = name;
//	}
//	// 아래 둘 오버로딩 적용될까?
//	public User(String id, Date date) { // 외부에서 값을 받아올 매개변수 지정
//		userId = id;	 // 초기화
//		enrollDate = date;
//	}
//	
//	public User(String id, String pwd, String name, Date date) { // 외부에서 값을 받아올 매개변수 지정
//		
//		userId = id;	 
//		userPwd = pwd;	// 초기화
//		userName = name;
//		enrollDate = date;
//	}
//	
//	
////	public User(String userId, String userPwd, String userName) { 
////		// 외부에서 값을 받아올 매개변수 지정
////		this.userId = userId;	  // 노란줄 : 똑같은 변수에 넣어서 의미없다고 나옴
////		this.userPwd = userPwd;	  // this를 사용해서 해결
////		this.userName = userName; // this를 추가하므로 같은 지역변수를 넣는게 아니라 필드라고 말해주는 것
////	}							  // 그럼 코드 플로우가 런파일에서 인자를 받아서 public User() 매개변수에 들어가고
//								  // 이게 바로 아래인 지역변수인 userId로 들어가서 this.userId = userId;대입을 통해
//								  // userId에 있는 값이 필드인 this.userId로 최종적으로 들어가는 코드
//	
//	public User(String id, String pwd) { 
//		
//		System.out.println(this);  // this 레퍼런스 변수
//	}
//	
//	
////	public User(String s, Date d) { 오버로딩 미적용. error
////		
////	}
//	
//	
//	
//	//출력용 메소드
//	public void inform() {
//		System.out.println(userId+ ", "+userPwd+", "+userName+", "+enrollDate);
//		
//	}
	


/////////////////////////////////////////////////////////////////////	
/////////////////////////   this() 생성자 설명     ////////////////////////
////////////////////////////////////////////////////////////////////
	
// 생성자, 같은 클래스의 다른 생성자를 호출할 때 사용하며 반드시 첫 줄에 선언

public class User {
	private String userId;		// 필드
	private String userPwd;
	private String userName;
	private Date enrollDate;


	
	
	// 2)매개변수 있는 생성자
	public User(String userId, String userPwd, String userName) {
		this(userId,userPwd);  			// this() 생성자
//		this.userId = userId;	 
//		this.userPwd = userPwd;	
		this.userName = userName; 
	}

	
	public User(String userId, String userPwd, Date enrollDate, String userName) { 
		this.userId = userId;	 	// 데이터타입,개수 같아도 순서 다르면 중복에러x
		this.userPwd = userPwd;
		this.enrollDate = enrollDate;
		this.userName = userName;
	}
	
	public User(String userId, Date enrollDate) { 
		userId = userId;	 // 초기화
		this.enrollDate = enrollDate;
	}
	
	public User(String userId, String userPwd, String userName, Date userDate) { // 외부에서 값을 받아올 매개변수 지정
		
//		this.userId = userId;	 
//		this.userPwd = userPwd;	
//		this.userName = userName;
		this(userId,userPwd,userName);
		this.enrollDate = userDate;
	}
	
	
	public User(String userId, String userPwd) { 
		this.userId = userId;
		this.userPwd = userPwd;	
	}
	

	
	
//		public User(String s, Date d) { 오버로딩 미적용. error
//			
//		}
	
	
	
	//출력용 메소드
	public void inform() {
		System.out.println(userId+ ", "+userPwd+", "+userName+", "+enrollDate);
		
	}
	
}
