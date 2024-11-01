package com.javaex.basic.opers;


// 비교 연산과 논리 연산
// 연산 결과는 항상 boolean 임
public class LogicalOperEx {

	public static void main(String[] args) {
		int a = 7, b = 3;
		
		// 비교 연산자 : 
		// >, >=, <, <=, ==, !=
		// 크다, 크거나 같다, 작다, 작거나 같다, 같다 , 같지 않다
		// 근데 질문임. 크냐?(초과냐?) 크거나 같냐?(이상이냐?) 작냐?(미만이냐?) 작거나 같냐?(이하냐?) 같냐? 같지 않냐? 로 물어보는 거임
		System.out.println(a > b);
		System.out.println(a == b);
		System.out.println(a != b);
		
		// 논리 연산 : 
		// AND (&&), OR (||), NOT (!)
		// 논리연산은 집합의 개념을 떠올립니다.
		
		int val = 5;
		/*
		 * val가 0초과, val가 10 미만의 값?
		 * 조건1 : val > 0 ?     // val가 0 초과이냐?
		 * 조건2 : val < 10 ?		// val가 0 미만이냐?
		 * 조건1 and 조건2 (교집합 영역)
		 */
		boolean r1 = val > 0;
		boolean r2 = val < 10;
		// 두 조건의 조합
		boolean r1AndR2	= r1 && r2;
		System.out.println("r1 && r2 => " + r1AndR2);
		
		System.out.println(val > 0 && val < 10);
		//System.out.println(val > 0 && val < 10); 를 not 조건 하면 밑에있는 System.out.println("r3 || r4 => " + r3OrR4); 얘랑 같아짐 
		
		/*
		 * val 가 0이하 이거나 val 가 10 이상의 값? 을 보고 싶을땐?
		 * 조건1 : val <= 0 ?   		// val가 0 이하냐?
		 * 조건2 : val >= 0 ?			// val가 
		 * 조건1 or 조건2 (합집합 영역)
		 */
		boolean r3 = val <= 0;
		boolean r4 = val >= 10;
		// 두 조건의 조합
		boolean r3OrR4 = r3 || r4;
		System.out.println("r3 || r4 => " + r3OrR4);
		
		System.out.println(val <= 0 || val >= 10);
		
		// not -> 논리 부정 (여집합)
		boolean rNOT = !(val > 0 && val < 10);
		System.out.println(rNOT);
		
		System.out.println(rNOT == val <= 0 || val >= 10);

	}

}
