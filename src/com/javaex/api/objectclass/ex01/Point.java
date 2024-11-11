package com.javaex.api.objectclass.ex01;


// Object ex01 
public class Point {
	// 필드
	private int x;
	private int y;
	
	// 생성자
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	@Override
	public String toString() {
		// 객체 내부 데이터의 문자열 출력 
		return "Point("+ x + "," + y + ")";
	}
	
	

}
