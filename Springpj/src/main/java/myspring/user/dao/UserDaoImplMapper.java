package myspring.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.user.vo.UserVO;

@Repository("userDao")
public class UserDaoImplMapper implements UserDao {

	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public void insert(UserVO user) {
		userMapper.insertUser(user);
		System.out.println("등록된 Record UserId = " + user.getUserId() + " Name = " +user.getName());
	}

	@Override
	public List<UserVO> readAll() {
		List<UserVO> list = userMapper.selectUserList();
		return list;
	}

	@Override
	public void update(UserVO user) {
		userMapper.updateUser(user);
		System.out.println(user.getUserId() + "사용자 정보 수정 완료");
	}

	@Override
	public void delete(String id) {
		userMapper.deleteUser(id);
		System.out.println(id + "사용자 삭제 완료");

	}

	@Override
	public UserVO read(String id) {
		UserVO user = userMapper.selectUserById(id);
		return user;
	}

}


















