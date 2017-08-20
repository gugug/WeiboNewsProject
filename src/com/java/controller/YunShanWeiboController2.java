package com.java.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.config.PathConfig;
import com.java.po.Event;
import com.java.po.Weibo;
import com.java.service.ControllerService;
import com.java.service.XmlFileUtil;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * 云山舆情的微博平台Controller 2017-01-16
 * 
 * @author iiip version 2
 */

@Controller
@RequestMapping("/weibo")
public class YunShanWeiboController2 {
	
	MysqlEvent mysqlEvent = new MysqlEvent();
	MysqlWeibo mysqlWeibo = new MysqlWeibo();


	/**
	 * 微博平台的首页的方法
	 */
	@RequestMapping("/weiboMain")
	public String weiboMain(HttpServletRequest request, Model model,@RequestParam(defaultValue="") String searchContent) throws Exception {
		List<Event> eventList = null;
		if (!searchContent.equals("")){
			eventList = mysqlEvent.getEventInfoByKW(searchContent);
			if (eventList.size()==0){
				System.out.println("搜索没有结果");
				eventList = mysqlEvent.getEventInfo();
			}
		}else{
			eventList = mysqlEvent.getEventInfo();
		}
		
		List<String> imageList = new ArrayList<String>();
		imageList.add("lindan.png");
		for (int i = 1; i < eventList.size();i++)
			imageList.add("luoyixiao.png");
		model.addAttribute("eventList", eventList);
		model.addAttribute("imageList", imageList);
		return "weibo2/weiboMain";
	}

	/**
	 * 微博平台的事件详情页面
	 */
	@RequestMapping("/eventDetail")
	public String eventDetail(Model model,String eid) throws Exception {
		Event event = mysqlEvent.selectEventByEid(eid);
		List<Weibo> weiboList = mysqlWeibo.selectWeiboByEid(eid);
		String weiboTransformPath = weiboTransformPath(eid);
		Object[] weiboCharacter = weiboCharacter(eid);//ageSexArr
		Object[] topicPathAndList = weiboTopic(eid);
		
		model.addAttribute("eid", eid);
		model.addAttribute("event", event);
		model.addAttribute("weiboList", weiboList);
		model.addAttribute("weiboTransformPath", weiboTransformPath);
		model.addAttribute("queryByIDSex",weiboCharacter[1]);
		model.addAttribute("queryByIDAge",weiboCharacter[0]);
		model.addAttribute("topicJsonPath", topicPathAndList[0]);
		model.addAttribute("topicList", topicPathAndList[1]);
		
		return "weibo2/eventDetail";
		
	}
	

	/**
	 * 微博平台的地域分布的方法，用于query ajax请求
	 */
	@RequestMapping("/weiboLocation")
	public @ResponseBody  List<Map<String,Object>> weiboLocation(Model model,@RequestParam(value="eid",required=true,defaultValue="1") String eventId) throws Exception{
		MongoHelper mongoHelper = new MongoHelper();
		MongoDaoImpl mongoDaoImpl = new MongoDaoImpl();
		MongoClient mongoClient = mongoHelper.getMongoClient();
		MongoDatabase mongoDataBase = mongoHelper.getMongoDataBase(mongoClient);
		String areaTable = "area";
		int eid = Integer.parseInt(eventId);
		Map<String, Integer> queryByIDArea = mongoDaoImpl.queryByID(mongoDataBase, areaTable, eid);
		queryByIDArea.remove("_id");
		Set<String> areaKeySet = queryByIDArea.keySet();
		 List<Map<String,Object>> areaList = new ArrayList<Map<String,Object>>();
		
		for (String areaName : areaKeySet){
			Map<String, Object> areaMap = new HashMap<String,Object>();
			areaMap.put("name", areaName);
			areaMap.put("value", queryByIDArea.get(areaName));
			areaList.add(areaMap);
		}
		return areaList;
	}
	

	/**
	 * 微博平台的传播链页面对应的json数据路径
	 */
	public String weiboTransformPath(String eventId) throws Exception {
		//事件的id对应的转发路径的json文件 
		String absPath = PathConfig.ROOT_PATH+PathConfig.TRANSFORM_JSON_PATH+"transform"+eventId+".json";
		File file = new File(absPath);
		String jsonPath = null;
		if (file.exists()){
			jsonPath = "../"+PathConfig.TRANSFORM_JSON_PATH+"transform"+eventId+".json";
		}else{
			//生成转发路径的json文件
			jsonPath = "../"+PathConfig.TRANSFORM_JSON_PATH+"default.json";
		}
		return jsonPath;

	}

	/**
	 * 微博平台的读者基本属性页面的方法
	 */
	public Object[] weiboCharacter(String eventId) throws Exception{
		MongoHelper mongoHelper = new MongoHelper();
		MongoDaoImpl mongoDaoImpl = new MongoDaoImpl();
		MongoClient mongoClient = mongoHelper.getMongoClient();
		MongoDatabase mongoDataBase = mongoHelper.getMongoDataBase(mongoClient);
		String sexTable = "sex";
		String ageTable = "age";
		int eid = Integer.parseInt(eventId);
		Map<String, Integer> queryByIDAge = mongoDaoImpl.queryByID(mongoDataBase, ageTable, eid);
		Map<String, Integer> queryByIDSex = mongoDaoImpl.queryByID(mongoDataBase, sexTable, eid);
		Object[] ageSexArr = new Object[]{queryByIDAge,queryByIDSex};
		return ageSexArr;
	}

	/**
	 * 微博平台的话题页面的json路径方法
	 */
	public Object[] weiboTopic(String eventId) throws Exception {
		
		String absxmlpath = PathConfig.ROOT_PATH+PathConfig.TOPIC_XML_PATH+"topic"+eventId+".xml";
		XmlFileUtil xmlFileUtil = new XmlFileUtil();
		List<String> topicList =xmlFileUtil.loadXml(absxmlpath);
		
		String absTopicJsonPath = PathConfig.ROOT_PATH+PathConfig.TOPIC_JSON_PATH+"topic"+eventId+".json";
		File file = new File(absTopicJsonPath);
		String topicJsonPath = null;
		if (file.exists()){
			topicJsonPath = "../"+PathConfig.TOPIC_JSON_PATH+"topic"+eventId+".json";;
		}else{
			//生成话题的json文件
			topicJsonPath = "../"+PathConfig.TOPIC_JSON_PATH+"default.json";;
		}
		
		Object[] pathAndList = new Object[]{topicJsonPath,topicList};
		return pathAndList;
	}




	
}
