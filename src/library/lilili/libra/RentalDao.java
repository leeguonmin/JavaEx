package library.lilili.libra;

// import java.awt.print.Book;
import lilili.Book;
import java.util.Date;
import java.util.List;

public interface RentalDao {
	public List<RentalVo> getList();		// 전체 책 목록
	// 모든 책 정보를 목록 형태로 가져와
	public List<RentalVo> search(String keyword);		//  책 검색 
	// 특정 키워드를 포함하는 책을 검색 
	public RentalVo get(Long id);
	// 특정 아이드를 가진 책 정보를 가져와
	
	
	public RentalVo getBookById(int bookId);
	

	
	public boolean insert(RentalVo vo);
	// 새로운 책 정보를 추가해 
	
	public List<RentalVo> getbookid(int bookId);	// 북아이디 검색
	public boolean update(RentalVo vo);
	// 기존 책 정보를 수정 업데이트해
	public boolean delete(Long id);
	// 특정 아이디를 가진 책 정보를 삭제해~
	public RentalVo findByBookId(int bookId);
	public static boolean update(int bookId, Date date) {
		// TODO Auto-generated method stub
		return false;
	}
	public List<Book> searchBooks(String keyword);
	

}
