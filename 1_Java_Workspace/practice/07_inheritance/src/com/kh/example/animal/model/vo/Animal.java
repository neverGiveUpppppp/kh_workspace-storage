package com.kh.example.animal.model.vo;

public class Animal {
	// Animal Dog Snake 3가지의 공통된 코드들이 존재
	// 3코드의 공통분모를 공통으로 묶을 부모클래스를 만들어준다면 편할 것
	// Animal을 부모클래스로 하고 Dog,Snake를 자식 클래스로
	
	private String name;
	private int age;
	private double weight;
	
	public Animal() {}
	
	public Animal(String name, int age, double weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	
	// setter
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getWeight() {
		return weight;
	}
	
	//getter
	
	public String inform(String name, int age, double weight) {
		return null;
	}
	
}
