package lilili.masterbookup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManagerDaoImpl implements ManagerDao {
	static final String dburl = "jdbc:mysql://localhost:3306/library_db";
	static final String dbuser = "library_manager";
	static final String dbpass = "0000";
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbuser, dbpass);
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!" + e.getMessage());
		}
		return conn;
	}
	
	//관리자 로그인
	
	
	//전체 도서 목록
	@Override
	public List<ManagerVo> getList() {
		List<ManagerVo> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = "SELECT Books.id, Books.title, Authors.author_name,  "
					+ "	Types.type_name, Publishers.publisher_name, Books.pub_date, "
					+ "	Books.rate, Books.stock, Books.Locations_id, "
					+ " Rental.rental_date, Rental.return_expect, Customers.name, Customers.name_id "
					+ "FROM Books "
					+ "JOIN Types ON Books.type_id = Types.type_id  "
					+ "JOIN Authors ON Books.author_id = Authors.author_id "
					+ "JOIN Publishers ON Books.publisher_id = Publishers.publisher_id "
					+ "LEFT JOIN Rental ON Books.id = Rental.book_id "
					+ "LEFT JOIN Customers ON Rental.customer_id = Customers.id "
					+ "ORDER BY Books.id;";
			rs = stmt.executeQuery(sql);
			
			//	각 레코드를 List<UserVo>로 변환
			while (rs.next()) {
	            int bookId = rs.getInt("id");
	            String title = rs.getString("title");
	            String authorName = rs.getString("author_name");
	            String typeName = rs.getString("type_name");
	            String publisherName = rs.getString("publisher_name");
	            String pubDate = rs.getString("pub_date");
	            int rate = rs.getInt("rate");
	            int stock = rs.getInt("stock");
	            int locationsId = rs.getInt("Locations_id");
	            String rentalDate = rs.getString("rental_date");
	            if (rentalDate == null) rentalDate = "null";
	            String returnExpect = rs.getString("return_expect");
	            if (returnExpect == null) returnExpect = "null";
	            String name = rs.getString("name");
	            if (name == null) name = "null";
	            String nameId = rs.getString("name_id");
	            if (nameId == null) nameId = "null";

				
	            ManagerVo vo = new ManagerVo(bookId, title, authorName, typeName, publisherName, pubDate, rate, stock, locationsId, rentalDate, returnExpect, name, nameId);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	 //신규 도서 추가
		@Override
		public boolean insert(ManagerVo book) {
			Connection conn = null;
	        PreparedStatement pstmt = null;

	        try {
	            conn = getConnection();
	            conn.setAutoCommit(false); // 트랜잭션 시작

	            // 작가 ID 가져오기 또는 신규 작가 추가
	            int authorId = getOrInsertAuthor(conn, book.getAuthorName(), book.getAuthorEmail());

	            // 출판사 ID 가져오기 또는 신규 출판사 추가
	            int publisherId = getOrInsertPublisher(conn, book.getPublisherName(), book.getPublisherEmail());

	            // 도서 정보 저장
	            String insertBookQuery = "INSERT INTO Books (title, pub_date, rate, stock, Locations_id, type_id, publisher_id, author_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	            pstmt = conn.prepareStatement(insertBookQuery);
	            pstmt.setString(1, book.getTitle());
	            pstmt.setString(2, book.getPubDate());
	            pstmt.setInt(3, book.getRate());
	            pstmt.setInt(4, 1); // 기본 재고는 1
	            pstmt.setInt(5, book.getLocationsId());
	            pstmt.setInt(6, book.getTypeId());
	            pstmt.setInt(7, publisherId);
	            pstmt.setInt(8, authorId);

	            int rowsInserted = pstmt.executeUpdate();
	            conn.commit(); // 트랜잭션 커밋
	            return rowsInserted > 0;

	        } catch (SQLException e) {
	            try {
	                if (conn != null) conn.rollback(); // 롤백
	            } catch (SQLException rollbackEx) {
	                rollbackEx.printStackTrace();
	            }
	            e.printStackTrace();
	            return false;

	        } finally {
	            try {
	                if (pstmt != null) pstmt.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    private int getOrInsertAuthor(Connection conn, String authorName, String authorEmail) throws SQLException {
	        String selectQuery = "SELECT author_id FROM Authors WHERE author_email = ?";
	        try (PreparedStatement pstmt = conn.prepareStatement(selectQuery)) {
	            pstmt.setString(1, authorEmail);
	            try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    return rs.getInt("author_id");
	                }
	            }
	        }

	        // 신규 작가 추가
	        String insertQuery = "INSERT INTO Authors (author_name, author_email) VALUES (?, ?)";
	        try (PreparedStatement pstmt = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
	            pstmt.setString(1, authorName);
	            pstmt.setString(2, authorEmail);
	            pstmt.executeUpdate();
	            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    return generatedKeys.getInt(1);
	                }
	            }
	        }
	        throw new SQLException("Failed to insert new author.");
	    }

	    private int getOrInsertPublisher(Connection conn, String publisherName, String publisherEmail) throws SQLException {
	        String selectQuery = "SELECT publisher_id FROM Publishers WHERE publisher_email = ?";
	        try (PreparedStatement pstmt = conn.prepareStatement(selectQuery)) {
	            pstmt.setString(1, publisherEmail);
	            try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    return rs.getInt("publisher_id");
	                }
	            }
	        }

	        // 신규 출판사 추가
	        String insertQuery = "INSERT INTO Publishers (publisher_name, publisher_email, publisher_number) VALUES (?, ?, ?)";
	        try (PreparedStatement pstmt = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
	            pstmt.setString(1, publisherName);
	            pstmt.setString(2, publisherEmail);
	            pstmt.executeUpdate();
	            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    return generatedKeys.getInt(1);
	                }
	            }
	        }
	        throw new SQLException("Failed to insert new publisher.");
	    }

	
	//도서 삭제
	public boolean deleteBook(ManagerVo vo) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    boolean success = false;

	    try {
	        //Books 테이블 삭제 (나머지 테이블 자동 삭제)
	    	conn = getConnection();
	        String Sql = "DELETE FROM Books WHERE id = ?";
	        pstmt = conn.prepareStatement(Sql);
	        pstmt.setInt(1, vo.getBookId());
	        pstmt.executeUpdate();

	        success = true;

	    } catch (SQLException e) {
	        try {
	            if (conn != null) {
	                conn.rollback();
	            }
	        } catch (SQLException rollbackEx) {
	            rollbackEx.printStackTrace();
	        }
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return success;
	}
	
