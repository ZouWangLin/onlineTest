package com.online.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.util.E3Result;

@Controller
public class TimeController {
	@RequestMapping("/time/setTime")
	@ResponseBody
	public E3Result calTime(){
		return E3Result.ok("数据");
		
	}

}
