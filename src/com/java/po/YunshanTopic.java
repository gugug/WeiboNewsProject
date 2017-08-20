package com.java.po;

/**
 * YunshanTopic 话题类
 * @author iiip
 *
 */
public class YunshanTopic {
	
	private Integer topicId;
	private String topicSummary;
	private float topicHotWeight;
	private String topicName;
	private boolean isHot;
	private String topicDatetime;
	private String topicImgUrl;
	
	
	public YunshanTopic() {
		super();
	}

	public YunshanTopic(Integer topicId, String topicSummary,
			float topicHotWeight, String topicName, boolean isHot,
			String topicDatetime,String topicImgUrl) {
		super();
		this.topicId = topicId;
		this.topicSummary = topicSummary;
		this.topicHotWeight = topicHotWeight;
		this.topicName = topicName;
		this.isHot = isHot;
		this.topicDatetime = topicDatetime;
		this.topicImgUrl = topicImgUrl;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getTopicSummary() {
		return topicSummary;
	}

	public void setTopicSummary(String topicSummary) {
		this.topicSummary = topicSummary;
	}

	public float getTopicHotWeight() {
		return topicHotWeight;
	}

	public void setTopicHotWeight(float topicHotWeight) {
		this.topicHotWeight = topicHotWeight;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public boolean getIsHot() {
		return isHot;
	}

	public void setIsHot(boolean isHot) {
		this.isHot = isHot;
	}

	public String getTopicDatetime() {
		return topicDatetime;
	}

	public void setTopicDatetime(String topicDatetime) {
		this.topicDatetime = topicDatetime;
	}

	public String getTopicImgUrl() {
		return topicImgUrl;
	}

	public void setTopicImgUrl(String topicImgUrl) {
		this.topicImgUrl = topicImgUrl;
	}
	
}
