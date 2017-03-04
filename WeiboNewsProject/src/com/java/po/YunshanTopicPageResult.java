package com.java.po;

import java.util.List;
/**
 * 封装YunshanTopic页面的json结果集
 * @author iiip
 *
 */
public class YunshanTopicPageResult {
	private YunshanEvent basic;
	private List<YunshanTopic> topics;
	private List<YunshanReportPercent> report_percent;
	private List<YunshanEmotionPercent> emotion_percent;
	private YunshanKeyword keywords;
	private YunshanEventReportNum report_num;
	
	public YunshanTopicPageResult() {
		super();
	}

	public YunshanTopicPageResult(YunshanEvent basic,
			List<YunshanTopic> topics,
			List<YunshanReportPercent> report_percent,
			List<YunshanEmotionPercent> emotion_percent,
			YunshanKeyword keywords, YunshanEventReportNum report_num) {
		super();
		this.basic = basic;
		this.topics = topics;
		this.report_percent = report_percent;
		this.emotion_percent = emotion_percent;
		this.keywords = keywords;
		this.report_num = report_num;
	}

	public YunshanEvent getBasic() {
		return basic;
	}

	public void setBasic(YunshanEvent basic) {
		this.basic = basic;
	}

	public List<YunshanTopic> getTopics() {
		return topics;
	}

	public void setTopics(List<YunshanTopic> topics) {
		this.topics = topics;
	}

	public List<YunshanReportPercent> getReport_percent() {
		return report_percent;
	}

	public void setReport_percent(List<YunshanReportPercent> report_percent) {
		this.report_percent = report_percent;
	}

	public List<YunshanEmotionPercent> getEmotion_percent() {
		return emotion_percent;
	}

	public void setEmotion_percent(List<YunshanEmotionPercent> emotion_percent) {
		this.emotion_percent = emotion_percent;
	}

	public YunshanKeyword getKeywords() {
		return keywords;
	}

	public void setKeywords(YunshanKeyword keywords) {
		this.keywords = keywords;
	}

	public YunshanEventReportNum getReport_num() {
		return report_num;
	}

	public void setReport_num(YunshanEventReportNum report_num) {
		this.report_num = report_num;
	}
	

}
