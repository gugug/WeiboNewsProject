package com.java.po;
/**
 * YunshanReportPercent 此类表示事件的报道量
 * private String name; //报道的媒体name
 * private float y; //报道的数量
 * @author iiip
 *
 */
public class YunshanReportPercent {
	//报道的媒体name
	private String name;
	//报道的数量
	private float y;
	
	public YunshanReportPercent() {
		super();
	}
	public YunshanReportPercent(String name, float y) {
		super();
		this.name = name;
		this.y = y;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	
	

}
