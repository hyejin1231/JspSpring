package myspring.lec.springwebprj;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.lec.user.dao.UserDAO;
import myspring.lec.user.service.UserService;
import myspring.lec.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class UserTest {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	UserService userService;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void daoTest() {
		UserDAO dao = context.getBean("userDAO", UserDAO.class);
		
		List<UserVO> list = dao.select();
		
		for(UserVO user : list) {
			System.out.println(user);
		}
	}
}
























