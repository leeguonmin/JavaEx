package com.javaex.basic.flow;

public class FlowcontolEx {

	public static void main(String[] args) {
		continueEx();
		breakEx();
		breakExx();

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
		System.out.println();
		System.out.println("6과 14의 최소공배수(단순무식 버전):" + num);
		System.out.println();
		
		// 근까 이ㄱ 뭐냐면, while은 반복하다가, 조건에 맞는 수를 찾으면, 탈출하라! 라는 뜻 .
		// 예제를 해석해보자면,  숫ㅈ는 1이고, 조건은 6의 배수이며 동시에 12의 배수인 것을 찾아라. 임. 
		// 그럼 1은 해당 안되지? 2로 넘어가. 2도 해당 안되지? 3으로 넘어가. 그런식으로 최소공배수를 찾을ㄸ까지 넘어가 (++num을 해줬잖아 증감)
		// 그러다 6의 배수이자 14의 배수인 42를 찾았어! 그럼 조건에 맞는 숫자를 찾았지? 더 찾으라는 말이 없었지? 
		// 브레이크! 탈출! 출력!
		
	}
	
	// 근데 그러면, 어... 6와 14의 최소공배수인 수를 4개 찾아줘. 하려면 어떻ㄱ 해야함?
	// 이렇게
	public static void breakExx() { 
	    int num = 1;
	    int count = 0; // 최소공배수를 찾은 개수를 세는 변수

	    while (count < 5) {  // 다섯 개를 찾을 때까지 반복
	        if (num % 6 == 0 && num % 14 == 0) {
	            System.out.println("6과 14의 최소공배수: " + num);
	            count++; // 최소공배수를 찾았을 때 카운트 증가
	        }
	        ++num;
	    }
	    System.out.println();
	}
	
	
	

}
