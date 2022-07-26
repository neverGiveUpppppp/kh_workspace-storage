package com.kh.example.chap01_String.controller;

public class StringController {
	
	// String : 문자열 클래스
	// 문자열의 값 수정 불가(불변 클래스)
	// String name = "abc";
	// name = "def"; // <-수정된 거 아닌가? 수정된거 아님

	// 배열 크기 변경 불가능
	// 눈으로 보이기는 수정되는 것처럼 보이나 컴퓨터 안에 로직은 삭제 새로생성되었고 주소값도 변경됨
	// 값이 변경되는게 아니고 def가 새로 생성되고 abc가 지워져서 바꿔치기가 되는 것
	// 
	
	
	public void method1() {
		
		// String 만드는 방법 2가지
		// 방법1
		String str1 = "java";
		String str2 = "java";
		// 방법2
		String str3 = new String("java"); // String도 클라스 객체생성 방식으로 생성가능
		
		System.out.println("str1과 str2의 주소는  같은가? : "+(str1 == str2)); // ==은 주소값 비교 // 주소값 같다
		System.out.println("str1과 str3의 주소는  같은가? : "+(str1 == str3)); // 주소값 다르다
		
		// == : 주소값 비교, 기본형
		// .equals : 객체 자체값 비교, 참조형
		
		System.out.println(str1); // 결과값 java
		System.out.println(str2); // String = 참조형
		System.out.println(str3); 			// str3와 아래의 str3.toString은 같은 결과값을 낸다
		System.out.println(str3.toString());// 
		// toString : 객체에 대한 대표값을 반환
		
		// Q. new String(); 객체찍으면 여태까지 주소값이 나왔는데 왜 java라는 결과값이 나왔을까?
		// A. Object클래스의 toString을 오버라이딩 했기 때문에 주소값이 아닌 java가 뜬다
		// 위답의  Object클래스의 toString메소드가 아닌 String클래스의 toString메소드를 사용한다 
		
		// 참조변수.toString = 참조변수는 같은 결과값이 나옴
		// toString : 객체의 대표값을 반환
		// 그렇기에 객체만 찍어도 결과값이 잘나옴.
		
//		// hashCode()
//		주소값을 보기 위해 사용하는 코드
//		객체의 주소값을 해시코드로 구현한 결과값 
//
//		object클래스에 있음. 
//		실제 주소값을 직접 볼 수 있는건 아님.
//		자바는 애초에 주소값을 다이렉트로 볼 수 없게 만듬
		
		System.out.println("str1의 hashcode : "+str1.hashCode());
		System.out.println("str2의 hashcode : "+str2.hashCode());
		System.out.println("str3의 hashcode : "+str3.hashCode());
		
		// identityHashCode()
		// 실주소값을 연산해놓은 결과값을 도출하는 메소드
		System.out.println("str1의 실주소값 : "+System.identityHashCode(str1));
		System.out.println("str2의 실주소값 : "+System.identityHashCode(str2));
		System.out.println("str2의 실주소값 : "+System.identityHashCode(str3));
		System.out.println();
		
		str2 += "oracle"; // 결과값 : javaoracle
		System.out.println(str2);
		System.out.println("str1의 hashcode : "+str1.hashCode()); 			// hashCode()
		System.out.println("str2의 hashcode : "+str2.hashCode());
		System.out.println("str3의 hashcode : "+str3.hashCode());
		System.out.println("str1의 실주소값 : "+System.identityHashCode(str1)); // identityHashCode()
		System.out.println("str2의 실주소값 : "+System.identityHashCode(str2));
		System.out.println("str2의 실주소값 : "+System.identityHashCode(str3));
		
		
	}
	
