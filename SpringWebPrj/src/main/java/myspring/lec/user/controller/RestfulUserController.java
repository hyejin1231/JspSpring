package myspring.lec.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import myspring.lec.user.service.UserService;
import myspring.lec.user.vo.UserVO;
import myspring.lec.user.vo.UserVOXML;

@Controller
public class RestfulUserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public Map getUserList() {
		List<UserVO> userList = userService.selectUser();
		Map result = new HashMap();
		result.put("result", Boolean.TRUE);
		result.put("data", userList);
		return result;
	}
	
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map getUser(@PathVariable String id) {
		UserVO user = userService.selectUserId(id);
		Map result = new HashMap();
		result.put("result", Boolean.TRUE);
		result.put("data", user);
		return result;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST, headers = {"Content-type=application/json"})
	@ResponseBody
	public Map insertUser(@RequestBody UserVO user) {
		if(user != null) {
			userService.insertUser(user);
		}
		
		Map result = new HashMap();
		result.put("result", Boolean.TRUE);
		return result;
	}
	
	
	@RequestMapping(value = "/users", method = RequestMethod.PUT, headers = {"Content-type=application/json"})
	@ResponseBody
	public Map updateUser(@RequestBody UserVO user) {
		if(user != null) {
			userService.updateUser(user);
		}
		
		Map result = new HashMap();
		result.put("result", Boolean.TRUE);
		return result;
	}
	
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		Map result = new HashMap();
		result.put("result", Boolean.TRUE);
		return result;
	}
	
	// xml응답을 주는 RESTful 웹 서비스 구현
	@RequestMapping(value = "/usersXml", method = RequestMethod.GET)
	@ResponseBody
	public UserVOXML getUserListXml( ) {
		List<UserVO> list = userService.selectUser();
		UserVOXML xml = new UserVOXML("success", list);
		return xml;
	}
	
	
	
}


