//	//회원정보 수정 - 삭제해도 됨!
//	public boolean UpdateCustomer(ManagerVo vo) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		boolean success = false;
//		
//		try {
//			conn = getConnection();
//			//회원 정보 출력
//			String customerSQL = "SELECT * FROM CUSTOMERS WHERE id = ?;";
//			//회원 정보 변경
//			String updateName = "UPDATE CUSTOMERS SET name = '?' WHERE id = ?;";
//			pstmt = conn.prepareStatement(updateName);
//	        pstmt.setString(1, vo.getName());
//	        pstmt.setInt(2, vo.getId());
//	        
//			String updateEmail = "UPDATE CUSTOMERS SET email = '?' WHERE id = ?;";
//			String updatePhoneNum = "UPDATE CUSTOMERS SET phone_number = '?' WHERE id = ?;";
//			String updateBirth = "UPDATE CUSTOMERS SET birth_date = '?' WHERE id = ?;";
//			String updateNameId = "UPDATE CUSTOMERS SET name_id = '?' WHERE id = ?;";
//			String updatePassword = "UPDATE CUSTOMERS SET password = '?' WHERE id = ?;";
//			
//		} catch() {
//			
//		}
//		
//		
//	}
	
	//전체 회원 목록
	@Override
	public List<ManagerVo> getCustomerList() {
		List<ManagerVo> list = new ArrayList<>();
		
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			
			String sql = "select * from customers";
			ResultSet rs = stmt.executeQuery(sql);
			
			//	각 레코드를 List<UserVo>로 변환
			while (rs.next()) {
				int customerId = rs.getInt("id");
				String customerName = rs.getString("name");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phone_number");
				String birthDate = rs.getString("birth_date");
				String customerNameId = rs.getString("name_id");
				String customerPassword = rs.getString("password");

				
	            ManagerVo vo = new ManagerVo(customerId, customerName, email, phoneNumber, birthDate, customerNameId, customerPassword);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//회원 삭제
	public boolean deleteCustomer(ManagerVo vo) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    boolean success = false;

	    try {
	        //회원정보 삭제
	    	conn = getConnection();
	        String Sql = "DELETE FROM Customers WHERE id = ?";
	        pstmt = conn.prepareStatement(Sql);
	        pstmt.setInt(1, vo.getBookId());
	        pstmt.executeUpdate();

	        success = true;

	    } catch (SQLException e) {
	        try {
	            if (conn != null) {
	                conn.rollback();
	            }
	        } catch (SQLException rollbackEx) {
	            rollbackEx.printStackTrace();
	        }
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return success;
	}
	
	//도서 존재 유무 확인
	public boolean isBookExists(int id) {
		
	    String sql = "SELECT COUNT(*) FROM books WHERE id = ?";
	    
	    try (
	    	 Connection conn = getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setInt(1, id); // 도서 ID를 쿼리에 설정
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            return rs.getInt(1) > 0; // 도서가 존재하면 true 반환
	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
	    }
	    return false; // 도서가 존재하지 않으면 false 반환
	}
	    
	    
	//회원 존재 유무 확인    
	public boolean isCustomerExists(int id) {
		
		String sql = "SELECT COUNT(*) FROM customers WHERE id = ?";
		
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				
				if (rs.next()) {
					return rs.getInt(1) > 0;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}
		
	
	

	
}
