package com.lec.spring.user.dao;

import java.util.List;

import com.lec.spring.user.vo.UserVO;

public interface UserDAO {

	public void insert(UserVO user);
	
	public List<UserVO> select();
	
	public UserVO selectUser(String id);
	
	public void update(UserVO user);
	
	public void delete(String id);
}
