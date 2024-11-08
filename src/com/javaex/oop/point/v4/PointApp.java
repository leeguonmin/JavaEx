package com.javaex.oop.point.v4;

// v4. 상속
class  point {
	// 필드 (필드는 은닉시킨다)
//	private int x;
//	private int y;
	
	// 필드, 은닉을 풀어줘			// 이케하면 수퍼.겟엑스 이런거 안써도 상속 가능하니까 걍 써도 됨 
	protected int x;
	protected int y;					
	
	
	// ▼ 기본 생성자는 기본적으로 이렇게 생겼다 
//	public point() {
//	}
	public point(int x, int y) {
		// 초기화
		this.x = x;
		this.y = y;
	}
	
	
	
	
	// Getters/Setters
	public int getx() {
		return x;
	}
	
	// 내보낼거 없을땐 void
	public void setx(int x) {
		this.x = x;
	}		// 외부로 부터 데이터를 받아서 내부에 세팅하는 목적, 그래서 리턴이 없는거임
	
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

	public void draw(boolean bShow) {			
		// 먼저 이렇게 메세지 만들어주고
	String message = String.format("점[x=%d, y=%d]을", x,y);
//	message += bShow ? "그렸습니다." : "지웠습니다" ;		// 트루면 그렸습니다, 패일이면 지웠습니다 가  뜰 수 있게 
	if (bShow)
		message+="그렸습니다.";
	else 
		message+="지웠습니다.";
	System.out.println(message);
	}
	
}


// 포인트 상속 받아서, colorPoint 클래스를 생성
class ColorPoint extends point {
	// 필드
	// x,y,draw는 상속 받음
	private String color;
	
	
	/*
	public ColorPoint() {
		// 특별히 지정하지 않으면 부모의 기본 생성자 super()를 선택한다.
		super();				// 위에 기본 생성자 지워서 이 부분이 에러났음. 기본 생성자 지우고 할거니까, 이건 쓸 수 없음
	}
	*/
	
	public ColorPoint(String color) {
//		super(0,0);
//		this.color=color;			// 밑에 있음. 중복이라서 주석
		this(0,0,color);			// 걍 불러오슈
	}
	
	public ColorPoint(int x,int y,String color) {
		super(x,y);			// 부모 초기화
		this.color=color;	// 나 초기화
	}
	
	
	// getters / setters 
	public String getcolor() {
		return color;
	}
	
	public void setcolor() {
		this.color=color;
	}
	
	// draw 메서드를 상속받았으나, 약간 부족하니 새로 선언한다 (컬러를 넣을 구다리가 없음)
//	@Override
//	public void draw() {
//		System.out.printf("색상점[x=%d, y=%d, color=%s]를 그렸습니다."%n, super.getx(), super.gety(),color);
//	}
//}
	
	@Override
	public void draw() {
		System.out.printf("색상점[x=%d, y=%d, color=%s]를 그렸습니다.%n", x,y,color);			// 위에 프라이빗 풀고 프로텍트로 바꿔줘서 super 안쓰고도 출력 가능해짐 
	}
	
	@Override
	public void draw(boolean bShow) {
		String message = String.format("색상점[x=%d, y=%d, color=%s]를 ", x,y,color);		// 먼저 이렇게 메세지 만들어주고
		message += bShow ? "그렸습니다." : "지웠습니다!!!!!!!!!" ;		// 트루면 그렸습니다, 패일이면 지웠습니다 가  뜰 수 있게 
//		if (bShow)
//			message+="그렸습니다.";
//		else 
//			message+="지웠습니다.";
		System.out.println(message);
		
		// 오버라이드 했지만 부모의 기능을 다시 사용해야할때
		super.draw(bShow); 				//이렇게!!
		
		
		}
	// 지금 이렇게 덮어쓰기 했지만, 나중에 아쉬워질 수 있잖아? 부모가 물려준걸 다시 써야할 수도 있잖아? 그땐 super 써줭
	
}			


//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ// 


	
public class PointApp {

	public static void main(String[] args) {
		
//		point p1 = new point(); 
//		p1.setx(5);
//		p1.sety(5);
		point p1 = new point(5,5);
		p1.draw();
		p1.draw(true);
		p1.draw(false);
		
//		point p2 = new point();
//		p2.setx(10);
//		p2.sety(23);
		point p2 = new point(10,23);
		p2.draw();
		p2.draw(true);
		p2.draw(false);
		
		ColorPoint cp1 = new ColorPoint("red");
		cp1.draw();
		cp1.draw(true);
		
		ColorPoint cp2 = new ColorPoint(10,10,"bule");
		cp2.draw();
		cp2.draw(false);
		// 레드와 블루 추가하려면, 이제 오버라이드를 사용해야 함

	}

	
}
	
	
	




