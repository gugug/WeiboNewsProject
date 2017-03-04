package com.java.po;

/**
 * YunshanEvaluationObject 评价对象类
 * @author iiip
 *
 */
public class YunshanEvaluationObject {
	
	private int evaluationObjectId;
	private String evaluationObjectName;
	private float pasitiveNum;
	private float negativeNum;
	
	public YunshanEvaluationObject() {
		super();
	}

	public YunshanEvaluationObject(int evaluationObjectId,
			String evaluationObjectName, float pasitiveNum, float negativeNum) {
		super();
		this.evaluationObjectId = evaluationObjectId;
		this.evaluationObjectName = evaluationObjectName;
		this.pasitiveNum = pasitiveNum;
		this.negativeNum = negativeNum;
	}

	public int getEvaluationObjectId() {
		return evaluationObjectId;
	}

	public void setEvaluationObjectId(int evaluationObjectId) {
		this.evaluationObjectId = evaluationObjectId;
	}

	public String getEvaluationObjectName() {
		return evaluationObjectName;
	}

	public void setEvaluationObjectName(String evaluationObjectName) {
		this.evaluationObjectName = evaluationObjectName;
	}

	public float getPasitiveNum() {
		return pasitiveNum;
	}

	public void setPasitiveNum(float pasitiveNum) {
		this.pasitiveNum = pasitiveNum;
	}

	public float getNegativeNum() {
		return negativeNum;
	}

	public void setNegativeNum(float negativeNum) {
		this.negativeNum = negativeNum;
	}

}
