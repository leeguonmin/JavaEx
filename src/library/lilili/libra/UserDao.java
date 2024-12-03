package library.lilili.libra;

import java.util.List;

public interface UserDao {

	public List<UserVo> getList();	// 전체 책 목록
	public List<UserVo> search(String keyword);	// 검색
	public UserVo get(Long id);
	public boolean insert(UserVo vo);
	public boolean update(UserVo vo);
	public boolean delete(Long id);
	public UserVo getUserByIdAndPassword(String customersId, String customersPassword);
	
}
