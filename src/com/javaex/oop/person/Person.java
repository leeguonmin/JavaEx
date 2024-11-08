package com.javaex.oop.person;

// 여기가 부모 클래스!!!! 
public class Person {
	// 필드 
	protected String name;
	protected int age;
	
	// 생성자 
	public Person() {
		// 기본 생성자 
		System.out.println("Person() 생성자 호출");
	}
	
	
	public Person(String name, int age) {
		this.name=name;
		this.age=age;
		System.out.println("Person(String, int) 생성자 호출");
	}
	
	// Getter / Setter 
	public String getName() {
		return name;
	}
	
	// 나이는, 시간이 지나면 먹어야 하니까 (그거랑 겟에이지가 무슨 상관인지를 이해를 못함 슬프다 
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	// 일반 메서드
	public void showInFo() {
		System.out.println("name: "+name+", Age: "+age);
	}
	
	
	
	
	
	
	
	
	
	
	
}
