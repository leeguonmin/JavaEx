package com.javaex.oop.methods;

public class MethodPractice {

	
	
	public static void main(String[] args) {
//		printHelloMethod();
		//1번
		
//		printNumbers();
		//2번
		
//		int mam = getRandomNumber();
//		for (int man = 0; man < 2; man++) {
//			System.out.print((int)(Math.random() * 100) + 1);
//		}
		//3번
		
//		printOddOrEven()
		
		//5번
		
		//7번
		getLargeNumber();
	}

	
	private static void printHelloMethod() {
		System.out.println("Hello Method");
	}
	
	private static void printNumbers() {
		System.out.println("1,2,3,4,5,6,7,8,9,10");
	}
	
	
	private static int getRandomNumber() {
		return ;
	}
	
	
	
	
	// 5번
	private static void printOddOrEven() {
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		String result;
		result = i % 2 == 0 ? "짝수": "홀수";
		System.out.println(i + "는" + result);
		
	}
	
	
	//6번

	
	//7번
	private static void getLargeNumber() {
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
	
