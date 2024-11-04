package com.javaex.basic.flow;

public class FlowcontolEx {

	public static void main(String[] args) {
//		continueEx();
		breakEx();

	}
	
	
	private static void continueEx() {
		// continue : 반복 블록 내부에서 남아있는 문장을 실행하지 않고 다음번 루프로 진행
		
		// 1 ~ 100 루프를 돌면서 2의 배수와 3의 배수가 아닌 숫자만 출력
		for (int i = 1;			// 초기화
			i <= 100;			// 반복 조건
			++i) {
			if (i % 2 == 0 || i % 3 == 0) continue;			// 2의 배수와 3의 배수는 출력 안 시키겠다는 명령어. 컨티뉴 사용법
			System.out.println(i);
		}
		
	}
	
/*	
	for (int i = 1;			
			i <= 100;			
			++i) {
			System.out.println(i);			// 이렇게 쓰고 재생누르면, 1~100까지 정상적으로 출력됨
*/	
	
	
	public static void breakEx() {
		// break : 반복 블럭 내부에서 남아있는 문장은 실행하지 않고 블록을 탈출한다!!!
		
		// 6과 14로 모두 나누어 떨어지는 수를 구해보자
		int num = 1;
		
		while (true) {		// 어디까지 가야 저 값이 나올지 모름
			if (num % 6 == 0 && num % 14 == 0)
				break;		// 루프 탈출
			++num;
		}
		
		System.out.println("6과 14의 최소공배수(단순무식 버전):" + num);
		
	}
	
	
	
	

}
