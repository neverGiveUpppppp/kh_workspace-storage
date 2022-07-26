package com.kh.example.chap03_Date.controller;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateController {
	public void method1() {
		Date today = new Date();	// 기본생성자는 현재 시간에 대한 정보를 갖고 객체생성
		System.out.println(today);  // 현재 시각. 초단위까지
		
		System.out.println(today.getTime()); // .getTime() : 1970년도부터 지금까지 흐른 초(second)의 합계
		// Returns the number of milliseconds since January 1, 1970, 00:00:00 GMTrepresented by this Date object.
		
		Date time = new Date(1645668906189L); // 인트 범위를 벗어났기에 long의 접미사 L 꼭 붙일 것
		// Date(long date)
		// 위에 .getTime()으로 얻은 값을 long date에 집어넣은 것
		System.out.println(time);
		
		Date date = new Date(2022,7,13); // new Date()의 취소줄 : 공식API의 Deprecated를 알려주는 것. 사용금지.
	
	}
	public void method2() {

		// 1)Calendar 클래스
		
//		Calendar c = new Calendar(); 		 // error : 추상 클래스라 객체생성 불가능 + 기본 생성자가 protected임
		Calendar c = Calendar.getInstance(); // getInstance() : 캘린더에 있는 static 메소드를 사용한 것
		System.out.println(c);		// []안에 , 기준으로 각각 시간값을 가지고 있는 데이터
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int date = c.get(Calendar.DATE);
		int ampm = c.get(Calendar.AM_PM); // 오전=0 오후1
		int hour = c.get(Calendar.HOUR);
		int hour24 = c.get(Calendar.HOUR_OF_DAY); // 24시간 기준
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		int millisecond = c.get(Calendar.DAY_OF_WEEK);

		
		System.out.println(year);  // 2022
		System.out.println(month); // 1    : month는 0부터 시작하기에 +1해야 월이 제대로 출력됨
		System.out.println(date);
		System.out.println(ampm);
		System.out.println(hour); 
		System.out.println(hour24);
		System.out.println(minute);
		System.out.println(second);
		System.out.println(millisecond);
		
		// 날짜에서 해당 달은 0부터 시작(제로인덱스)
		// 1월 = 0 
		// 2월은 = 1
		// 11월  = 10
		// 12월  = 11
		System.out.println(millisecond); // 요일별로 아래의 해당 숫자가 나옴
		// 일 월 화 수 목 금 토
		// 1 2 3 4 5 6 7
	}
	
	public void method3() {
		
		// 2)GregorianCalendar 캘린더
		
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc);
		
		System.out.println(gc.get(Calendar.YEAR)); // 캘린더 후손 클래스라 캘린꺼 그대로 사용가능
		
		GregorianCalendar end = new GregorianCalendar(2022,/*7*/6, 13, 17, 50, 0); // 월은 0으로 시작하기에
		long time = end.getTimeInMillis();                                                // 7이라고 나오면 8월을 말하는 것
		Date endDate = new Date(time);
		System.out.println(endDate); 
		
		// 평상시 보는 시계
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E요일 a hh시 mm분 ss초"); // 24시 기준  시간 HH
		String fmt = sdf.format(endDate); // 위의 심플데이터포맷에서 형태를 입력 받는다
		System.out.println(fmt);
		
		
		
	}
	
	
}
