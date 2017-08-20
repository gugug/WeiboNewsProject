package com.java.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 读取xml文件，加载相关数据
 * @author iiip
 *
 */
public class XmlFileUtil {
	
	public List<List<String>> keyWordList = new ArrayList<List<String>>();//value是评论关键词

	public static void main(String[] args) {
		String path = "./Documents/result/1.xml";
		XmlFileUtil xmlFileUtil = new XmlFileUtil();
		List<String> loadXml =xmlFileUtil.loadXml(path);
	}

//	//包装成topic需要的json数据格式
//	public Object getTopicJson(){
//		ArrayList<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
//		HashMap<String, Object> resultMap = new HashMap<String,Object>();
//
//		for (int i = 0; i < keyWordList.size(); i++){
//			HashMap<String, Object> tempMap = new HashMap<String,Object>();
//			System.out.println(keyWordList.get(i));
//			ArrayList<HashMap<String, Object>> kwList = new ArrayList<HashMap<String, Object>>();
//			for (int j = 0; j < keyWordList.get(i).size();j++){
//				HashMap<String, Object> kwMap = new HashMap<String,Object>();
//				kwMap.put("name", keyWordList.get(i).get(j));
//				kwMap.put("size", 1);
//				kwList.add(kwMap);
//			}
//			tempMap.put("name","话题"+i);
//			tempMap.put("children", kwList);
//			resultList.add(tempMap);
//		}
//		resultMap.put("name", "林丹事件");
//		resultMap.put("children", resultList);
//		return JSON.toJSON(resultMap);
//	}
	
	/**
	 * 读取xml的文件内容，并加载
	 * @param path xml所在路径
	 * @return
	 */
	public  List<String> loadXml(String path) {
		Element element = null;
		File f = new File(path);
		// documentBuilder为抽象不能直接实例化(将XML文件转换为DOM文件)
		DocumentBuilder db = null;
		DocumentBuilderFactory dbf = null;
		
		List<String> topicList = new ArrayList<String>();//用于存放拼接字符串，显示前端
		
		new HashMap<String,String>();
		try {
			// 返回documentBuilderFactory对象
			dbf = DocumentBuilderFactory.newInstance();
			// 返回db对象, 用documentBuilderFatory对象获得返回documentBuildr对象
			db = dbf.newDocumentBuilder();
			// 得到一个DOM并返回给document对象
			Document dt = db.parse(f);
			// 得到一个elment根元素
			element = dt.getDocumentElement();
			// 获得根节点
//			System.out.println("根元素：" + element.getNodeName());
			// 获得根元素下的子节点
			NodeList childNodes = element.getChildNodes();
			// 遍历这些子节点
			for (int i = 0; i < childNodes.getLength(); i++) {
				// 获得每个对应位置i的结点
				Node node1 = childNodes.item(i);
				if ("topic".equals(node1.getNodeName())) {
					// 获得<topic>下的节点
					NodeList nodeDetail = node1.getChildNodes();
					// 遍历<topic>下的节点
					String str =  null;

					for (int j = 0; j < nodeDetail.getLength(); j++) {
						// 获得<topic>元素每一个节点
						Node detail = nodeDetail.item(j);
						if ("keyword".equals(detail.getNodeName())) {
//							System.out.println("keyword: "+ detail.getTextContent());
							str = "keyword: "+detail.getTextContent()+"<br />";
							keyWordList.add(Arrays.asList(detail.getTextContent().split(" ")));
						}

						else if ("represent".equals(detail.getNodeName())) {
//							System.out.println("represent: " + detail.getTextContent());
							str += "represent: "+detail.getTextContent();
						}
					}
					topicList.add(str);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topicList;
	}

}
