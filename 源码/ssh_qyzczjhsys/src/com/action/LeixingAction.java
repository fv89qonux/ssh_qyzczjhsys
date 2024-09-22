package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TLeixingDAO;
import com.model.TLeixing;
import com.opensymphony.xwork2.ActionSupport;

public class LeixingAction extends ActionSupport {
	private TLeixingDAO TLeixingDAO;
	private TLeixing leixing;
	private String id;
	
	private String message;
	private String path;
	public TLeixingDAO getTLeixingDAO() {
		return TLeixingDAO;
	}
	public void setTLeixingDAO(TLeixingDAO leixingDAO) {
		TLeixingDAO = leixingDAO;
	}
	
	public TLeixing getLeixing() {
		return leixing;
	}
	public void setLeixing(TLeixing leixing) {
		this.leixing = leixing;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String leixingAdd(){
		leixing.setDel("no");
		TLeixingDAO.save(leixing);
		
		this.setMessage("类型添加成功!");
		this.setPath("leixingMana.action");
		return "succeed";
	}
	public String leixingUpd(){
		String sql = "update TLeixing set miaoshu='"+leixing.getMiaoshu()+"'," +
					 "qianzhui='"+leixing.getQianzhui()+"' " +
					 "where id = "+leixing.getId();
		
		TLeixingDAO.getHibernateTemplate().bulkUpdate(sql);
		this.setMessage("类型修改成功!");
		this.setPath("leixingMana.action");
		return "succeed";
	}
	public String leixingDel(){
		String sql = "update TLeixing set del='yes' where id = "+id;
		TLeixingDAO.getHibernateTemplate().bulkUpdate(sql);
		
		this.setMessage("类型删除成功!");
		this.setPath("leixingMana.action");
		return "succeed";
	}
	public String leixingMana(){
		String sql = "select id,miaoshu,qianzhui from TLeixing where del = 'no'";
		List retList = TLeixingDAO.getHibernateTemplate().find(sql);
		
		List lxList = new ArrayList();
		for(int i=0;i<retList.size();i++){
			Object[] obj = (Object[])retList.get(i);
			
			TLeixing lx = new TLeixing();
			lx.setId((Integer)obj[0]);
			lx.setMiaoshu((String)obj[1]);
			lx.setQianzhui((String)obj[2]);
			
			lxList.add(lx);
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("lxList", lxList);
		return ActionSupport.SUCCESS;
	}
}
