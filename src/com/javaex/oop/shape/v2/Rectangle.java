package com.javaex.oop.shape.v2;


// implements Drawable 인터페이스 추가? (쉐이프에서 드로우 주석하고, 인ㅍ터페이스로 드로우 만들었잖아
// 그걸 implements Drawable 로 추가한거임
public class Rectangle extends Shape implements Drawable {		//Rectangle가 에러나는 이유. 1. 기본 생성자가 없고 2. 
	// 필드 선언
	protected int width;		// 너비
	protected int height;		// 높이
	
	// 생성자
	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
		this.width=width;
		this.height=height;
	}
	
	@Override
	public double area() {
		return width * height;
	}
	
	@Override
	public void draw() {
		System.out.printf("사각형 [x=%d, y=%d, w=%d, h=%d, area=%f]" + "을 그렸어요.%n", x, y, width,height,area());
	}

}
