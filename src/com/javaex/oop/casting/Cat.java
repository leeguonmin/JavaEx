package com.javaex.oop.casting;

public class Cat extends Animal {
	public Cat(String name) {
		super(name);			// 디스.네임=네임 도 .. 되나? 본데? 나중에 시험해봐 근데 부모 있으니까 굳이? 란 느낌인듯 
	}

	
	public void meow() {
		System.out.println(name + ": 야~~옹");
	}
	
}
