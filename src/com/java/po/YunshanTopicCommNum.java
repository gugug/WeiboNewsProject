package com.java.po;

import java.util.List;
/**
 * YunshanTopicCommNum 话题评论随时间的变化的封装类，两个类表，位置一一对应
 * @author iiip
 *
 */
public class YunshanTopicCommNum {
	private List<String> date; //时间列表
	private List<Integer> number; //评论数量

	public YunshanTopicCommNum() {
		super();
	}

	public YunshanTopicCommNum(List<String> date, List<Integer> number) {
		super();
		this.date = date;
		this.number = number;
	}

	public List<String> getDate() {
		return date;
	}

	public void setDate(List<String> date) {
		this.date = date;
	}

	public List<Integer> getNumber() {
		return number;
	}

	public void setNumber(List<Integer> number) {
		this.number = number;
	}

}
