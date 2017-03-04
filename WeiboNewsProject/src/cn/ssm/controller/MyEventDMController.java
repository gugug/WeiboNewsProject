package cn.ssm.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ssm.po.EntityMo;
import cn.ssm.po.Events;
import cn.ssm.po.EventsNewsMoEntity;
import cn.ssm.po.News;
import cn.ssm.service.PathConfig;

@Controller
@RequestMapping("/index")
public class MyEventDMController {
	/**
	 * 获取第一个事件的实体和情感
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	 @RequestMapping(value = "/index", method = {RequestMethod.POST,RequestMethod.GET})
	 public String index(Model model,HttpSession session) throws Exception{
		 System.out.println(session.getServletContext().getRealPath("/"));
		 EventsNewsMoEntity eventsNewsMoEntity = new EventsNewsMoEntity(); //实例一个对象
		 Map<String, Events> events = eventsNewsMoEntity.getEvents();
		 /**
		  * 获取第一个事件的实体和情感
		  */
		 Events firstEvent = events.get("253727.txt");
		 String firstEventId = firstEvent.getId();
		 List<EntityMo> FirstEntityEmoList = eventsNewsMoEntity.getEntityEmo(firstEventId);
		 List<String> entityList = new ArrayList<String>(); //保存实体
		 List<Double> negativeList = new ArrayList<Double>(); //保存负向情绪值
		 List<Double> pastiveList = new ArrayList<Double>();
		 if(FirstEntityEmoList.size()>5){
			 FirstEntityEmoList = FirstEntityEmoList.subList(0, 5);
		 }
		 Collections.reverse(FirstEntityEmoList);
		 for (EntityMo em : FirstEntityEmoList){
			 double sum = Double.parseDouble(em.getNegativeMo()) + Double.parseDouble(em.getPastiveMo());
			 entityList.add(em.getEntity());
			 negativeList.add(Double.parseDouble(em.getNegativeMo())/sum);
			 pastiveList.add(Double.parseDouble(em.getPastiveMo())/sum);
		}
			System.out.println("实体： "+entityList);
			System.out.println("负向情感值： "+negativeList);
			System.out.println("正向情感值： "+pastiveList);

		 /**
		  * 传输模型数据
		  */
		 model.addAttribute("entityList",entityList);
		 model.addAttribute("negativeList",negativeList);
		 model.addAttribute("pastiveList",pastiveList);
		 model.addAttribute("firstEvent",firstEvent);
		 model.addAttribute("eventId",firstEventId);
		 return "/index/index";
	 }
	 
	 /**
	  * 获取传入事件id的实体和情感值
	  * @param model
	  * @param session
	  * @param eventId
	  * @return
	  * @throws Exception
	  */
	 
	 @RequestMapping(value = "/details", method = {RequestMethod.POST,RequestMethod.GET})
	 public String details(Model model,HttpSession session,@RequestParam(value="id",required=true) String eventId) throws Exception{
		 System.out.println("事件id: "+eventId);
		 //	new PathConfig().setRealPath(session.getServletContext().getRealPath("/"));
		 EventsNewsMoEntity eventsNewsMoEntity = new EventsNewsMoEntity(); //实例一个对象
		 Map<String, Events> events = eventsNewsMoEntity.getEvents();
		 
		 List<EntityMo> entityEmoList = eventsNewsMoEntity.getEntityEmo(eventId);
		 List<String> entityList = new ArrayList<String>(); //保存实体
		 List<Double> negativeList = new ArrayList<Double>(); //保存负向情绪值
		 List<Double> pastiveList = new ArrayList<Double>();
		 if(entityEmoList.size()>5){
			 entityEmoList = entityEmoList.subList(0, 5);
		 }
		 Collections.reverse(entityEmoList);
		 for (EntityMo em : entityEmoList){
			 double sum = Double.parseDouble(em.getNegativeMo()) + Double.parseDouble(em.getPastiveMo());
			 entityList.add(em.getEntity());
			 negativeList.add(Double.parseDouble(em.getNegativeMo())/sum);
			 pastiveList.add(Double.parseDouble(em.getPastiveMo())/sum);
		 }
		 System.out.println("实体： "+entityList);
		 System.out.println("负向情感值： "+negativeList);
		 System.out.println("正向情感值： "+pastiveList);
		
		 model.addAttribute("entityList",entityList);
		 model.addAttribute("negativeList",negativeList);
		 model.addAttribute("pastiveList",pastiveList);
		 model.addAttribute("firstEvent",events.get(eventId));
		 model.addAttribute("eventId",eventId);

		 return "/details/details";
	 }
	 
	 
	 /**
	  * 获取传入事件id的相关新闻报道
	  * @param eventId
	  * @return
	  */
	 @RequestMapping(value = "/showNewsList", method = {RequestMethod.POST,RequestMethod.GET})
	 public @ResponseBody List<News> showNewsList(@RequestParam(value="id",required=true) String eventId){
		 
		 EventsNewsMoEntity eventsNewsMoEntity = new EventsNewsMoEntity(); //实例一个对象
		 Map<String, Events> events = eventsNewsMoEntity.getEvents();
		 List<News> newsList = new ArrayList<News>();
		 List<String> newsIdList = events.get(eventId).getNews(); 
		 for (String nid : newsIdList){
			 News news = eventsNewsMoEntity.getNews(nid);
			 newsList.add(news);
		 }
		 return newsList;
	 }
	 
	 
	 /**
	  * 获取的左边的全部事件列表
	  * @return  List<Events>
	  * @throws Exception
	  */
	 @RequestMapping(value = "/showEventsList", method = {RequestMethod.POST,RequestMethod.GET})
	 public @ResponseBody List<Events> showEventsList() throws Exception{
		 
		 EventsNewsMoEntity eventsNewsMoEntity = new EventsNewsMoEntity(); //实例一个对象
		 List<Events> eventsList = new ArrayList<Events>(); //页面右边的事件列表
		 Map<String, Events> events = eventsNewsMoEntity.getEvents();
		 eventsList.add(events.get("253727.txt"));//   
		 eventsList.add(events.get("156113.txt"));
		 eventsList.add(events.get("253034.txt"));
		 eventsList.add(events.get("251880.txt"));
		 Set<String> keySet = events.keySet();
		 for(String ks : keySet){			 
			 eventsList.add(events.get(ks));
		 }
		 return eventsList;
	 }
	 
	 
	 /**
	  * 接收页面的新闻id，然后返回新闻
	  * @param id 页面接收的新闻id
	  * @return newsComments{title:"...",comment:"..."}
	  * @throws Exception
	  */
	 
	 @RequestMapping(value = "/comments", method = {RequestMethod.POST,RequestMethod.GET})
	 public @ResponseBody Map<String,String> comments(String id) throws Exception{
		 System.out.println("评论id: "+id);
		 Map<String,String> newsComments = new HashMap<String,String>();
		 EventsNewsMoEntity eventsNewsMoEntity = new EventsNewsMoEntity(); //实例一个对象
		 String comment = eventsNewsMoEntity.getComment(id);
		 News news = eventsNewsMoEntity.getNews(id);
		 newsComments.put("title",news.getTitle());
		 newsComments.put("comment", comment);
		 return newsComments;
	 }
	 
	 /**
	  * 获取需要显示评论的新闻id，传给对应的页面，接收id后显示评论
	  * @param model
	  * @param id 新闻的id
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value = "/showComments", method = {RequestMethod.POST,RequestMethod.GET})
	 public String showComments(Model model,String id) throws Exception{
		 System.out.println("评论id"+id);
		 model.addAttribute("id", id);
		 return "/details/commentsDetails";
	 }
}
