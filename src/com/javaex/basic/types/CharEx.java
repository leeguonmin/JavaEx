package com.javaex.basic.types;

// char (2바이트) : 문자의 유니코드 값(부호없는 정수)
public class CharEx {

	public static void main(String[] args) {
		char ch1 = 'A';
		char ch2 = '한';
		
		System.out.println(ch1);
		System.out.println(ch2);
		
		System.out.println((int)ch1);
		System.out.println((int)ch2);
		
		// ch1의 네글자 뒤 > E
		char test = (char)((int)ch1 + 4);
		System.out.println(test);
		
		// 한글 유니코드 : ㄱ~힣
		
		// string 형은 char의 집합
		// 가장 기본적인 참조자료형
		String str = "Java Programming";
		System.out.println(str);

	}

}
