package com.javaex.practice04;

public class Ex06 {

	public static void main(String[] args) {
		
		char c[] = {'T','h','i','s',' ','i','s',' ','a',' ','p','e','n','c','i','l'};
		
		for (int i = 0; i <c.length; i++) {
			if (c[i] == ' ') {
				c[i] = ',';
			}
		}
		
		for (int i = 0; i<c.length; i++) {
			System.out.print(c[i]);
		}
	}

}


// ln이 엔터 밑으로 쭉