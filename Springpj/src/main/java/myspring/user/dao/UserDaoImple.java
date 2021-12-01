package myspring.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.user.vo.UserVO;

//@Repository("userDao")
public class UserDaoImple implements UserDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(UserVO user) {
		session.update("userNS.insertUser",user);
		
		System.out.println("등록된 Record userid = " + user.getUserId() + " name = " + user.getName());
	}

	@Override
	public List<UserVO> readAll() {
		List<UserVO> list = session.selectList("userNS.selectUserList");
		return list;
	}

	@Override
	public void update(UserVO user) {
		session.update("userNS.updateUser", user);
		System.out.println(user.getUserId() + "사용자 정보 수정 완료");
	}

	@Override
	public void delete(String id) {
		session.update("userNS.deleteUser", id);
		System.out.println(id + "사용자 삭제 완료");
	}

	@Override
	public UserVO read(String id) {
		UserVO user = session.selectOne("userNS.selectUserById", id);
		return user;
	}

}













