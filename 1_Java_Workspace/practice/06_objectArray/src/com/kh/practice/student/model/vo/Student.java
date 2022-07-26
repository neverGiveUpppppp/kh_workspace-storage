package com.kh.practice.student.model.vo;

public class Student {

	private String name;
	private String subject;
	private int score;
	
	// 기본 생성자
	public Student() {}
	
	// 3개의 초기값을 받는 생성자
	public Student(String name, String subject, int score) {
		this.name = name;
		this.subject = subject;
		this.score = score;
		
	}
	
	// setter
	public void setName(String name) {
		this.name = name;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void score(int score) {
		this.score = score;
	}
	
	// getter
	public String getName() {
		return name;
	}
	public String getSubject() {
		return subject;
	}
	public int Score() {
		return score;
	}
	
	// Student 클래스의 모든 필드 값들을 합쳐 반환
	public String inform() {
		System.out.println("========== 학생 정보 출력 ==========");
		System.out.println("========== 학생 성적 출력 ==========");
		System.out.println("========== 학생 결과 출력 ==========");
		
		return name;
	}
	
}
