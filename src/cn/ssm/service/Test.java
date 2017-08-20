package cn.ssm.service;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> entityList = new ArrayList<String>(); //保存实体
		entityList.add("253727.txt");//  
		entityList.add("253722.txt");//  
		entityList.add("253724.txt");//  
		entityList.add("253727.txt");//  
		
		System.out.println(entityList);
		entityList.remove("253727.txt");
		System.out.println(entityList);

		
		 
	}
	 

}
