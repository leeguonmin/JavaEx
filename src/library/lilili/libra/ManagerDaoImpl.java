package library.lilili.libra;

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
	public List<ManagerVo> search6(String manager_nameid, String manager_password) {
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









	@Override
	public List<ManagerVo> search2(String mananameid, String manapassword) {
		// TODO Auto-generated method stub
		return null;
	}
}
