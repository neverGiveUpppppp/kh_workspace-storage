package com.kh.example.person.model.vo;

public class Run {

	public static void main(String[] args) {
		
		Person p = new Person();
		p.setName("a");
		p.setAge(25);
		p.setGender('M');
		p.setHeight(175.0);
		p.setWeight(80);
		
		p.getName();
		p.getAge();
		p.getGender();
		p.getHeight();
		p.getWeight();
		
		p.personInfo();
		System.out.println(p.personInfo()); // return값 출력
		
//		String name = p.getName();
//		int age = p.getAge();
//		char gender = p.getGender();
//		double height = p.getHeight();
//		double weight = p.getWeight();
//		
//		// 변수 도입 출력 방식
//		System.out.println("이름 : " + name);
//		System.out.println("나이 : " + age);
//		System.out.println("성별 : " + gender);
//		System.out.println("키 : " + height);
//		System.out.println("몸무게 : " + weight);
		

	}

}
