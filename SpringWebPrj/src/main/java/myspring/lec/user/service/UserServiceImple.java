package myspring.lec.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.lec.user.dao.UserDAO;
import myspring.lec.user.vo.UserVO;

@Service("userService")
public class UserServiceImple implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void insertUser(UserVO user) {
		userDAO.insert(user);
		System.out.println(user.getUserid() + "사용자 등록 완료");
	}

	@Override
	public List<UserVO> selectUser() {
		List<UserVO> list = userDAO.select();
		return list;
	}

	@Override
	public UserVO selectUserId(String id) {
		UserVO user = userDAO.selectUser(id);
		return user;
	}

	@Override
	public void updateUser(UserVO user) {
		userDAO.update(user);
		System.out.println(user.getUserid() + "사용자 정보 수정 완료");
	}

	@Override
	public void deleteUser(String id) {
		userDAO.delete(id);
		System.out.println(id + "사용자 삭제 완료");
		
	}

}
