package com.javaex.api.objectclass.ex02;

public class LangClassTest {

	public static void main(String[] args) {
		Point p = new Point(10,10);
		Point p2 = new Point(10,10);
		
		System.out.println(p == p2);
		System.out.println(p.equals(p2));
		

		
		String s1=new String("Java");
		String s2=new String("Java");
		
		System.out.println(s1 == s2);		// 주소가 같냐? 주소가 같지 않을테니 false
		System.out.println(s1.equals(s2));	// 값이 같냐? 값이 같으니 true
		
		
		
		
		
		
		
		
		
		
		
		
		
//		// Java의 최상위 클래스는 Object
//		// -> 기본적으로 Object 의 모든 기능을 상속
//		System.out.println(p.getClass().getName());		// 얘넨
//		System.out.println(p.hashCode());				// 우리가 만든게 아님에도 불구하고	//hashCode():객체 식별자. 우리가 특별히 무슨 설정을 하지 않는다면, hashCode()는 주소?라고? 음
//		System.out.println(p.toString());				// 상속된거임	 // toString());:객체 내부 데이터를 문자열로 출력(반환) 
//		System.out.println(p);		// 문자열 정보가 필요할 때, toString()을 호출해준다
//		
//		// p의 부모 객체를 받아와서 확인
//		System.out.println(p.getClass().getSuperclass().getName());
	}

}
