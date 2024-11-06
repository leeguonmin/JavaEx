package com.javaex.practice04;

import java.util.Scanner;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		
		int[] won = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		String[] mon = { "50000원", "10000원", "5000원","1000원","500원","100원","5원","1원"};
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("금액: ");
		int sa = scanner.nextInt();
		// 여기다 금액을 적어
		// 그럼 이제 뭐해야해 // 금액.......에서 지폐를 빼야지 차례차례.........어떻게

		// con 이... 합이야! 이 합을...어ㅓㅓㅓㅓㅓㅓㅓㅓ 지폐 배열들로 쳐내 쳐쳐 어떻게쳐
		int i;
		for (i=0; i<won.length; i++) {
			int con = sa / won[i];				// 아니지 con이 지폐 개수야 그치? 그치...합은무슨	
			
		System.out.println(mon[i] + ": "+ con + "개");
		
		}
		
		scanner.close();
	}

}




// int (방)[0] < 첫번째 방
// (방)[1] < 두번째 방
// [(숫자)] < 박스의 위치를 말하는거임










//int cons = sa / won[i];		// con = 금액/돈[박스]
//sa %= won[i];				// 
