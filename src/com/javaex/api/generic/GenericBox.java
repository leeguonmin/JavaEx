package com.javaex.api.generic;


// Generic
// : 설계시에는 내부 데이터 타입을 비워두고(미정 상태로 남겨두고)
// 실제 객체화시 그때 외부에서 내부 데이터 타입을 결정해주는 방식 (-> 일반화)
public class GenericBox<T> {
	// 자주 사용하는 템플릿 문자 
	// <T> : 데이터 타입
	// <K> : key
	// <V> : Value
	// <R> : Return Type
	
	T content;

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
	
	
	
	
	
}
