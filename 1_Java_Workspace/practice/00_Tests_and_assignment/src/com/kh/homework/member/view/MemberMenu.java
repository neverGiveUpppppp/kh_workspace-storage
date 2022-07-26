package com.kh.homework.member.view;
import java.util.Scanner;
import com.kh.homework.member.controller.MemberController;

public class MemberMenu {

	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	
	
	
	public MemberMenu () {}
	public void mainMenu() {
		System.out.printf("최대 등록 가능한 회원 수는 %d명 입니다%n",MemberController.SIZE); // mc.SIZE라고 했다면 에러는 아니나 목적과 다른 코드라 틀린 코드. 가리키는게 다름
		System.out.printf("현재 등록된 회원수는 %d명 입니다%n",mc.exisMemberNum());
		
		if(mc.exisMemberNum() !=10 ) {
			System.out.println("1. 새회원 등록");
			System.out.println("2. 회원검색");
			System.out.println("3. 회원 삭제");
			
			
			int menuNum = Integer.parseInt(sc.nextLine()); // 얼마 받아올지 모르기에 Integer.parseInt()
			
			switch(menuNum) {
			case 1: insert
			case 2:
			case 3:
			case 4:
			case 5:
			case 9:
			}
			
		}
	}
	// 1.회원등록 코드
	public void insertMember() {
		
		System.out.println("새 회원을 등록합니다.");
		
		boolean check = false;
		String id = null;
		do {
			System.out.print("아이디 : ");
			String inputId = sc.nextLine();
			check = mc.checkId(inputId);
			if(check) {
				id = inputId;
			}else {
				System.out.println("중복된 아이디. 다시 입력");
			}
		}while(!check);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("비밀번호 : ");
		String name = sc.nextLine();
		System.out.print("이메일 : ");
		String name = sc.nextLine();
		
		String gender = null;
		do {
			System.out.print("성별(M/F) : ");
			gender = sc.nextLine();
			if(!gender.toUpperCase().equals("M") && !gender.toUpperCase().equals("F")) {
				System.out.println("성별 다시 입력");
			}
//		}while(!gender.equals("M" && !gender.equals("m") && !gender.equals("F") && !gender.equals("f"))
		// 대문자로 변환하는 toUpperCase()
		// 대소문자 전부 경우의수를 생각해줘야하니 toUpperCase()메소드로 해결
		}while(!gender.toUpperCase().equals("M") && !gender.toUpperCase().equals("F"));
		
			
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		mc.insertMember(id, name, password, email, gender, age);
		
	}
	
	// search
	// 1.회원등록 코드
	public void searchMember() {
		System.out.println("1. 아이디로 검색하기");
		System.out.println("1. 아이디로 검색하기");
		System.out.println("1. 아이디로 검색하기");
		System.out.println("1. 아이디로 검색하기");
		int menuNum = Integer.parseInt(sc.nextLine());
		
		switch(menuNum) {
		case 1: break;
		case 2: break;
		case 3: break;
		case 9: break;
		default:
				
		}
		
		System.out.println("새 회원을 등록합니다");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		System.out.print("이멜 : ");
		String email = sc.nextLine();
		System.out.print("성별(M/F) : ");
		char gender = sc.nextLine().charAt(0);
		System.out.print("나이 : ");
		int age = sc.nextInt();
	}
	public void searchId() {
		System.out.print("검색할 아이디 : ");
		String id = sc.nextLine();
		String result = mc.searchId(id);
		if(result != null) {
			System.out.println("찾으신 회원 검새 결과입니다");
			System.out.println(result);
		}else {
			System.out.println("검색할 결과가 없습니다");
		}
		
		
	}
	public void searchName() {
		System.out.print("검색할 이름 : ");
		String name = sc.nextLine();
		Member[] result = mc.searchName(name);
		
		int count = 0;
		for(int i=0; i < result.length; i++) {
			if(result[i] == null) {
				count++;
			}
		}
		
		if(count == 10) {
			System.out.println("검색할 결과가 없습니다");
		}else {
			System.out.println("찾으신 회원 검새 결과입니다");
			for(int i=0; i < result.length; i++) {
				if(result[i] != null) {
					System.out.println(result[i].inform());
				}
			}
		}
		
	}
	public void searchEmail() {
		System.out.print("검색할 이메일 : ");
		String email = sc.nextLine();
		Member[] result = mc.searchEmail(email);
		
		int count = 0;
		for(int i=0; i < result.length; i++) {
			if(result[i] == null) {
				count++;
			}
		}
		
		if(count == 10) {
			System.out.println("검색할 결과가 없습니다");
		}else {
			System.out.println("찾으신 회원 검새 결과입니다");
			for(int i=0; i < result.length; i++) {
				if(result[i] != null) {
					System.out.println(result[i].inform());
				}
			}
		}
	}
	
