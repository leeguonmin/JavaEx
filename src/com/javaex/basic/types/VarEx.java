package com.javaex.basic.types;

// 변수의 선언과 할당
public class VarEx {
	public static void main (String[] args) {
		// 변수 명령 규칙
		// 문자, 숫자, $, _의 조합으로 생성
		// 숫자로 시작하면 안 됨
		
		// 변수명 관례
		// 소문자로 작성, 단어의 조합이면 두번째 이후 단어의 첫글자는 대문자로 한다.
		
		/*
		int myAge; // 선언
		myAge = 52; // 초기화
		*/
		
		int myAge = 52; // 선언과 동시에 초기화
		System.out.println("내 나이는" 
				+ myAge + "살입니다");   // 조회 
		
		
		// 한 번에 여러 변수를 선언할 때
		int v1 = 10, v2 = 20, v3 = 30;
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		// System.out.println 이게 출력한다는 의미임.
		
		
		// 여러 변수에 동일한 값을 할당할 때
		v1 = v2 = v3 = 2024;
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);

	}
}
