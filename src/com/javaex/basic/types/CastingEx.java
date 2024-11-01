package com.javaex.basic.types;

// casting (형변환)
// 특정 자료(데이터)를 다른 자료형(데이터)으로 바꾸는 작업 
public class CastingEx {

	public static void main(String[] args) {
		testPromotion();
		testCasting();

	}
	
	private static void testCasting() {
		// 강제 캐스팅
		// 표현범위가 넓은 자료형 -> 에서 좁은 자료형 으로의 변화
		// 자료 유실 위험 -> 강제로 변환해야 함
		
		byte b;    // 바이트 비어있음. 2024를 넣어볼까함
		int i = 2024;     // 이제 여기다 123.456f 넣을 거임
		float f = 123.456f;
		
//		b = i;  // 당연히 에러났음
		b = (byte)i;    // 캐스팅 / i:내가 책임질테니 바꿔줘
		System.out.println(i);
		System.out.println(b);    // 부호가 1이면 -인가봐유 
		
		// 실수 -> 정수 캐스팅
//		i = f;     // 당연히 에러남
		i = (int)f;
		System.out.println(f);
		System.out.println(i);	
		
		
	}
	
	

	private static void testPromotion() {
		// 암묵적 캐스팅
		// 표현 범위가 좁은 자료형 -> 표현 범위가 넓은 자료형 으로의 변화
		// 같은 경우, 변환하지 않아도 자동으로 변환 됨

		// *적혀있는거 기준*밑으로 갈수록 큰 박스인거임 (byte ~ double )
		// 정수, 실수의 경우 실수가 표현할 수 있는 범위가 더 크기 때문에 큰걸로 인식
		// 큰 박스로 이동할땐 작은 박스에 있던 값이 문제 없이 이동이 가능하기 때문에 '재생' 눌렀을때 무리 없이, 문제 없이 다 25가 나오는
		// 거임
		// 마지막의 25.0 나오는건, 25가 실수로 변환 되었기 때문에 뒤에 .0이 붙어서 25.0으로 나온 거임
		byte b = 25; // 1바이트 정수
		System.out.println(b);

		short s = b; // 2바이트 정수
		System.out.println(s);

		int i = s; // 4바이트 정수
		System.out.println(i);

		long l = i; // 8바이트 정수
		System.out.println(i);

		float f = l; // 4바이트 실수
		System.out.println(f);

		double d = f; // 8바이트 실수
		System.out.println(d);

		char ch = 'A';
//		short s2 = ch2;
//		int i2 = ch2;
		// 근데 마지막에 얘는 왜 적는겨? :3c

		// 컨트롤, 쉬프트, f 누르면 정리 됨

	}

}
