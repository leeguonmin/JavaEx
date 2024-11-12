package com.javaex.api.arrays;

import java.util.Arrays;

public class ArraysEx {

	public static void main(String[] args) {
		// 배열의 복사
		arraysCopyEx();
		
		// 얕은 비교
		equalsEx();
	

	}
	
	private static void arraysCopyEx() {
		char[] src="Java Programming".toCharArray();
		System.out.println(Arrays.toString(src));
		
		// system을 이용한 카피
		char[] target=new char[src.length];
		System.arraycopy(src,0,		// src의 0버부터의 요소를 
				target,0,			// target의 0번부터 복사
				src.length);		// src.length길이를 복사
		System.out.println(Arrays.toString(target));
		
		
		// Arrays.copyOf 를 이용한 카피
		target=Arrays.copyOf(src, 5);
//		System.out.println("copyOf:" + target);
		System.out.println("copyOf:" + Arrays.toString(target));
		
		
		// 범위 복제
		target = Arrays.copyOfRange(src, 5,12);		// 5번 인덱스부터 12번 앞(11번)까지
		System.out.println("copyOfRange:" + Arrays.toString(target));
		
	}
	
	
	private static void equalsEx() {
		// 배열의 얕은 비교 
		// -> 배열의 요소 값을 단순 비교
		int[] nums1 = {1,2,3,4,5,6,7,8,9,0};
		int[] nums2 = {1,2,3,4,5,6,7,8,9,0};
		int[] nums3 = {1,2,3,4,0,6,7,8,9,0};
		
		System.out.println("nums1 vs nums2: " + Arrays.equals(nums1,nums2));
		System.out.println("nums1 vs nums3: "+ Arrays.equals(nums1,nums3));
		
		
	}
	

}
