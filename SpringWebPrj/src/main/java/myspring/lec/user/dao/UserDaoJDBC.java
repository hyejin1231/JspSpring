package myspring.lec.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.lec.user.vo.UserVO;

@Repository("userDAO")
public class UserDaoJDBC implements UserDAO {

	@Autowired
	private User1Mapper userMapper;
	
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
		UserVO user = userMapper.selectUserById(id);
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
