package myspring.lec.user.service;

import java.util.List;

import myspring.lec.user.vo.UserVO;

public interface UserService {

	public void insertUser(UserVO user);
	
	public List<UserVO> selectUser();
	
	public UserVO selectUserId(String id);
	
	public void updateUser(UserVO user);
	
	public void deleteUser(String id);
}
