package com.javaex.oop.goods.v2;


// Goods v2. 접근 제한자
class Goods {					// 제한자를 따로 설정하지 않았지? 이걸 디폴트로 보는거임
	// 필드 선언	-> private로 변경 
	// >> 정보는 은닉하고 Getter와 Setter 를 통한 우회 접근이 필요!
	// 데이터를 다루는 기능(메서드) 함께 구현
	private String name;
	private int price;
	// private 추가해주니까, 밑에 싹 다 에러남. 공유안되니까
	// 해결하는 방법? 있다!! ㄱㄷ  -> "우회 접근(Getter와 Setter)"
	
	
	// 우회 접근 방법 ▼
	
	// name 필트를 위한 Getter 
	public String getName() {
		return name;
		// 네임을, 출력하라
	}
	
	// name 필드를 위한 Setter
	public void setName(String name) {
		this.name = name;
		// this -> 현재 인스턴스 자체
		// 네임을, 가져와라
	}
	
	// price 필드를 위한 Getter  
	public int getPrice() {
		return price;
	}
	
	// price 필드를 위한 Setter 
	public void setPrice(int price) {
		this.price = price;
	}
	
	// 읽기만 가능하면(필요하면) Getter      	* 근데 읽기만 가능한게 어떤때고
	// 쓰기만 가능하면(필요하면) Setter 		* 쓰기만 가능한게 어떤때인거죠 ..? 근본부터 모르겠다
	// 둘 다 필요하면 둘 다 쓰는거임 (예제는 둘 다 썼음. 모르겠다 평생 둘 다 쓰다보면 언젠가 아, 하고 알때가 오나?)

	
}


// Goods 테스트 클래스
public class GoodsApp {

	public static void main(String[] args) {
		Goods camera = new Goods();		// 생성자 호출
		// 생성자를 호출 -> 인스턴스 생성 -> camera로 참조
//		camera.name = "Nikon";
//		camera.price = 400_000;
		camera.setName("Nikon");
		camera.setPrice(400_000);
		
//		System.out.printf("%s -> %,d%n", camera.name, camera.price);
		System.out.printf("%s -> %,d%n", camera.getName(), camera.getPrice());

		
		Goods on = new Goods();
		on.setName("LG그램");
		on.setPrice(900_000);
		System.out.printf("%s -> %,d%n", on.getName(), on.getPrice());
		
		
		Goods mug = new Goods();
		mug.setName("머그컵");
		mug.setPrice(2_000);
		System.out.printf("%s -> %,d%n", mug.getName(), mug.getPrice());
	}
	
	
	
	
	
	

}
