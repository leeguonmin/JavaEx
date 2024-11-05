package com.javaex.practice;

import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		BMI();
	
	}

	
	public static void BMI() {
		System.out.println("키와 몸무게를 입력해주쒜요");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("키는: ");
		int hi = scanner.nextInt();
		System.out.println("몸무게는: ");
		int wi = scanner.nextInt();
		double bmi = wi / hi;
		
		if (18.5 <= bmi) {
			System.out.println("저체중입니다.");
			System.out.println("BMI: " + bmi);
		} else if (bmi <= 24.9) {
			System.out.println("과체중입니다.");
			System.out.println("BMI: " + bmi);
		} else {
			System.out.println("정상체중입니다.");
			System.out.println("BMI: " + bmi);
		}
		scanner.close();
		
	}
	
	
}

// 틀렸는데 어덯게 고쳐야할지 모르겠습니다..........................................
