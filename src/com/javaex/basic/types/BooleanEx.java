package com.javaex.basic.types;

// 논리형 (1바이트) -true or false
public class BooleanEx {

	public static void main(String[] args) {
		boolean b1 = true;
		boolean b2 = false;
		
		System.out.println(b1);
		System.out.println(b2);
		
		int var1 = 3, var2 = 5;
		boolean result = var1 > var2;
		// 비교연산, 논리연산의 결과를 boolean
		
		System.out.println(var1 + ">" + var2 + "=>" + result);
	}

}
