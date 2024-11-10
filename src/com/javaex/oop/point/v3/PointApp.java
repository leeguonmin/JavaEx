package com.javaex.oop.point.v3;

// v3. 메서드 오버로딩(내가 지난 클래스에 오버로그라고 적어둔거 있으면 이거임 ㅋ)
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
	
	
	// 메서드 오버로딩 
	// 한 클래스 내에 같은 이름을 가진 메서드
	// 각 메서드는 매개변수의 타입, 순서, 개수 에 따라 구별된다
	// 아 진짜 배고파 대박이다
	public void draw(boolean bShow) {
	String message = String.format("점[x=%d, y=%d]을", x,y);
//	message += bShow ? "그렸습니다." : "지웠습니다" ;
	if (bShow)
		message+="그렸습니다.";
	else 
		message+="지웠습니다.";
	System.out.println(message);
	
}
	
}

	
public class PointApp {

	public static void main(String[] args) {
		
		point p1 = new point(); 
		p1.setx(5);
		p1.sety(5);
		p1.draw();
		p1.draw(true);
		p1.draw(false);
		
		point p2 = new point();
		p2.setx(10);
		p2.sety(23);
		p2.draw();
		p2.draw(true);
		p2.draw(false);

	}

	
}
	
	
	




