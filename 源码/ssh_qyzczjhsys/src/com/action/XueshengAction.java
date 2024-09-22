package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TXueshengDAO;
import com.model.TXuesheng;
import com.opensymphony.xwork2.ActionSupport;

public class XueshengAction extends ActionSupport {
	private TXueshengDAO TXueshengDAO;
	private TXuesheng xuesheng;
	
	private int id;
	private String zt;
	private String message;
	private String path;
	public TXueshengDAO getTXueshengDAO() {
		return TXueshengDAO;
	}
	public void setTXueshengDAO(TXueshengDAO xueshengDAO) {
		TXueshengDAO = xueshengDAO;
	}
	public TXuesheng getXuesheng() {
		return xuesheng;
	}
	public void setXuesheng(TXuesheng xuesheng) {
		this.xuesheng = xuesheng;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	public String xueshengAdd(){
		xuesheng.setDel("no");
		TXueshengDAO.save(xuesheng);
		
		this.setMessage("注册成功,请登录系统!");
		this.setPath("login.jsp");
		return "succeed";
	}
	
	public String xueshengMana(){
		List xsList = TXueshengDAO.findAll();
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xsList", xsList);
		return ActionSupport.SUCCESS;
	}
	
	public String ztChange(){
		String sql = "update TXuesheng set del='"+zt+"' where id="+id;
		TXueshengDAO.getHibernateTemplate().bulkUpdate(sql);
		
		this.setMessage("状态修改成功!");
		this.setPath("xueshengMana.action");
		return "succeed";
	}
	
	public String pwChange(){
		String sql = "update TXuesheng set loginPw='111111' where id="+id;
		TXueshengDAO.getHibernateTemplate().bulkUpdate(sql);
		
		this.setMessage("密码初始化成功!");
		this.setPath("xueshengMana.action");
		return "succeed";
	}
}
