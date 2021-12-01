package myspring.user.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import myspring.user.dao.UserDao;
import myspring.user.dao.UserDaoImple;
import myspring.user.service.UserService;
import myspring.user.vo.UserVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")
public class UserClient {

	@Autowired
	ApplicationContext context;
	
	@Autowired
	UserService service;
	
	@Test @Ignore
	public void daoTest() {
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		//dao.insert(new UserVO("user4", "유저4", "여2", "경기2"));
		
		//dao.update(new UserVO("user4", "유저4", "여", "경기"));
		
		//dao.delete("user4");
		
//		UserVO vo = 	dao.read("user4");
//		System.out.println(vo);
		
		List<UserVO> list = dao.readAll();
		
		for (UserVO userVO : list) {
			System.out.println(userVO);
		}
	}
	
	
	
	@Test @Ignore
	public void configTest() {
		SqlSession session	= context.getBean("sqlSession", SqlSession.class);
		
		System.out.println(session.getClass().getName());
		
//		 UserVO vo = session.selectOne("userNS.selectUserById", "hyejin");
//		 System.out.println(vo);
	}
	
	
	@Test @Ignore
	public void updateUserTest1() {
		service.updateUser(new UserVO("dooly", "김둘리", "남", "광주"));
		
		UserVO user = service.getUser("dooly");
		System.out.println(user);
	}
	
	
	@Test 
	public void getUserTest1() {
		UserVO user = service.getUser("hyejin");
		System.out.println(user);
		assertEquals("혜진2", user.getName());
	}
	
	
	@Test @Ignore
	public void dataSourceTest() {
		DataSource ds = (DataSource) context.getBean("dataSource");
		try {
			System.out.println(ds.getConnection());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test @Ignore
	public void insertUserTest() {
		service.insertUser(new UserVO("dooly2", "둘리2", "남2", "경기2"));
		
		for(UserVO user : service.getUserList()) {
			System.out.println(user);
		}
	}
	
	@Test @Ignore
	public void getUserTest() {
		UserVO user = service.getUser("user4");
		System.out.println(user);
		assertEquals("user4", user.getName());
	}
	
	@Test @Ignore
	public void updateUserTest() {
		service.updateUser(new UserVO("dooly", "김둘리", "여", "부산"));
		
		UserVO user = service.getUser("dooly");
		System.out.println(user);
	}
	
	@Test @Ignore
	public void deleteUserTest() {
		service.deleteUser("dooly2");
		
		for(UserVO user : service.getUserList()) {
			System.out.println(user);
		}
	}


}





















