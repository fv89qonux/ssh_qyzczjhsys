package com.model;

/**
 * TWeixiu entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TWeixiu implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer sbid;
	private String wxsj;
	private String wxnr;
	private String wxr;
	private long wxje;
	private Integer zt;
	private String bz;

	private String sbbh;
	private String sbms;
	private String sblx;
	private String strZt;
	// Constructors

	/** default constructor */
	public TWeixiu() {
	}

	/** full constructor */
	public TWeixiu(Integer sbid, String wxsj, String wxnr, String wxr,
			long wxje, Integer zt, String bz) {
		this.sbid = sbid;
		this.wxsj = wxsj;
		this.wxnr = wxnr;
		this.wxr = wxr;
		this.wxje = wxje;
		this.zt = zt;
		this.bz = bz;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSbid() {
		return this.sbid;
	}

	public void setSbid(Integer sbid) {
		this.sbid = sbid;
	}

	public String getWxsj() {
		return this.wxsj;
	}

	public void setWxsj(String wxsj) {
		this.wxsj = wxsj;
	}

	public String getWxnr() {
		return this.wxnr;
	}

	public void setWxnr(String wxnr) {
		this.wxnr = wxnr;
	}

	public String getWxr() {
		return this.wxr;
	}

	public void setWxr(String wxr) {
		this.wxr = wxr;
	}

	public long getWxje() {
		return this.wxje;
	}

	public void setWxje(long wxje) {
		this.wxje = wxje;
	}
	
	public Integer getZt() {
		return zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getSbbh() {
		return sbbh;
	}

	public void setSbbh(String sbbh) {
		this.sbbh = sbbh;
	}

	public String getSbms() {
		return sbms;
	}

	public void setSbms(String sbms) {
		this.sbms = sbms;
	}

	public String getSblx() {
		return sblx;
	}

	public void setSblx(String sblx) {
		this.sblx = sblx;
	}

	public String getStrZt() {
		return strZt;
	}

	public void setStrZt(String strZt) {
		this.strZt = strZt;
	}
}