package com.javaex.basic.opers;

public class CondOperEx {
	
	// 3항 연산자
	// 조건에 따라 선택적으로 값을 선탣액하는 연산자 


	public static void main(String[] args) {
		int a = 10;
		// a가 짝수면 짝수, 홀수면  홀수
		String result;
		// 짝수인줄 알려면 2로 나눴을때 아무것도 안남는걸 봐
		
		result = a % 2 == 0 ? "짝수": "홀수";
		System.out.println(a + "는" + result);
		// 참이 앞, 거짓이 뒤 
		
		// 점수가 80점 이상이면 good
		// 점수가 50 ~ 80점 사이면 pass
		// 점수가 50이 안되면 fail
		
		String message;
		int score = 70;
		
		message = (score >= 80) ? "Good":
			(score >= 50) ? "Pass":
				"Fail";
		System.out.println("점수:" + score + "결과:" + message);
		
	}

}
