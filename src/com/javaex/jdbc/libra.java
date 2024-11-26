package com.javaex.jdbc;

import java.sql.*;

public class libra {



//... (기존 코드)

//데이터베이스 연결 정보
private static final String DB_URL = "jdbc:mysql://localhost:3306/library_db";
private static final String USER = "library_user";
private static final String PASS = "1234";

//데이터베이스 연결 메소드
private static Connection getConnection() throws SQLException {
 return DriverManager.getConnection(DB_URL, USER, PASS);
}

}

public static void JoinCustomer() {
    // ... (기존 코드)

    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        // 이메일 중복 확인
        String checkEmailSql = "SELECT COUNT(*) FROM Customers WHERE email = ?";
        try (PreparedStatement checkPstmt = conn.prepareStatement(checkEmailSql)) {
            checkPstmt.setString(1, email);
            ResultSet rs = checkPstmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("이미 존재하는 이메일입니다.");
                return;
            }
        }

        // 비밀번호 암호화 (예: BCrypt 사용)
        String hashedPassword = BCrypt.hashpw(customersPassword, BCrypt.gensalt());
        pstmt.setString(5, hashedPassword);

        // 트랜잭션 시작
        conn.setAutoCommit(false);

        // 회원 정보 삽입
        int result = pstmt.executeUpdate();

        // 성공 시 커밋, 실패 시 롤백
        if (result > 0) {
            conn.commit();
            System.out.println("회원 가입 성공!");
        } else {
            conn.rollback();
            System.out.println("회원 가입 실패");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}