package com.javaex.api.objectclass.ex01;

public class LangClassTest {

	public static void main(String[] args) {
		Point p = new Point(10,10);
		// (10,10)의 이름은 p야
		
		//(p.getClass().getName());  이걸 직역하자면, 주어.동사 라고 합니다. p야, getClass()클래스좀 가져와줘
		// 그리고, 할당하는 것도 잘 못하는거같음. 주의하자.
		
		
		
		// Java의 최상위 클래스는 Object
		// -> 기본적으로 Object 의 모든 기능을 상속
		System.out.println(p.getClass().getName());		// 얘넨
		System.out.println(p.hashCode());				// 우리가 만든게 아님에도 불구하고	//hashCode():객체 식별자. 우리가 특별히 무슨 설정을 하지 않는다면, hashCode()는 주소?라고? 음
		System.out.println(p.toString());				// 상속된거임	 // toString());:객체 내부 데이터를 문자열로 출력(반환) 
		System.out.println(p);		// 문자열 정보가 필요할 때, toString()을 호출해준다
		
		// p의 부모 객체를 받아와서 확인
		System.out.println(p.getClass().getSuperclass().getName());
	}

}
