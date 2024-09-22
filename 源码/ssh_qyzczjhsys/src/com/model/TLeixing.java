package com.model;

/**
 * TLeixing entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TLeixing implements java.io.Serializable {

	// Fields

	private Integer id;
	private String miaoshu;
	private String qianzhui;
	private String del;

	// Constructors

	/** default constructor */
	public TLeixing() {
	}

	/** minimal constructor */
	public TLeixing(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TLeixing(Integer id, String miaoshu, 
					String qianzhui,String del) {
		this.id = id;
		this.miaoshu = miaoshu;
		this.qianzhui = qianzhui;
		this.del = del;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMiaoshu() {
		return this.miaoshu;
	}

	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}
	
	public String getQianzhui() {
		return qianzhui;
	}

	public void setQianzhui(String qianzhui) {
		this.qianzhui = qianzhui;
	}

	public String getDel() {
		return this.del;
	}

	public void setDel(String del) {
		this.del = del;
	}

}