package com.javaex.basic.flow;

import java.util.Scanner;

public class LoopEx {

	public static void main(String[] args) {
//		whileEx();
		whileGuge();

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
