package library.libra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



public class RentalDaoImpl implements RentalDao { 
	
	static final String dburl = "jdbc:mysql://localhost:3306/library_db";
	static final String dbuser = "library_user";
	static final String dbpass = "1234";
	
	
	
	
	Connection getConnection1() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl,
												dbuser, 
												dbpass);
//			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!");
		}
		return conn;
	} 
	
	
	
	
	
	
	 // 특정 책 대여 정보 검색
    public RentalVo getRentalByBookId(int bookId, Connection conn) throws SQLException {
        String sql = "SELECT * FROM Rental  WHERE book_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, bookId);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            RentalVo rental = new RentalVo(
                rs.getInt("rental_id"),
                rs.getInt("book_id"),
                rs.getInt("customer_id"),
                rs.getDate("rental_date"),
                rs.getDate("return_date"),
                rs.getDate("realretuen_date"),
                rs.getString("status")
            );
            rs.close();
            pstmt.close();
            return rental;
           
        }
		return null;
    }

    // 대여 상태 업데이트
    public boolean updateRentalStatus(int rentalId, String status, Connection conn) throws SQLException {
        String sql = "UPDATE Rental SET status = ? WHERE rental_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, status);
        pstmt.setInt(2, rentalId);
        int rowsAffected = pstmt.executeUpdate();
        pstmt.close();
        return rowsAffected > 0;
    }

    // 반납일 계산
    public Date calculateReturnDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 9); // 대여 기간 9일 추가
        return cal.getTime();
    }

    // 모든 대여 내역 조회
    public List<RentalVo> getAllRentals(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Rental";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<RentalVo> rentalList = new ArrayList<>();

        while (rs.next()) {
            RentalVo rental = new RentalVo(
                rs.getInt("rental_id"),
                rs.getInt("book_id"),
                rs.getInt("customer_id"),
                rs.getDate("rental_date"),
                rs.getDate("return_date"),
                rs.getDate("realretuen_date"),
                rs.getString("status")
            );
            rentalList.add(rental);
        }
        rs.close();
        pstmt.close();
        return rentalList;
    }
	
	
	
	
	
	
	

//	@Override				// 도서 조회
//	public List<RentalVo> getBookbyid(int bookId) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet re = null;
//		
//		try {
//			conn = getConnection();
//			String sql = "SELECT * FROM Rental WHERE book_id = ?";
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setInt(1,  bookId);
//			ResultSet rs = pstmt.executeQuery();
//			
//			if (rs.next()) {
//				RentalVo rental = new RentalVo();
//				rental.setRentalId(rs.getInt("rental_id"));
//				rental.setBookId(rs.getInt("book_id"));
//				rental.setRentalDate(rs.getDate("rental_date"));
//				rental.setReturnDate(rs.getDate("return_date"));
//				rental.setRealreturnDate(rs.getDate("realretuen_date"));
//				rental.setStatus(rs.getString("status"));
//	            return (List<RentalVo>) rental;
//				
//			}
//				
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
	
	
//	@Override				// 도서 조회
//	public List<RentalVo> getbookid(int bookId) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		
//		try {
//			conn = getConnection();
//			String sql = "SELECT * FROM Rental WHERE book_id = ?";
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setInt(1,  bookId);
//			rs = pstmt.executeQuery();
//			
//			  if (rs.next()) {
//	                RentalVo rental = new RentalVo();
//	                rental.setRentalId(rs.getInt("rental_id"));
//	                rental.setBookId(rs.getInt("book_id"));
//	                rental.setRentalDate(rs.getDate("rental_date"));
//	                rental.setReturnDate(rs.getDate("return_date"));
//	                rental.setRealreturnDate(rs.getDate("real_return_date"));
//	                rental.setStatus(rs.getString("status"));
//	                return (List<RentalVo>) rental;
//	            }
//	        }catch (SQLException e) {
//		        e.printStackTrace();
//		    }
//		    return null; // 조회된 결과가 없을 때
//		}


	
//	@Override					// 도서 조회
//	public RentalVo getBookById(int book_id) {
//		List<RentalVo> list = new ArrayList<>();
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		
//		
//		try {
//			conn = getConnection();
//			String sql = "SELECT * FROM Rental WHERE book_id = ?";
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setInt(1,  book_id);
//			rs = pstmt.executeQuery();
//			
//			  if (rs.next()) {
//	                RentalVo rental = new RentalVo();
////	                rental.setRental_id(rs.getInt("rental_id"));
//	                rental.setBook_id(rs.getInt("book_id"));
////	                rental.setRental_date(rs.getDate("customer_id"));
//	                rental.setReturn_date(rs.getDate("return_date"));
//	                rental.setRealretuen_date(rs.getDate("realretuen_date"));
//	                rental.setStatus(rs.getString("status"));
//	                return rental;
//	            }
//	        }catch (SQLException e) {
//		        e.printStackTrace();
//		    }
//		    return (RentalVo) rs; 
//		}
	
	
	

	
							// 도서 반납 
//	public boolean update(int book_id, java.sql.Date realretuen_date) {
//		 Connection conn = null;
//		    PreparedStatement pstmt = null;
//
//		    try {
//		        conn = getConnection();
//		        String sql = "UPDATE Rental SET realretuen_date = ?, status = 'RETURNED' WHERE book_id = ?";
//		        pstmt = conn.prepareStatement(sql);
//
//		        pstmt.setDate(1, realretuen_date); // 실제 반납 날짜 설정
//		        pstmt.setInt(2, book_id); // 책 ID
//
//		        int updatedRows = pstmt.executeUpdate(); // 쿼리 실행
//
//		        return updatedRows > 0; // 업데이트 성공 여부 반환
//		    } catch (SQLException e) {
//		        e.printStackTrace();
//		        return false; // 예외 발생 시 false 반환
//		    } finally {
//		        // 자원 해제
//		        try {
//		            if (pstmt != null) pstmt.close();
//		            if (conn != null) conn.close();
//		        } catch (SQLException e) {
//		            e.printStackTrace();
//		        }
//		    }
//		}
	 	       
//	 	      list.add(vo);
	 	        
//	 	       int insertedCount = pstmt.executeUpdate();
	    	 			
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	        return false; // 예외 발생 시 false 반환
//	    } finally {
//	        // 자원 해제
//	        try {
//	            if (pstmt != null) {
//	                pstmt.close();
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	        try {
//	            if (conn != null) {
//	                conn.close();
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	    
//	}

		
		
		
		
		
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
   


//	@Override
//	public List<RentalVo> getList() {		// 여기를 채워야 데이터를 가져올수있다고....합니다
//		List<RentalVo> list = new ArrayList<>();
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = getConnection();
//			
//			String sql = "SELECT rental_id, book_id, rental_date, return_date, realretuen_date, status " + "FROM Rental";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while (rs.next()) {
////				RentalVo vo = new RentalVo();
//				int rentalId = rs.getInt(1);
//				int book_id = rs.getInt(2);
//				Date rentalDate = rs.getDate(3);
//				Date returnDate = rs.getDate(4);
//				Date realreturnDate = rs.getDate(5);
//				String status = rs.getString(6);
//				
//				RentalVo vo = new RentalVo(rentalId, book_id, book_id, rentalDate,returnDate, realreturnDate, status);
//				
//				list.add(vo);
//			}
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}


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








	@Override
	public List<RentalVo> getbookid(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<RentalVo> getList() {
		// TODO Auto-generated method stub
		return null;
	}






	@Override
	public RentalVo getBookById(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}






	public boolean checkBookAvailability(int bookId, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}






	public boolean createRentalRecord(int bookId, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}









}




















