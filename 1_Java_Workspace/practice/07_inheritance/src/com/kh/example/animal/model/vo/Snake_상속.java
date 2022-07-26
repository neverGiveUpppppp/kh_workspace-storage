package com.kh.example.animal.model.vo;

public class Snake_상속 extends Animal_상속 {

	// 공통된 부분인 name,age,weight의 전역변수, 매개변수 생성자 및 set get  삭제 
	private String pattern;
	
	public Snake_상속() {}
	
	public Snake_상속(String name, int age, double weight, String pattern) {
		super(name,age,weight);
		this.pattern = pattern;
		
	}
	
	// setter & getter
	// 공통된 부분인 name,age,weight의 전역변수 및 set get  삭제 
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getPattern() {
		return pattern;
	}
	
	
//	@Override
//	public String inform() {
//		// 부모 클래스 메소드 불러오기
//		// 방법1
////		return super.getName()+super.getAge()+super.getWeight()+pattern;
//		// 방법2
//		return super.inform()+pattern;
//	}	
	// 에러원인
	// inform() 안에 매개변수를 설정해둔 상태여서 이걸 다른 dog,animal inform의 매개변수에도 
	    // 설정해주던가 다 지워주던가 해야함.
	
//	@Override
//	public String inform() {
//		return super.inform();
//	}
	
	@Override
	public String toString() {
		return super.toString()+" "+pattern;
	}
	
}
