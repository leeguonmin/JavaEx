package com.javaex.oop.staticmember;


// 생성하지 않고도 사용할수있는 정적 클래스
public class Calc {
	
	// static final 상수
		public static final double PI = 3.14159F;


	public static double getSum(double ... values) {
		double total = 0;
		
		for (double value: values) {
			total += value;
		}
		
		return total;
	}
	
	
	}
