package com.javaex.practice04;

public class Ex2 {

	public static void main(String[] args) {
		Ex();

	}

	private static void Ex() {
		
		double[] num;
		
		num = new double[3];
		num[0] = 1.2;
		num[1] = 3.3;
		num[2] = 6.7;
		
		for (int i = num.length - 1; i >= 0; --i) {
			// 어디서 시작할래, 했으니까 -1 줘서, 가장 마지막에서 시작하겠다고 지정
			// 어디까지 갈래? 했으니, 밑으로 쭉쭉 내려가서 0까지 가겠다고 지정
			// 어떤 방향으로 갈래? 했으니, <- 이쪽 방향으로 가겠다! 해서 --d 로 지정 
			System.out.println(num[i]);
		}
				
		
	}
	
	// for ( 시작하는 자리 지정; 끝자리 지정; 얼마나 움직일것인가;)
	
	
//	for (d = 0; d < num.length; d++) {
//		System.out.println(num[d]);
}
