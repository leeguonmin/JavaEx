package com.javaex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

// ConnectionTest + SelectTest 합친 실습
public class SelectTest {

								// 통신 규약 ->  jdbc:mysql:      (중요)
								// 주소 : //localhost
								// 포트 : 3306
								// 패스 정보 : hrdb
	static final String dbur1 = "jdbc:mysql://localhost:3306/hrdb";			// URL (문서의 식별자, 문서의 위치)
			      //jdbc:		// 위치		   // 스키마
	static final String dbuser = "hrdb";	
	static final String dbpass = "hrdb";
	
	// departments 테이블로부터 {department_id} - {department_name}
	public static void main(String[] args) {
		Connection conn = null;				// 접속 정보 객체
		java.sql.Statement stmt = null;    // 쿼리 실행 객체
		ResultSet rs = null;			// 결과 객체
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			// 드라이버 로드
			conn = DriverManager.getConnection(dbur1, dbuser, dbpass);		// 드라이버로부터 커넥션 얻어오기
			// 접속 개체 출력
//			System.out.println(conn);
//			System.out.println("연결 성공!");
			
			stmt = conn.createStatement();		// 쿼리 수행 객체
			String sql = "SELECT department_id, department_name " + "FROM departments";		// sql은 자바에서 오타체크 안되니까 확인 잘하기
			
			rs = stmt.executeQuery(sql);				// -> cursor // rs가 지금 커서뭐라는거임
			
			while(rs.next()) {
				int deptID = rs.getInt(1);
				String deptName = rs.getString("department_name");
				
				System.out.printf("%d - %s%n",deptID, deptName);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾지 못했습니다!");
			e.printStackTrace();					// 이건 왜 추가한건지 모르겟어................. 딴건 뭐 알겟냐마는
		} catch (SQLException e) {
			System.out.println("SQLError!");
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
