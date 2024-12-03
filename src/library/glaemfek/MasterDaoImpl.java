package library.glaemfek;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MasterDaoImpl implements MasterDao {
	
	static final String dburl = "jdbc:mysql://localhost:3306/library_db";
	static final String dbuser = "library_manager";
	static final String dbpass = "0000";

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbuser, dbpass);
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!");
		}
		return conn;
	}
	
	
	
	@Override
	public List<ManagerVo> searchmaster(String name_id, String password) {
	    List<ManagerVo> list = new ArrayList<>();

	    try (Connection conn = getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(
	             "SELECT name_id, password FROM customers WHERE name_id = 'master' AND password = ?"
	         )) {

	        // 비밀번호만 매개변수로 설정
	        pstmt.setString(1, password);

	        try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                ManagerVo vo = new ManagerVo(rs.getString("name_id"), rs.getString("password"));
	                list.add(vo);
	                break; // 첫 번째 결과만 가져옴
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list; // 빈 리스트 반환 가능성 있음
	}


	
	
	

}
