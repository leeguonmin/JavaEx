package libra;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
	
	static final String dburl = "jdbc:mysql://localhost:3306/library_db";
	static final String dbuser = "library_user";
	static final String dbpass = "1234";
	
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl,
												dbuser, 
												dbpass);
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!");
		}
		return conn;
	}
	
	
	public List<UserVo> getList() {
		List<UserVo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet re = null;
		
		
		try {
			conn = getConnection();
			
//			String sql = "SELECT * FROM Customers WHERE name_id = ? AND password = ?";
//
//			pstmt = conn.prepareStatement(sql);
//	        pstmt.setString(1, name_id);
//	        pstmt.setString(2, password);
	        
//			re = pstmt.executeQuery(sql);
			
			String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name_id); // username 변수에 사용자 입력값 저장
			pstmt.setString(2, password); // password 변수에 사용자 입력값 저장
			re = pstmt.executeQuery();
			
			while (re.next()) {
				// 결과가 있으면 UserVo 객체 생성 후 반환
				UserVo user = new UserVo();
	            user.setCustomersId(re.getLong("id"));
	            user.setCustomersName(re.getString("name"));
	            list.add(user);
	        }
	
			
//			while(re.next()) {
//				Long customerId = re.getLong(1);
//				String customerName = re.getString(2);
//				String customerEmail = re.getString(3);
//				String customerPassword = re.getString(4);
				
//				UserVo vo = new UserVo(customerId, customerName, customerEmail, customerPassword,customersName_id, customersphone_number);
				
//				list.add(vo);
//		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public List<UserVo> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserVo get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean insert(UserVo vo) {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    int insertedCount = 0;

	    try {
	        conn = getConnection();

	        String sql = "INSERT INTO Customers (name, email, phone_number, birth_date, name_id, password, Customerscol) " +
	                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, vo.getCustomersName());
	        pstmt.setString(2, vo.getCustomersEmail());
	        pstmt.setString(3, vo.getCustomersphone_number());

	        insertedCount = pstmt.executeUpdate();

	        return insertedCount == 1;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        try {
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


	@Override
	public boolean update(UserVo vo) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int daletedCount = 0;
		
		try {
			conn = getConnection();
			String sql =  ""
		}

		
		
		
		
		return false;
	}

		
		
		
	}
	
	

