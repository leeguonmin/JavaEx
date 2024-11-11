package com.javaex.api.arrays;

import java.util.Arrays;
import java.util.Collections;

// 두 객체의 선후 관계 비교를 위해 comparable 인터페이스를 구현해야 한다.
class Member implements Comparable {
	// 필드
	String name;
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Member) {
			Member other = (Member)o;		// 다운 캐스팅
			// 리턴값이 0 -> 순서가 같다 
			// 리턴값이 -1 -> 순서가 앞선다
			// 리턴값이 1 -> 순서가 뒤다
			return name.compareTo(other.name);
		}
		return 0;
	}

	// 생성자
	public Member(String name) {
		this.name=name;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + "]";
	}
	
	
	
/*	
	if(o instanceof Member) {
		Member other = (Member)o;		// 다운 캐스팅
		// 리턴값이 0 -> 순서가 같다 
		// 리턴값이 -1 -> 순서가 앞선다
		// 리턴값이 1 -> 순서가 뒤다
		return name.compareTo(other.name);
	}
	
*/	
	
	
	
}




//-----------------------------------------------------------------------------------------// 원래 클래스는 다른 클래스에 만들어야하는데 





public class ArraysSortEx {

	public static void main(String[] args) {
//		basicDoctTest();		// 기본 타입 소트
		
//		basicSortDescTest();		// 기본 타입 내림차순 정렬 
		
		sortCustomclassTest();		// 사용자 정의 클래스 정렬

	}
	
	private static void basicDoctTest() {
		int[] score= {80,50,30,90,75,88,77};
		System.out.println("원본 배열:" + Arrays.toString(score));
		Arrays.sort(score);
		System.out.println("오름차순 정렬: " + Arrays.toString(score));
		
	}
	
	
	
	private static void basicSortDescTest() {
		// compareTo 가 데이터의 선후 관계를 결정해 주므로
		// 기본 데이터 타입은 역순 정렬을 할 수 없다 (편법으로 가능은 하지만, 원래는 안되는거임. 편법이 Integer 이건가봐
		Integer[] score= {80,50,30,90,75,88,77};			// 컨트롤하고 Integer를 클릭하면 내부 상세 사항을 볼 수 있음 
		System.out.println("원본 배열:" + Arrays.toString(score));
		Arrays.sort(score, Collections.reverseOrder());
		System.out.println("내림 차순 정렬: "+ Arrays.toString(score));
		
	}
	
	
	
	
	private static void sortCustomclassTest() {
		// 사용자 정의 클래스의 소팅
		Member m1=new Member("홍길동");
		Member m2 = new Member("고길동");
		Member m3= new Member("장길산");
		Member m4 =new Member("임꺽정");
		
		
		Member[] members= {m1,m2,m3,m4};
		System.out.println("원본 배열:" + Arrays.toString(members));
//		Arrays.sort(members);
//		System.out.println("오름차순 정렬: " + Arrays.toString(members));
		Arrays.sort(members, Collections.reverseOrder());
		System.out.println("내림차순 정렬: "+Arrays.toString(members)); // 역순
		
		
		
		
		
		
		
		
	}

}
