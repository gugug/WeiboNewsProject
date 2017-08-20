//package com.java.controller;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.java.dao.MongoDaoImpl;
//import com.java.dao.MongoHelper;
//import com.java.dao.MysqlEvent;
//import com.java.dao.MysqlWeibo;
//import com.java.po.Event;
//import com.java.po.Weibo;
//import com.java.service.XmlFileUtil;
//import com.mongodb.MongoClient;
//import com.mongodb.client.MongoDatabase;
//
///**
// * 云山舆情的微博平台Controller 2017-01-16
// * 
// * @author iiip version 1
// */
//
//@Controller
//@RequestMapping("/weibo")
//public class YunShanWeiboController {
//
//	/**
//	 * 微博平台的首页的方法
//	 */
//	@RequestMapping("/weiboMain")
//	public String weiboMain(Model model) throws Exception {
//		MysqlEvent mysqlEvent = new MysqlEvent();
//		List<Event> eventList = mysqlEvent.getEventInfo();
//		
//		List<String> imageList = new ArrayList<String>();
//		imageList.add("林丹.png");
//		imageList.add("罗一笑.jpg");
//		imageList.add("裸条.jpg");
//		model.addAttribute("eventList", eventList);
//		model.addAttribute("imageList", imageList);
//
//		return "weibo/weiboMain";
//	}
//
//	/**
//	 * 微博平台的新闻页面的方法
//	 */
//	@RequestMapping("/weiboNews")
//	public String weiboNews(Model model,@RequestParam(value="eid",required=true, defaultValue="1") String eventId) throws Exception {
//				
//		MysqlEvent mysqlEvent = new MysqlEvent();
//		Event eventByEid = mysqlEvent.selectEventByEid(eventId);
//		
//		MysqlWeibo mysqlWeibo = new MysqlWeibo();
//		List<Weibo> weiboList = mysqlWeibo.selectWeiboByEid(eventId);
//		model.addAttribute("event", eventByEid);
//		model.addAttribute("weiboList", weiboList);
//		model.addAttribute("eid", eventId);
//
//		return "weibo/weiboNews";
//	}
//
//	/**
//	 * 微博平台的传播链页面的方法
//	 */
//	@RequestMapping("/weiboTransform")
//	public String weiboTransform(Model model,@RequestParam(value="eid",required=true,defaultValue="1") String eventId) throws Exception {
//		MysqlEvent mysqlEvent = new MysqlEvent();
//		Event eventByEid = mysqlEvent.selectEventByEid(eventId);
//		
//		//事件的id对应的jsOn文件 
//		String jsonUrl = "";
//		if (eventId.equals("1")){
//			jsonUrl = "../public/data/林丹出轨门.json";
//		}else if(eventId.equals("2")){
//			jsonUrl = "../public/data/罗尔.json";
//		}else if(eventId.equals("311")){
//			jsonUrl = "../public/data/美联航暴力拖拽华人乘客下机.json";
//		}else{
//			jsonUrl = "../public/data/裸贷.json";
//		}
//		
//		String jsonPath = "../public/data/"+eventId+".json";
//		
//		model.addAttribute("eid", eventId);
//		model.addAttribute("event", eventByEid);
//		model.addAttribute("jsonUrl", jsonUrl);
//
//		return "weibo/weiboTransform";
//	}
//
//	/**
//	 * 微博平台的读者基本属性页面的方法
//	 */
//	@RequestMapping("/weiboCharacter")
//	public String weiboCharacter(Model model,@RequestParam(value="eid",required=true,defaultValue="1") String eventId) throws Exception{
//		MongoHelper mongoHelper = new MongoHelper();
//		MongoDaoImpl mongoDaoImpl = new MongoDaoImpl();
//		MongoClient mongoClient = mongoHelper.getMongoClient();
//		MongoDatabase mongoDataBase = mongoHelper.getMongoDataBase(mongoClient);
//		String sexTable = "sex";
//		String ageTable = "age";
//		System.out.println(eventId);
//		int eid = Integer.parseInt(eventId);
//		Map<String, Integer> queryByIDAge = mongoDaoImpl.queryByID(mongoDataBase, ageTable, eid);
//		Map<String, Integer> queryByIDSex = mongoDaoImpl.queryByID(mongoDataBase, sexTable, eid);
//		
//		System.out.println(queryByIDAge);
//		System.out.println(queryByIDSex);
//		System.out.println(queryByIDAge.get("a79"));
//		
//		Event eventByEid = new MysqlEvent().selectEventByEid(eventId);
//		
//		model.addAttribute("queryByIDSex",queryByIDSex);
//		model.addAttribute("queryByIDAge",queryByIDAge);
//		model.addAttribute("eid", eventId);
//		model.addAttribute("event", eventByEid);
//
//		return "weibo/weiboCharacter";
//	}
//	
//	/**
//	 * 显示地域分布
//	 * @param model
//	 * @param eventId
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("/showLocation")
//	public String showLocation(Model model,@RequestParam(value="eid",required=true,defaultValue="1") String eventId) throws Exception{
//		MysqlEvent mysqlEvent = new MysqlEvent();
//		Event eventByEid = mysqlEvent.selectEventByEid(eventId);
//		model.addAttribute("eid", eventId);
//		model.addAttribute("event", eventByEid);
//		return "weibo/weiboLocation";
//	}
//
//	
//	/**
//	 * 微博平台的地域分布的方法，用于query ajax请求
//	 */
//	@RequestMapping("/weiboLocation")
//	public @ResponseBody  List<Map<String,Object>> weiboLocation(Model model,@RequestParam(value="eid",required=true,defaultValue="1") String eventId) throws Exception{
//		MongoHelper mongoHelper = new MongoHelper();
//		MongoDaoImpl mongoDaoImpl = new MongoDaoImpl();
//		MongoClient mongoClient = mongoHelper.getMongoClient();
//		MongoDatabase mongoDataBase = mongoHelper.getMongoDataBase(mongoClient);
//		String areaTable = "area";
//		int eid = Integer.parseInt(eventId);
//		Map<String, Integer> queryByIDArea = mongoDaoImpl.queryByID(mongoDataBase, areaTable, eid);
//		System.out.println(queryByIDArea);
//		queryByIDArea.remove("_id");
//		Set<String> areaKeySet = queryByIDArea.keySet();
//		 List<Map<String,Object>> areaList = new ArrayList<Map<String,Object>>();
//		
//		for (String areaName : areaKeySet){
//			Map<String, Object> areaMap = new HashMap<String,Object>();
//			areaMap.put("name", areaName);
//			areaMap.put("value", queryByIDArea.get(areaName));
//			areaList.add(areaMap);
//		}
//		
//		System.out.println(areaList);
//		
////		System.out.println(JSON.serialize(areaList));
////		Object areaObj = JSON.parse(JSON.serialize(areaList));
////		System.out.println(areaObj);
//		
//		return areaList;
//	}
//
//	/**
//	 * 微博平台的话题页面的方法
//	 */
//	@RequestMapping("/weiboTopic")
//	public String weiboTopic(Model model,@RequestParam(value="eid",required=true,defaultValue="1") String eventId) throws Exception {
//		MysqlEvent mysqlEvent = new MysqlEvent();
//		Event eventByEid = mysqlEvent.selectEventByEid(eventId);
//		
//		String path = "/home/iiip/workspace/WeiboNewsProject/Documents/result/"+eventId+".xml";
//		XmlFileUtil xmlFileUtil = new XmlFileUtil();
//		List<String> topicList =xmlFileUtil.loadXml(path);
//		
//		String topicJsonPath = "../public/data/topic"+eventId+".json";
//		System.out.println(path);
//		System.out.println(topicJsonPath);
//		
//		model.addAttribute("topicJsonPath", topicJsonPath);
//		model.addAttribute("topicList", topicList);
//
//		model.addAttribute("eid", eventId);
//		model.addAttribute("event", eventByEid);
//		return "weibo/weiboTopic";
//	}
//	
//	
//
//}
