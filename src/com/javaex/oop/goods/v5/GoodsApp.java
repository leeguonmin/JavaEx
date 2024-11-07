package com.javaex.oop.goods.v5;
//선생님 패캐지는 4임. 나는 3 따로 복제해둔게 있어서 5부터 된거고


// Goods v5/ this
// this -> 현재 인스턴스 그 자체를 지칭
// this(...)  -> 현재 클래스 내부의 다른 생성자를 지칭 (내부 필드가 많을 경우, 필수 필드와 아닌 것으로 분류하고, 음?놓침

class Goods {					
	// 필드
	private String name;
	private int price;
	
	// 생성자
	public Goods(String name) {		// 밑에와 달리 네임만 넘어오는 생성자
		this.name = name;			// 필수 필드로 분류 된거? 지? 
									// 그리고 가격을 지정하지 않아도, 이 클래스에서 네임 외의 입력값은 
									// 가격뿐ㅇ리ㅏ 자연스럽게 가격이 소환된다? 고? 맞게 이해 한게 맞나 내가 
	}
	
	public Goods(String name, int price) {
//		this.name = name;		// this.현재네임필드 = 밖에서 받아온 네임;
		this(name);		// 다른 생성자 호출 			// 필드가 많을 경우 필요한 기능
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
