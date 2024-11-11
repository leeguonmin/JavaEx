package com.javaex.api.stringclass;

import java.util.Arrays;

public class StringEx {

	public static void main(String[] args) {
//		stringBassic();
		usefulMethods();
		

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
	
	
	private static void usefulMethods() {
		// 유용한 메서드들
//		String str="Java Programming is Fun?";
		String str="Java Programming, JavaScript Programming";
		
		// 문자열의 길이
		System.out.println(str.length());			// "Java Programming is Fun?"의 길이를 알려준다 (->주석, 후 "Java Programming, JavaScript Programming"로 수정)
		
		// 변환 메서드
		System.out.println(str.toUpperCase());		// 전부 대문자롷 (-> 확인 후 주석ㅡ "Java Programming, JavaScript Programming"로 수정)
		System.out.println(str.toLowerCase());		// 전부 소문자로 (-> 확인 후 주석, "Java Programming, JavaScript Programming"로 수정. 밑에서부턴 수정된 str로 출력)
		
		// 검색 관련 메서드
		System.out.println(str.charAt(5)); 			// 5번 인덱스의 char
		
		// Java가 어느 인덱스에 있는가? (중요★★★★★★) //
		int pos=str.indexOf("Java");				// 문자열 내부에서 Java의 위치
		System.out.println("1st Seach Java:" + pos);
		pos=str.indexOf("Java", pos+4);
		System.out.println("2nd Seach Java:" + pos);		// 두번째 Java의 위치를 찾으려고
		// 혹시 뒤에 또 Java가 있나 확인
		pos=str.indexOf("Java", pos+4);
		System.out.println("3rd Seach Java:" + pos);		// 근데 뒤에 Java가 없잖아. 
		// 검색할 부분문자열이 없으면 -1을 반환
		
		// Java를 문장의 뒤에서부터 찾아보겠다는거
		pos=str.lastIndexOf("Java");
		System.out.println("Last Index Java:" + pos);		
		
		// 문자열 추출
		System.out.println("SUBSTRING:" + str.substring(5));		// 5번 이후부터를 추출
		System.out.println("SUBSTRING:"+str.substring(5,16));   	// 5~16번까지 추출

		
		// 문자열 치환
		System.out.println("REPLACE:" + str.replace("Programming", "Coding"));			// Programming을 찾아서 Coding으로 바꿔서 출력
		
		
		// trimming : 화이트스페이스(공백,스페이스 등등)를 제거한다
		String s6="                     Hello             ";			// < 이렇게 문자가 지저분하게, 공백이 많게 입력이 됐다? 할때.. 없애줘야할거아냐 그때 trimming
		String s7=", Java";
		
		s6 = s6.trim();		// 이렇게 트리밍 넣어주면 깔끔하게 출력됨
		System.out.println(s6+s7);
		
		
		// 문자열 분리 : split()  -> 특정 구분자를 기준으로 구분한다
		// " "  기준으로 잘라보고, ","는 삭제하는거 예시
		String[] tokens = str.replace(",", "").split(" ");		// (,를 지워주고).split(공백을 기준으로 분할해달라);
		System.out.println("SPLIt:"+Arrays.toString(tokens));
		
		
		// 문자열 비교 : Unicode	(중요★★★★★★)
		// compareTo (매우 중요★★★★★★)			// 내부 객제 데이터의 대소 비교 할때도
		// -> 결과값이 0이면 순번이 같다, 값이 작으면 음수, 값이 크면 양수가 나오게
		System.out.println("ABC".compareTo("ABD"));		// -> C가 D보다 작아서 음수
		
		
		
		
	}
	
	

}
