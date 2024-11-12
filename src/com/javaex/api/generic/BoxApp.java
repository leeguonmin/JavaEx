package com.javaex.api.generic;

public class BoxApp {

	public static void main(String[] args) {
		// Integer Box 를 하나 만든다
		IntegerBox iBox = new IntegerBox();
//		iBox.setContent("문자열");
		
		// 어떤 객체든 담을 수 있는 박스를 설계 > 오브젝트박스 클래스 생성했음 
		ObjectBox intBox = new ObjectBox();
		intBox.setContent(123);
		
		// 값을 꺼내와 봅시다
		Integer retVal = (Integer)intBox.getContent();	// 강제 캐스팅
		System.out.println(retVal);
		
		ObjectBox strBox = new ObjectBox();
		strBox.setContent("Java");
		
		// 값을 꺼낸다
		String strVal = (String)strBox.getContent();	// 강제 캐스팅
		System.out.println(strVal);
		
		
		// GenericBox
		// 내부 데이터 타입을 외부에서 객체화 시점에서 결정한다
		// 이 밑으론 강제 캐스팅을 안해도 내부 데이터가 결정됨
		GenericBox<String> genericStrBox = new GenericBox<String>();
		genericStrBox.setContent("GENERic Box");
//		genericStrBox.setContent(2024);		// -> 컴파일 타임에서 내부 데이터 타입을 체크 가능
		
		String objStr = genericStrBox.getContent();
		// 캐스팅 불필요 (제네릭의 장점!)
		

	}

}
