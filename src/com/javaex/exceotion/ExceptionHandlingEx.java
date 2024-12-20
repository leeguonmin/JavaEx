package com.javaex.exceotion;

import java.util.InputMismatchException;
import java.util.Scanner;

// 예외

public class ExceptionHandlingEx {

	
	
	public static void main(String[] args) {
//		arithExceptionEx();
		arrayExceptionEx();
		nullpointerExceptionEx();

	}
	
	
	// ===========================================================================================================================//
	
	
	
	private static void arrayExceptionEx() {
		int[] intArray=new int[] {3,6,9};
		
		// 예외 발생 영역 
		try {
		System.out.println(intArray[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Error:" + e.getMessage());
		}
	} 
	
	private static void nullpointerExceptionEx() {
		String str = new String("Hello Java");
		
		try {
			str =null;			// 여기서 참조를 끊었기 때문에 
			System.out.println(str.toUpperCase());		// 여기가지 접근할 수 없게 된거임 	(//toUpperCase() 문자를 전부 대문자로 바꿔주는 고정된 명령어)
			} catch (NullPointerException e) {	
				System.err.println("널입니다");
			}
	}
	
	
	
	// ===========================================================================================================================//
	
	
	
	private static void arithExceptionEx() {
		// 스캐너에서 정수 입력
		// 100을 정수로 나눈 값을 출력
		
		double result =0;
		int num;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		
		try {
		// 예외 발생 가능 영역 	// 그럼 뭐해야해? 예외 발생 영역 묶어줘야함 트라이
		num = scanner.nextInt();
		result = 100/num;
		System.out.println(result);
		} catch (InputMismatchException e) {
			System.err.println("정수를 입력해주쇼");			// 구체적 예오;
		} catch (ArithmeticException e) {
			System.err.println("0으로 나눌 수 없습니다아");	// 구체적 예외
		} catch (Exception e) {
			// Exception(일반적 예외)은 가장 마지막에 남아 있는 예외 처리를 위해
			e.printStackTrace();
		} finally {
			// 예외 유무 관계 없이 가장 마지막에 실행 
			// 자원 정리 등을 수행
			System.out.println("예외 처리 종료!");
		}
		
	
		scanner.close();
		System.out.println("프로그램 종료!");
		
	}

}
