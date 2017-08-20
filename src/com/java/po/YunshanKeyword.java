package com.java.po;

import java.util.ArrayList;

/**
 * YunshanKeyword 类
 * 两个列表，关键词表一一对应词重表
 * @author iiip
 */
public class YunshanKeyword {
	private ArrayList<String> wordsList;
	private ArrayList<Float> weightList;

	public YunshanKeyword() {
		super();
	}

	public YunshanKeyword(ArrayList<String> wordsList,
			ArrayList<Float> weightList) {
		super();
		this.wordsList = wordsList;
		this.weightList = weightList;
	}

	public ArrayList<String> getWordsList() {
		return wordsList;
	}

	public void setWordsList(ArrayList<String> wordsList) {
		this.wordsList = wordsList;
	}

	public ArrayList<Float> getWeightList() {
		return weightList;
	}

	public void setWeightList(ArrayList<Float> weightList) {
		this.weightList = weightList;
	}

}
