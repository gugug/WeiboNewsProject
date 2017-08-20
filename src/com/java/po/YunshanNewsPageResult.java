package com.java.po;

import java.util.List;
/**
 * YunshanNews页面的封装json结果集
 * @author iiip
 *
 */
public class YunshanNewsPageResult {
	private YunshanTopic basic;
	private List<YunshanNews> news_links;
	private List<YunshanEvaluationObject> standby;
	private YunshanTopicCommNum comment_num;
	private List<YunshanEmotionPercent> emotion_percent;
	private YunshanEmoCommNumWithTime emocomm_num;

	public YunshanNewsPageResult() {
		super();
	}

	public YunshanNewsPageResult(YunshanTopic basic,
			List<YunshanNews> news_links,
			List<YunshanEvaluationObject> standby,
			YunshanTopicCommNum comment_num,
			List<YunshanEmotionPercent> emotion_percent,
			YunshanEmoCommNumWithTime emocomm_num) {
		super();
		this.basic = basic;
		this.news_links = news_links;
		this.standby = standby;
		this.comment_num = comment_num;
		this.emotion_percent = emotion_percent;
		this.emocomm_num = emocomm_num;
	}


	public YunshanTopic getBasic() {
		return basic;
	}

	public void setBasic(YunshanTopic basic) {
		this.basic = basic;
	}

	public List<YunshanNews> getNews_links() {
		return news_links;
	}

	public void setNews_links(List<YunshanNews> news_links) {
		this.news_links = news_links;
	}

	public List<YunshanEvaluationObject> getStandby() {
		return standby;
	}

	public void setStandby(List<YunshanEvaluationObject> standby) {
		this.standby = standby;
	}

	public YunshanTopicCommNum getComment_num() {
		return comment_num;
	}

	public void setComment_num(YunshanTopicCommNum comment_num) {
		this.comment_num = comment_num;
	}

	public List<YunshanEmotionPercent> getEmotion_percent() {
		return emotion_percent;
	}

	public void setEmotion_percent(List<YunshanEmotionPercent> emotion_percent) {
		this.emotion_percent = emotion_percent;
	}

	public YunshanEmoCommNumWithTime getEmocomm_num() {
		return emocomm_num;
	}

	public void setEmocomm_num(YunshanEmoCommNumWithTime emocomm_num) {
		this.emocomm_num = emocomm_num;
	}

}
