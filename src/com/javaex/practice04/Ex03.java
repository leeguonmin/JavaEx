package com.javaex.practice04;

public class Ex03 {

	public static void main(String[] args) {

		
		int[] intA = { 3, 6, 9 };
		
		int[] intB;
		intB = intA;
		intB[0] = 20;
		intB[2] = 10;
		
		for(int i = 0; i<intA.length; i++) {
			System.out.println(intA[i]);
		}
		
	}

	
// 참조 복제
	// 아니 얘는 예상한 대로 나왔는데
	// 바로 다음 문제인 Ex4 난도이는 왜 이래ㅠ 아 ㅠ 아ㅠㅏ 아 ㅏㅇ아퓨 아아ㅏㅏㅠ아ㅠ ㅠㅠ 

}
