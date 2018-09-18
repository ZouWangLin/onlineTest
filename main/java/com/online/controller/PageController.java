package com.online.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面挑战控制类
 * @author 26282
 *
 */
@Controller
public class PageController {
	/**
	 * 页面跳转到首页
	 * @return	返回页面跳转试图
	 */
	@RequestMapping("/")
	public String toIndex(){
		return "index";
	}
	/**
	 * 页面跳转到指定的页面
	 * @param url	用户指定的url
	 * @return		返回页面跳转试图
	 */
	@RequestMapping("{url}")
	public String toRequest(@PathVariable String url){
		return url;
	}

}
