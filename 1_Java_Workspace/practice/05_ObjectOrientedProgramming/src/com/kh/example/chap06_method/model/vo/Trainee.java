package com.kh.example.chap06_method.model.vo;

public class Trainee {
	
	private String name;
	private final String ACADEMY = "KH"; // 변수 대문자 = 상수 -> final
	private char classRoom;
	private String time;
	private  static double score; // 밑줄 = static

	
	public Trainee() {
		
		
	}
	
	public Trainee(String name, char classRoom, String time, double score) {
		this.name = name;
		this.classRoom = classRoom;
		this.time = time;
//		this.score = score; // score가 static인데 this쓴다는 것 자체가 객체를 만들었을 떄 쓰는 방법
		Trainee.score = score; //해결법 : 클래스명.변수명
		// ACADEMY는 상수라서 초기화해봤자 의미 없기에 ACADEMY는 뺀 것
		
	}
	
/////////////////////////////////////////////////////////////////////
///////////////////////   getter & setter   /////////////////////////
/////////////////////////////////////////////////////////////////////
	
	
	// name을 변경하는 메소드
	// getter & setter
	
	// 변경 : setXXX
	// 가져오기(반환) : getXXX
	
	public void setName(String name) { 
	// 캡슐화 원칙 : 기능은 어디서든지 접근 가능하게 public으로 사용한다
	// 값을 변경할거니 값을 받아와야함. 매개변수 사용ㄱㄱ
	// void 반환타입 지정 이유: 수정할꺼 자기 할 일만 하면 되기 때문	
		
		this.name = name; // 변경할 값을 받을 매개변수 (String name)
						  // this.name 수정시킬 값
	}
	
	// name 반환 메소드
	public String getName() {
	// 반환 타입 : String
	// 반환만 해주면 되서 매개변수 필요x
		return name;
//		return this.name; // this안써도 지역변수에 name 없어서 알아서 전역변수name으로
						  // 따라서 그냥 name만 써도 됨
	}
	
	// classRoom 변경 메소드
	public void setClassRoom(char classRoom) {
		this.classRoom = classRoom; // 파라미터에서 받아온 (char classRoom)을
	}								// this.classroom로 넣어서 변경시킴
	
	// classRoom 반환 메소드
	public char getClassRoom () {
	// 반환 필요x 따라서 void X
		return classRoom;
	}
	
	// time 변경 메소드
	// time 반환 메소드
	public void setTime(String time) {
		this.time = time;
	}
	public String getTime() {
		return time;
	}
	
	// ACADEMY 변경 메소드
	// ACADEMY 반환 메소드
	// 상수라 변경수정 불가
	public String getACADEMY() {
		return ACADEMY;
	}
	
	// score 변경 메소드
	// score 반환 메소드
	public static void setScore(double score) {
		Trainee.score = score;
	}
	public static double getScore() {
		return score;
	}
	
	
	public String inform() {
		return name + ", " + ACADEMY + ", " + classRoom + ", " + time + ", " + score;
	}
	
	
}
