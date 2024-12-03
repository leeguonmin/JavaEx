package library.libra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.javaex.jdbc.dao.AuthorVo;

	public class BooksDaoImpl {
		static final String dbur1 = "jdbc:mysql://localhost:3306/test_db";
		static final String dbuser = "test_user";	
		static final String dbpass = "test";



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
	

	
	public boolean update(AuthorVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int daletedCount = 0;
		
		
		
		try {
            conn = DriverManager.getConnection(dbur1, dbuser, dbpass);
            pstmt = conn.prepareStatement("UPDATE Rental SET real_return_date = ? WHERE rental_id = ?");
            pstmt.setDate(1, realReturnDate);
            pstmt.setInt(2, rentalId);

            updatedRows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 자원 해제
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e   
) {
                e.printStackTrace();
            }
        }

        return updatedRows > 0;
    }
}
		
		return false;
	}



}