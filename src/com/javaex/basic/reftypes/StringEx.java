package com.javaex.basic.reftypes;

public class StringEx {

	public static void main(String[] args) {
//		usingString();
		stringFormatEx();

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
	
	
	private static void stringFormatEx() {
		// 포매팅 문자 중에서 %s(문자열), %d(정수), %n(개행)
		
		// 만약에'10개의 사과 중에 3개를 먹었다'라는 문장을 만들고 싶다
		// 10의 자리에 %d , 사과 자리에 %s , 3개 자리에 %d
		
		int total = 10, eat = 7;
		String fruit = "사과";
		System.out.println(total + "개의 " + fruit + "중에 " + eat + "개를 먹었다");
		// ▲이전에 사용하던 방식
		// ▼formatting 을 이용한 방식
		System.out.printf("%d개의 %s중에 %d개를 먹었다%n", total, fruit, eat);
		
		
		
//		// string.format 매서드를 활용한 것
		String template = "%d개의 %s중에 %d개를 먹었다";
		System.out.println(String.format(template, 10, "사과", 5));
		
		System.out.println(String.format(template, 5, "바나나", 2));
		
		
		
		
		// 천단위에 , 포매팅
		int amount = 123_456_789;
		System.out.printf("현재 잔고는: %d입니다.%n", amount);
		System.out.printf("현재 잔고는: %,d입니다.%n", amount);
//		System.out.println("현재 잔고는: %,d입니다.%n", amount);		// 프린트 부분 보면 위에는 printf 로 썼고 얘는 println로 써서 오류난거임
		
		
		// %f
		float interestRate = 1.2345f;
		System.out.printf("현재 이자율을 %f입니다.%n", interestRate);
		System.out.printf("현재 이자율을 %.2f입니다.%n", interestRate);
			
	}
	
	
	
	
	
	
	
	
}
