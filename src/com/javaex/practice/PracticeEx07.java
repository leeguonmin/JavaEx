package com.javaex.practice;

import java.util.Scanner;

public class PracticeEx07 {

	public static void main(String[] args) {
		money();

	}

	
	public static void money() {
		System.out.println("나이를 입력해주세요~");
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("나이: ");
		int age = scanner.nextInt();
		
		if (age >= 0 & age < 8) {
			System.out.println("취학전아동 /무료 입니다 좋겠다");
		} else if (age >= 8 & age < 14) {
			System.out.println("초등학생 /200원입니다 이것도 좋겠다");
		} else if (age >= 14 & age < 17) {
			System.out.println("중학생 /3000원입니다");
		} else if (age >= 17 & age < 20) {
			System.out.println("고등학생 /4000원입니다");
		} else {
			System.out.println("성인 /5000원입니다!!!!!!!!!!!!");
		}
		scanner.close();
	}
	
	
	
	
	public static void Ex4() {
		int s = 0;
		
		if (s == 0) {
			System.out.println("x는 영이다");
		}
	}
	
	
	
}
