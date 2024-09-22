package com.model;

/**
 * TShebei entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TShebei implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer lxid;
	private String bh;
	private String miaoshu;
	private String goumaishijian;
	private Integer zt;
	private String del;
	private String fujian;
	private String strLx;	//类型中文描述
	private String strZt;	//状态中文描述
	// Constructors

	/** default constructor */
	public TShebei() {
	}

	/** minimal constructor */
	public TShebei(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TShebei(Integer id, Integer lxid, String bh, String miaoshu,
			String goumaishijian,String fujian,Integer zt, String del) {
		this.id = id;
		this.lxid = lxid;
		this.bh = bh;
		this.miaoshu = miaoshu;
		this.goumaishijian = goumaishijian;
		//this.fujian = fujian;
		this.zt = zt;
		this.del = del;
		
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLxid() {
		return this.lxid;
	}

	public void setLxid(Integer lxid) {
		this.lxid = lxid;
	}

	public String getBh() {
		return this.bh;
	}

	public void setBh(String bh) {
		this.bh = bh;
	}

	public String getMiaoshu() {
		return this.miaoshu;
	}

	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}

	public String getGoumaishijian() {
		return this.goumaishijian;
	}

	public void setGoumaishijian(String goumaishijian) {
		this.goumaishijian = goumaishijian;
	}

	public Integer getZt() {
		return zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}

	public String getDel() {
		return del;
	}

	public void setDel(String del) {
		this.del = del;
	}

	public String getStrLx() {
		return strLx;
	}

	public void setStrLx(String strLx) {
		this.strLx = strLx;
	}

	public String getStrZt() {
		return strZt;
	}

	public void setStrZt(String strZt) {
		this.strZt = strZt;
	}

	/**
	 * @return the fujian
	 */
	public String getFujian() {
		return fujian;
	}

	/**
	 * @param fujian the fujian to set
	 */
	public void setFujian(String fujian) {
		this.fujian = fujian;
	}

	
}