package com.lec.spring.user.dao;

import java.util.List;

import com.lec.spring.user.vo.UserVO;

public interface UserMapper {

	void insertUser(UserVO user);
	
	List<UserVO> selectUserList();
	
	UserVO selectUserId(String id);
	
	void updateUser(UserVO user);
	
	void deleteUser(String id);
}
