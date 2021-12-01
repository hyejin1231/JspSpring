package com.lec.spring.user.service;

import java.util.List;

import com.lec.spring.user.vo.UserVO;

public interface UserService {
	
	public void insertUser(UserVO user);
	
	public List<UserVO> selectUserList();
	
	public UserVO selectUserID(String id);
	
	public void updateUser(UserVO user);
	
	public void deleteUser(String id);
	
}
