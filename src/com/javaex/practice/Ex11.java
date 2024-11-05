package com.javaex.practice;

import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {
		// 두개의 정수를 입력받아 큰 수를 작은 수로 나눈 몫과 나머지를 출력
		inner();
	}
	
	public static void inner() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("첫번째 숫자: ");
		int fir = scanner.nextInt();
		System.out.println("두번째 숫자2: ");
		int sec = scanner.nextInt();
		
		if (fir > sec) {
			System.out.println("몫:" + fir / sec);
			System.out.println("몫:" + fir % sec);
		} else if (fir < sec) {
			System.out.println("몫:" + sec / fir);
			System.out.println("몫:" + sec % fir);
		} else if (fir == sec) {
			System.out.println("몫:" + sec / fir);
			System.out.println("몫:" + sec % fir);
		}
		scanner.close();
		
	}
	
	
	
	

}
