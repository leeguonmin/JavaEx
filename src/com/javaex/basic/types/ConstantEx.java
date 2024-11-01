package com.javaex.basic.types;


// 상수
// 다루는 데이터에 불변성(immutable)을 부여하는 것)
public class ConstantEx {

	public static void main(String[] args) {
		final int SPEED_LIMIT = 110;
		// 앞에 파이널을 추가 했기 때문에 불변성이 됨. 그래서 밑에서 스피드를 300으로 바뀌도, 오류나면서 적용이 안 됨 
		// final은 한번 할당 되면 재할당 불가
		// 상수의 이름은 모두 대문자, 단어의 조합은 _로 구분
		
		System.out.println("현재 도로의 제한속도는" + SPEED_LIMIT + "입니다.");
		
//		SPEED_LIMIT = 300; -> 이거 주석풀면 빨간불 뜰거임 // 불변성 제한
		System.out.println("제한 속도" + SPEED_LIMIT + "이하로 주행해 주세요.");

	}

}

// refacter > rename 으로 폴더 이름 바꿀수있음