	public void method2() {
		// StringBuffer & StringBuilder
		
		// 주소값은 그대로하고 문자열을 수정 가능케 하는 메소드(가변)
		// String클래스 : 변경이 적고 읽기만 많은 경우에 유리
		// StringBuffer / StringBuilder : 문자열에 대한 수정이 많이 일어나는 경우 유리
		
		// StringBuffer 동기화 o / 느림 / 안전
		// StringBuilder 동기화 x / 빠름

		
		// 1) StringBuffer & StringBuilder
		StringBuffer buffer1 = new StringBuffer();
		System.out.println("초기 buffer1의 수용량 : " +buffer1.capacity()); 		// StringBuffer에 기본생성자의 최초 capacity는 16으로 설정되어있음
		System.out.println("buffer1에 들어있는 실제 값의 길이 : " +buffer1.length()+"\n"); // 수용량하고 실제값의 길이가 다르다
		
		
		StringBuffer buffer2 = new StringBuffer(100);   // StringBuffer생성자는 int랑 str받는게 있다
		System.out.println("초기 buffer2의 수용량 : " +buffer2.capacity()); 		// 수용량 단위 : character 한문자임
		System.out.println("buffer2에 들어있는 실제 값의 길이 : " +buffer2.length()); //
		System.out.println();
		
		StringBuffer buffer3 = new StringBuffer("abc"); // StringBuffer생성자는 int랑 str받는게 있다
		System.out.println("초기 buffer3의 수용량 : " +buffer3.capacity()); 		// 수용량 단위는 character 한문자이므로 기본용량16에 abc 세글자를 +3해서 19
		System.out.println("buffer3에 들어있는 실제 값의 길이 : " +buffer3.length()); // StringBuffer 생성자에 들어간 문자열 abc 길이3
		System.out.println("buffer3 : " +buffer3); // StringBuffer 생성자에 들어간 문자열 abc 길이3

		System.out.println("buffer3의 실주소값 : " +System.identityHashCode(buffer3)+"\n"); // StringBuffer 생성자에 들어간 문자열 abc 길이3
		
		// 2) append()
		// 받아온 값을 뒤에 추가로 이어주는 메소드
		buffer3.append("abc"); // 결과값 abcabc
		System.out.println(buffer3);
		System.out.println("buffer3의 실주소값 : " +System.identityHashCode(buffer3)); // append 추가후에도 주소값 같음
																				// ->수정 후에도 buffer가변클래스인걸 알 수 있음
		System.out.println("abc 추가 후의 buffer3의 수용량 : " +buffer3.capacity()); 		// 수용량 단위는 character 한문자이므로 기본용량16에 abc 세글자를 +3해서 19
		System.out.println("abc 추가 후의 buffer3에 들어있는 실제 값의 길이 : " +buffer3.length()); // StringBuffer 생성자에 들어간 문자열 abc 길이3
		System.out.println();
		
		buffer3.append("def");
		System.out.println(buffer3); // 결과값 abcabcdef
		System.out.println("abc 추가 후의 buffer3의 수용량 : " +buffer3.capacity()); 		// 수용량 단위는 character 한문자이므로 기본용량16에 abc 세글자를 +3해서 19
		System.out.println("abc 추가 후의 buffer3에 들어있는 실제 값의 길이 : " +buffer3.length()); // StringBuffer 생성자에 들어간 문자열 abc 길이3
		
		// 2) append() 반환값 : Stringbuffer
		buffer3.append("abc").append("def"); // 메소드 체이닝
		System.out.println(buffer3); // 결과값 abcabcdef
		System.out.println("abc, def 추가 후의 buffer3의 수용량 : " +buffer3.capacity()); 		// 수용량 단위는 character 한문자이므로 기본용량16에 abc 세글자를 +3해서 19
		System.out.println("abc, def 추가 후의 buffer3에 들어있는 실제 값의 길이 : " +buffer3.length()+"\n"); // StringBuffer 생성자에 들어간 문자열 abc 길이3
		
		

		// 3) insert()
		// 원하는 자리에 값 추가 시킬 수 있는 메소드
		buffer3.insert(2,"zzz");
		System.out.println("인덱스2에 추가 후의 buffer3 : "+buffer3+"\n"); // abzzzcabcdef
		
		// 4) delete()
		// 데이터 삭제하는 메소드
		// delete(int start, int end) : StringBuffer	
		// deleteCharAt(int index) : StringBuffer	
		
		buffer3.delete(2, 5);							 // zzz 삭제. 마지막 인덱스 미포함. 
		System.out.println("삭제 후의 buffer3 : "+buffer3); // delete(2, 5-1) // (start, end-1)
		buffer3.deleteCharAt(2);
		System.out.println("삭제 후의 buffer3 : "+buffer3+"\n"); // 
		
		
		// 5)reverse()
		// 앞뒤 거꾸로 값을 바꿔놓는 메소드
		buffer3.reverse();							 // zzz 삭제. 마지막 인덱스 미포함. 
		System.out.println("reverse의 buffer3 : "+buffer3); // 
		
		
		StringBuilder sb = new StringBuilder("abc"); 
		sb.append("zzz").insert(2,"yy").reverse().delete(1,3);
		// abc + zzz -> abyyczzz -> zzzcyyba -> zcyyba
	}
	
