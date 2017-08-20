package com.java.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.java.config.PathConfig;

public class TransformTree {

	public static void main(String[] args) {
		TransformTree transformTree = new TransformTree();
		String transformtxtpath = PathConfig.ROOT_PATH+PathConfig.TRANSFORM_TXT_PATH+"美联航暴力拖拽华人乘客下机.txt";
		String eventName = "美联航暴力拖拽华人乘客下机";
		Object transformJson = transformTree.getTransformJson(transformtxtpath, eventName);
		System.out.println(transformJson);
		FileUtil.rwFile(transformJson.toString(), PathConfig.ROOT_PATH+PathConfig.TRANSFORM_JSON_PATH, "transform311.json");
	}

	
	/**
	 * 生成传播树状图的json数据格式
	 * @param transformtxtpath 传播路径txt的文件所在地
	 * @param eventName 事件名字
	 * @return
	 */
	public Object getTransformJson(String transformtxtpath, String eventName) {
		String text = readTftxt(transformtxtpath);
		// 赋值给每一个节点一个id标识
		Map<String, Integer> nodeMap = new HashMap<String, Integer>();
		int headNum = 1;
		String[] line = text.split("\n");
		for (int i = 0; i < line.length; i++) {
			String[] Name = line[i].split("~");
			for (int j = 0; j < Name.length; j++) {
				if (!nodeMap.containsKey(Name[j])) {
					nodeMap.put(Name[j], headNum);
					headNum++;
				}
			}
		}
		// System.out.println("nodeMap: "+nodeMap.size());
		// System.out.println(JSON.toJSON(nodeMap));

		// 子节点对应的多个父节点id列表
		Map<String, Set<Integer>> nameIdMap = new HashMap<String, Set<Integer>>();
		for (int i = 0; i < line.length; i++) {
			String[] nameList = line[i].split("~");
			Set<Integer> headList = new HashSet<Integer>();
			headList.add(0);
			nameIdMap.put(nameList[0], headList);
			for (int j = 1; j < nameList.length; j++) {
				if (nameIdMap.containsKey(nameList[j])) {
					nameIdMap.get(nameList[j]).add(nodeMap.get(nameList[j - 1]));
				} else {
					Set<Integer> idList = new HashSet<Integer>();
					idList.add(nodeMap.get(nameList[j - 1]));
					nameIdMap.put(nameList[j], idList);
				}
			}
		}
		// System.out.println("--------------------"+nameIdMap);

		// 生成树状图
		Set<String> nameIdMapKeySet = nameIdMap.keySet();
		Map<Integer, TreeTest> map = new HashMap<Integer, TreeTest>();
		for (String name : nameIdMapKeySet) {
			Set<Integer> pIdList = nameIdMap.get(name);
			// System.out.println("name+pidList"+name +" "+pIdList);
			for (Integer id : pIdList) {
				TreeTest terr = new TreeTest(nodeMap.get(name), id, name);
				map.put(terr.getId(), terr);
			}
		}
		List<TreeTest> li = TreeTest.getChildren(map, 0, 1);

		// 包装根节点
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("name", eventName);
		resultMap.put("children", li);
		resultMap.put("id", -1);
		resultMap.put("pId", 0);
		// System.out.println(JSON.toJSON(resultMap));
		return JSON.toJSON(resultMap);
	}

	/**
	 * 读取传播路径的txt
	 * 
	 * @param transformtxtpath
	 *            传播路径的文件所在地
	 * @return 文本内容
	 */
	private String readTftxt(String transformtxtpath) {
		FileReader fr = null;
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();

		try {
			File f = new File(transformtxtpath);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String str;
			while ((str = br.readLine()) != null) {
				sb.append(str);
				sb.append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

}
