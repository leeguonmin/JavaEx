package com.javaex.oop.point.v2;

// v2
class  point {
	// 필드 (필드는 은닉시킨다)
	private int x;
	private int y;
	
	// ▼ 기본 생성자는 기본적으로 이렇게 생겼다 
	public point() {
		
	}
	public point(int x, int y) {
		// 초기화
		this.x = x;
		this.x = y;
	}
	
	
	
	
	
	
	
	// Getters/Setters
	public int getx() {
		return x;
	}
	
	// 내보낼거 없을땐 void
	public void setx(int x) {
		this.x = x;
	}
	
	public int gety() {
		return y;
	}
	
	// 내보낼거 없을땐 void
	public void sety(int y) {
		this.y =y;
	}
	
	// 메서드
	public void draw() {
		System.out.printf("점[x=%d, y=%d]을 그렸습니다.%n", x, y);
	}

}

	
public class PointApp {

	public static void main(String[] args) {
		
		point p1 = new point(); 
		p1.setx(5);
		p1.sety(5);
		p1.draw();
		
		point p2 = new point();
		p2.setx(10);
		p2.sety(23);
		p2.draw();

	}

	
	
	
	
	
}




