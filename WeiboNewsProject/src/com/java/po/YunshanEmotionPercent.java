package com.java.po;

/**
 * 情感比例类
 * private int id; 情感id
 * private String name;情感名字
 * private float y;情感比例值
 * @author iiip
 *
 */
public class YunshanEmotionPercent {
	private int id;
	private String name;
	private float y;

	public YunshanEmotionPercent() {
		super();
	}

	public YunshanEmotionPercent(int id, String name, float y) {
		super();
		this.id = id;
		this.name = name;
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
