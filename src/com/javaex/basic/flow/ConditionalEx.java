package com.javaex.basic.flow;

import java.util.Scanner;

// 여기서부터 }까지가 하나의 클래스
public class ConditionalEx {

	public static void main(String[] args) {
//		ifEx();
//		ifEx2();
//		ifEx3()
//		ifPractice01();
//		switchEx();
//		switchEx2();
		switchPractine();

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

	
	// 혼자 먼저 해본거라 주석했음
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
	
	
	
	// 여기서부터
	private static void switchEx() {
		// switch 사용해서 위와 같은 예제 풀어보기
		// ifPractice0  ->  switchEx ~ case 로
		System.out.println("과목을 선택하세요");
		System.out.println("(1.자바  2.C  3.C++  4.파이썬)");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("과목 번호:");
		int subj = scanner.nextInt();
		
		// 변수 값에 따른 조건 분기
		switch (subj) {
		case 1 : 		// subj == 1 이면, 라는 뜻과 동일
			System.out.println("R101호 입니다.");
			break;		// 잊지말자 break
		case 2 :		// subj == 2 이면 
			System.out.println("R202호 입니다");
			break;
		case 3 :		// subj == 3 이면 
			System.out.println("R303호 입니다.");
			break;
		case 4 : 		// subj == 4 이면 
			System.out.println("R404호 입니돠");
			break;
		default: 		// else
			System.out.println("상담원에게 문의하세유");
			break;
		}
		scanner.close();
	}
	// 여기까지 하나의 메모리 블록
	
	
	private static void switchEx2() {
		// 1, 3, 5, 7, 8, 10, 12월 > 31일
		// 2 > 28일
		// 4, 6, 9, 11 > 30일
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.print("월을 입력하세요: ");
		int month = scanner.nextInt();
		
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:		// month == 1 or month == 3 ......
			System.out.println(month + "는 31일입니다.");
			break;
		case 2:
			System.out.println(month + "는 28일입니다.");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println(month + "는 30일입니다");
			break;
		default:
			System.out.println(month + "월이 어딨어?");
			break;
		}
		scanner.close();
	}
	
	
	private static void switchPractine() {
		// TODO: 이 코드를 나중에 enum (열거형) 객체로 다시 만들 예정임
		
		// 문자열 변수에 문자열로 요일 정보를 입력
		// "SUNDAY" -> 휴식
		// "MONDAY" ~ "THURSDAY" -> 열공
		// "FRIDAY" > 열공 후 불금 
		// "SATURDAY" > 주말
		
//		String day = "SUNDAY";		// 재생하면 'SUNDAY에는 휴식'
		String day = "MONDAY";		// 재생하면 'MONDAY에는 열공'
//		String day = "MONDA";		// 재생하면 'MONDA에는 난 누구지?'
		String action;
		
		switch (day) {
		case "SUNDAY":
			action = "휴식";
			break;
		case "MONDAY":
		case "TUESDAY":
		case "WEDNDAY":
		case "THURDAY":
			action = "열공";
			break;
		case "SATUDAY":
			action = "주말";
			break;
		default:
			action = "난 누구지?";
			break;
		}
		
		System.out.println(day + "에는 " + action);
		
	}
	
	
	
}
// 여기까지가 하나의 클래스

