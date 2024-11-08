package com.javaex.oop.casting;

public class Animal {
	// 필드 
	protected String name;
	
	// 생성자
	public Animal(String name) {
		this.name=name;
	}
	
	public void eat() {
		System.out.println(name+"is eatng.");
		
	}
	
	public void walk() {
		System.out.println(name+"is walking");
		
	}

}
