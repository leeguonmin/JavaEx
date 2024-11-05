package com.javaex.practice;

import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		System.out.println("숫자 두개를 입력해주세요");
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자1: ");
		int big = scanner.nextInt();
		System.out.println("숫자2: ");
		int small = scanner.nextInt();
		
		if (big > small) {
			System.out.println("큰수: " + big+ "    " + "작은수: " + small);
		} else if (big < small) {
			System.out.println("큰수: " + small+ "    " + "작은수: " + big);
		}
		scanner.close();

	}

}