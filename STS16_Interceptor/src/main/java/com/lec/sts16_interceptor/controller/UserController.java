package com.lec.sts16_interceptor.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

	public static final String ADMIN_ID = "admin";
	public static final String ADMIN_PW = "1234";
	
	@RequestMapping(value = "/login")
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value = "/loginOk", method = RequestMethod.POST)
	public String loginOk(String id, String pw, HttpSession session) {
		String returnUrl = "";
		
		// 기존에 로그인 세션정보가 있는 상태라면 
		if(session.getAttribute("id") != null) {
			session.removeAttribute("id"); // 일단 이전 로그인 세션 정보를 제거한다. 
		}
		
		if(ADMIN_ID.equals(id) && ADMIN_PW.equals(pw)) {
			
			session.setAttribute("id", id); // 새로 로그인 세션에 정보를 추가한다. 
			String priorUrl = (String) session.getAttribute("url_prior_login");
			if(priorUrl != null) { // 만약 기존에 가려고 했던 url 이 있다면 해당하는 페이지로 이동하고 
				returnUrl = "redirect:" + priorUrl;
				session.removeAttribute("url_prior_login");
			}else { // 없었다면 목록으로 redirect
				returnUrl = "redirect:/board/list.do";
			}
			
		}else {
			returnUrl = "user/logfail";
		}
		
		return returnUrl;
	}
	
	@RequestMapping("/logout")
	public String logOut(HttpSession session) {
		session.removeAttribute("id");
		return "user/logout";
	}
}
