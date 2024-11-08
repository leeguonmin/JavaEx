package com.javaex.oop.person;


// 얘가 이제, 마지막 실행 클래스!! 
public class PersonApp {

	public static void main(String[] args) {
		Person  p = new Person("정우성",45);
		p.showInFo();
		
		Student s1 = new Student("서울고등학교");
		s1.showInFo();
		
		Student s2 = new Student("이정재", 45, "한국고등학교");
		s2.showInFo();

	}
	
	
	

}
