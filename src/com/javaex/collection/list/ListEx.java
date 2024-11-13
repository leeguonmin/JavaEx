package com.javaex.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListEx {

	
	// 순서가 있는 자료형, 중복을 허용, List 인터페이스에 선언되어 있다 
	public static void main(String[] args) {
//		List<String> lst = new LinkedList<String>();
		// 프로그램 작성하다가, 효율이 좋은 알고리즘을 알게 되었을 때, 
		// List 인터페이스를 구현한 클래스라면 교체 가능하다
		List<String> lst = new ArrayList<>();	// 이렇게 교체 가능
		
		
		// 객체
		lst.add("Java");		// add : 맨 뒤에 새 아이템 추가 
		lst.add("C");
		lst.add("C++");
		lst.add("Python");
		lst.add("Java");		// 중복 허용 
		System.out.println(lst);
		
		
		// 객체 중간에 삽입
		lst.add(2, "C#");		// C(2번 인덱스)뒤에 C# 추가
		System.out.println(lst);
		
		// 객체 삭제 : 인덱스로 삭제
		lst.remove(5);			// 5번째 인덱스인 Java 삭제 
		System.out.println(lst);
		// 객체 삭제 : 주어진 객체로 삭제
		lst.remove("Java");		// Java 객체를 삭제하라
		System.out.println(lst);
		
		// 요소 개수 확인 
		System.out.println("size=" + lst.size());
		
		
		// List와 Set은 Iterator 반복자를 사용
		System.out.println();
		System.out.println("========== Iterator");
		Iterator<String> it = lst.iterator();
		while(it.hasNext()) {		// 뒤에 더 있니? 물어봐 
			String item = it.next();		// 다음 요소 받아오고 이동
			System.out.println(item);
		}
		
		System.out.println();
		// TODO : 리스트의 순회
		// 리스트 비우기 
		lst.clear();
		System.out.println(lst);
		
		
		
		
		
		

	}

}
