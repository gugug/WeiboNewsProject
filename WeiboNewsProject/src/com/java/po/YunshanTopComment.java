package com.java.po;

/**
 * YunshanTopComment 类
 * @author iiip
 *
 */
public class YunshanTopComment {
	private int commentId;
	private int newsId ;
	private String commentContent;
	private String commentDatetime;
	private int commenGoodNum;
	private int emotionId;
	private int tid;
	
	
	public YunshanTopComment() {
		super();
	}

	public YunshanTopComment(int commentId, int newsId, String commentContent,
			String commentDatetime, int commenGoodNum, int emotionId, int tid) {
		super();
		this.commentId = commentId;
		this.newsId = newsId;
		this.commentContent = commentContent;
		this.commentDatetime = commentDatetime;
		this.commenGoodNum = commenGoodNum;
		this.emotionId = emotionId;
		this.tid = tid;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDatetime() {
		return commentDatetime;
	}

	public void setCommentDatetime(String commentDatetime) {
		this.commentDatetime = commentDatetime;
	}

	public int getCommenGoodNum() {
		return commenGoodNum;
	}

	public void setCommenGoodNum(int commenGoodNum) {
		this.commenGoodNum = commenGoodNum;
	}

	public int getEmotionId() {
		return emotionId;
	}

	public void setEmotionId(int emotionId) {
		this.emotionId = emotionId;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}
	

}
