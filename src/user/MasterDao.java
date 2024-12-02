package user;

import java.util.List;

public interface MasterDao {

	List<ManagerVo> searchmaster(String name_id, String password);

}
