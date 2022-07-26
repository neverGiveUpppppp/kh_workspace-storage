package com.kh.practice.snack.controller;
import com.kh.practice.snack.model.vo.Snack;

public class SnackController {
	
	private Snack s = new Snack();
	
	// 기본 생성자
	public SnackController() {} // SnackController에 대한 기본생성자
	
	// 데이터를 setter를 이용해 저장하고 저장완료되었다는 
	// 결과를 반환하는 메소드
	public String saveData(String kind, String name, String flavor, int numOf, int price) {
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
		return "저장 완료되었습니다";
	}
	
	// 저정된 데이터를 반환하는 메소드
	public String confirmData() {
		// 바로 위에 public String saveData()에서 저장한 데이터를 불러온다는 것
		// getter통해서도 가능
		
		return s.information();
	}
	
}
