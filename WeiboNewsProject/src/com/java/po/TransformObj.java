package com.java.po;

/**
 * 用于生成传播链路的json数据的封装类
 * @author iiip
 *
 */
public class TransformObj {
	private String name;
	private Integer id;
    private Integer pId ;
    
	public TransformObj() {
		super();
	}
	
	public TransformObj(String name, Integer id, Integer pId) {
		super();
		this.name = name;
		this.id = id;
		this.pId = pId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}

}
