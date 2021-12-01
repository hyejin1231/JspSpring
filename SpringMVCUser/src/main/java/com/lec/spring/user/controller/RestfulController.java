package com.lec.spring.user.controller;

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

import com.lec.spring.user.service.UserService;
import com.lec.spring.user.vo.UserVO;
import com.lec.spring.user.vo.UserVOXML;

@Controller
public class RestfulController {
	
	@Autowired
	private UserService userService;
	
	
	// 사용자 목록 조회 
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public Map getUserList() {
		List<UserVO> list = userService.selectUserList();
		Map result = new HashMap();
		result.put("result", Boolean.TRUE);
		result.put("data", list);
		return result;
	}
	
	// 특정 사용자 조회 
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map getUser(@PathVariable String id) {
		UserVO user = userService.selectUserID(id);
		Map result = new HashMap();
		result.put("result",Boolean.TRUE);
		result.put("data", user);
		
		return result;
	}
	
	
	// 사용자 정보 등록
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
	
	// 사용자 정보 수정 
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
	
	// 사용자 정보 삭제
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public Map deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		Map result = new HashMap();
		result.put("result", Boolean.TRUE);
		return result;
	}
	
	
	// xml 응답을 주는 RESTful 웹 서비스
	@RequestMapping(value = "/usersXml", method = RequestMethod.GET)
	@ResponseBody
	public UserVOXML getUserListXml() {
		List<UserVO> list = userService.selectUserList();
		UserVOXML xml = new UserVOXML("success", list);
		return xml;
	}
}
















































































