package myspring.lec.user.dao;

import java.util.List;

import myspring.lec.user.vo.UserVO;

public interface UserDAO {

	public void insert(UserVO user);
	
	public List<UserVO> select();
	
	public UserVO selectUser(String id);
	
	public void update(UserVO user);
	
	public void delete(String id);
}
