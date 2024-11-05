package com.javaex.practice;

import java.util.Scanner;

public class Ex13 {

	public static void main(String[] args) {
		ex();
	}

	private static void ex() {
		System.out.println("첫번째 숫자: ");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("두번째 숫자: ");
		int fir = scanner.nextInt();
		int sec = scanner.nextInt();
		
		
		// 약수 인지 아닌지
		// 두개의 정수중 작은 수가 큰 수의 약수인지
		if (fir > sec && sec / fir == 0) {
			System.out.println(sec + "는(은)" + fir + "의 약수입니다.");
		} else if (fir < sec && fir / sec == 0) {
			System.out.println(sec + "는(은)" + fir + "의 약수입니다.");
		} else if (fir > sec && fir / sec != 0) {
			System.out.println(sec + "는(은)" + fir + "의 약수가 아닙니다 제발");
		} else if (fir < sec && sec / fir != 0) {
			System.out.println(sec + "는(은)" + fir + "의 약수가 아닙니다 제발");
		}
		
		
		
		
		// 왜 다 약수로 나오는겨ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ
		
		/*
		else if (fir < sec && fir / sec != 0) {
			System.out.println(sec + "는(은)" + fir + "의 약수가 아닙니다");
		} else if (fir < sec && fir / sec != 0) {
			System.out.println(sec + "는(은)" + fir + "의 약수가 아닙니다. 제발");
		scanner.close();
	}
	*/
	
}
	
}

