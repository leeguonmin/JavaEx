package com.javaex.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

							// 보다시피 인터페이스를 구현하느 클래스
							// 실제 데이터베이스와 상호작용하여 작가 정보를 관리할것임
public class AuthorDaoImpl implements AuthorDao {
	// 작가의 데이터를 관리하는 클래스
	// 이 클래스는 데이터 베이스에 있는 작가 정보를 다루는 역할을 함.
	// like 도서관에서 사서가 책을 관리하듯
	// 작가의 정보를 추가, 수정, 삭제, 조회하는 기능을 제공!
	// 더 쉽게 얘기하자면~ 이 클래스느 자바의 프로그램과 데이터베이스 사이에서 
	// 작가의 정보를 주고받느 다리역할을 해줌
	
	// JDBC : Java Database Connectivity의 약자
	// - 자바 프로그램에서 데이터베이스에 연결하고 SQL 문장을 실행하기 위한 기술
	
	
	static final String dbur1 = "jdbc:mysql://localhost:3306/test_db";
	static final String dbuser = "test_user";	
	static final String dbpass = "test";

	
	// getConnection() : 데이터베이스에 연결하는 메서드
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbur1, dbuser, dbpass);
			//DriverManager.getConnection 메소르르 이용하여 데이터베이스에 연결 
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패!");
		}
		return conn;
		
		
	}
	
	
	
	
	// getList() : 모든 작가 정보 조회. 데이터베이스에서 모든 작가 정보를
	// 조회하여 List<AuthorVo> 형태로 반환함다
	@Override
	public List<AuthorVo> getList() {
		List<AuthorVo> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			// sql 실행. sql 문장을 실행하여 결과를 ResultSet 객체에  저장
			// ResultSet 객체를 통해 조회 결과를 행 단위로 처리
			// 각 행의 데이터를 AuthorVo 객체에 담고, 이를 List에 추가
			String sql = "SELECT author_id, author_name, author_desc, regdate " +
			"FROM author";
			rs = stmt.executeQuery(sql);
			
			// 각 레코드를 List<AuthorVo>로 변환 해줘야 함
			while (rs.next()) {
				Long authorId = rs.getLong(1);
				String authorName = rs.getString(2);
				String authorDesc = rs.getString(3);
				Date regdate = rs.getDate(4);		// 이때  Date 는 자바로. sql가 아니라. 이유가 있는데 못들었음 sql가 필요있는 구간이 아니래
				
				AuthorVo vo = new AuthorVo(authorId, authorName, authorDesc, regdate);
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<AuthorVo> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthorVo get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(AuthorVo vo) {
		Connection conn= null;
		PreparedStatement pstmt = null;
		int insertedCount = 0;
		// PreparedStatement 를 사용하여 sql 인젝션 공격을 방지하고
		// 동일한 sql 문장을 여러번 실행할 때 효율적으로 사용
		// PreparedStatement는  동일한 SQL 문장을 
		// 여러 번 실행할 때 매개변수만 변경하여 사용할 수 있는 인터페이스라
		// SQL 인젝션 공격을 방지하는 데 효과적임
		
		try {
			conn = getConnection();
			
			String sql = "INSERT INTO author (author_name, author_desc) " +
			"VALUES(?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			// conn 데이터베이스 연결 객체 
			// prepareStatement(sql) 는 connection 객체의 메서드로, 전달된(미리 컴파일된) sql 문자열을
			// 기반으로 prepareStatement 객체를 생성한다는 거임 
			// pstmt: 생성된 PreparedStatement 객체를 참조하는 변수
			
			pstmt.setString(1, vo.getAuthorName());
			pstmt.setString(2,  vo.getAuthorDesc());
			
			// executeUpdate() 메소드를 통해 SQL 문장을 실행하고, 
			// 영향받은 행의 수를 반환하여 작업 성공 여부를 확인
			//executeUpdate() 메소드: 이 메소드는 주로 데이터베이스에 데이터를 삽입(INSERT), 
			// 수정(UPDATE), **삭제(DELETE)**하는 등 데이터를 변경하는 SQL 문장을 실행할 때 사용
			insertedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {}
		}
		return 1 == insertedCount;
	}

	@Override
	public boolean update(AuthorVo vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int daletedCount = 0;
		
		try {
			conn= getConnection();
			String sql = "DELETE FROM author " +
					"WHERE author_id=?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			
			daletedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {}
		}
		return 1 == daletedCount;
	}
	

}
