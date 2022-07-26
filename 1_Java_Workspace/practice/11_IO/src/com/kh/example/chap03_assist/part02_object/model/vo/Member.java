package com.kh.example.chap03_assist.part02_object.model.vo;
import java.io.Serializable;

public class Member implements Serializable { // implements Serializable : Member클래스의 직렬화 
	// 노랑줄 : The serializable class Member does not declare a static final serialVersionUID field of type long
	// 안쓴다고 에러나는건 아니지만 쓰면 혹시 모를 에러를 잡아주니 쓰는걸 추천
	// Member 노란줄에 이클립스 추천 명령어에서 add generated serial version ID 클릭
	/**
	 * 
	 */
	private static final long serialVersionUID = -317919167845418272L;
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private int age;
	private char gender;
	private double point;
	
	public Member() {}
	public Member(String userId, String userPwd, String userName) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
	}
	public Member(String userId, String userPwd, String userName, String email, int age, char gender, double point ) {
		this(userId,userPwd, userName);
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.point = point;
	}
	
	
	// getter
	// 저장된 데이터를 불러오는 메소드
	public String getUserId() {
		return userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public String getEmail() {
		return email;
	}
	public int getAge() {
		return age;
	}
	public char getGender() {
		return gender;
	}
	public double getPoint() {
		return point;
	}
	
	// setter
	// 데이터를 변수에 저장하는 메소드
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	
	@Override
	public String toString() { 
		return userId+" "+userPwd+" "+userName+" "+email+" "+age+" "+gender+" "+point;
	}// toString 자체가 객체에 대한 대표값을 가지고 있는데 inform()이나 다른걸로 넣어줄 수 있지만 
	 // toString을 통해서 대표값에 넣을 수 있도록 오버라이딩. 
	 // 인폼이나 다른 메소드들을 추가적으로 안만들기 위해
	
}
