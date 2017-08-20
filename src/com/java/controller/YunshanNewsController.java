package com.java.controller;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.java.dao.news.YunshanSqlCommentNum;
import com.java.dao.news.YunshanSqlEvaluationObject;
import com.java.dao.news.YunshanSqlEvent;
import com.java.dao.news.YunshanSqlEventKeyword;
import com.java.dao.news.YunshanSqlEventReportNum;
import com.java.dao.news.YunshanSqlEventTopic;
import com.java.dao.news.YunshanSqlKeyword;
import com.java.dao.news.YunshanSqlNews;
import com.java.dao.news.YunshanSqlTopComment;
import com.java.dao.news.YunshanSqlTopic;
import com.java.dao.news.YunshanSqlTopicEvaluationObject;
import com.java.dao.news.YunshanSqlTopicNews;
import com.java.dao.news.YunshanSqlWebNum;
import com.java.po.YunshanEmoCommNumWithTime;
import com.java.po.YunshanEmotionPercent;
import com.java.po.YunshanEvaluationObject;
import com.java.po.YunshanEvent;
import com.java.po.YunshanEventReportNum;
import com.java.po.YunshanKeyword;
import com.java.po.YunshanNews;
import com.java.po.YunshanNewsPageResult;
import com.java.po.YunshanReportPercent;
import com.java.po.YunshanTopComment;
import com.java.po.YunshanTopic;
import com.java.po.YunshanTopicCommNum;
import com.java.po.YunshanTopicPageResult;

@Controller
@RequestMapping("/news")
public class YunshanNewsController {
	
