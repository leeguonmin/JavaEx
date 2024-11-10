package com.javaex.basic.types;

// 정수형 데이터 타입
// byte (1) < short (2) < int (4) < long (8)
// 정수형의 기본은 int
// 실수형 기본은 double
public class IntLongEx {
	public static void main(String[] ages) {
		// 선언
		int intVar1;
		int intVar2;
		
		// 초기화
		intVar1 = 2024;
//		intVar2 = 1234567890123; // out of range
		
		System.out.println(intVar1);
		
		long longVar1 = 2024;
		long longVar2 = 123456789123L;
		// 큰 숫자의 경우, 숫자 뒤에 L 을 써야 롱 데이터인걸 인식함
		
		System.out.println(longVar1);
		System.out.println(longVar2);
		
		long amount = 1000_000_000_000L;
		
		// 2진수, 8진수, 16진수 표기
		int bin, oct, hex;
		bin = 0b1100;     // 0b -> 2진수 표기
		oct = 072;        // 0 -> 8진수 표기
		hex = 0xFF;       // 0x -> 16진수 표기 (16진수는 0 1 2 3 4 5 6 7 8 9 다음으로 숫자가 아니라 A B C D E F 다음에 10 온다고그랬나? 음?
		System.out.println(bin);
		System.out.println(oct);
		System.out.println(hex);
		
		// 내일은 이 프로그램이 어떻게 흘러가고 있는가 파악하는거 배운다
		
		
		
	}

}
