package com.java.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dao.MysqlWeibo;
import com.java.po.Weibo;

@Controller
@RequestMapping("/weibo")
public class MyWeiboController {

	
	/**
	 * show weibo content by eid
	 */
	 @RequestMapping(value = "/showWeiboByEid", method = {RequestMethod.POST,RequestMethod.GET})
	 public  @ResponseBody  List<Weibo>  showWeiboByEid(Model model, @RequestParam(value="eid",required=true) String eventId){
		 MysqlWeibo mysqlWeibo = new MysqlWeibo();
		 List<Weibo> weiboList = mysqlWeibo.selectWeiboByEid(eventId);
		
		 return weiboList;
	 }

}
