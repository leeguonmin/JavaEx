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

public class AuthorDaoImpl implements AuthorDao {
	
	static final String dbur1 = "jdbc:mysql://localhost:3306/test_db";
	static final String dbuser = "test_user";	
	static final String dbpass = "test";

	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbur1, dbuser, dbpass);
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패!");
		}
		return conn;
		
		
	}
	
	
	
	
	
	@Override
	public List<AuthorVo> getList() {
		List<AuthorVo> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
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
		
		try {
			conn = getConnection();
			
			String sql = "INSERT INTO author (author_name, author_desc) " +
			"VALUES(?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getAuthorName());
			pstmt.setString(2,  vo.getAuthorDesc());
			
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
