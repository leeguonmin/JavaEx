package com.javaex.oop.person;

// 여기는 상속받아야하는 자식 클래스!! 학교 이름만 있을거임 
public class Student extends Person {			// 부모 클래스에서 기본 설정을 상속받을 수 있음
	private String schoolname;
	
	// 생성자
	public Student(String schoolName) {
		super();					// = 우리가 특별히 뭐 안하면, 부모의 설정을 상속받는다. 라는 의미로 사용 
		this.schoolname = schoolName;
// 부모 클래스의 기본 생성자에 시스템 추가하고 왓음 
		System.out.println("Stubent(String) 생성자 호출");
		
	}
	
	
	public Student (String name, int age, String schoolName) {
		super(name,age);
		this.schoolname = schoolName;
		System.out.println("student(String,int String) 생성자 호출");
	}
	
	
	// 스쿨네임의 겟터 셋터가 필요
	public String getschoolName() {
		return schoolname;
	}
	
	public void setschoolName(String schoolName) {
		this.schoolname=schoolName;
	}
	
	@Override
	public void showInFo() {
		System.out.println("Name: " +name+", Age: "+age+", SchoolName: "+schoolname);
	}

}
