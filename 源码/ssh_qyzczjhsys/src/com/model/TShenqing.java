package com.model;

/**
 * TShenqing entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TShenqing implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer xsid;
	private Integer sbid;
	private String sqsj;
	private String spsj;
	private String spyj;
	private Integer zt;		//0申请 1同意 2不同意 3完成借用

	private String xsxm;
	private String sbbh;
	private String sbmc;
	private String sblx;
	private String strZt;
	// Constructors

	/** default constructor */
	public TShenqing() {
	}

	/** full constructor */
	public TShenqing(Integer xsid, Integer sbid, String sqsj, String spsj,
					 String spyj,Integer zt) {
		this.xsid = xsid;
		this.sbid = sbid;
		this.sqsj = sqsj;
		this.spsj = spsj;
		this.spyj = spyj;
		this.zt = zt;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getXsid() {
		return this.xsid;
	}

	public void setXsid(Integer xsid) {
		this.xsid = xsid;
	}

	public Integer getSbid() {
		return this.sbid;
	}

	public void setSbid(Integer sbid) {
		this.sbid = sbid;
	}

	public String getSqsj() {
		return this.sqsj;
	}

	public void setSqsj(String sqsj) {
		this.sqsj = sqsj;
	}

	public String getSpyj() {
		return this.spyj;
	}

	public String getSpsj() {
		return spsj;
	}

	public void setSpsj(String spsj) {
		this.spsj = spsj;
	}

	public void setSpyj(String spyj) {
		this.spyj = spyj;
	}

	public Integer getZt() {
		return this.zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}

	public String getXsxm() {
		return xsxm;
	}

	public void setXsxm(String xsxm) {
		this.xsxm = xsxm;
	}

	public String getSbbh() {
		return sbbh;
	}

	public void setSbbh(String sbbh) {
		this.sbbh = sbbh;
	}

	public String getSbmc() {
		return sbmc;
	}

	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
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