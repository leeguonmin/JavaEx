package com.javaex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// Java JDBC를 사용하여 HR 데이터베이스에서 직원을 검색하는 프로그램
// mysql 데베에 연결 (jdbc:mysql)
// 입력받ㅇㄴ 검색어를 포함하는 이름을 가진 직원 정보를 조회
// 조회된 직원 정보를 출력!
public class HRSearchEmployeesPstmt {
	
	static final String dbur1 = "jdbc:mysql://localhost:3306/hrdb";
	static final String dbuser = "hrdb";	
	static final String dbpass = "hrdb";
	// 필드 변수 들

	public static void main(String[] args) {
		Connection conn = null;				// 접속 정보 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		
		Scanner scanner = new Scanner(System.in);
		
		try {				
							// jdbc 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbur1, dbuser, dbpass);
					// 데이터 베이스 연결
			
			System.out.print("검색어 입력:");
			String keyword = scanner.next();
			// 사용자에게 입력 받고
			
			// 실행 계획 수립
			String sql = "SELECT CONCAT(first_name, ' ', last_name) full_name, " +
			"email, phone_number, hire_date FROM employees " +
					"WHERE UPPER(first_name) like ? OR " +
			"UPPER(last_name) like ?";
			// 데이터 바인딩 위치를 ?로 설정, 동적으로 데이터를 연결 시킴
			// like 연산자는 mysql 에서 문자열 패턴 매칭 수행에 사용 됨. 특 특정 문자열과 일치하는 값을 찾고 싶을때 사용
			// 예시 : WHERE name LIKE '김%': 이름이 '김'으로 시작하는 모든 레코드를 찾습니다.
			// 예시2 : WHERE email LIKE '%@gmail.com': 이메일 주소가 '@gmail.com'으로 끝나는 모든 레코드를 찾습니다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  "%" + keyword.toUpperCase() + "%");
			pstmt.setString(2, "%" + keyword.toUpperCase() + "%");
			// % : 와일드 카드. 얘는 0 이상의 임의의 문자를 상징. 즉 %가 들어간 자링 어떤 문자가 와도 노상관. 어떤 문자열과도 일치
			// keyword.toUpperCase(): 사용자가 입력한 검색어를 모두 대문자로 변환


			
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