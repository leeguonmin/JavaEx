package com.javaex.basic.flow;

import java.util.Scanner;

// 
public class ConditionalEx {

	public static void main(String[] args) {
//		ifEx();
//		ifEx2();
//		ifEx3()
		ifPractice01();

	}

	private static void ifEx() {
		Scanner scanner = new Scanner(System.in);        // 에러나면 컨트롤 쉬프트 o -> 설계도를 가져온거임
		
		// 점수를 입력받아서 60점 이상이면 합격이다 > 일단 스캐너부터 필요
		System.out.println("점수를 입력하세요:");
		int score = scanner.nextInt();
		
		
		// if ~ else ~ 
		    // (자격조건)  ->  자격 조건에 합당하다 {} < 들어올수있음
		if (score >= 60) {    // 조건 만족시
			System.out.println("이열 합격입니다");
			
		} else {
			// 조건 불만족시
			System.out.println("저런, 안타깝지만 불합격이세요~");
			
		}
		
		scanner.close();
		// 스캐너 다 썼으면 꼭 닫아주기
		
		
			
//		if (score <= 59) {
//				System.out.println("불합격입니다 깔깔");
//		}
		
		
	}
	
	
	
	private static void ifEx2() {
		// if ~ else if ~ else ~
		// 정수를 입력 받아서, 양수인지 0인지 음수인지 판별
		// 스캐너부터 열어줘
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수를 입력하세요:");
		int num = scanner.nextInt();
		
		// 조건 1 : 0 체크 -> 나머지 : 양수 or 음수
		// 조건 2 : 양수 체크 -> 나머지 : 음수
		
		// 일반적인 순차 조건 분기
		/*
		if (num == 0) {
			System.out.println("0입니다.");
		} else if (num > 0) {
			System.out.println("양수입니다");
		} else {
			System.out.println("음수입니다");
		}
		
		scanner.close();
				*/
		
		
		// 중첩 if
				if (num == 0) {
					System.out.println("0입니다~");
				} else {
					// 양수 or 음수
					if (num > 0) {
						System.out.println("양수입니다.");
					} else {
						System.out.println("음수입니다");
					}
				}
				scanner.close();
	}

	
	
//	private static void ifEx3() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("정수를 입력하세요:");
//		int num = scanner.nextInt();
//				
//		// 중첩 if
//		if (num == 0) {
//			System.out.println("0입니다~");
//		} else {
//			// 양수 or 음수
//			if (num > 0) {
//				System.out.println("양수입니다.");
//			} else {
//				System.out.println("음수입니다");
//			}
//		}
//		scanner.close();
//		
//	}
//	
//	
	
	
	private static void ifPractice01() {
		// 과목 번호 입력 -> 강의실 번호 출력
		// 1 > "R101호 입니다"
		// 2> "R202호 입니다."
		// 3 > "R303호 입니다."
		// 4 > "R404호 입니다"
		// 나머지 > "상담원에게 문의하세요"

		
		// 예제 혼자 해본거
		System.out.println("과목을 선택하세요");
		System.out.println("(1.자바  2.C  3.C++  4.파이썬)");
		
		Scanner scanner = new Scanner(System.in);
		// 설계도를 바탕으로 새로운 설계도를 만들것이다~ 라는 의미 
		System.out.println("과목번호:");
		int num = scanner.nextInt();
		// 선생님은 num를 subj 로
		
		if (num == 1) {
			System.out.println("R101호 입니다");
		} else if (num == 2) {
			System.out.println("R202호 입니다.");
		} else if (num == 3) {
			System.out.println("R303호 입니다.");
		} else if (num == 4) {
			System.out.println("R404호 입니다");
		} else {
			System.out.println("상담원에게 문의하세요");
		}
		
		scanner.close();
	}
	
	
	
	
	
	
	
}

