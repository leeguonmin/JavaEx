package com.javaex.basic.reftypes;

import java.util.Arrays;

public class ArrayEx {

	public static void main(String[] args) {
//		usingArray();		//  1차원 배열
		multiDimArrayEx();	// 2차원 배열 
//		arrayCopyForEx();
//		arrayCopySystem();
//		enhancedFor();
		
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
		
		System.out.println();
		// scores 배열이 있음. 근데!
		int scores2[] = scores;			// 참조 복제 (가장 쉬운 복제지만, 정상적인 복제는 아님) 근데 이게 왜 중요하냐. 얘네 메모리 구조를 볼 필요가 있음
		
		System.out.println("scores:" + Arrays.toString(scores));
		System.out.println("scores2:" + Arrays.toString(scores2));
		
		// scores2의 2번 인덱스 숫자를 변경
		scores2[2] = 100;
		System.out.println("scores2:" + Arrays.toString(scores2));
		System.out.println("scores:" + Arrays.toString(scores));		// 출력하면, scores2에서만 100점으로 바꿀려했는데, 얘도 100점으로 수정되어버림
																		// 왜냐, 참조 복제의 경우. scores를 복제해서 2가 나온거라, 결국 heep에 들어있는 메모리가 같아서
																		// 같이 복제 되는 거임
		// 참조 복제 -> 객체의 주소를 복사하는 것 (주의해야 함)
		
	
	}
	
	
	
	private static void multiDimArrayEx() {
		// 5행 10열의 2차원 배열 (예제인거임)
		int[][] twoDimens = new int[5][10];		// 빈 2차원 배열
		
		// 기본 데이터가 있을 경우
		int table[][] = {
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 },
				{ 2, 3, 4, 5, 6, 7, 8, 9, 0, 1 },
				{ 3, 4, 5, 6, 7, 8, 9, 0, 1, 2 },
				{ 4, 5, 6, 7, 8, 9, 0, 1, 2, 3 },
				{ 5, 6, 7, 8, 9, 0, 1, 2, 3, 4 }
		};
		
		System.out.println("table.length:" + table.length);			// 0부터 시작하기 때문에 -1 이라고 이해했는데 왜 5 나오는거야?ㅠ 못들었어 타자치느냐ㅠ 어우등신아정신차려ㅠ
		// 인덱스 범위 : table[0] ~ table[table.length - 1]
		
		System.out.println("table[0].length:" + table[0].length);
		// 인덱스 범위 : table[0][0] ~ table[0][table[0].length - 1]
		
		// table 배열 내부의 모든 요소의 합을 구하시오
		int sum = 0; 
		for (int row = 0; row < table.length; ++row) { 	// 행 루프
			for (int col = 0; col < table[row].length; ++col) {	// 열루프
				int val = table[row][col];
				
				System.out.print(val + "\t");
				sum += val; 		// 내부 cell 데이터 합산
			}
			System.out.println();
		}
		
		System.out.println("합산 결과: " + sum);
		
	}
	
	
	
	private static void arrayCopyForEx() {
		// 배열은 크기 변경이 안된다 ~
		// (기존 박스가 꽉 찼는데 추가하려면) 새 배열을 생성하고 복사해야함
		int source[] = {1,2,3};
		System.out.println("원본:"+Arrays.toString(source));
		
		// 7개의 빈 공간이 더 필요하다
		int target[] = new int[10];
		
		//  source 있는 애들을 복사!
		for (int i = 0; i<source.length; ++i) {			// ++i 하나씩 늘려간다			// 시작위치를 바구면,  source에 있는 숫자가 들어가는 위치가 바뀌기도 함
			target[i] = source[i];
		}
		System.out.println("복사본: " + Arrays.toString(target));
	}
	
	
	
	private static void arrayCopySystem() {
		// 손 쉬운 배열 복제 ( arrayCopyForEx() 얘는 무식한 배열 복제였었음)
		
		int source[] = {1,2,3};
		System.out.println("원본:"+Arrays.toString(source));
		
		int[] target = new int[10];			// 10개 짜리 정수형 배열을 하나 만들었습니다 짜잔
		
		// 복제
		System.arraycopy(source,				// 원본 뱌열
				0,							// 시작 인덱스
				target,						// 타겟 배열
//				0,							// 타겟 배열의 시작 인덱스
				4,							// > 타겟 배열 시작 인덱스를 이렇게 4로 바꿔주면, 출력하면 4번째에서부터 복사되어있는걸 볼 수 있음 
				source.length);				//복사할 길이 
		
		System.out.println("복사본: " + Arrays.toString(target));
	}
	
	
	
	
	private static void enhancedFor() {
		int[] nums = {1,2,3,4,5,6,7,8,9,10};
		// 일반적인 for문
		for (int i =0; i<nums.length; ++i) {  		// ++i 하나씩 늘려간다고
			System.out.print(nums[i] + "\t");
		}
		System.out.println();
		
		
		// Enhanced For:
		// 카운터 변수, 반복 조건, 증감식 신경쓰지 않고
		// 손쉽게 컬렉션 데이터(배열 등)를 조작할 수 있다  	// (편의 기능)
		for (int num: nums) {
			System.out.print(num+"\t");
		}
		System.out.println();
		
	}
	
	
	
	
	
	
	
	
}
