package user;

import java.util.Date;
import java.util.List;

import libra.UserVo;

public interface UserDao {
	
	// 도서조회
	public List<UserVo> getList();									// 전체 책 목록
	public List<UserVo> search(String name_id, String password);	// 회원 검색
	public List<UserVo> search2(String author_name);				// 작가 검색
	public List<UserVo> search3(String title);						// 제목 검색
	public List<UserVo> search4(String publisher);					// 출판사 검색
	public List<UserVo> search5(String type);						// 장르 검색
	
	
	// 회원가입
	public boolean insert(UserVo vo);
	
	
	// 도서 대여
	public boolean insertRental(UserVo vo);
	public List<UserVo> searchRentalBook(int book_id);
	
	public boolean stockUpdate(UserVo vo);							// stock 0으로 전환
	
	
	// 도서 반납
	public List<UserVo> searchReturnBook(int book_id);
	public boolean Deadline(Date date);
	public boolean stockUpdate2(UserVo vo);							// stock 1로 전환
	
	
	
	// 매니저권한 : 도서등록
	
	
	
	public List<UserVo> getListC();
	

}
