package lilili;

// import java.awt.print.Book;
import lilili.Book;
import java.util.List;

public interface RentalDao2 {
	 // 책 검색
    List<Book> searchBooks(String keyword);

    // 책 대여 가능 여부 확인
    boolean isBookAvailable(int bookId);

    // 대여 처리
    boolean rentBook(int bookId, int customerId);

	boolean rentBook(int bookId);

	boolean rentBookByTitle(String title);
}