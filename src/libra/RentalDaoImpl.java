package libra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class RentalDaoImpl implements RentalDao {
	
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
			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!");
		}
		return conn;
	}
	
	
	
	
	@Override				// 도서 조회
	public List<RentalVo> getbookid(int bookId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet re = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM Rental WHERE book_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,  bookId);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				RentalVo rental = new RentalVo();
				rental.setRentalId(rs.getInt("rental_id"));
				rental.setBookId(rs.getInt("book_id"));
				rental.setRentalDate(rs.getDate("rental_date"));
				rental.setReturnDate(rs.getDate("return_date"));
				rental.setRealreturnDate(rs.getDate("realretuen_date"));
				rental.setStatus(rs.getString("status"));
	            return (List<RentalVo>) rental;
				
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	



	
							// 도서 반납 
	public boolean update(int bookId, Date realReturnDate) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet re = null;
		
	    try {
	    	 	conn = getConnection();
	    	 	String sql = "UPDATE Rental SET realreturn_date = ? WHERE book_id = ?";
	    	 	pstmt = conn.prepareStatement(sql);
	    	 	
	    	 	pstmt.setDate(1, (java.sql.Date) realReturnDate);
	 	        pstmt.setInt(2, bookId);
	 	        
	 	       RentalVo vo = new RentalVo(bookId, realReturnDate);
	 	       
	 	      int updatedRows = pstmt.executeUpdate();

	 	        if (updatedRows > 0) {
	 	            return true; // 업데이트 성공
	 	        } else {
	 	            return false; // 업데이트 실패
	 	        }
	 	       
//	 	      list.add(vo);
	 	        
//	 	       int insertedCount = pstmt.executeUpdate();
	    	 			
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false; // 예외 발생 시 false 반환
	    } finally {
	        // 자원 해제
	        try {
	            if (pstmt != null) {
	                pstmt.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

		
		
		
		
		
//		try {
//			conn = DriverManager.getConnection(dburl, dbuser, dbpass);
//            pstmt = conn.prepareStatement("UPDATE Rental SET realreturn_date = ? WHERE rental_id = ?");
//            pstmt.setDate(1, (java.sql.Date) realReturnDate);
//            pstmt.setInt(2, rentalId);
//
//            updatedRows = pstmt.executeUpdate();
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            // 자원 해제
//            try {
//                if (pstmt != null) pstmt.close();
//                if (conn != null) conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return updatedRows > 0;
   


	@Override
	public List<RentalVo> getList() {		// 여기를 채워야 데이터를 가져올수있다고....합니다
		List<RentalVo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "SELECT rental_id, book_id, rental_date, return_date, realretuen_date, status " + "FROM Rental";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
//				RentalVo vo = new RentalVo();
				int rentalId = rs.getInt(1);
				int book_id = rs.getInt(2);
				Date rentalDate = rs.getDate(3);
				Date returnDate = rs.getDate(4);
				Date realreturnDate = rs.getDate(5);
				String status = rs.getString(6);
				
				RentalVo vo = new RentalVo(rentalId, book_id, book_id, rentalDate,returnDate, realreturnDate, status);
				
				list.add(vo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public List<RentalVo> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public RentalVo get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean insert(RentalVo vo) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean update(RentalVo vo) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public RentalVo findByBookId(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}










}




