	public void method3() {
		String str = "Hello world";
		
		// 1)charAt(int index):char ->
		// 해당 문자열의 index번째 문자를 char로 변환
		char ch = str.charAt(4);
		System.out.println(ch);
		
		// 2)concat()
		// concat(String str):String
		// 원래 문자열 끝에 매개변수로 들어온 값을 이어붙인 문자열 반환
		String concatStr = str.concat("!!!");
		System.out.println("concatStr : "+concatStr);
		str += "!!!"; // concat과 같은 역할 : +
		System.out.println(str);
		
		// 3)equals()
		// equals(Object anObject):boolean
		// 문자열이 같은지 확인
		System.out.println("concatStr.equals(str) : "+concatStr.equals(str));
		
		// 4)substring
		// substring(int beginIndex):String
		// 해당 인덱스 넘버부터 문자열 시작. 
		// substring(int beginIndex, int endIndex):String
		// A to B 사이의 문자열 일부 반환
		System.out.println("str.substring(6) : "+str.substring(6));
		System.out.println("str.substring(0,4) : "+str.substring(0,4));
		
		// 5)replace()
		// replace(char oldChar, char newChar):String
		// 기존 문자를 새로운 문자로 대체하여 반환
		System.out.println("str.replace('l','e') : "+str.replace('l', 'e'));
		
		// 6)toUpperCase() & toLowerCase()
		// toUpperCase():String 
		// toLowerCase():String
		// 문자열을 대/소문자로 변형 후 반환
		System.out.println("str.toUpperCase() : "+str.toUpperCase());
		System.out.println("str.toLowerCase() : "+str.toLowerCase());
		
		
		
		// 7)equalsIgnoreCase()
		// equalsIgnoreCase(String anotherString):boolean
		// 대문자는 무시하고 비교
		String str2 = "Wonderful";
		String str3 = "wonderful";
		System.out.println(str2.equals(str3));			// false
		System.out.println(str2.equalsIgnoreCase(str3));// true
		
		
		// 8)trim()
		// trim():String
		// 앞 뒤에 있는 빈 공간을 제거한 문자열 반환
		String str4 = "    Java";
		String str5 = "  Java  ";
		String str6 = "Java    ";
		
		System.out.println(str4+" : "+str4.trim());
		System.out.println(str5+" : "+str5.trim());
		System.out.println(str6+" : "+str6.trim());
		
		
		// 9)split()
		// split(String str):String[] 
		// 전달받은 구분자를 통해 문자열을 잘라 String[]반환
		String splitStr = "Java, Oracle, JDBC, Front, Server, Framework";
		String[] strArr = splitStr.split(", "); // 공백도 나누는 기준인걸 잊지마
		for(int i=0; i < strArr.length; i++) {
			System.out.println(strArr[i]); // 
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
