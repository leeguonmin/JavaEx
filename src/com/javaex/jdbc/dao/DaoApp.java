package com.javaex.jdbc.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DaoApp {
	
	// 프로그램 실행 클래스겠죠? app
	// 이 클래스는, 위에서 만든 AuthorDaoImpl 클레스를 사용하여 
	// 실제로 데이터베이스에 접근하고 데이터를 처리하는 역할을 하셔

	public static void main(String[] args) {
		listAuthors();
//		insertAuthor();
		deleteAuthor();
		listAuthors();
		

	}
	
	
	// Author table의 모든 레코드를 출력한다.
	private static void listAuthors() {
						// 작가의 모든 정보를 출력
		AuthorDao dao = new AuthorDaoImpl();
		// AuthorDao : 작가의 정보를 다루는 인터페이스
		// AuthorDaoImpl : AuthorDao를 구현한 클래스. 실제로 데이터 베이스에 접근하여 작가의 정보를 가져오는 작업을 수행
		// 이 코드는 AuthorDaoImpl 클래스의 객체를 생성하여, dao 변수에 저장
		// 즉, 데이터베이스에 접근하기 위해 통로를 만든거임
		
		List<AuthorVo> list = dao.getList();
		// dao.getList() : AuthorDaoImpl 클래스의 getList() 메소드를 호출하여 데이터베이스에서 모든 작가 정보를 가져오겠다
		// List<AuthorVo> : 가져온 작가 정보를 저장할 리스트. AuthorVo는 각 작가의 정보를 담는 객체
		Iterator<AuthorVo> iter = list.iterator();
		// Iterator: 리스트에 저장된 요소들을 순서대로 접근하기 위한 인터페이스
		// iter.hasNext(): 리스트에 다음 요소가 있는지 확인하는 
		// iter.next(): 다음 요소를 가져오겠다!
		
		
		
		System.out.println("=======================================");
		
		// 여서 has는 "갖고 있다" 라는 의미로 사용됨.
		// 즉, hasNext() 메서드는 "다음 요소를 가지고 있느냐?"라고 질문을 던지는 셈
		// 자세한 설명 :  Iterator 인터페이스의 hasNext() 메서드는 현재 반복자가 
		// 가리키는 위치의 뒤에 다음 요소가 존재하는지 확인하는 역할을 함 
		// 만약 다음 요소가 있다면 true를 반환하고, 없다면 false를 반환
		while (iter.hasNext()) {
			AuthorVo vo = iter.next();
			// AuthorVo vo = iter.next();: 각 요소를 AuthorVo 객체에 저장하겠돠
			System.out.println(vo);
		}
		
		System.out.println("=======================================");
		
	}
	
	// 스캐너에서 정보 입력 받아 테이블에 넣는 로직
	private static void insertAuthor() {		
						// 사용자 입력을 받아 새로운 작가를 추가할거임
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름: ");
		String name = scanner.nextLine();
		System.out.println("정보: ");
		String desc = scanner.nextLine();
		
		AuthorVo vo = new AuthorVo(name, desc);
		
		AuthorDao dao = new AuthorDaoImpl();
		boolean success = dao.insert(vo);
		
		System.out.println("Author INSERT " + (success ? "성공" : "실패"));
		scanner.close();
		
	}
	
	
	private static void deleteAuthor() {
						// 사용자 입력을 받아 특정 작가를 삭제할거임
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 저자 ID:");
		Long authorId = scanner.nextLong();
		
		AuthorDao dao = new AuthorDaoImpl();
		boolean success = dao.delete(authorId);
		
		System.out.println("AUTHOR DELETE " + (success ? "성공": "실패"));
		
		scanner.close();
	}
	
	
	

}
