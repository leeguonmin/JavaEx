package com.javaex.oop.casting;

public class AnimalApp {

	public static void main(String[] args) {
		// upcasting(업캐스팅) : 부모 타입으로 자식 인스턴스를 참조하는 것
		Animal dog1 = new Dog("Snoopy");
		dog1.eat();
		dog1.walk();
//		dog1.bark();		// 오류 뜨는 이유 > 참조 타입의 설계도(부모 클래스)에 있는 것만 사용&실현 가능
		
		
		Dog dog2 = new Dog("Doogy");
		dog2.eat();
		dog2.walk();
		dog2.bark();        // 얜 도그 설계도에 있는 기능이라 가능. 오류 안나 
		
		
		Animal pet = new Dog("Azi");
		pet.eat();
		pet.walk();			// 펫이라는 뉴 도그를 만들어줬으니, 부모에 있는 먹다&걷다는 되지만, 개 클래스에 있는 멍멍은 못함
							// 멍멍 하려면? > 다운캐스팅 쓰면 됨
		
		// downcasting(다운캐스팅) : 부모 타입으로 참조되던 타입을 원래대로 되돌리는 것
		// 가로 안에 넣어주면서, '펫'의 설계도가 '도그'로 바뀜.
		((Dog)pet).bark();			// 도그 설계도에 있는 멍멍 가능해짐 
		
		pet= new Cat("Yaong");
		pet.eat();
		pet.walk();
		
//		((Dog)pet).bark();	// 만약, 실수로 고양이를 개인줄 착각하고 멍머을 시켰다?
							// 펫은, 개로 캐스팅 될 수 없다- 라는 빨간 오류 떠 (같은 자식 클래스끼리는 캐스팅 안되나?
		// 캐스팅 시, 해당 객체가 캐스팅 가능 객체인지 확인 필수 (이럴때 필요한건? 인스턴스 오브 instanceof)
		if (pet instanceof Dog) {
			((Dog)pet).bark();
		} else if (pet instanceof Cat) {
			((Cat)pet).meow();
		}			// cat이 개라면 짖고, 개가 아니라면 고양이 설계도에 있는 야옹
		
		
		
		
	}
	
	

}
