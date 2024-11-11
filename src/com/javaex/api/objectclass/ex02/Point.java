package com.javaex.api.objectclass.ex02;


// Object ex02 : equals()
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
	
	@Override						// 이걸 해줘야 LangClassTest 출력했을때 p1,p2가 맞는 값이 나옴
	public boolean equals(Object obj) {
		// obj가 point 인지 확인해줘야함
		if (obj instanceof Point) {
			// 다운 캐스팅
			Point other = (Point)obj;
			return x == other.x && y == other.y;
		}
		return super.equals(obj);
		
	}

}
