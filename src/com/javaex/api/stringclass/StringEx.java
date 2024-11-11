package com.javaex.api.stringclass;

public class StringEx {

	public static void main(String[] args) {
		stringBassic();

	}
	
	
	
	private static void stringBassic() {
		String s1 = "Java";					// 리터럴 					//소스코드에 직접 작성된 게시물 자체?라고 표현하는게 맞는건지 
		String s2 = new String("Java");		// 메모리에 새로 만들기
		String s3;
		s3="Java";		// 리터럴
		
		System.out.println(s1==s2); 		// 주소 비교
		System.out.println(s1==s3); 		// 주소 비교 			// 리터럴로 만든 객체는 값이 같으면 같다고 나옴 
		
		
		
		// 문자열 배열로 String 생성
		char[] letters= {'J','a','v','a',' ','P','r','o','g','r','a','m','!'};
		String s4 = new String(letters);
		System.out.println(s4);
		System.out.println(s4.length());
		
		
		
		// valueOF 메서드 (자바 내부적으로 있는 기능, 고정된 이름)
		// -> 다른 데이터타입을 문자열로 변환하는 메서드
		float PI=3.14159f;		// 얘를 문자열로 바꾸고 싶다면
		String s5=String.valueOf(PI);
		System.out.println(s5);
		
		
		
		
	}

}
