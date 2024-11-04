package com.javaex.basic.flow;

import java.util.Scanner;

// 
public class ConditionalEx {

	public static void main(String[] args) {
		ifEx();

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
	
	
}

