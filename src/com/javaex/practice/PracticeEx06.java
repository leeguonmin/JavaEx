package com.javaex.practice;

import java.util.Scanner;

public class PracticeEx06 {

	public static void main(String[] args) {
		practice();

		
	}
	
	
	public static void practice() {
		System.out.println("나이를 입력해주세요");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("나이: ");
		int age = scanner.nextInt();
		
		if (age >= 19 & age < 65) {
			System.out.println("1번 그룹입니다.");
		} else {
			System.out.println("2번 그룹입니다");
		}
		scanner.close();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
