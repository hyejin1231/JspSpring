package myspring.lec.user.dao;

import java.util.List;

import myspring.lec.user.vo.UserVO;

@MyMapper
public interface User1Mapper {

	UserVO selectUserById(String id);
	List<UserVO> selectUserList();
	void insertUser(UserVO userVO);
	void updateUser(UserVO userVO);
	void deleteUser(String id);
}
