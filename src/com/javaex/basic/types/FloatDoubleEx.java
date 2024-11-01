package com.javaex.basic.types;

// float (4바이트 실수) < double (8바이트 실수)
// 실수형의 기본은 double
// 그니까 float으로 인식시키려면, 숫자 뒤에 F를 불여줘야함.
public class FloatDoubleEx {

	public static void main(String[] args) {
		float floatVar = 3.14159F;
		double doubleVar = 3.14159;
		
		System.out.println("float:" + floatVar);
		System.out.println("dolble:" + doubleVar);
		
		// e 표기법
		int intVar = 3000000; //3곱하기 10의 7승
		doubleVar = 3E6;       // 3* 10 ^ 6 3곱하기 10의 6승
		floatVar = 3e-6f;       // 3* 10 ^ -6
		
		System.out.println("ontVar:" + intVar);
		System.out.println("doubleVar:" + doubleVar);
		System.out.println("floatVar:" + floatVar);
		
		// 부동소수점 처리 유의사항 
		// float, double은 정밀도  포기, 표현 범위를 넓힌 것
		// 정밀한 실수 계산을 할 때는 다른 방법을 사용해야 함 (예를 들어, 정수로 바꿔서 진행하고 마지막에 실수로 바꾼다던가)
		System.out.println(0.1*3);

	}

}
