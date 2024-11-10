package com.javaex.basic.reftypes;

import java.util.Arrays;

// 에러ㄴ서 하나씩 일로 옮겨서 재생해보려고 방 복사함
public class ArrayEx2 {

	public static void main(String[] args) {
		enhancedFor();

	}


	private static void enhancedFor() {
		int[] nums = {1,2,3,4,5,6,7,8,9,10};
		// 일반적인 for문
		for (int i =0; i<nums.length; ++i) {  		// ++i 하나씩 늘려간다고
			System.out.print(nums[i] + "\t");
		}
		System.out.println();
		
		
		// Enhanced For:
		// 카운터 변수, 반복 조건, 증감식 신경쓰지 않고
		// 손쉽게 컬렉션 데이터(배열 등)를 조작할 수 있다  	// (편의 기능)
		for (int num: nums) {
			System.out.print(num+"\t");
		}
		System.out.println();
		
	}
	
}