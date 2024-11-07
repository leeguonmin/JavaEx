package com.javaex.oop.goods.v4;
//선생님 패캐지는 3임. 나는 3 따로 복제해둔게 있어서 4부터 된거고


// Goods v4. 생성자
// 생성자가 만들어져 있지 않으면 JVM이 기본 생성자를 끼워 넣는다
// 그러나 만약, 개발자가 생성자를 만들면 JVM은 기본 생성자를 끼워넣지 않는다
// Setter 가 없으면 Read-only
class Goods {					
	// 필드
	private String name;
	private int price;
	
	// 생성자
	public Goods(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	
	

	// 우회 접근 방법 ▼
	// Getter/ Setter 
	
	// name 필트를 위한 Getter 
	public String getName() {
		return name;
	}
	
	// name 필드를 위한 Setter
	public void setName(String name) {
		this.name = name;
		// this -> 현재 인스턴스 자체
	}
	
	// price 필드를 위한 Getter  
	public int getPrice() {
		return price;
	}
	
	// price 필드를 위한 Setter 
	public void setPrice(int price) {
		this.price = price;
	}
	
	

	// 일반 메서드
	public void showInFo() {
		System.out.println("상품병:"+name);
		System.out.printf("가격:%,d원%n",price);
	}
	
}


// Goods 테스트 클래스
public class GoodsApp {

	public static void main(String[] args) {
//		Goods camera = new Goods();		
//
//		camera.setName("Nikon");
//		camera.setPrice(400_000);
		Goods camera = new Goods("Nikon", 400_000);
		camera.showInFo();

		
//		Goods on = new Goods();
//		on.setName("LG그램");
//		on.setPrice(900_000);
		Goods on = new Goods("LG그램", 900_000);
//		on.setPrice(1_000);
		on.showInFo();
		
		
//		Goods mug = new Goods();
//		mug.setName("머그컵");
//		mug.setPrice(2_000);
		Goods mug = new Goods("머그컵", 2_000);
		mug.showInFo();
		
	}
	
	
	
	
	
	

}
