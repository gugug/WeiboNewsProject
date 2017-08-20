package cn.ssm.service;

public class PathConfig {
	private static String RealPath = "D:\\javaEE\\workspace\\dmhk\\";
	private String eventsPath = RealPath + "DataDocument/data/事件";
	private String newsPath = RealPath + "DataDocument/data/新闻";
	private String entityEmoPath = RealPath + "DataDocument/data/实体与情感";
	private String labelPath = RealPath + "DataDocument/data/NewsLabel";
	private String commentsPath = RealPath + "DataDocument/data/Comments";
	
	public PathConfig() {
		super();
	}
	
	public String getRealPath() {
		return RealPath;
	}



	public void setRealPath(String realPath) {
		RealPath = realPath;
	}



	public String getEventsPath() {
		return eventsPath;
	}
	public void setEventsPath(String eventsPath) {
		this.eventsPath = eventsPath;
	}
	public String getNewsPath() {
		return newsPath;
	}
	public void setNewsPath(String newsPath) {
		this.newsPath = newsPath;
	}
	public String getEntityEmoPath() {
		return entityEmoPath;
	}
	public void setEntityEmoPath(String entityEmoPath) {
		this.entityEmoPath = entityEmoPath;
	}

	public String getLabelPath() {
		return labelPath;
	}

	public void setLabelPath(String labelPath) {
		this.labelPath = labelPath;
	}

	public String getCommentsPath() {
		return commentsPath;
	}

	public void setCommentsPath(String commentsPath) {
		this.commentsPath = commentsPath;
	}
	

}
