package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.java.po.TopicObj;

/**
 * 包装成话题对象需要的json数据
 * @author iiip
 *
 */
public class TopicJson {
	
	public static void main(String[] args) {
		String path = "./Documents/result/3.xml";
		XmlFileUtil xmlFileUtil = new XmlFileUtil();
		xmlFileUtil.loadXml(path);
		Object topicJson = getTopicJson(xmlFileUtil.keyWordList);
		System.out.println(topicJson);
		FileUtil.rwFile(topicJson.toString(), "./Documents/result", "4.json");
	}
	

	/**
	 * 打包返回topic的json数据格式
	 * @param keyWordList
	 * @return
	 */
	public static Object getTopicJson(List<List<String>>  keyWordList){
		HashMap<String, Object> resultMap = new HashMap<String,Object>();
		ArrayList<TopicObj> topicObjList = new ArrayList<TopicObj>();

		for (int i = 0; i < keyWordList.size(); i++){
			ArrayList<HashMap<String, Object>> kwList = new ArrayList<HashMap<String, Object>>();
			for (int j = 0; j < keyWordList.get(i).size();j++){
				HashMap<String, Object> kwMap = new HashMap<String,Object>();
				kwMap.put("name", keyWordList.get(i).get(j));
				kwMap.put("size", 1);
				kwList.add(kwMap);
			}
			TopicObj topicObj = new TopicObj("话题"+(i+1), kwList);
			topicObjList.add(topicObj);
		}
		resultMap.put("name", "林丹事件");
		resultMap.put("children", topicObjList);
		return JSON.toJSON(resultMap);
	}
	

}
