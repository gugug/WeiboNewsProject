package cn.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/testStatic")
public class MyStaticPageController {
	 @RequestMapping(value = "/index", method = RequestMethod.GET)
	   public String index() throws Exception{
		   return "testStatic/index";
	   }
	   
	   @RequestMapping(value = "/staticPage", method = RequestMethod.GET)
	   public String staticPage() throws Exception{
	     
	      return "forward:/views_html/index.html"; 

	   }

}
