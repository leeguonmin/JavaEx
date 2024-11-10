package com.javaex.basic.opers;

public class ArithOperEx {

	public static void main(String[] args) {
		arithBasic();
//		incrOpers();
	}
	
	private static void incrOpers() {
		// 증감 연산자 (1항 연산) 
		// ++, --
		// 앞에 붙으면 : 전위 증감
		// 뒤에 붙으면 : 후위 증감
		
		int a = 7;
		System.out.println("전위 증감");
		System.out.println("a:" + a);
		System.out.println("++a:" + ++a);
		System.out.println("final a:" + a);
//		" (여기 안에 있는건 문장이다. 단어다 "
		
		System.out.println();
		System.out.println("후위 증감");
		a = 7;		// 원상 복구
		System.out.println("a:" + a);
		System.out.println("a++:" + a++);
		System.out.println("final a:" + a);
		
		
	}
	
	
	private static void arithBasic() {
		// 기초 산술 연산자
		int a = 7, b = 3;
		
		System.out.println(a + b);   // 덧셈
		System.out.println(a - b);	// 뺄셈
		System.out.println(a * b);	//곱셈
		System.out.println(a / b);	// 나눗셈 (정수형과 정수형의 나눗셈은 결과가 정수로만 나와야함) // int / int 는 int
		
		System.out.println(a % b);	// 나머지 
		
		
		System.out.println();
		// 만약에 정수끼리의 나눗셈을 실수로 얻고자 한다면 
		// 캐스팅
		System.out.println((float)a / (float) b);	// 강제 캐스팅
		System.out.println((float)a / b);	// 이렇게 써도, a가 더 크니까 알아서 자동으로 b도 실수로 바꿔 계산함
		
	
	}

}
