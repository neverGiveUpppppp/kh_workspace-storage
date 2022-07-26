package com.kh.homework.member.controller;
import com.kh.homework.member.model.vo.Member;

public class MemberController {

	private Member[] m = new Member[SIZE]; // 멤버(회원들) DB를 저장할려고 배열로 만든 것.
	public static final int SIZE = 10;
	
	// 현재 존재하는 멤버수 반환
	public int exisMemberNum() {
		// 전체 회원수(전체 배열길이) 10 중에 NULL이 아닌 것을 카운트하면 현재회원수
		int count = 0;
		for(int i=0; i <m.length;i++) {
			if(m[i] != null) {
				count++;
			}
		}
		return count;
	}
	// 아이디 중복확인 메소드
	public boolean checkId(String inputId) {
		
		for(int i = 0; i<m.length; i++) {
			if(m[i] != null && m[i].getId().equals(inputId)) {
				return false;
			}
		}
		return true;
	}
	//멤버객체를 객체배열에 저장하는 메소드
	public void insertMember(String id, String name, String password, 
			String email, String gender, int age) {
		for(int i = 0; i<m.length; i++) {
			if(m[i] != null) {
				m[i] = new Member(id,name,password,email,gender.charAt(0));
				break;
			}
		}
	}
	
	// search
	// 아이디로 회원조회하는 메소드
	public String searchId(String id) {
		for(int i = 0; i<m.length; i++) {
			if(m[i] != null && m[i].getId().equals(id)) {
				return m[i].inform();
			}
		}
		return null;
	}
	//이름으로 회원조회하는 메소드
	public Member[] searchName(String name) {
		Member[] result = new Member[SIZE];
		for(int i = 0; i<m.length; i++) {
			if(m[i] != null && m[i].getId().equals(name)) {
				result[i] = m[i];
			}
		}
		return result;
	}
	// 이메일로 회원 조회하는 메소드
	public Member[] searchEmail(String email) {
		Member[] result = new Member[SIZE];
		for(int i = 0; i<m.length; i++) {
			if(m[i] != null && m[i].getId().equals(email)) {
				result[i] = m[i];
			}
		}
		return result;
	}

	
	// update & del
	// 비밀번호 변경 메소드
	public boolean updatePassword(String id, String password) {
		for(int i = 0; i<m.length; i++) {
			if(m[i] != null && m[i].getId().equals(id)) {
				m[i].setPassword(password);
				return true;
			}
		}
		return false;
	}
	// 이름 변경 메소드
	public boolean updateName(String id, String name) {
		for(int i = 0; i<m.length; i++) {
			if(m[i] != null && m[i].getId().equals(id)) {
				m[i].setPassword(name);
				return true;
			}
		}
		return false;
	}
	// 이메일 변경 메소드
	public boolean updateEmail(String id, String email) {
		for(int i = 0; i<m.length; i++) {
			if(m[i] != null && m[i].getId().equals(id)) {
				m[i].setPassword(email);
				return true;
			}
		}
		return false;
	}
	// 특정 회원 삭제 메소드
	public boolean delete(String id) {
		for(int i = 0; i<m.length; i++) {
			if(m[i] != null && m[i].getId().equals(id)) {
				return m[i].inform();
			}
		}
		return null;
	}
	// 전체 회원 삭제 메소드
	public void delete() {
		
	}
	
	// print
	// 멤버객체 반환 메소드
	public Member[] System.out.print("정말 삭제하시겠습니까?(Y/N) : ");
	char answer = sc.nextLine().charAt(0);
	if (answer == 'y' || answer == 'Y') {() {
		return null;
	}
	
	
}
