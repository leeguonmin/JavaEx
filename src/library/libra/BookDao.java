package library.libra;

import java.util.List;

import com.javaex.jdbc.dao.AuthorVo;

public interface BookDao {
	public List<BooksVo> getList();		// 전체 책 목록
	// 모든 책 정보를 목록 형태로 가져와
	public List<BooksVo> search(String keyword);		//  책 검색 
	// 특정 키워드를 포함하는 책을 검색 
	public BooksVo get(Long id);
	// 특정 아이드를 가진 책 정보를 가져와
	public boolean insert(BooksVo vo);
	// 새로운 책 정보를 추가해 
	public boolean update(BooksVo vo);
	// 기존 책 정보를 수정 업데이트해
	public boolean delete(Long id);
	// 특정 아이디를 가진 책 정보를 삭제해~
}
