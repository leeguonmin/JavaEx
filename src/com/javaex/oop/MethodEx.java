package com.javaex.oop;

public class MethodEx {

	// 매서드 작성 연습!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// 입력이 있고 없고, 출력이 있고 없고
	// 매개 변수 -> 입력
	// 리턴 -> 출력
	public static void main(String[] args) {
		// 1.
		// 매개변수가 없고 리턴도 없다 (매개변수 x, 리턴 x)
		printMessage();
		
		
		// 2.
		// 매개변수 x, 리턴 o
		String message = getMessage();
		System.out.println("getMessage:"+ message);
		
		
		// 3.
		// 매개변수 o, 리턴 x
		printSum(10,20);
		
		// 4.
		// 매개변수 o, 리턴 o
		System.out.println(getSum(10,20));
		// 5.매개변수 o, 리턴 o (오버로그. 중복 권유)
		System.out.println(getSum(10,20,30));
		
		
		// 6. 매개 변수 개수를 알 수 없을 때의 해결 방법
		// 방법 1, 배열을 전달한다
		System.out.println("getSumArr:"+getSumArr(new double[] {1,2,3,4,5,6,7,8}));
		// 방법 2, 가변 인수 
		System.out.println("getSumVar:" +getSumVar(1,2,3,4,5,6,7,8));
		
		// 7. 일반 매개 변수와 가변 매개 변수 함게 사용할때
		// 일반 매개변수 먼저, 가변 인수 나중에 선언
		printSum("합산값", 1,2,3,4,5,6,7,8);
	}
	
	
	
	
	// 7. 
	private static void printSum(String message, double...values) {
		System.out.println(message+":"+getSumVar(values));
	}
	
	
	
	// 6.
	private static double getSumArr (double[] values) {
		// 방법 1 . 배열을 전달한다
		double total = 0;
		
		for (int i = 0; i<values.length; ++i) {
			total += values[i];
		}
		return total;

	}
	
	private static double getSumVar(double...valuse) {
		// 방법2. 가변 인수 
		double total =0;
		
		for(double value: valuse) {
			total+=value;
		}
		return total;
	}
	
	
	
	
	
	// 1.
	// 매개변수 x	-> 파라미터 없음 
	// 리턴 x 	-> void
	// 불러준게 없으니까 받을 것도 없다
	private static void printMessage() {
		System.out.println("매개 변수 없고, 리턴도 없음");
		
	}
	
	
	// 2.
	// 매개변수 x 	-> 파라미터 없음
	// 리턴 o 	-> 리턴될 데이터의 타입 
	private static String getMessage() {
		// return(리턴)으로 데이터 반환
		return "입력은 없지만, 출력은 있는 매서드";
	}
	
	
	// 3.
	// 매개변수 o	-> 파라미터 있음
	// 리턴 x 	-> void
	private static void printSum(double num1, double num2) {
		System.out.println(num1+num2);
	}
	
	
	// 4. 
	// 매개변수 o	-> 파라미터 있음 
	// 리턴 o		-> 리턴될 데이터 타입 명시
	private static double getSum(double num1, double num2) {
		return num1 + num2;
	}
	
	
	
	// 5.
	// 오버로그. 같은 이름을 가진 같은 타입의 함수를 중복 선언 할 수 있다
	// 매개변수의 타입, 순서에 따라서 다른 값을 출력 할 수 있는 오버로그
	// 매서드 오버로딩 (초과적재) -> 다형성의 일부
	private static double getSum(double num1,double num2,double num3) {
		return num1+num2+num3;
	}
	

	
}
