package com.javaex.oop.staticmember;


// static, instance, local
public class StaticEx {
	public static int refCount;	// 클래스 변수
	public static String classVar;	// 클래스 변수
	public String instanceVer;		// 인스턴스 변수 (각 개별 인스턴스는 자기만의 공간을 가짐)
	
	// 클래스 변수를 초기화 하는 static 블록 
	static {
		refCount = 0;		// 현재 인스턴스의 수
		classVar = "Static Member";
		System.out.println("Static Block calls");
//		instanceVar="instanceVar";
		//  static 영역에서는 static만 접근할 수 있다
	}
	
	
	// 생성자 : 인스턴스 생성시 초기화의 역할 
	public StaticEx() {
		++refCount;
		System.out.println("생성자 호출");
		System.out.println("참조카운트:"+refCount);
	}
	
	
	// 소멸자 	(생성된 인스턴스를 없애기 위해선, 제거가 아니라 연결을 끊는거임)
	protected void finalize() throws Throwable {
		--refCount;
		super.finalize();
		System.out.println("소멸자 호출");
	}
	
	

}