	// update
	public void updateMember() {
		System.out.println("1. 비밀번호 수정하기");
		System.out.println("2. 이름 수정하기");
		System.out.println("3. 이메일 수정하기");
		System.out.println("9. 메인으로 돌아가기");
		
		
		
	}
	public void updatePassword() {
		System.out.print("수정할 아이디 : ");
		String id = sc.nextLine();
		System.out.print("수정할 비밀번호 : ");
		String password = sc.nextLine();
		boolean check = mc.updatePassword(id, password);
		if(check) {
			System.out.println("수정 성공");
		}else {
			System.out.println("존재하지않는 아이디");
		}
		
	}
	public void updateName() {
		System.out.print("수정할 아이디 : ");
		String id = sc.nextLine();
		System.out.print("수정할 비밀번호 : ");
		String password = sc.nextLine();
		boolean check = mc.updatePassword(id, password);
		if(check) {
			System.out.println("수정 성공");
		}else {
			System.out.println("존재하지않는 비번");
		}
	}
	public void updateEmail() {
		System.out.print("수정할 아이디 : ");
		String id = sc.nextLine();
		System.out.print("수정할 이메일 : ");
		String email = sc.nextLine();
		boolean check = mc.updateEmail(id, email);
		if(check) {
			System.out.println("수정 성공");
		}else {
			System.out.println("존재하지않는 이메일");
		}
	}
	
	//delete
	public void deleteMember() {
		System.out.println("1. 특정 회원 삭제하기");
		System.out.println("2. 모든 회 삭제하기");
		System.out.println("9. 메인으로 돌아가기");
		int menuNum = Integer.parseInt(sc.nextLine());
		
		switch(menuNum) {
		case 1: deleteOne(); break;
		case 2: deleteAll(); break;
		case 3: System.out.println("메인으로 돌아갑니다");break;
		default: System.out.println("잘못 입력하셨습니다");break;
		}
	}
	public void deleteOne() {
		System.out.print("삭제할 아이디 : ");
		String id = sc.nextLine();
		System.out.print("정말 삭제하시겠습니까?(Y/N) : ");
		char answer = sc.nextLine().charAt(0);
		if (answer == 'y' || answer == 'Y') {
			boolean check = mc.delete(id);
			if(check) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("존재하지않는 아이디");
			}
		}
		
		
	}
	public void deleteAll() {
		System.out.print("정말 삭제하시겠습니까?(Y/N) : ");
		char answer = sc.nextLine().charAt(0);
		if (answer == 'y' || answer == 'Y') {
			mc.delete();
			System.out.println("성공적으로 삭제하였습니다.");
		}
	}
	
	// print all
	public void printAll() {
		Member[] result = mc.printAll();
		if(mc.exisMemberNum() == 0 ) {
			System.out.println("저장된 회원 없습니다");
		}else {
			for(int i = 0; i<result.length; i++) {
				if(result[i] != null) {
					System.out.println(result[i].inform());
				}
			}
		}
	
	
	
}
