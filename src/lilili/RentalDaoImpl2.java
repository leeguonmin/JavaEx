package lilili;


// import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lilili.Book;

public class RentalDaoImpl2 implements RentalDao2  {
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

	@Override					// 책 검색
	public List<Book> searchBooks(String keyword) {
		List<Book> books = new ArrayList<>();
	    String sql = "SELECT id, title, author, publisher, stock FROM Books WHERE title LIKE ? OR author LIKE ? OR publisher LIKE ?";
	    try (Connection conn = getConnection2();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, "%" + keyword + "%");
	        pstmt.setString(2, "%" + keyword + "%");
	        pstmt.setString(3, "%" + keyword + "%");
	        ResultSet rs = pstmt.executeQuery();

	        // 책 정보를 올바르게 추가
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String title = rs.getString("title");
	            String author = rs.getString("author");
	            String publisher = rs.getString("publisher");
	            int stock = rs.getInt("stock");

	            books.add(new Book(id, title, author, publisher, stock));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return books;
	}
	
	

	@Override			// 대여 가능 여부 확인
	public boolean isBookAvailable(int bookId) {
		 String sql = "SELECT stock FROM Books WHERE id = ?";
	        try (Connection conn = getConnection2();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, bookId);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next() && rs.getInt("stock") > 0) {
	                return true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
/*
	@Override				// 대여 처리
	public boolean rentBook(int bookId, int customerId) {
		        String updateStockSql = "UPDATE Books SET stock = stock - 1 WHERE id = ?";
		        String insertRentalSql = "INSERT INTO Rental (book_id, customer_id, rental_date, return_date) VALUES (?, ?, NOW(), DATE_ADD(NOW(), INTERVAL 9 DAY))";
		        try (Connection conn = getConnection2();
		             PreparedStatement updateStockStmt = conn.prepareStatement(updateStockSql);
		             PreparedStatement insertRentalStmt = conn.prepareStatement(insertRentalSql)) {
		            conn.setAutoCommit(false);

		            // 재고 업데이트
		            updateStockStmt.setInt(1, bookId);
		            updateStockStmt.executeUpdate();

		            // 대여 기록 추가
		            insertRentalStmt.setInt(1, bookId);
		            insertRentalStmt.setInt(2, customerId);
		            insertRentalStmt.executeUpdate();

		            conn.commit();
		            return true;
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return false;
		    }
		    */
	
	
	
	@Override
	public boolean rentBook(int bookId) {
	    String sql = "UPDATE Books SET stock = stock - 1 WHERE id = ? AND stock > 0";
	    try (Connection conn = getConnection2();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, bookId);
	        int rowsUpdated = pstmt.executeUpdate();
	        return rowsUpdated > 0; // 업데이트된 행이 있다면 대여 성공
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public boolean rentBook(int bookId, int customerId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	@Override
	public boolean rentBookByTitle(String title) {
	    String checkStockSql = "SELECT stock FROM Books WHERE title = ? AND stock > 0";
	    String rentBookSql = "UPDATE Books SET stock = stock - 1 WHERE title = ? AND stock > 0";

	    try (Connection conn = getConnection2();
	         PreparedStatement checkStmt = conn.prepareStatement(checkStockSql);
	         PreparedStatement rentStmt = conn.prepareStatement(rentBookSql)) {

	        checkStmt.setString(1, title);
	        ResultSet rs = checkStmt.executeQuery();

	        // 재고 확인
	        if (rs.next() && rs.getInt("stock") > 0) {
	            rentStmt.setString(1, title);
	            int rowsUpdated = rentStmt.executeUpdate();
	            return rowsUpdated > 0; // 대여 성공 여부
	        } else {
	            System.out.println("재고가 부족하여 대여할 수 없습니다.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	
	
	
	
	
		}