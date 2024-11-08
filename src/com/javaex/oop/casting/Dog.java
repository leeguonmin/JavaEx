package com.javaex.oop.casting;

// 애니멀의 자식 클래스인 도그 
public class Dog extends Animal { 
	public Dog(String name) {	// 이름 생성자 
		super(name);			// 이렇게 세팅해줘야 도그에 오류 안 떠. 부모에서 이름 가져온..거야 아 진짜뭐지 맞나 
	}
	
	public void bark() {
		System.out.println(name + ": 멍멍!!!!");
	}
	
	
	

}
