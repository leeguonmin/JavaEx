package com.javaex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HRSearchEmployeesPstmt {
	
	static final String dbur1 = "jdbc:mysql://localhost:3306/hrdb";
	static final String dbuser = "hrdb";	
	static final String dbpass = "hrdb";

	public static void main(String[] args) {
		Connection conn = null;				// 접속 정보 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbur1, dbuser, dbpass);
			
			System.out.print("검색어 입력:");
			String keyword = scanner.next();
			
			// 실행 계획 수립
			String sql = "SELECT CONCAT(first_name, ' ', last_name) full_name, " +
			"email, phone_number, hire_date FROM employees " +
					"WHERE UPPER(first_name) like ? OR " +
			"UPPER(last_name) like ?";
			// 데이터 바인딩 위치를 ?로 설정, 동적으로 데이터를 연결 시킴
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  "%" + keyword.toUpperCase() + "%");
			pstmt.setString(2, "%" + keyword.toUpperCase() + "%");

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.printf("%s: %s, %s, %s%n", 
						rs.getString("full_name"),
						rs.getString("email"),
						rs.getString(3),
						rs.getString(4));
			}
		

	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
		}
	}
		
		scanner.close();

}

}