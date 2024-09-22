package com.model;

/**
 * TXuesheng entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TXuesheng implements java.io.Serializable {

	// Fields

	private Integer id;
	private String xingming;
	private String xingbie;
	private String xuehao;
	private String loginName;
	private String loginPw;
	private String del;

	// Constructors

	/** default constructor */
	public TXuesheng() {
	}

	/** full constructor */
	public TXuesheng(String xingming, String xingbie, String xuehao,
			String loginName, String loginPw, String del) {
		this.xingming = xingming;
		this.xingbie = xingbie;
		this.xuehao = xuehao;
		this.loginName = loginName;
		this.loginPw = loginPw;
		this.del = del;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getXingming() {
		return this.xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}

	public String getXingbie() {
		return this.xingbie;
	}

	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}

	public String getXuehao() {
		return this.xuehao;
	}

	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPw() {
		return this.loginPw;
	}

	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}

	public String getDel() {
		return this.del;
	}

	public void setDel(String del) {
		this.del = del;
	}

}