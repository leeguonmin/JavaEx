package com.javaex.jdbc.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DaoApp {

	public static void main(String[] args) {
		listAuthors();
//		insertAuthor();
		deleteAuthor();
		listAuthors();
		

	}
	
	
	// Author table의 모든 레코드를 출력한다.
	private static void listAuthors() {
		AuthorDao dao = new AuthorDaoImpl();
		
		List<AuthorVo> list = dao.getList();
		Iterator<AuthorVo> iter = list.iterator();
		
		
		
		System.out.println("=======================================");
		
		while (iter.hasNext()) {
			AuthorVo vo = iter.next();
			System.out.println(vo);
		}
		
		System.out.println("=======================================");
		
	}
	
	// 스캐너에서 정보 입력 받아 테이블에 넣는 로직
	private static void insertAuthor() {
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
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 저자 ID:");
		Long authorId = scanner.nextLong();
		
		AuthorDao dao = new AuthorDaoImpl();
		boolean success = dao.delete(authorId);
		
		System.out.println("AUTHOR DELETE " + (success ? "성공": "실패"));
		
		scanner.close();
	}
	
	
	

}
