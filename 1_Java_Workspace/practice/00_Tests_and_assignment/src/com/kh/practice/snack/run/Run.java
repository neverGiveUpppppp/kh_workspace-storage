package com.kh.practice.snack.run;
import com.kh.practice.snack.view.SnackMenu;

public class Run {

	public static void main(String[] args) {

		// menu() 호출
		
		// 방법1
//		SnackMenu sm = new SnackMenu();
//		sm.menu();
		
		// 방법2
		new SnackMenu().menu(); // 객체에서 바로 실행

	}

}
