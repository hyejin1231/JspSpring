package com.lec.spring.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lec.spring.user.vo.UserVO;

@Repository("userDAO")
public class UserDAOJDBC implements UserDAO {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void insert(UserVO user) {
		userMapper.insertUser(user);
	}

	@Override
	public List<UserVO> select() {
		List<UserVO> list = userMapper.selectUserList();
		return list;
	}

	@Override
	public UserVO selectUser(String id) {
		UserVO user = userMapper.selectUserId(id);
		return user;
	}

	@Override
	public void update(UserVO user) {
		userMapper.updateUser(user);
	}

	@Override
	public void delete(String id) {
		userMapper.deleteUser(id);
	}

}
