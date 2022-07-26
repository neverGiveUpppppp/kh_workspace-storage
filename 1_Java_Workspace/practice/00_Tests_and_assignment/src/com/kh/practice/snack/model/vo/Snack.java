package com.kh.practice.snack.model.vo;

public class Snack {

	private String kind;
	private String name;
	private String flavor;
	private int numOf;
	private int price;
	
	// 기본 생성자
	public Snack() {}
	
	// 매개변수 있는 생성자
	public Snack(String kind, String name, String flavor, int numOf, int price) {
		this.kind = kind;
		this.name = name;
		this.flavor = flavor;
		this.numOf = numOf;
		this.price = price;
	}
	
	// 담긴 데이터를 리턴하는 메소드
	public String information() {
		// 리턴 방법 3가지
//		String result = kind+"("+name+" - " + flavor + ") "+numOf+"개"+price+"원";
//		return kind+", "+name+", "+flavor+", "+numOf+", "+price;
		return kind+"("+name+" - " + flavor + ") "+numOf+"개"+price+"원";
	}
	
	
	
	// setter
	// 데이터를 변수에 저장하는 메소드
	public void setKind(String kind) {
		this.kind = kind;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public void setNumOf(int numOf) {
		this.numOf = numOf;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	
	// getter
	// 저장된 데이터를 불러오는 메소드
	public String getKind() {
		return kind;
	}
	public String getName() {
		return name;
	}
	public String getFlavor() {
		return flavor;
	}
	public int getNumOf() {
		return numOf;
	}
	public int getPrice() {
		return price;
	}
	
	
	
}
