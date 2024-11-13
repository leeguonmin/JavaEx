package com.javaex.collection.hash;

import java.util.Arrays;
import java.util.HashSet;

// 사용자 정의 클래스 
class Student {
	int id; 	// 학번
	String name;	// 이름
	
	// 생성자 
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// 두 객체의 동등성 체크 
	// 1. hashcode() 값을 비교 
	// 2. equals() 로 내부 데이터 비교
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
//		return super.hashCode();
		return id;		// 학번을 hashcode로 사용
		// 여기를 통과하면 equals로 내부 데이터 비교
	}

	@Override
	public boolean equals(Object obj) {
		// +
		if (obj instanceof Student) {
			// 다운 캐스팅 가능 
			Student other = (Student)obj;
			return id==other.id && name.equals(other.name);
		}
		return super.equals(obj);
	}
	
	
	
	
}













public class HashSetEx {

	public static void main(String[] args) {
//		usinghashSet();
//		setOperation();
		UsingHashSetWithCustom();

	}
	
	private static void usinghashSet() {
		// 선언 
		HashSet<String> hs = new HashSet<>();
		
		
		// 추가 
		hs.add("Java");
		hs.add("C");
		hs.add("C++");
		hs.add("Python");
		hs.add("Java");			// // set자료형은 중복을 허용하지 않기 때문에 중복자바는 출력 안될거임
		
		System.out.println("hs:"+hs);
		System.out.println("size:"+hs.size());		
		
		// 포함 여부 확인 
		System.out.println("C++가 포함되어 있는가?:"+hs.contains("C++"));
		System.out.println("Linux가 포함되어 있는가?:"+hs.contains("Linux"));
		
		// 요소 삭제 
		hs.remove("C++");
		System.out.println("hs:"+hs);
		
	}
	
	
	private static void setOperation() {
		// 집합 연산 : Set은 집함을 표현하는 자료 구조
		HashSet<Integer> numbers = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));	// 전체 집합
		HashSet<Integer> odds = new HashSet<>(Arrays.asList(1,3,5,7,9));		// 홀수 집합
		HashSet<Integer> evens = new HashSet<>(Arrays.asList(2,4,6,8,10));		// 짝수 집합
		HashSet<Integer> mthree = new HashSet<>(Arrays.asList(3,6,9));		// 3의 배수 집합
		
		
		// 교집합 : retainAll
		System.out.println("====== 교집합");
		HashSet<Integer> setA = (HashSet<Integer>)odds.clone();
//		HashSet<Integer> setB = (HashSet<Integer>)evens.clone();
		HashSet<Integer> setB = (HashSet<Integer>)mthree.clone();
		
		System.out.println("집합A:" + setA);
		System.out.println("집합B:"+setB);
		
		// 홀수 교집합 3의 배수
		setA.retainAll(setB);		// 홀수 교집합 3의 배수
		System.out.println("교집합:"+setA);
		
		// 검증
		System.out.println(setA.equals(new HashSet<Integer>(Arrays.asList(3,9))));
		
		// 합집합 : addAll
		System.out.println();
		System.out.println("========= 합집합");
		setA = (HashSet<Integer>)odds.clone();		// 홀수 집합
		setB=(HashSet<Integer>)evens.clone();		// 짝수 집합
		
		System.out.println("집합A:"+setA);
		System.out.println("집합B:"+setB);
		
		setA.addAll(setB);			// 집합A 합집합 집합B
		System.out.println("합집합:"+setA);
		// 검증
		System.out.println(setA.equals(numbers));
		
		
		// 차집합 : removeAll
		System.out.println();
		System.out.println("===== 차집합");
		setA=(HashSet<Integer>)numbers.clone();		// 전체집합
		setB=(HashSet<Integer>)odds.clone();		// 홀수 집합
		
		System.out.println("집합A:"+setA);
		System.out.println("집합B:"+setB);
		
		setA.removeAll(setB);		// 집합A 자집합 집합B
		System.out.println("차집합: "+setA);
		// 검증
		System.out.println(setA.equals(evens));
		
	}
	
	
	
	private static void UsingHashSetWithCustom() {
		HashSet<Student> hs = new HashSet<>();
		
		Student s1=new Student(10, "홍길동");
		Student s2 = new Student(20, "홍길동");		// 얘넨 동명이인 
		Student s3=new Student(30, "고길동");			
		Student s4=new Student(30, "고길동");			// 얘넨 동일인물이지
		
		// s3, s4가 이름도 같고 학번도 같으니
		// 두 객체를 동등객체로 판별하도록 롲기을 작성해야한다
		hs.add(s1);
		hs.add(s2);
		hs.add(s3);
		hs.add(s4);
		
		System.out.println("학생부:"+ hs);
		
		
	}
	

}
