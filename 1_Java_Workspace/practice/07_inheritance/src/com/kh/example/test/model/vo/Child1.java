package com.kh.example.test.model.vo;

public class Child1 {

	private String str;
	
	// Parent 안에 접근 시도
	public Child1() {
		Parent p = new Parent();
//		p.num = -10;    // private : not visible. 범위가 같은 클래스 내에서만이라 접근 불가
		p.dNum = 0.0;   // default: 같은 패키지 내라 접근가능 
		p.bool = false; // protected : 같은 패키지라 접근가능. 상속상태면 패키지 넘어서도 가능 
		p.ch = 'A';     // public : 접근범위 전체. 접근가능
		
		
		
	}
	
	
	
	public void setStr(String str) {
		this.str = str;
	}
	public String getStr() {
		return str;
	}
	
	
}
