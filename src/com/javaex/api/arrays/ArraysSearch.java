package com.javaex.api.arrays;

import java.util.Arrays;

public class ArraysSearch {

	public static void main(String[] args) {
		besicSearch();
		customSearch();
	

	}
	
	
	
	
// -------------------------------------------------------------------------------------------------------//
	
	
	
	private static void besicSearch() {
		// Java Arrays의 search는 기본적으로 binarySearch 알고리즘을 사용
				// 기본 타입 검색
				int[] nums = {5,7,3,1,2,4,6,8,9,10};		
				System.out.println("원본 배열: "+Arrays.toString(nums));	
				
				Arrays.sort(nums); 			// binarySearch는 sort가 우선
				System.out.println("소팅: "+Arrays.toString(nums));
				
				int index = Arrays.binarySearch(nums, 7); 	// nums에서 여기서 7을 찾아볼거임
				System.out.println("7의 인덱스: "+index);		
				
				
				// 참조 타입 검색
				String[] str = {"Java", "C", "C++", "Python", "Linux"};
				Arrays.sort(str);
				System.out.println("소팅: "+Arrays.toString(str));
				
//				int index2 = Arrays.binarySearch(str, "Java");
//				System.out.println("Java의 인덱스:"+index2);
				
				int index2 = Arrays.binarySearch(str, "Python");
				System.out.println("Python의 인덱스: "+index2);
				
	}
	
	
	
	private static void  customSearch() {
		// 사용자 정의 클래스의 소팅
			Member m1=new Member("홍길동");
			Member m2 = new Member("고길동");
			Member m3= new Member("장길산");
			Member m4 =new Member("임꺽정");
				
				
			Member[] members= {m1,m2,m3,m4};
			System.out.println("원본 배열:"+Arrays.toString(members));
			
			Arrays.sort(members); 		// 정렬
			System.out.println("소팅:"+Arrays.toString(members));
			
			int index = Arrays.binarySearch(members, new Member("장길산"));
			System.out.println("장길산은 "+index+" 번 인덱스에 위치");
		
	}



}
