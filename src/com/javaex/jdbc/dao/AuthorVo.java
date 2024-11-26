package com.javaex.jdbc.dao;

import java.util.Date;

// DTO(VO)
// : 자바 계층간 데이터를 주고받기 위한 데이터 객체
// 		- 내부에 로직이 없는 순수 데이터 객체다
//		- 기본 생성자가 반드시 있어야 한다.
//		- toString(), equals() 메서드는 만들기도 한다.


// 작가 정보를 담는 클래스
// 이 클래스는, 작가의 정보를 저장하는 도장과 같음. 자가 이름, 설명, 등록일 등의 정보를 담는 클래스
public class AuthorVo {
	private Long authorId;
	private String authorName;
	private String authorDesc;
	private Date regdate;
	
	public AuthorVo() {
			// 아무런 값 없이 객체를 생성할 때 사용하는 기본 생성자
	}

	public AuthorVo(String authorName, String authorDesc) {
		super();
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}
	// authorId;  regdate; 얘는 왜 빼는거야..? 
	// 작가의 이름과 설명만 가지고 객체를 생성하기 위해

	public AuthorVo(Long authorId, String authorName, String authorDesc, Date regdate) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
		this.regdate = regdate;
	}		
	// 모든 필드를 다 .. 음 하는 생성자
	// 모든 정보를 다 가지고 객체를 생성할때 사용

	
	// 이건 알다시피 각 필드의 값을 읽거나 변경할때 사용할것임
	// 예를 들어, getAuthorName() 메소드를 호출하면 해당 객체의 작가 이름을 가져올 수 있음
	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorDesc() {
		return authorDesc;
	}

	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	
	// toString() 메소드: 객체의 정보를 문자열 형태로 출력할 때 사용. 디버깅이나 로그 출력 시 유용함
	@Override
	public String toString() {
		return "AuthorVo [authorId=" + authorId + ", authorName=" + 
							authorName + ", authorDesc=" + authorDesc
							+ ", regdate=" + regdate + "]";
	}
	
	
	// 예시
	/*
	 
	 AuthorVo author = new AuthorVo(1L, "김 작가", "베스트셀러 작가", new Date());
	 System.out.println(author); // AuthorVo [authorId=1, authorName=김 작가, 
	 											authorDesc=베스트셀러 작가, regdate=2023-11-27]
	 
	 
	 * */
	
	

}
