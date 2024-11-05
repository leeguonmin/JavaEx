package com.javaex.basic.reftypes;

public class ArrayEx {

	public static void main(String[] args) {
		usingArray();

	}

	private static void usingArray() {
		// 배열의 선언과 초기화, 그리고 사용
		// 선언
		String[] names; 	// Type[] 식별자  	< 이렇게 만들어도 되고
		int scores[];		// Type 식별자[]		< 이렇게 만들어도 됨
		
		// 초기화
		names = new String[] {
				"김", "이", "박", "최"
		};		// 초기값이 이미 있을 때
		
		
		
		scores = new int[4];		//  빈 배열 만들기
		// 인덱스 접근
		// 0부터 시작
		// .length - 1 까지 (= 랭스에서 하나 뺀 숫자까지)
		scores[0] = 80;
		scores[1] = 90;
		scores[2] = 85;
		scores[3] = 88;
		
		float heights[] = {
				175.3f, 
				170.2f,
				173.4f,
				168.5f
		};			// 선언과 동시에 할 때만 가능
		
		// names, scores, heights 를 같은 인덱스에 접근해서 확인 (같은 인덱스에 묶어서 관리할 수 있는 방법??)
		for (int i = 0; i < names.length; ++i) {
			System.out.printf("%s (%.2f) : scores = %d%n", names[i],
															heights[i],
															scores[i]);			
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
