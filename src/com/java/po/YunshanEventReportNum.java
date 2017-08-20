package com.java.po;

import java.util.List;
/**
 * YunshanEventReportNum类，媒体的报道数量类，
 * 两个列表， 时间列表一一对应报道数量表
 * @author iiip
 *
 */
public class YunshanEventReportNum {
	private List<String> date; //时间类表
	private List<Integer> report_data; //报道数量列表

	public YunshanEventReportNum() {
		super();
	}

	public YunshanEventReportNum(List<String> date, List<Integer> report_data) {
		super();
		this.date = date;
		this.report_data = report_data;
	}

	public List<String> getDate() {
		return date;
	}

	public void setDate(List<String> date) {
		this.date = date;
	}

	public List<Integer> getReport_data() {
		return report_data;
	}

	public void setReport_data(List<Integer> report_data) {
		this.report_data = report_data;
	}

}
