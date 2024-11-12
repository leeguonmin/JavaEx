package com.javaex.collection.list;

import java.util.Stack;

public class StackEx {

	public static void main(String[] args) {
		// Stack : 가장 마지막에 입력된 자료가 먼저 출력된다(먼저 나온다) *많이 사용!
		// Last Input First Output : 후입선출 자료형
		Stack<Integer> stack = new Stack<>();
		
		// 값을 10개 push(입력)
		for (int i=1; i<=10; ++i) {
			stack.push(i);	// 입력
			System.out.println("STACK: " + stack);		// 뒤쪽에서 숫자가 하나씩 입력된 것을 알 수 있고
		}
		
		// 출력 방향의 데이터 확인 
		System.out.println("PEEK: " + stack.peek());	// 출력 방향을 확인 (확인만 해. 인출하진 않아)
		System.out.println("STACK: " + stack);			// 인출하지 않으니까, 출력하면 그대로 남아있음 
		
		// 인출 : 입력방향과 동일
		System.out.println("POP: " + stack.pop()); 	// 확인 후 인출 
		System.out.println("STACK: " + stack);		// 10이 출력된 결과가 출력됨 
		
		while(!stack.empty()) {		// stack이 비어있지 않으면, 라는 조건을 줘야 마지막에 에러 안난다고 (원래는 true 썼는데, 얘는 에러나)
			System.out.println("POP:" + stack.pop());
			System.out.println("STACK: " + stack);		
		}

	}

}
