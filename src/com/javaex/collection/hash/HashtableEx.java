package com.javaex.collection.hash;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class HashtableEx {

	public static void main(String[] args) {
		Map<String, Student> map = new Hashtable<>();
		
		// 맵에 데이터 추가 및 변경 : put
		map.put("10, 홍길동", new Student(10, "홍길동"));
		map.put("20,홍길동", new Student(20, "홍길동"));
		map.put("30,고길동",new Student(30,"고길동"));
		map.put("30,고길동", new Student(30,"고길동2"));
		// 키는 중복되지 않고, 순서도 없다 (HashSet 이니까)
		
		System.out.println(map);
		
		// 맵데이터 가져오기 : get 
		System.out.println(map.get("30,고길동"));
		
		// 특정 키 포함 여부 
		System.out.println(map.containsKey("30,고길동"));
		
		//  Iterator
		 Iterator<String> it = map.keySet().iterator();
		 while(it.hasNext()) {
			 Student st = map.get(it.next());
			 System.out.println(st);
		 }

	}
	


}
