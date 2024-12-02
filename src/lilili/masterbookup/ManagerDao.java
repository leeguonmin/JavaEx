package lilili.masterbookup;

import java.util.List;

public interface ManagerDao {
	
	public List<ManagerVo> getList();				//책 목록
	public boolean insert(ManagerVo vo);			//책 추가
	public boolean deleteBook(ManagerVo vo);		//책 삭제
	public List<ManagerVo> getCustomerList();		//회원 목록
//	public boolean updateCustomer(ManagerVo vo);	//회원 수정 (그냥 넣어본거. 삭제해도 됨)
	public boolean deleteCustomer(ManagerVo vo);	//회원 삭제
	
}
