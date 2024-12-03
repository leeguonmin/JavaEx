package library.lilili.libra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class 시험 {
	
	static final String dburl = "jdbc:mysql://localhost:3306/library_db";
	static final String dbuser = "library_user";
	static final String dbpass = "1234";
	
	
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
	
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl,dbuser,dbpass);
			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!");
			
			
		System.out.println("대여할 책의 아이디를 입력하세요: ");
		int bookId = scanner.nextInt();
		
		String sql = "SELECT * FROM books WHERE book_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, bookId);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
        	// 책 정보 출력 (예시)
        	String bookTitle = rs.getString("book_title");
        	System.out.println("대여할 책: " + bookTitle);

        	// 대여 상태 업데이트 쿼리
        	String updateSql = "UPDATE books SET is_rented = 1 WHERE book_id = ?";
        	pstmt = conn.prepareStatement(updateSql);
        	pstmt.setInt(1, bookId);
        	pstmt.executeUpdate();
	
		
        // 오늘 날짜 구하기
        Date today = new Date();

        // Calendar 객체 생성 및 오늘 날짜 설정
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);

        // 대여 기간 더하기 (9일)
        cal.add(Calendar.DATE, 9);
        
        

        // 결과 출력
        Date returnDate = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
        String formattedDate = sdf.format(returnDate);
        System.out.println("책 반납일은 " + formattedDate + " 입니다.");
    }
        
        rs.close();
        pstmt.close();
        conn.close();
} catch (SQLException e) {
	e.printStackTrace();
}

} 
	
}