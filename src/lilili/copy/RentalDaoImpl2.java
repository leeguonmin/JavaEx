package lilili.copy;


// import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentalDaoImpl2 implements RentalDao2  {
	static final String dburl = "jdbc:mysql://localhost:3306/library_db";
	static final String dbuser = "library_user";
	static final String dbpass = "1234";
	
	private Connection getConnection2() throws SQLException {
		Connection conn = null;
		try {
			

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl,dbuser, dbpass);
//			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!");
		}
		return conn;
	}

	
	// 책 ID로 책 정보를 가져오기
    @Override
    public Book getBookById(int bookId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 변수 선언, null 초기화로 명확성을 향상 시킴 // 끝나면 반드시 닫아줘야함
        // 코드 가독성을 위해 기재

        try {
            conn = getConnection2();		// 데이터베이스 연결, 메서드 호출
            String sql = "SELECT b.id, b.title, a.author_name, p.publisher_name, b.stock " +
                         "FROM Books b " +
                         "JOIN Authors a ON b.author_id = a.author_id " +
                         "JOIN Types t ON b.type_id = t.type_id " +
                         "JOIN Publishers p ON b.publisher_id = p.publisher_id " +
                         "WHERE b.id = ?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bookId);
            rs = pstmt.executeQuery();
            
            // prepareStatement : SQL 문장의 템플릿과 같은 역할임
            // pstmt.setInt(1, bookId) : ? 위치에 bookId 을 넣겠다고
            // pstmt.executeQuery() : 메서드를 호출~ SQL 문을 실행하고 결과 집합을 ResultSet 객체(rs)에 담아
            
            // sql 실행, 결과 처리 // 담은거 굴려
            if (rs.next()) {							// rs.next() 가 true 를 반환하면(결과가 있으면)
                return new Book(						// Book 객체를 생성하여 도서 정보를 담아 반환
                    rs.getInt("id"),					// Book 객체의 생성ㅈ자는 id, title, author_name, 
                    rs.getString("title"),				// publisher_name, stock 값을 매개변수로 받음
                    rs.getString("author_name"), 
                    rs.getString("publisher_name"), 
                    rs.getInt("stock")
                );
            }
        } catch (SQLException e) {				// 예외 처리 : 데이터베이스 연결이나 SQL 실행 도중 예외가 발생할 경우
            e.printStackTrace();				// catch 블럭에서 e.printStackTrace() 예외 내용을 출력
        } finally {								// 변수 선언한거 닫아주라 했지. 닫아줘
            try {
                if (rs != null) rs.close();				// null 값이 아니면 닫아
                if (pstmt != null) pstmt.close();		// 닫고 
                if (conn != null) conn.close();			// 닫아 자원 해제 끝
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
	



 // 책 ID로 대여 정보 가져오기
    @Override
    public Rental getRentalByBookId(int bookId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 변수 선언, 나중에 꼭 닫아 주셔

        try {
            conn = getConnection2();
            String sql = "SELECT * FROM Rental WHERE book_id = ? AND real_return IS NULL";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bookId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Rental(
                    rs.getInt("rental_id"),
                    rs.getInt("book_id"),
                    rs.getInt("customer_id"),
                    rs.getDate("rental_date"),
                    rs.getDate("return_expect"),
                    rs.getDate("real_return")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    
    
// stock 업데이트
//    @Override   			
//    public boolean updateStock(int bookId) {
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//
//        try {
//            conn = getConnection2();
//            String sql = "UPDATE Books SET stock = stock + 1 WHERE id = ?";
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setInt(1, bookId);
//
//            int rowsUpdated = pstmt.executeUpdate(); // 업데이트된 행 수 확인
//            return rowsUpdated > 0; // 1 이상의 값이면 성공
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        } finally {
//            try {
//                if (pstmt != null) pstmt.close();
//                if (conn != null) conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    
    
    

    // 책 반납 처리 (real_return 을 오늘 날짜로 업데이트)
    @Override
    public boolean returnBook(int bookId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection2();
            String sql = "UPDATE Rental SET real_return = NOW() WHERE book_id = ? AND real_return IS NULL";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bookId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    
    // 연체일 계산
    public int OverDays(Date returnDate) {
        long diff = new Date().getTime() - returnDate.getTime(); // 밀리초 차이
        return (int) (diff / (1000 * 60 * 60 * 24)); // 일 단위로 변환
        
        // new Date().getTime : 현재 시스템 시간을 밀리초 단위로 반환
        // returnDate.getTime() : 데이터베이스에 저장된 return 날자의 시간을 밀리초 단위로 변환
        // diff : 두 시간의 값의 차이를 밀리초 단위로 저장 = 두 날짜 사이에 얼마나 많은 시간이 흘렀는지 밀리초 단위로 표현
        
        // (diff / (1000 * 60 * 60 * 24) :
        // 밀리초 단위의 차이를 일 단위로 변환하기 위해 1000(밀리초/초), 
        // 60(초/분), 60(분/시), 24(시/일)로 나누어줍니다.
        // int : 결과를 정수형으로 변환하여 소수점 이하를 나가리
        // (1000 * 60 * 60 * 24 : 하루 86,400,000초
        // 1000 밀리초 > 1초
        
        // 긍까 실제 반납일이랑 반납예정일이랑 전부 초단위로 바꿔서 빼준 값을 나누고 int 정수로 받아서 연체된 날짜를 계산
    }
    

	
	
	
	/*
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet re = null;
	
	
	try {
		conn = getConnection();
		
//		String sql = "SELECT * FROM Customers WHERE name_id = ? AND password = ?";
//
//		pstmt = conn.prepareStatement(sql);
//        pstmt.setString(1, name_id);
//        pstmt.setString(2, password);
        
//		re = pstmt.executeQuery(sql);
		
		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name_id); // username 변수에 사용자 입력값 저장
		pstmt.setString(2, password); // password 변수에 사용자 입력값 저장
		re = pstmt.executeQuery();
	
	*/
	
	
	
	
	@Override					// 책 검색
	public List<Book> searchBooks2(String keyword) {
		List<Book> books = new ArrayList<>();
	    String sql = "SELECT b.id, b.title, b.publisher, a.author_name "
	            + "FROM Books b "
	            + "JOIN Authors a ON b.author_id = a.author_id "
	            + "WHERE b.title LIKE ? OR b.publisher LIKE ? OR a.author_name LIKE ?";
	    
	    
	    
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
//	            String author = rs.getString("author");
	            String publisher = rs.getString("publisher");
	            String author = rs.getString("author_name");

//	            books.add(new Book(id, title, publisher, author));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return books;
	}
	
	
	@Override					// 책 검색   // bookrental
	public List<Book> searchBooks(String keyword) {
		List<Book> books = new ArrayList<>();
		String sql = "SELECT id, title FROM Books WHERE title LIKE ? OR author_id LIKE ?";
	    try (Connection conn = getConnection2();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, "%" + keyword + "%");
	        pstmt.setString(2, "%" + keyword + "%");
	        ResultSet rs = pstmt.executeQuery();

	        // 책 정보를 올바르게 추가
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String title = rs.getString("title");
//	            String author = rs.getString("author");
	            String publisher = rs.getString("publisher");
	            int stock = rs.getInt("stock");

//	            books.add(new Book(id, title, publisher, stock));
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
	
	
	@Override				// 업데이트
	public boolean returnBook2(int bookId) {
	   
		String sql = "UPDATE Books SET stock = stock + 1 WHERE id = ? AND stock == 0";
	    try (
	    		
	    	Connection conn = getConnection2();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, bookId);
	        int rowsUpdated = pstmt.executeUpdate();
	        return rowsUpdated > 0; // 업데이트된 행이 있다면 대여 성공
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	
	
	@Override				// 업데이트
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


	@Override
	public boolean updateStock(int bookId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
	
		}