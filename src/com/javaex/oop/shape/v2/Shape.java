package com.javaex.oop.shape.v2;

// 구체적 도형들의 공통점을 추출한 추상 클래스 (실제로 객체가 될 순 없음)
//  퍼블릭 옆에 abstract 붙여주면 완성
// 직접 객체화는 불가, 다른 클래스의 부모로만 존재 (오로지 퍼주기만 하는 아이)
public abstract class Shape {
	// 필드 
	protected int x;
	protected int y;
	
	// 생성자
	public Shape(int x, int y) {
		this.x = x;
		this.y=y;
	}		
	
	// ▼ 추상 클래스 내에는 한개 이상의 추상 메서드가 있어야 한다 ▼
//	public abstract void draw();		-> 인터페이스에 위임! 하는거 할거임 v2에서
	public abstract double area();

}
