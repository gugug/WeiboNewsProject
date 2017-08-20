package com.java.po;

import java.util.List;

/**
 * 前端的8条折线图 -- 话题下情感随时间的折线图
 * 两个列表，时间列表一一对应情感的评论的列表
 * @author iiip
 *
 */

//class Report{
//	public String name;
//	public List<Integer> data;
//	public Report(String name, List<Integer> data) {
//		super();
//		this.name = name;
//		this.data = data;
//	}
//	
//}

public class YunshanEmoCommNumWithTime {
	private List<String> date;
	private List<Report> report;
	
	public static class Report{
		public String name;
		public List<Integer> data;
		public Report(String name, List<Integer> data) {//用来标记对应情感下的评论量
			super();
			this.name = name;
			this.data = data;
		}
		
	}
	
	public YunshanEmoCommNumWithTime() {
		super();
	}

	
	public YunshanEmoCommNumWithTime(List<String> date, List<Report> report) {
		super();
		this.date = date;
		this.report = report;
	}

	public List<String> getDate() {
		return date;
	}

	public void setDate(List<String> date) {
		this.date = date;
	}

	public List<Report> getReport() {
		return report;
	}

	public void setReport(List<Report> report) {
		this.report = report;
	}

}
