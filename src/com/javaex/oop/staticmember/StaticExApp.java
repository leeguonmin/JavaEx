package com.javaex.oop.staticmember;

public class StaticExApp {

	public static void main(String[] args) {
		// 첫번째 인스턴스가 생성되기 전에, 클래스가 먼저 메모리에 로드됐다 
		// static 블록을 통해 (스태틱 블록에서) 스태틱 영역 초기화 -> 생성자 호출
		
		StaticEx s1 = new StaticEx();		// 인스턴스 생성
		System.out.println("refCount:"+StaticEx.refCount);
		
		StaticEx s2 = new StaticEx();		// 인스턴스 생성
		System.out.println("refCount:"+StaticEx.refCount);
		
		
		// s1 참조 해제   // 소멸자 이어서 여기로 왔음요
		s1 = null;
//		System.out.println("refCount:"+StaticEx.refCount);
		System.gc();    // 가비지 컬렉터 호출 -> 직접 호출은 사양하자. (가급적 안하는게 좋음. 지금은 보여주기 위해 하는 것)
		try {
			Thread.sleep(3000);	// 3초간 대기
			System.out.println("refCount:" + StaticEx.refCount);
		} catch (Exception e) {
			// 흐름보려고 강제로 돌려본거고, 실제로 우리가 할 일은 없을거다. 

	}
		
		
		// static 클래스 
		System.out.println(Calc.PI);
		System.out.println(Calc.getSum(1,2,3,4,5));
	
	
	
}
	
}
