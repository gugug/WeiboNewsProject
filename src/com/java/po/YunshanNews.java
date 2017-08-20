package com.java.po;
/**
 * YunshanNews 新闻类
 * @author iiip
 *
 */
public class YunshanNews {
	private Integer newsId;
	private Integer newsWebId;
	private String newsWebType;
	private String newsUrl;
	private String newsTitle;
	private String newsContent;
	private String newsDatetime;
	private String newsSource;
	private String newsSourceUrl;
	private String newsImageUrl;
	private String newsAuthor;
	private String newsArgs;
	
	public YunshanNews() {
		super();
	}

	public YunshanNews(Integer newsId, Integer newsWebId, String newsWebType,
			String newsUrl, String newsTitle, String newsContent,
			String newsDatetime, String newsSource, String newsSourceUrl,
			String newsImageUrl, String newsAuthor, String newsArgs) {
		super();
		this.newsId = newsId;
		this.newsWebId = newsWebId;
		this.newsWebType = newsWebType;
		this.newsUrl = newsUrl;
		this.newsTitle = newsTitle;
		this.newsContent = newsContent;
		this.newsDatetime = newsDatetime;
		this.newsSource = newsSource;
		this.newsSourceUrl = newsSourceUrl;
		this.newsImageUrl = newsImageUrl;
		this.newsAuthor = newsAuthor;
		this.newsArgs = newsArgs;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public Integer getNewsWebId() {
		return newsWebId;
	}

	public void setNewsWebId(Integer newsWebId) {
		this.newsWebId = newsWebId;
	}

	public String getNewsWebType() {
		return newsWebType;
	}

	public void setNewsWebType(String newsWebType) {
		this.newsWebType = newsWebType;
	}

	public String getNewsUrl() {
		return newsUrl;
	}

	public void setNewsUrl(String newsUrl) {
		this.newsUrl = newsUrl;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getNewsDatetime() {
		return newsDatetime;
	}

	public void setNewsDatetime(String newsDatetime) {
		this.newsDatetime = newsDatetime;
	}

	public String getNewsSource() {
		return newsSource;
	}

	public void setNewsSource(String newsSource) {
		this.newsSource = newsSource;
	}

	public String getNewsSourceUrl() {
		return newsSourceUrl;
	}

	public void setNewsSourceUrl(String newsSourceUrl) {
		this.newsSourceUrl = newsSourceUrl;
	}

	public String getNewsImageUrl() {
		return newsImageUrl;
	}

	public void setNewsImageUrl(String newsImageUrl) {
		this.newsImageUrl = newsImageUrl;
	}

	public String getNewsAuthor() {
		return newsAuthor;
	}

	public void setNewsAuthor(String newsAuthor) {
		this.newsAuthor = newsAuthor;
	}

	public String getNewsArgs() {
		return newsArgs;
	}

	public void setNewsArgs(String newsArgs) {
		this.newsArgs = newsArgs;
	}

}
