package com.javaex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class 실습삼번 {
	
	static final String dburl = "jdbc:mysql://localhost:3306/hrdb";
	static final String dbuser = "hrdb";
	static final String dbpass = "hrdb";
	
	public static void main(String[] args) {
		Connection conn = null;				// 접속 정보 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		
		Scanner scanner = new Scanner(System.in);
		// 입력을 받을거니까
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbuser, dbpass);
			// 드라이버 매니저로부터 커넥션 정보를 받아오겠다
			
//			System.out.print("검색어 입력:");
//			String keyword = scanner.next();
			
			String input = scanner.nextLine();
			String[] tokens = input.split(" ");
			
			int minSalary = Integer.parseInt(tokens[0]);
			int maxSalary = Integer.parseInt(tokens[1]);
			
			// 실행 계획 수립 
			String sql = "SELECT CONCAT(first_name, ' ', last_name) full_name, " +
					"salary FROM employees " + 
					"WHERE salary BETWEEN ? AND ? ORDER BY salary"; 

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, minSalary);
			pstmt.setInt(2, maxSalary);
			
			rs=pstmt.executeQuery();
			
			// 루프 돌려
			while(rs.next()) {
				System.out.printf("%s\t%d%n", 
						rs.getString(1),
						rs.getString(2));
			}
			
			// 드라이버 로드에 관련된 예외 처리
		} catch (ClassNotFoundException e) {
			e.printStackTrace();		// 예외 표시
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