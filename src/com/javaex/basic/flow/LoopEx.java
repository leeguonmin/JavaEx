package com.javaex.basic.flow;

import java.util.Scanner;

public class LoopEx {

	public static void main(String[] args) {
//		whileEx();
//		whileGuge();
//		doWhileEx();
//		forGugu();
		randomEx();

	}
	
	
	private static void whileEx() {
		// while (condition) {}
		// condition 이 참인 동안 브록을 반복
		/*
		 * I Like Java0
		 * I Like Java2
		 * I Like Java3
		 * I Like Java4
		 * I Like Java5
		 */
		
		int i = 0; 		// 반복 제어 변수
		
		while ( i < 5 ) {				// ( i <= 4) 여도 됨
			System.out.println("I Like Java" + i);
			// 주의 : 반복 제어 변수가 false 가 되어야 탈출이 가능하기 때문에, 잘 조정해야 한다.
			i += 1;			//+= 확장 할당 연산자		// i = +1   ->   중복 빼주면   ->   i += 1
		}	
		
	}

	
	
	private static void whileGuge() {
		// 단을 입력 받아서 해당 단의 구구표를 출력
		Scanner scanner = new Scanner(System.in);
		System.out.println("단을 입력하세요.");
		System.out.println("단:");
		
		int dan = scanner.nextInt();
		int i = 1; 		// 반복 제어 변수
		
		while ( i <= 9) {
			System.out.println(dan + " * " + i + " = " + (dan * i));
			i += 1;
		}
		
		scanner.close();
		
	}
	
	
	private static void doWhileEx() {
		// 입력받은 정수를 다 더한다
		// 만약에 입력 받은 정수가 0이면 반복하지 않는다
		
		int total = 0; 		// 합산 변수 (합계인거임)
		int value = 0; 		// 더해주는 수, 반복제어 변수 (내가 쓰는 부분)
		
		System.out.println("숫자를 입력하세요. [0이면 종료]");
		
		Scanner scanner = new Scanner(System.in);
		
		// 최소 한번 실행
		do {
			value = scanner.nextInt();		// value 에게 스캐너 줘 변하는애니까 ? ??
			total += value;
			System.out.println("합계:" + total);
		} while (value != 0);
		
		scanner.close();
	}
	
	
	
	private static void forGugu() {
		// 단을 입력 받아서 해당 단의 구구표를 출력
		// for loop
		// for (반복 변수 초기화; 반복 조건 확인; 반복 변수 증감;)
		Scanner scanner = new Scanner(System.in);
		System.out.println("단을 입력하세요.");
		System.out.println("단:");
		
		int dan = scanner.nextInt();
		
		for (int i = 1;		// 반복 변수 초기화
			i <= 9;			// 반복 조건 체크
			++i) {			// 반복 변수 증감
				System.out.println(dan + " * " + i + " = " + (dan * i));
			}
		scanner.close();
		
	}
	
	
	private static void randomEx() {
		// Math 클래스 : 수학 상수 와 수학 함수를 모아둔 클래스이다
		// 1 ~ 45 까지의 정수 난수 6개를 추출하는 예제
		// for 버전 하나, while 버전 하나 - 이렇게 총 두개 만들거임
		
		// for문 버전
		for (int i = 0; i < 6; i++) {
			System.out.println((int)(Math.random() * 45) + 1);
			System.out.println("\t");
		}
		System.out.println();
		
		
		// while문 버전
		int i = 0;
		
		while (i < 6) {
			System.out.println((int)(Math.random() * 45) + 1);
			System.out.println("\t");
			++i;
		}
	}
	
	
	
	
	
	
}
		
		
		
		
		
		
		
		
//		int dan = 8;
//		int i = 1;
//		
//		while ( dan * 8 > 73 ) {
//			System.out.println("8 * " + i + "=" + dan);
//			i += 1;
//		}
//		scanner.close();
//	}
		// 얼마나 멍청하게 했는지 잊지 않게 적어두자 ㅋ
	
	
	
	
//}
