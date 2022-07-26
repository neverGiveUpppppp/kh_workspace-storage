
public class practice_everyday01 {
	public static void main(String[] args) {	
		
		// String class : representative methods
		String str = "힘을 내라";
		
		// 1)charAt ()
		// charAt(int index):char
		char cheer = str.charAt(0);
		System.out.println("1."+cheer); // 힘
		
		// 2) concat()
		// concat(String str):String
		// 원래 문자열 끝에 매개변수로 들어온 값을 이어붙인 문자열 반환
		String cstr = str.concat(" cheer up");
		System.out.println("2."+cstr );
		
		
		// 3) equals()
		// equals(Object anObject):boolean
		System.out.println("3."+str.equals("equal"));
		
		// 4)substring()
		// substring(int beginIndex):String
		// 해당 인덱스 넘버부터 문자열 시작
		// substring(int beginIndex, int endIndex):String
		// A to B 사이의 문자열 일부 반환
		
		System.out.println("4.1."+str.substring(0,3));
		System.out.println("4.2."+str.substring(2));
		
		
		// 5)replace()
		// replace(char oldChar, char newChar):String
		
		System.out.println("5."+str.replace('힘','손'));
	}	
}