package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mongodb.util.JSON;

public class EventJson {
	public static void main(String[] args) {
		Map<String,List<String>> srcDstMap = new HashMap<String,List<String>>();
		
		List<String> dstList = new ArrayList<String>();
		List<String> dstList1 = new ArrayList<String>();
		dstList.add("b");
		dstList.add("c");
		dstList.add("d");
		dstList.add("e");
		dstList.add("f");
		srcDstMap.put("A", dstList);
		
		dstList1.add("g");
		dstList1.add("h");
		dstList1.add("i");
		dstList1.add("j");
		
		srcDstMap.put("K", dstList1);
		
		List<String> dstList2 = new ArrayList<String>();

		srcDstMap.put("b", dstList2);
		srcDstMap.put("c", dstList2);
		srcDstMap.put("d", dstList2);
		srcDstMap.put("e", dstList2);
		srcDstMap.put("f", dstList2);
		srcDstMap.put("g", dstList2);
		srcDstMap.put("h", dstList2);
		srcDstMap.put("i", dstList2);
		srcDstMap.put("j", dstList2);

		
		Set<String> nodesKeySet = srcDstMap.keySet();
		
		
		List<Map<String, String>> nodekList = new ArrayList<Map<String, String>>();
		List<Map<String, Object>> linkList = new ArrayList<Map<String, Object>>();

		for (String node : nodesKeySet){
			HashMap<String, String> nodeMap = new HashMap<String,String>();
			nodeMap.put("name", node);
			nodekList.add(nodeMap);
			
			List<String> nodeDstlist = srcDstMap.get(node);
			for (String dst : nodeDstlist){
				HashMap<String, Object> srcdst = new HashMap<String,Object>();
				srcdst.put("source", node);
				srcdst.put("target", dst);
				srcdst.put("value", 0.1);
				linkList.add(srcdst);
			}
		}
		
		HashMap<String, Object> resultMap  = new HashMap<String,Object>();
		resultMap.put("nodes", nodekList);
		resultMap.put("links", linkList);
		System.out.println(resultMap);
		System.out.println(JSON.serialize(resultMap));
		
		
		
		
//		List<Map<String,Object>> transformList = new ArrayList<Map<String,Object>>();
//		for(String node :nodesKeySet){
//			
//		}
		
	}

}
