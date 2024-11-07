package com.javaex.oop.methods;

public class MethodPractice {

	
	
	public static void main(String[] args) {
		printHelloMethod();
		
		printNumbers();
		
		int mam = getRandomNumber();
		for (int man = 0; man < 2; man++) {
			System.out.print((int)(Math.random() * 100) + 1);
			System.out.print("\t");
		}
		
	}

	
	private static void printHelloMethod() {
		System.out.println("Hello Method");
	}
	
	private static void printNumbers() {
		System.out.println("1,2,3,4,5,6,7,8,9,10");
	}
	
	
	private static int getRandomNumber() {
		return int man;
	}
	
	
	
}