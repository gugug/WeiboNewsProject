package com.java.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dao.MongoDaoImpl;
import com.java.dao.MongoHelper;
import com.java.dao.MysqlEvent;
import com.java.dao.MysqlWeibo;
import com.java.po.Event;
import com.java.po.Weibo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

@Controller
@RequestMapping("/event")
public class MyEventController {
	/**
	 * show index page about events
	 * 
	 * @return
	 * @throws Exception
	 */
//	@RequestMapping(value = "index")
//	public String index() throws Exception {
//		return "event/index";
//	}

//	/**
//	 * show all events by ajax request
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "/showEvent", method = { RequestMethod.POST,
//			RequestMethod.GET })
//	public @ResponseBody
//	List<Event> showEvent() throws Exception {
//		MysqlEvent mysqlEvent = new MysqlEvent();
//		List<Event> eventList = mysqlEvent.getEventInfo();
//		System.out.println(eventList.get(0).getEventId());
//		System.out.println(eventList.size());
//		return eventList;
//	}
	
	
	/**
	 * show all events 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index", method = { RequestMethod.POST,
			RequestMethod.GET })
	public 	String index(Model model) throws Exception {
		MysqlEvent mysqlEvent = new MysqlEvent();
		List<Event> eventList = mysqlEvent.getEventInfo();
		model.addAttribute("eventList", eventList);
		return "event/index";
	}
	
	
	

	@RequestMapping(value = "/showEventDetails")
	public String showEventDetails(Model model,
			@RequestParam(value = "eid", required = true) String eventId)
			throws Exception {
		MysqlEvent mysqlEvent = new MysqlEvent();
		Event eventByEid = mysqlEvent.selectEventByEid(eventId);

		MysqlWeibo mysqlWeibo = new MysqlWeibo();
		List<Weibo> weiboList = mysqlWeibo.selectWeiboByEid(eventId);

		model.addAttribute("eventByEid", eventByEid);
		model.addAttribute("weiboList", weiboList);
		model.addAttribute("eventId", eventId);
		return "yunshan/yunshan";
	}

	// /**
	// * 用于ajax请求
	// * @param model
	// * @param eventId
	// * @return
	// * @throws Exception
	// */
	// @RequestMapping(value="/showEventByEid", method
	// ={RequestMethod.POST,RequestMethod.GET})
	// public @ResponseBody Event showEventByEid(Model model,
	// @RequestParam(value="eid",required=true) String eventId) throws
	// Exception{
	// MysqlEvent mysqlEvent = new MysqlEvent();
	// Event eventByEid = mysqlEvent.selectEventByEid(eventId);
	// return eventByEid;
	// }
	
	@RequestMapping(value = "/showStatistics")
	public String showStatistics(Model model,
			@RequestParam(value = "eid", required = true) String eventId)
			throws Exception {
		MongoHelper mongoHelper = new MongoHelper();
		MongoDaoImpl mongoDaoImpl = new MongoDaoImpl();
		MongoClient mongoClient = mongoHelper.getMongoClient();
		MongoDatabase mongoDataBase = mongoHelper.getMongoDataBase(mongoClient);
		String areaTable = "area";
		String sexTable = "sex";
		String ageTable = "age";
		System.out.println(eventId);
		int eid = Integer.parseInt(eventId);
		Map<String, Integer> queryByIDAge = mongoDaoImpl.queryByID(mongoDataBase, ageTable, eid);
		Map<String, Integer> queryByIDSex = mongoDaoImpl.queryByID(mongoDataBase, sexTable, eid);
		Map<String, Integer> queryByIDArea = mongoDaoImpl.queryByID(mongoDataBase, areaTable, eid);
	
//		model.addAttribute("queryByIDAge", queryByIDAge);
		System.out.println(queryByIDAge);
		System.out.println(queryByIDSex);
		System.out.println(queryByIDArea);
		
		model.addAttribute("queryByIDArea",queryByIDArea);
		model.addAttribute("queryByIDSex",queryByIDSex);
		model.addAttribute("queryByIDAge",queryByIDAge);
		
		return "yunshan/statistics";
	}

}
