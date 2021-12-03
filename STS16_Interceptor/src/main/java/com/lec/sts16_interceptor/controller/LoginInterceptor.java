package com.lec.sts16_interceptor.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	// preHandle 
	// : 컨트롤러로 request 들어가기 전에 수행 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		System.out.println("[preHandle]" + id);
		
		// 만약 로그인하지 않았다면 로그인 페이지로 redirect 한다. 
		if(id == null) {
			String urlPrior = request.getRequestURL().toString() + "?" + request.getQueryString();
			request.getSession().setAttribute("url_prior_login", urlPrior); // 직전 url을 session에 기록한다.
			
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false; // 그리고 더 이상 컨트롤러의 핸들러를 진행하지 않도록 false 리턴한다. 
		}
//		return HandlerInterceptor.super.preHandle(request, response, handler);
		return true; // true를 리턴하면 컨트롤러 핸들러 진행 
	}

	// postHandle 
	// : 컨트롤러 실행 후, 뷰 실행 전 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("[postHandle]");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	// afterCompletion
	// : 뷰(화면) response 끝난 후 실행
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("[afterCompletion]");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}






















