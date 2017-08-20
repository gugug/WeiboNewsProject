package cn.ssm.service;

import cn.ssm.po.Events;

public class LoadEvents {
	public static void main(String[] args) {
		loadData();
	}
	
	public static Events loadData(){
		String[] flist = MyFileUtil.getFileName("../dmhk/DataDocument");
		for(String f: flist){
			System.out.println(f);
		}
		return null;
		
	}

}
