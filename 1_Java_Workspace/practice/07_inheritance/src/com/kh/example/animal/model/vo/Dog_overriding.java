package com.kh.example.animal.model.vo;

public class Dog_overriding extends Animal_상속 {

	// 공통된 부분인 name,age,weight의 전역변수, 매개변수 생성자 및 set get  삭제  
	private double height;
	private String hair;
	
	public Dog_overriding() {}
	
	public Dog_overriding(String name, int age, double weight, double height, String hair) {
		super(name,age,weight);
		this.height = height;
		this.hair = hair;
		
	}
	
	// setter & getter
	// 공통된 부분인 name,age,weight의 전역변수 및 set get  삭제 
	
	public void setHeight(double height) {
		this.height = height;
	}
	public double getHeight() {
		return height;
	}
	public void setHair(String hair) {
		this.hair = hair;
	}
	public String getHair() {
		return hair;
	}
	
	public String inform1() {
		
		// 부모 클래스 메소드 불러오기
		//방법1
//		return super.getName()+super.getAge()+super.getWeight()+" "+height+" "+hair;
		// 방법2
		return super.inform()+" "+height+" "+hair;
	}
	
	
}
