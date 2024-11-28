package lilili;

// import java.awt.print.Book;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import libra.RentalDao;
import libra.RentalDaoImpl;
import lilili.Book;

public class RentalDaoApp2 {

	public static void main(String[] args) {
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

		
		/*
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
	            System.out.printf("ID: %d, 제목: %s, 작가: %s, 출판사: %s, 재고: %d\n",
	                              book.getId(), book.getTitle(), book.getAuthor(), 
	                              book.getPublisher(), book.getStock());
	        }

	        // 3. 대여할 책 ID 입력
	        System.out.println("대여할 책 ID를 입력하세요:");
	        int bookId = sc.nextInt();

	        // 4. 책 재고 확인 (stock == 1이면 대여 가능)
	        Book selectedBook = books.stream()
	                                 .filter(book -> book.getId() == bookId)
	                                 .findFirst()
	                                 .orElse(null);

	        if (selectedBook == null) {
	            System.out.println("해당 ID의 책이 없습니다.");
	        } else if (selectedBook.getStock() > 0) {
	            System.out.println("대여하시겠습니까? (y/n):");
	            String answer = sc.next();
	            if (answer.equalsIgnoreCase("y")) {

	                // 5. 대여 진행
	                if (dao.rentBook(bookId)) {
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
	                    System.out.println("대여 처리 중 오류가 발생했습니다.");
	                }
	            } else {
	                System.out.println("대여를 취소했습니다.");
	            }
	        } else {
	            System.out.println("해당 책은 재고가 없어 대여할 수 없습니다.");
	        }

	        sc.close();
	    }
	}
		*/