package com.java.po;
/**
 * 微博的event表
 * @author iiip
 *
 */
public class Event {
	
	private int eventId;
	private String eventTitle;
	private String explosionTime;
	private String keyWord;
	private int totalLikeNum;
	private int totalCommentNum;
	private int totalRepostNum;
	
	public Event() {
		super();
	}

	public Event(int eventId, String eventTitle, String explosionTime,
			String keyWord, int totalLikeNum, int totalCommentNum,
			int totalRepostNum) {
		super();
		this.eventId = eventId;
		this.eventTitle = eventTitle;
		this.explosionTime = explosionTime;
		this.keyWord = keyWord;
		this.totalLikeNum = totalLikeNum;
		this.totalCommentNum = totalCommentNum;
		this.totalRepostNum = totalRepostNum;
	}



	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getExplosionTime() {
		return explosionTime;
	}

	public void setExplosionTime(String explosionTime) {
		this.explosionTime = explosionTime;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public int getTotalLikeNum() {
		return totalLikeNum;
	}

	public void setTotalLikeNum(int totalLikeNum) {
		this.totalLikeNum = totalLikeNum;
	}

	public int getTotalCommentNum() {
		return totalCommentNum;
	}

	public void setTotalCommentNum(int totalCommentNum) {
		this.totalCommentNum = totalCommentNum;
	}

	public int getTotalRepostNum() {
		return totalRepostNum;
	}

	public void setTotalRepostNum(int totalRepostNum) {
		this.totalRepostNum = totalRepostNum;
	}

}
