package com.online.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理类
 * @author 26282
 *
 */
public class MyHandlerExceptionResolver implements HandlerExceptionResolver{
	/**
	 * message		出错方法的位置（包名加类名加方法名），即字符串
	 * exception	异常类型
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object message,
			Exception exception) {
		//1.常见视图数据对象
		ModelAndView modelAndView = new ModelAndView();
		//2.页面跳转
		modelAndView.setViewName("/error/error");
		return modelAndView;
	}

}
