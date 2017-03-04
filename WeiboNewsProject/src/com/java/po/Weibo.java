package com.java.po;
/**
 * 微博的weibo表
 * @author iiip
 *
 */
public class Weibo {
	private int eventId;
	private String newsId;
	private String newsTitle;
	private String origin;
	private String content;
	private String releaseTime;
	private int likeNum;
	private int commentNum;
	private int repostNum;
	private String commentPath;
	private String repostPath;
	
	public Weibo() {
		super();
	}

	
	public Weibo(int eventId, String newsId, String newsTitle, String origin,
			String content, String releaseTime, int likeNum, int commentNum,
			int repostNum, String commentPath ,
			String repostPath) {
		super();
		this.eventId = eventId;
		this.newsId = newsId;
		this.newsTitle = newsTitle;
		this.origin = origin;
		this.content = content;
		this.releaseTime = releaseTime;
		this.likeNum = likeNum;
		this.commentNum = commentNum;
		this.repostNum = repostNum;
		this.commentPath = commentPath;
		this.repostPath = repostPath;
	}

	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getNewId() {
		return newsId;
	}
	public void setNewId(String newId) {
		this.newsId = newId;
	}
	
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	public int getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public int getRepostNum() {
		return repostNum;
	}
	public void setRepostNum(int repostNum) {
		this.repostNum = repostNum;
	}
	public String getCommentPath() {
		return commentPath;
	}
	public void setCommentPath(String commentPath) {
		this.commentPath = commentPath;
	}

	public String getRepostPath() {
		return repostPath;
	}
	public void setRepostPath(String repostPath) {
		this.repostPath = repostPath;
	}
	
	
 
}
