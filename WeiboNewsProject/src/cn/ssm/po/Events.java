package cn.ssm.po;

import java.util.List;

public class Events {
	private String id;
	private String title;
	private List<String> news;
	
	public Events() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * //获取相关新闻
	 * @return List<String> 相关新闻的列表
	 */
	public List<String> getNews() {
		return news;
	}

	public void setNews(List<String> news) {
		this.news = news;
	}
	
	
	
}
