package libra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDaoImpl implements ManagerDao {
	
	static final String dburl = "jdbc:mysql://localhost:3306/library_db";
	static final String dbuser = "library_manager";
	static final String dbpass = "0000";
	
	private Connection getConnection2() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl,dbuser, dbpass);
			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!");
		}
		return conn;
	}
	
	
	
	
	
	
	@Override
	public List<ManagerVo> getList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ManagerVo> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	@Override
	public List<ManagerVo> search2(String manager_nameid, String manager_password) {
		List<ManagerVo> list = new ArrayList<>();
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection2();
			
			String sql = "SELECT manager_nameid, manager_password FROM manager WHERE manager_nameid LIKE ? AND manager_password LIKE ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, manager_nameid);
			pstmt.setString(2, manager_password);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				if (rs.getString(1).equals(manager_nameid) & rs.getString(2).equals(manager_password)) {
					System.out.println("로그인 성공");
					ManagerVo vo = new ManagerVo(rs.getString(1), rs.getString(2));
					list.add(vo);
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt !=  null) pstmt.close();
				if (conn != null) conn.close();
		} catch (Exception e) {
			
		}
		}
		return list;
		
		
	}
	
	
	public boolean checkBookAvailability(int bookId, Connection conn) throws SQLException {
	    String sql = "SELECT stock FROM Books WHERE book_id = ?";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setInt(1, bookId);
	    ResultSet rs = pstmt.executeQuery();

	    boolean isAvailable = false;
	    if (rs.next()) {
	        int isRented = rs.getInt("stock");
	        isAvailable = (isRented == 0); // 0이면 보유 중
	    }
	    rs.close();
	    pstmt.close();
	    return isAvailable;
	}
	
	public boolean createRentalRecord(int bookId, Connection conn) throws SQLException {
	    String sql = "INSERT INTO Rental (book_id, customer_id, rental_date, return_date, status) VALUES (?, ?, NOW(), DATE_ADD(NOW(), INTERVAL 9 DAY), '대여 중')";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setInt(1, bookId);
	    pstmt.setInt(2, 1); // 고객 ID는 예시로 1로 설정 (실제 고객 ID 받아와야 함)
	    int rowsAffected = pstmt.executeUpdate();

	    if (rowsAffected > 0) {
	        // 책 상태 업데이트
	        String updateBookSql = "UPDATE books SET is_rented = 1 WHERE book_id = ?";
	        pstmt = conn.prepareStatement(updateBookSql);
	        pstmt.setInt(1, bookId);
	        pstmt.executeUpdate();
	    }
	    pstmt.close();
	    return rowsAffected > 0;
	}
	
	
	
	private Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UserVo get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean insert(ManagerVo vo) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update(ManagerVo vo) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}


