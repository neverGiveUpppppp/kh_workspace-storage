package com.kh.example.practice4.model.vo;

public class Book {
	
	private String title;
	private String publisher;
	private String author;
	private int price;
	private double discountRate;
	
	// 기본 생성자
	public Book() {
				
	}
	
	// 매개변수 3개인 생성자
	public Book(String title, String publisher, String author) {
		this.title = title;			// 값넣기까지 초기화 // 값을 대입시키는게 초기화
		this.publisher = publisher;
		this.author = author;
	}
	
	// 매개변수 5개인 생성자
	public Book(String title, String publisher, String author, 
				int price, double discountRate) {
		this.title = title;
		this.publisher = publisher;
		this.author = author;
//		this(title,publisher,author); 	// this() 생성자
		this.price = price;
		this.discountRate = discountRate;
		
	}
	
	public void inform() {
		System.out.printf(" title : %s%n publisher : %s%n author : %s%n price : %d%n 할인율 : %f",title,publisher,author,price,discountRate);
	}
	
}


