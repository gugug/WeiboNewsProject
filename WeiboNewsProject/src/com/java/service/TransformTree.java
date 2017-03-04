package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.java.po.TransformObj;

public class TransformTree {
	
	//a,b,c,d,e,f,g,h
	
	public static void main(String[] args) {
		Map<String,Integer>  userMap = new HashMap<String,Integer>();
		TransformObj tobj = null;
		//记录位置
		userMap.put("a", 1);
		userMap.put("b", 2);

		//生成对象
		if(userMap.containsKey("b")){
			Integer id = userMap.get("b");
			if(id == 1){
				tobj = new TransformObj("b",id,0);
			}else{
				tobj = new TransformObj("b",id,userMap.get("a"));
			}

		}else{
			userMap.put("b", 1);
			tobj =  new TransformObj("b",1,0);
		}
		
		//保存节点  和  //对象列表   选一个
		HashMap<Integer, TransformObj> nodeMap = new HashMap<Integer,TransformObj>(); 
		nodeMap.put(tobj.getId(), tobj);
		
		//对象列表
		List<TransformObj> userList = new ArrayList<TransformObj>();
		userList.add(tobj);
		userList.add(new TransformObj("a",1,0));

		//生成树状图
        Map<Integer,TreeTest> map = new HashMap<Integer,TreeTest>();
		for (TransformObj userobj : userList){
	        TreeTest terr = new TreeTest(userobj.getId(),userobj.getpId(),userobj.getName());
	        map.put(terr.getId(), terr);
		}
        List<TreeTest> li = TreeTest. getChildren(map,0,1);
        
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("name", "根节点");
        resultMap.put("children", li);
        resultMap.put("id", -1);
        resultMap.put("pId", 0);
        
        System.out.println(JSON.toJSON(li));
        System.out.println(JSON.toJSON(resultMap));
		
	}

}
