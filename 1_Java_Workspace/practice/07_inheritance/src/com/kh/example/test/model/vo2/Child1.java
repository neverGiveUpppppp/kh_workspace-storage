package com.kh.example.test.model.vo2;

import com.kh.example.test.model.vo.Parent;

public class Child1 {

	public Child1() {
		Parent p = new Parent();
//		p.num = 0;		// private : 접근 불가
//		p.dNum = 10.0;  // default : 패키지 달라서 접근불가
//		p.bool = true;  // protected  : 패키지 다르고 상속도 아님 접근불가.  
		p.ch = 'a';     // public 
		
	}
	
	
}
