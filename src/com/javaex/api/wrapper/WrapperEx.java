package com.javaex.api.wrapper;

// 포장 클래스
public class WrapperEx {

	public static void main(String[] args) {
		// Wrapper 클래스 생성
		
		Integer i = new Integer(10);
		Character c= new Character('c');
		// new wrapper 는 jdk9 부터 deprecated 됨 -> 가급적 빨리 수정 권장 
		
		// 정상적인 생성법
		Float f = Float.valueOf(3.14159f);
		Boolean b= Boolean.valueOf(true);
		
		// 문자열로 된 데이터를 실제 데이터로 생성하는 작업 
		Integer i2 = Integer.valueOf("10");
		Float f2 = Float.valueOf("3.14159f");
		Boolean b2= Boolean.valueOf("true");
		// 주의사항 : 문자열의 형태가 해당 자료형의 형태를 갖춰야 한다. 
		
		// parse 계열 메서드 : 문자열을 이용해서 해당 타입으로 변환하거나, 
		// 					아니면 출력 형태를 변환시키는 경우
		System.out.println(Integer.parseInt("-123")); // 문자열을 정수로 변환 케이스
		System.out.println(Integer.parseInt("10", 16));  //  16진수 문자열을 10진수 정수로 변환시키는
		System.out.println(Integer.toBinaryString(28));  // 2진수 형태의 문자열로 변환
		System.out.println(Integer.toHexString(28));   // 16진수 형태 문자열로 변환
		
		String s1 = "123";
		String s2= "456";
		System.out.println(s1+s2);		// 문자열이기 때문에 연산이 안되고 연결되어 그대로 출력 > 근데 계산하고 싶다면? 정수로 바꿔야겠지
		System.out.println(Integer.parseInt(s1)+Integer.parseInt(s2));   	// 정수로 바꿔줌 > +가 연산기호 역할을 해서, 더해진 값이 출력됨요
		
		// 형변환 
		System.out.println(i2.doubleValue());  // Integer i2 = Integer.valueOf("10");를 실수로 변환해서 출력
		
		// 자동 박싱(Auto Boxing)
		Integer i3 = 10;		// => Integer i3 = Integer.valueOf(10);
		
		// 포장된 값의 비교 
		Integer i4 = Integer.valueOf(2024);
		Integer i5=Integer.valueOf(2024);	// 자동 박싱?을 해주긴 하지만, 어쨋든 객체, 참조 데이터 타입임
		System.out.println(i4 ==i5);		// 참조 자료형과 참조 자료형의 비교는 주소비교기 때문에 false 출력 (주의하기)
		
		// 언박싱 비교 
		System.out.println(i4.intValue() == i5.intValue()); 		// 이렇게 언박싱해서 비교하면, 값의 비교라서 true 나와
		
		System.out.println(i4.equals(i5));		// 혹은 이렇게 참조 데이터 값(equals) 비교 방법 사용해
		
		
		
		
		

	}

}
