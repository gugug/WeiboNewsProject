package com.java.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.java.dao.news.YunshanSqlCommentNum;
import com.java.dao.news.YunshanSqlEvaluationObject;
import com.java.dao.news.YunshanSqlEvent;
import com.java.dao.news.YunshanSqlEventKeyword;
import com.java.dao.news.YunshanSqlEventTopic;
import com.java.dao.news.YunshanSqlKeyword;
import com.java.dao.news.YunshanSqlNews;
import com.java.dao.news.YunshanSqlTopComment;
import com.java.dao.news.YunshanSqlTopic;
import com.java.dao.news.YunshanSqlTopicEvaluationObject;
import com.java.dao.news.YunshanSqlTopicNews;
import com.java.dao.news.YunshanSqlWebNum;
import com.java.po.YunshanEmotionPercent;
import com.java.po.YunshanEvaluationObject;
import com.java.po.YunshanEvent;
import com.java.po.YunshanKeyword;
import com.java.po.YunshanNews;
import com.java.po.YunshanReportPercent;
import com.java.po.YunshanTopComment;
import com.java.po.YunshanTopic;

@Controller
@RequestMapping("/news1")
public class CopyOfYunshanNewsController {
	
	/**
	 * show all news events 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/newsIndex")
	public 	String newsIndex(Model model) throws Exception {
		YunshanSqlEvent yunshanSqlEvent = new YunshanSqlEvent();
		List<YunshanEvent> yunshanEventList = yunshanSqlEvent.getYunEventInfo();
		model.addAttribute("eventList", yunshanEventList);
		return "news/newsIndex";
	}
	
	/**
	 * 根据事件id显示相关话题
	 * @param model
	 * @param eid 事件id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsTopic")
	public 	String newsTopic(Model model, String eid) throws Exception {
		YunshanSqlEventTopic yunshanSqlEventTopic = new YunshanSqlEventTopic();
		List<Integer> topicIdList = yunshanSqlEventTopic.getTopicIdByEid(eid);
		YunshanSqlTopic yunshanSqlTopic = new YunshanSqlTopic();
		List<YunshanTopic> topicList = yunshanSqlTopic.selectTopicByTidList(topicIdList);
		YunshanSqlWebNum yunshanSqlWebNum = new YunshanSqlWebNum();
		List<YunshanReportPercent> allWebNum = yunshanSqlWebNum.getAllWebNumByTopicList(topicIdList);
		YunshanSqlCommentNum yunshanSqlCommentNum = new YunshanSqlCommentNum();
		List<YunshanEmotionPercent> allCommentNum = yunshanSqlCommentNum.getAllCommentNumByTopicList(topicIdList);
		YunshanSqlEventKeyword yunshanSqlEventKeyword = new YunshanSqlEventKeyword();
		Map<Integer, Float> wordIdWeightMap = yunshanSqlEventKeyword.getEventKwIdByEid(eid);
		YunshanSqlKeyword yunshanSqlKeyword = new YunshanSqlKeyword();
		YunshanKeyword keywordList = yunshanSqlKeyword.getKwByKIdList(wordIdWeightMap);
		System.out.println(JSON.toJSON(allCommentNum));
		model.addAttribute("topicList", topicList);
		model.addAttribute("allWebNum", allWebNum);
		model.addAttribute("allCommentNum", allCommentNum);
		model.addAttribute("keyWordList", keywordList);

		return "news/newsTopic";
	}
	
	@RequestMapping(value = "/newsNews")
	public 	String newsNews(Model model, String tid) throws Exception {
		YunshanSqlTopicNews yunshanSqlTopicNews = new YunshanSqlTopicNews();
		List<Integer> newsIdList = yunshanSqlTopicNews.getNewsIdByTid(tid);
		YunshanSqlNews yunshanSqlNews = new YunshanSqlNews();
		List<YunshanNews> newsList = yunshanSqlNews.selectNewsByNidList(newsIdList);
		YunshanSqlTopicEvaluationObject yunshanSqlTopicEvaluationObject = new YunshanSqlTopicEvaluationObject();
		List<Integer> evaluationObjIdList = yunshanSqlTopicEvaluationObject.getEvaluationObjIdByTid(tid);
		YunshanSqlEvaluationObject yunshanSqlEvaluationObject = new YunshanSqlEvaluationObject();
		List<YunshanEvaluationObject> evaluEvaluList = yunshanSqlEvaluationObject.getEvaluByEvaluIdList(evaluationObjIdList);
		
		ArrayList<Integer> tidList = new ArrayList<Integer>();
		tidList.add(Integer.parseInt(tid));
		YunshanSqlCommentNum yunshanSqlCommentNum = new YunshanSqlCommentNum();
		List<YunshanEmotionPercent> allCommentNum = yunshanSqlCommentNum.getAllCommentNumByTopicList(tidList);
	


		model.addAttribute("newsList", newsList);
		model.addAttribute("evaluEvaluList", evaluEvaluList);
		model.addAttribute("comNumList", allCommentNum);
		model.addAttribute("tid", tid);
		return "news/newsNews";
	}
	
	@RequestMapping(value = "/newsNewsDetail")
	public 	String newsNewsDetail(Model model, String nid) throws Exception {
		YunshanSqlNews yunshanSqlNews = new YunshanSqlNews();
		YunshanNews yunshanNews = yunshanSqlNews.selectNewsByNid(nid);
		model.addAttribute("news", yunshanNews);
		return "news/newsNewsDetail";
	}

	@RequestMapping(value = "/newsNewsEmoDetail")
	public 	String newsNewsEmoDetail(Model model, String tid, String emoid) throws Exception {
		
		YunshanSqlTopComment yunshanSqlTopComment = new YunshanSqlTopComment();
		List<YunshanTopComment> topCommList = yunshanSqlTopComment.getTopCommByTid(tid,emoid);
		model.addAttribute("topCommList", topCommList);
		
	return "news/newsNewsEmoDetail";
	}
	
}
