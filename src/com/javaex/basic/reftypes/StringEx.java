package com.javaex.basic.reftypes;

public class StringEx {

	public static void main(String[] args) {
		usingString();

	}

	
	private static void usingString() {
		String str; 	// 선언 -> null 상태 (아무것도 할당받지 않았기 때문애ㅔ)
		str = "Java";	// 할당 (이제 null 아닌거지), Literal
		String str2 = "Java";		// Literal
		String str3 = new String("Java");		// 새 객제 생성
		
		// 세 변수는 같은 '값'을 가지고 있음
		// 객체의 경우, ==은 참조 주소를 비교
		System.out.println(str == str2);		// true로 나오고 > 주소가 같으니끼 
		System.out.println(str == str3);		// false로 나옴 > 값은 같지만, 주소가 다르니까
		
		// 객체의 경우, 값의 비교는 equals 매서드 이용 
		System.out.println(str.equals(str3));	// (주소가 아닌) 값을 비교하려면 equals 공식을 써야함
	}
	
	
	
	
	
	
	
	
	
	
	
}
