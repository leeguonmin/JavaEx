package lilili;

// import java.awt.print.Book;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import libra.RentalDao;
import libra.RentalDaoImpl;
import lilili.Book;

public class RentalDaoApp2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
//		bookrental(scanner);
		bookrrturn(scanner);

		
		
		scanner.close();
	}
		
		
	public static void bookrrturn(Scanner scanner) {
		 RentalDaoImpl2 dao = new RentalDaoImpl2();

	        // 1. 반납할 책 ID 입력
	        System.out.println("반납할 책의 ID를 입력하세요:");
	        int bookId = scanner.nextInt();

	        // 2. 책 및 대여 정보 조회
	        Book book = dao.getBookById(bookId);
	        Rental rental = dao.getRentalByBookId(bookId);

	        if (book == null || rental == null) {
	            System.out.println("해당 책에 대한 대여 정보가 없습니다.");
	            return;
	        }
	        
	        // 3. 책 정보 출력
	        System.out.printf(
	        	    "책 정보:\nID: %d\t제목: %s\t출판사: %s\t작가: %s\n",
	        	    book.getId(), book.getTitle(), book.getPublisher(), book.getAuthor());

	        // 4. 반납 여부 확인 
	        System.out.println("반납 진행 하시겠습니까? (y/n)");
	        String response = scanner.next();
	        
	        if (!response.equals("y")) {
	        	System.out.println("반납을 취소합니다");
	        	return;
	        }
	        
	        // response.equals("y") 면 5번으로 넘어가서 반납 진행
	        // 5. 반납 예정일 확인
	        Date returnDate = rental.getReturn_date();
	        int overdueDays = dao.OverDays(returnDate);
	        // rental.getReturn_date() : 반납 예정일 가져오는
	        // OverDays : 데이터베이스에 저장된 실제 반납일과 입력된 
	        // 반납 예정일을 비교해서 연체된 일수를 계산하는 메서드(DaoImpl)
	        
	        

	        // 6. 연체 여부 확인
	        if (overdueDays > 0) {
	            int lateFee = overdueDays * 1000; // 연체료 계산
	            System.out.println("반납 예정일을 초과하였습니다. 연체료는 " + lateFee + "원 입니다.");
	        } else {
	            System.out.println("반납이 정상적으로 완료되었습니다.");
	        }

	        // 7. 반납 처리
	        if (dao.returnBook(bookId)) {
	            System.out.println("반납 처리가 완료되었습니다.");
	        } else {
	            System.out.println("반납 처리 중 오류가 발생했습니다.");
	        }
	        
	        
//	        // 8. stock 업데이트
//	        if (dao.returnBook(bookId)) {
//	            System.out.println("반납 처리가 완료되었습니다.");
//
//	            // stock 업데이트
//	            if (dao.updateStock(bookId)) {
//	                System.out.println("책의 재고가 정상적으로 업데이트되었습니다.");
//	            } else {
//	                System.out.println("재고 업데이트 중 오류가 발생했습니다.");
//	            }
//	        } else {
//	            System.out.println("반납 처리 중 오류가 발생했습니다.");
//	        }

	    }

	
	
	
	
	
	
		
	public static void bookrental(Scanner scanner) { 	
		RentalDao2 dao = new RentalDaoImpl2();
        Scanner sc = new Scanner(System.in);

        // 1. 검색
        System.out.println("검색할 키워드를 입력하세요 (책 제목, 작가, 출판사):");
        String keyword = sc.nextLine();
        List<Book> books = dao.searchBooks(keyword);

        if (books.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
            return;
        }

        // 2. 결과 출력
        System.out.println("검색 결과:");
        for (Book book : books) {
            System.out.printf("제목: %s, 작가: %s, 출판사: %s, 재고: %d\n",
                              book.getTitle(), book.getAuthor(), 
                              book.getPublisher(), book.getStock());
        }

        // 3. 대여 진행
        System.out.println("대여할 책의 제목을 입력하세요:");
        String title = sc.nextLine();

        // 4. 대여 여부 확인 및 진행
        boolean isRented = dao.rentBookByTitle(title);

        if (isRented) {
            // 현재 날짜 받아오기
            Date today = new Date();
            // Calendar 객체를 사용해 9일을 더한 날짜 계산
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(today);
            calendar.add(Calendar.DATE, 9);
            Date returnDate = calendar.getTime();

            // 날짜 형식 지정하여 출력
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM월 dd일");
            String formattedDate = dateFormat.format(returnDate);

            System.out.println("대여 완료! 반납 날짜는 " + formattedDate + "입니다.");
        } else {
            System.out.println("대여를 완료하지 못했습니다. 재고를 확인하거나 다시 시도하세요.");
        }

        sc.close();
    }
}

