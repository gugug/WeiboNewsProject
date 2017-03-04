package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/yunshan")
public class MyYunShanController {
	
	/**
	 * show index page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="index")
	public String weiboIndex() throws Exception{
		return "yunshan/yunshan";
	}

}
