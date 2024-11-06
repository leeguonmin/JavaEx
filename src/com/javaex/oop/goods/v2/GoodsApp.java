package com.javaex.oop.goods.v2;


// Goods v2. 접근 제한자
class Goods {					// 제한자를 따로 설정하지 않았지? 이걸 디폴트로 보는거임
	// 필드 선언	-> private로 변경 
	private String name;
	private int price;
	// private 추가해주니까, 밑에 싹 다 에러남. 공유안되니까
}

// Goods 테스트 클래스
public class GoodsApp {

	public static void main(String[] args) {
		Goods camera = new Goods();		// 생성자 호출
		// 생성자를 호출 -> 인스턴스 생성 -> camera로 참조
		camera.name = "Nikon";
		camera.price = 400_000;
		System.out.printf("%s -> %,d%n", camera.name, camera.price);

		
		Goods on = new Goods();
		on.name = "LG그램";
		on.price = 900_000;
		System.out.printf("%s -> %,d%n", on.name, on.price);
		
		
		Goods mug = new Goods();
		mug.name = "머그컵";
		mug.price = 2_000;
		System.out.printf("%s -> %,d%n", mug.name, mug.price);
		
	}
	
	
	
	
	
	

}
