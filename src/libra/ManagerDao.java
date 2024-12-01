package libra;

import java.util.List;

public interface ManagerDao {
	
//	public List<ManagerVo> getList();	// 전체 책 목록
//	public List<ManagerVo> search(String keyword);	// 검색
	public List<ManagerVo> search2(String mananameid, String manapassword);	// 검색
//	public UserVo get(Long id);
//	public boolean insert(ManagerVo vo);
//	public boolean update(ManagerVo vo);
//	public boolean delete(Long id);
//	public ManagerVo getUserByIdAndPassword(String customersId, String customersPassword);

	public List<ManagerVo> search6(String manager_nameid, String manager_password);
	

}