	/**
	 * show all news events 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/newsIndex",method = { RequestMethod.POST,RequestMethod.GET })
	public @ResponseBody Object newsIndex(HttpServletRequest request, String callback, @RequestParam(defaultValue="") String text) throws Exception {
		Map<String, String[]> parameterMap = request.getParameterMap(); //打印前端调用函数
		System.out.println("----------------"+JSON.toJSON(parameterMap));
		System.out.println("text:----------"+text);
		YunshanSqlEvent yunshanSqlEvent = new YunshanSqlEvent();
		List<YunshanEvent> yunshanEventList = null;
		if (!text.equals("")){
			yunshanEventList = yunshanSqlEvent.getYunEventListByKw(text);
			if (yunshanEventList.size()==0){
				System.out.println("搜索没有结果");
				yunshanEventList = yunshanSqlEvent.getYunEventInfo();
				
			}
		}else{
			yunshanEventList = yunshanSqlEvent.getYunEventInfo();
		}
		
		System.out.println(yunshanEventList);
		System.out.println(JSON.toJSON(yunshanEventList));
		//jsonp格式
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(yunshanEventList);
		mappingJacksonValue.setJsonpFunction(callback);
		return mappingJacksonValue;
	}

	/**
	 * 根据事件id显示相关话题
	 * @param model
	 * @param eid 事件id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsTopic")
	public @ResponseBody Object newsTopic(String callback, String eid) throws Exception {
		YunshanSqlEvent yunshanSqlEvent = new YunshanSqlEvent();
		YunshanEvent yunshanEvent = yunshanSqlEvent.selectYunEventByEid(eid);
		HashMap<String, YunshanEvent> basicMap = new HashMap<String, YunshanEvent>();
		basicMap.put("basic", yunshanEvent);//basic数据
		System.out.println(JSON.toJSON(basicMap));
		
		YunshanSqlEventTopic yunshanSqlEventTopic = new YunshanSqlEventTopic();
		List<Integer> topicIdList = yunshanSqlEventTopic.getTopicIdByEid(eid);
		YunshanSqlTopic yunshanSqlTopic = new YunshanSqlTopic();
		List<YunshanTopic> topicList = yunshanSqlTopic.selectTopicByTidList(topicIdList);
		HashMap<String, List<YunshanTopic>> topicMap = new HashMap<String, List<YunshanTopic>>();
		topicMap.put("topics", topicList);//话题链数据
		System.out.println(JSON.toJSON(topicMap));
		
		YunshanSqlTopicNews yunshanSqlTopicNews = new YunshanSqlTopicNews();
		List<Integer> allNewsId = yunshanSqlTopicNews.getAllNewsIdByTidList(topicIdList);
		YunshanSqlEventReportNum yunshanSqlEventReportNum = new YunshanSqlEventReportNum();
		YunshanEventReportNum eventReportNumWithTime = yunshanSqlEventReportNum.eventReportNumWithTimeByAllNewsId(allNewsId);
		System.out.println("eventReportNumWithTime： "+JSON.toJSON(eventReportNumWithTime));//事件随时间的报道，前端待定
		
		
		YunshanSqlWebNum yunshanSqlWebNum = new YunshanSqlWebNum();
		List<YunshanReportPercent> allWebNumList = yunshanSqlWebNum.getAllWebNumByTopicList(topicIdList);
		System.out.println(JSON.toJSON(allWebNumList));//媒体报道百分比
		
		YunshanSqlCommentNum yunshanSqlCommentNum = new YunshanSqlCommentNum();
		List<YunshanEmotionPercent> allEmotionNumList = yunshanSqlCommentNum.getAllCommentNumByTopicList(topicIdList);
		System.out.println(JSON.toJSON(allEmotionNumList));//情绪百分比
		
		YunshanSqlEventKeyword yunshanSqlEventKeyword = new YunshanSqlEventKeyword();
		Map<Integer, Float> wordIdWeightMap = yunshanSqlEventKeyword.getEventKwIdByEid(eid);
		YunshanSqlKeyword yunshanSqlKeyword = new YunshanSqlKeyword();
		YunshanKeyword kw = yunshanSqlKeyword.getKwByKIdList(wordIdWeightMap);
		System.out.println(JSON.toJSON(kw));//关键词数据
		
		YunshanTopicPageResult yunshanTopicPageResult = new YunshanTopicPageResult(yunshanEvent, topicList, allWebNumList, allEmotionNumList, kw, eventReportNumWithTime);
		System.out.println(JSON.toJSON(yunshanTopicPageResult));//整个话题页面的数据格式
		
		//jsonp格式
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(yunshanTopicPageResult);
		mappingJacksonValue.setJsonpFunction(callback);
		
		return mappingJacksonValue;
	}

	/**
	 * 根据话题id 显示话题相关信息
	 * @param tid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsNews")
	public @ResponseBody Object newsNews(String callback, String tid) throws Exception {
		YunshanSqlTopic yunshanSqlTopic = new YunshanSqlTopic();
		YunshanTopic yunshanTopic = yunshanSqlTopic.selectTopicByTid(tid);
		System.out.println(JSON.toJSON(yunshanTopic)); //basic数据
		
		YunshanSqlTopicNews yunshanSqlTopicNews = new YunshanSqlTopicNews();
		List<Integer> newsIdList = yunshanSqlTopicNews.getNewsIdByTid(tid);
		YunshanSqlNews yunshanSqlNews = new YunshanSqlNews();
		List<YunshanNews> newsList = yunshanSqlNews.selectNewsByNidList(newsIdList);
		//System.out.println(JSON.toJSON(newsList)); //新闻链数据
//		System.out.println(newsList.size());
		
		
		YunshanSqlTopicEvaluationObject yunshanSqlTopicEvaluationObject = new YunshanSqlTopicEvaluationObject();
		List<Integer> evaluationObjIdList = yunshanSqlTopicEvaluationObject.getEvaluationObjIdByTid(tid);
		YunshanSqlEvaluationObject yunshanSqlEvaluationObject = new YunshanSqlEvaluationObject();
		List<YunshanEvaluationObject> evaluEvaluList = yunshanSqlEvaluationObject.getEvaluByEvaluIdList(evaluationObjIdList);
		System.out.println(JSON.toJSON(evaluEvaluList));//立场数据
		
		ArrayList<Integer> tidList = new ArrayList<Integer>();
		tidList.add(Integer.parseInt(tid));
		YunshanSqlCommentNum yunshanSqlCommentNum = new YunshanSqlCommentNum();
		List<YunshanEmotionPercent> allCommentNum = yunshanSqlCommentNum.getAllCommentNumByTopicList(tidList);
		System.out.println(JSON.toJSON(allCommentNum));//情感比例数据
		
		YunshanEmoCommNumWithTime emoCommNumWithTime = yunshanSqlCommentNum.getEmoCommNumWithTimeByTid(tid);
		System.out.println("情感随时间---"+JSON.toJSON(emoCommNumWithTime));//情感随时间的评论量，前端待定
		
		YunshanTopicCommNum commentNum = yunshanSqlCommentNum.getCommentNumByTid(tid);
		System.out.println(JSON.toJSON(commentNum)); //评论量数据
		
		YunshanNewsPageResult yunshanNewsPageResult = new YunshanNewsPageResult(yunshanTopic, newsList, evaluEvaluList, commentNum, allCommentNum,emoCommNumWithTime);
//		System.out.println(JSON.toJSON(yunshanNewsPageResult));//整个新闻页面的数据格式
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(yunshanNewsPageResult);
		mappingJacksonValue.setJsonpFunction(callback);
		return mappingJacksonValue;
		
	}
	
	
//	@RequestMapping(value = "/newsNewsDetail")
//	public 	String newsNewsDetail(Model model, String nid) throws Exception {
//		YunshanSqlNews yunshanSqlNews = new YunshanSqlNews();
//		YunshanNews yunshanNews = yunshanSqlNews.selectNewsByNid(nid);
//		model.addAttribute("news", yunshanNews);
//		return "news/newsNewsDetail";
//	}

	/**
	 * 根据情感id， 返回对应的评论
	 * @param tid
	 * @param emoid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsNewsEmoDetail")
	public @ResponseBody Object newsNewsEmoDetail(String callback, String tid, String emoid) throws Exception {
//		System.out.println("emoid"+emoid);
		YunshanSqlTopComment yunshanSqlTopComment = new YunshanSqlTopComment();
		List<YunshanTopComment> topCommList = yunshanSqlTopComment.getTopCommByTid(tid,((Integer.parseInt(emoid)+1))+"");
		System.out.println(JSON.toJSON(topCommList));//对应情感id的评论数据
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(topCommList);
		mappingJacksonValue.setJsonpFunction(callback);
		
		return mappingJacksonValue;
	}
	
}
