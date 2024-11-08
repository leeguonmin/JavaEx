package com.javaex.oop.shape.v2;

public class ShapeApp {

	public static void main(String[] args) {
		// 추상 클래스는 부모로서만 존재한다 = 직접 객체화 할 수 없음 
//		Shape s = new Shape();
		
		Rectangle r = new Rectangle(10,20,100,50);
		r.draw();
		
		circle c = new circle(10,20,30);
		c.draw();
		
		Point p = new Point(100,100);
		p.draw();
		
		
		Drawable[] objs = new Drawable[] {		// []안에 숫자 넣으면 오류나
				r, c, p							// 여기에 3개라는 표시가 있어서??? 정확히는 왜인지 모르겟다
		};
		
		// 특정 객체가 특정 인터페이스를 구현한 객체인가를 판단하려면 
		if (r instanceof Drawable) {
			System.out.println("r은 Drawable의 구현체입니다");
		}
		
		for (Drawable obj: objs) {
			obj.draw();
		}				// 전혀 관계없는 클래스들인데, 한번에 관리할 수 있는 방법이 생기는 것 

	}

}
