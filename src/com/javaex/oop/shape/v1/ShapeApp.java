package com.javaex.oop.shape.v1;

public class ShapeApp {

	public static void main(String[] args) {
		// 추상 클래스는 부모로서만 존재한다 = 직접 객체화 할 수 없음 
//		Shape s = new Shape();
		
		Rectangle r = new Rectangle(10,20,100,50);
		r.draw();
		
		circle c = new circle(10,20,30);
		c.draw();

	}

}
