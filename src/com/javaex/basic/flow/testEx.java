package com.javaex.basic.flow;

import java.util.Scanner;

public class testEx {

	public static void main(String[] args) {
		testEx();
		
		
	}
	
	public static void testEx() {
		System.out.println("점수를 입력하세요");
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		if (num % 3 == 0) {
			System.out.println("3의 배수입니다");
		} else {
			System.out.println("3의 배수가 아닙니다");
		}
		scanner.close();
	}
	
	
	public static void testEx2() {
		System.out.println("점수를 입력하세요");
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		if (num >= 90) {
			System.out.println("A등급");
		}
	}
	
	

}
