package com.model;

/**
 * TJieyong entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TJieyong implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer xsid;
	private Integer sbid;
	private String jysj;
	private String ghsj;
	private Integer sfsh;
	private long pcje;
	private String bz;
	private Integer zt;		//状态 0:使用中 1:已归还

	
	private String sbbh;	//设备编号
	private String sbmc;	//设备名称
	private String lxmc;	//类型名称
	private String xsxm;	//学生姓名
	private String strZt;	//状态描述
	// Constructors

	/** default constructor */
	public TJieyong() {
	}

	/** full constructor */
	public TJieyong(Integer xsid, Integer sbid, String jysj, String ghsj,
			Integer sfsh, long pcje, String bz, Integer zt) {
		this.xsid = xsid;
		this.sbid = sbid;
		this.jysj = jysj;
		this.ghsj = ghsj;
		this.sfsh = sfsh;
		this.pcje = pcje;
		this.bz = bz;
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

	public String getJysj() {
		return this.jysj;
	}

	public void setJysj(String jysj) {
		this.jysj = jysj;
	}

	public String getGhsj() {
		return this.ghsj;
	}

	public void setGhsj(String ghsj) {
		this.ghsj = ghsj;
	}

	public Integer getSfsh() {
		return this.sfsh;
	}

	public void setSfsh(Integer sfsh) {
		this.sfsh = sfsh;
	}

	public long getPcje() {
		return this.pcje;
	}

	public void setPcje(long pcje) {
		this.pcje = pcje;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Integer getZt() {
		return this.zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
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

	public String getLxmc() {
		return lxmc;
	}

	public void setLxmc(String lxmc) {
		this.lxmc = lxmc;
	}

	public String getXsxm() {
		return xsxm;
	}

	public void setXsxm(String xsxm) {
		this.xsxm = xsxm;
	}

	public String getStrZt() {
		return strZt;
	}

	public void setStrZt(String strZt) {
		this.strZt = strZt;
	}
}