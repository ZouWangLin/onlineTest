package com.online.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户登录拦截器
 * @author 26282
 *
 */
public class LoginHandlerInterceptor implements HandlerInterceptor{

	//页面渲染后
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		
	}

	//方法后
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	//方法前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//1.判断用户请求的url
		String url = request.getRequestURI();
		//2.判断url问题，如果包含login，直接放行
		if(url.contains("login")){
			return true;
		}
		//3.判断session问题
		HttpSession session = request.getSession();
		
		//4.判断和教师端有关的url拦截问题
		if(session.getAttribute("teacher")!=null){
			if(!url.contains("student")){
				return true;
			}
		}
		//5.判断和学生端有关的url拦截问题
		if(session.getAttribute("student")!=null){
			if(url.contains("student")){
				return true;
			}
		}
		//如果两者都没有
		response.sendRedirect(request.getContextPath()+"/login");
		return false;
	}

}
