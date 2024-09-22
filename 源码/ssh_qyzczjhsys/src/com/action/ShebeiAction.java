package com.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.dao.TLeixingDAO;
import com.dao.TShebeiDAO;
import com.dto.TShebeiDTO;
import com.model.TLeixing;
import com.model.TShebei;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.ExcelUtil;
import com.util.ResponseUtil;

public class ShebeiAction extends ActionSupport {
	private TShebeiDAO TShebeiDAO;
	private TLeixingDAO TLeixingDAO;
	private TShebei shebei;
	private String id;
	
	private String message;
	private String path;
	private String fujian;
	
	public String getFujian() {
		return fujian;
	}
	/**
	 * @param fujian the fujian to set
	 */
	public void setFujian(String fujian) {
		this.fujian = fujian;
	}
	public TShebeiDAO getTShebeiDAO() {
		return TShebeiDAO;
	}
	public void setTShebeiDAO(TShebeiDAO shebeiDAO) {
		TShebeiDAO = shebeiDAO;
	}
	public TLeixingDAO getTLeixingDAO() {
		return TLeixingDAO;
	}
	public void setTLeixingDAO(TLeixingDAO leixingDAO) {
		TLeixingDAO = leixingDAO;
	}
	public TShebei getShebei() {
		return shebei;
	}
	public void setShebei(TShebei shebei) {
		this.shebei = shebei;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	
	public String toAddShebei()
	{
		List lxList = getLxList();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("lxList", lxList);
		
		return "toAdd";
	}
	
	public String shebeiAdd()
	{
		//shebei.setFujian(fujian);
		shebei.setZt(0);
		shebei.setDel("no");
		shebei.setFujian(fujian);
		TShebeiDAO.save(shebei);
		
		this.setMessage("设备添加成功!");
		this.setPath("shebeiMana.action");
		return "succeed";
	}
	
	public String toEditShebei()
	{
		TShebei shebei = TShebeiDAO.findById(Integer.parseInt(id));
		
		List lxList = getLxList();
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		request.put("sbInfo", shebei);
		request.put("lxList", lxList);
		
		return "toEdit";
	}
	
	public String shebeiUpd()
	{
		shebei.setZt(0);
		shebei.setDel("no");
		TShebeiDAO.getHibernateTemplate().update(shebei);
		
		this.setMessage("设备修改成功!");
		this.setPath("shebeiMana.action");
		return "succeed";
	}
	
	public String shebeiDel()
	{
		String sql = "update TShebei set del='yes' where id = "+id;
		TShebeiDAO.getHibernateTemplate().bulkUpdate(sql);
		
		this.setMessage("设备删除成功!");
		this.setPath("shebeiMana.action");
		return "succeed";
	}
	
	public String shebeiMana()
	{
		List sbList = new ArrayList();
		
		String sql = "select ta.id,ta.bh,ta.miaoshu,ta.goumaishijian,tc.miaoshu," +
					 "case zt when 0 then '空闲' when 1 then '已外借' when 2 then '维修中' end strzt,ta.zt " +
					 "from t_shebei ta,t_leixing tc where ta.lxid = tc.id and ta.del = 'no'";
		
		Session sqlSession = TShebeiDAO.getSessionFactory().openSession();
		SQLQuery sqlQuery = sqlSession.createSQLQuery(sql);
		List objList = sqlQuery.list();
		for (Object object : objList) {
			Object[] obj = (Object[])object;
			
			TShebei sb = new TShebei();
			
			sb.setId((Integer)obj[0]);
			sb.setBh((String)obj[1]);
			sb.setMiaoshu((String)obj[2]);
			sb.setGoumaishijian((String)obj[3]);
			sb.setStrLx((String)obj[4]);
			sb.setStrZt((String)obj[5]);
			sb.setZt((Integer)obj[6]);
			
			sbList.add(sb);
		}
		sqlSession.close();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("sbList", sbList);
		return ActionSupport.SUCCESS;
	}
	
	public String toJieyong()
	{
		ActionContext ctx = ActionContext.getContext();       
    
	HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
	
	String sbbh = request.getParameter("sbbh")==null?"":request.getParameter("sbbh");
	String sbmc = request.getParameter("sbmc")==null?"":request.getParameter("sbmc");
	
		//String soushuo=
		List sbList = new ArrayList();
		String sql = "select ta.id,ta.bh,ta.miaoshu,ta.goumaishijian,tb.miaoshu lx " +
					 "from t_shebei ta,t_leixing tb where ta.lxid = tb.id and ta.del = 'no' and ta.zt=0 ";
		if(!("".equals(sbbh.trim()))){
			sql += " and ta.bh like '%"+sbbh+"%'";
		}
		if(!("".equals(sbmc.trim()))){
			sql += " and ta.miaoshu like '%"+sbmc+"%'";
		}
		Session sqlSession = TShebeiDAO.getSessionFactory().openSession();
		SQLQuery sqlQuery = sqlSession.createSQLQuery(sql);
		List objList = sqlQuery.list();
		for (Object object : objList) {
			Object[] obj = (Object[])object;
			
			TShebei sb = new TShebei();
			
			sb.setId((Integer)obj[0]);
			sb.setBh((String)obj[1]);
			sb.setMiaoshu((String)obj[2]);
			sb.setGoumaishijian((String)obj[3]);
			sb.setStrLx((String)obj[4]);
			
			sbList.add(sb);
		}
		sqlSession.close();
		//Map request=(Map)ServletActionContext.getContext().get("request");
		request.setAttribute("sbbh", sbbh);		
		request.setAttribute("sbmc", sbmc);	
		request.setAttribute("sbList", sbList);
		return "toJieyong";
	}
	
	public String shebeiQuery()
	{
		ActionContext ctx = ActionContext.getContext();       
	      
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
		
		String sbbh = request.getParameter("sbbh")==null?"":request.getParameter("sbbh");
		String sbmc = request.getParameter("sbmc")==null?"":request.getParameter("sbmc");
		
		List sbList = new ArrayList();
		
		String sql = "select ta.id,ta.bh,ta.miaoshu,ta.goumaishijian,tb.miaoshu lx," +
					 "case zt when 0 then '空闲' when 1 then '已外借' when 2 then '维修中' end strzt,ta.zt " +
					 "from t_shebei ta,t_leixing tb where ta.lxid = tb.id and ta.del = 'no'";
		if(!("".equals(sbbh.trim()))){
			sql += " and ta.bh like '%"+sbbh+"%'";
		}
		if(!("".equals(sbmc.trim()))){
			sql += " and ta.miaoshu like '%"+sbmc+"%'";
		}
		
		Session sqlSession = TShebeiDAO.getSessionFactory().openSession();
		SQLQuery sqlQuery = sqlSession.createSQLQuery(sql);
		List objList = sqlQuery.list();
		for (Object object : objList) {
			Object[] obj = (Object[])object;
			
			TShebei sb = new TShebei();
			
			sb.setId((Integer)obj[0]);
			sb.setBh((String)obj[1]);
			sb.setMiaoshu((String)obj[2]);
			sb.setGoumaishijian((String)obj[3]);
			sb.setStrLx((String)obj[4]);
			sb.setStrZt((String)obj[5]);
			sb.setZt((Integer)obj[6]);
			
			sbList.add(sb);
		}
		sqlSession.close();
		request.setAttribute("sbbh", sbbh);		
		request.setAttribute("sbmc", sbmc);		
		request.setAttribute("sbList", sbList);		
		return "shebeiQuery";
	}
	
	
	public void shebeiExport()
	{
		ActionContext ctx = ActionContext.getContext();       
	      
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
		List<TShebeiDTO> sbList = new ArrayList<TShebeiDTO>();
		
		String sql = "select ta.id,ta.bh,ta.miaoshu,ta.goumaishijian,tb.miaoshu lx," +
					 "case zt when 0 then '空闲' when 1 then '已外借' when 2 then '维修中' end strzt,ta.zt " +
					 "from t_shebei ta,t_leixing tb where ta.lxid = tb.id and ta.del = 'no'";

		Session sqlSession = TShebeiDAO.getSessionFactory().openSession();
		SQLQuery sqlQuery = sqlSession.createSQLQuery(sql);
		List objList = sqlQuery.list();
		for (Object object : objList) {
			Object[] obj = (Object[])object;
			TShebeiDTO sb = new TShebeiDTO();
			sb.setId((Integer)obj[0]);
			sb.setBh((String)obj[1]);
			sb.setMiaoshu((String)obj[2]);
			sb.setGoumaishijian((String)obj[3]);
			sb.setStrLx((String)obj[4]);
			sb.setStrZt((String)obj[5]);			
			sbList.add(sb);
		}
		Workbook wb;
		try {
			wb = ExcelUtil.fillExcelDataWithTemplate(sbList, "shebeiTemp.xls");
			ResponseUtil.export(ServletActionContext.getResponse(), wb, "shebei.xls");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sqlSession.close();        
	}
	
	private List getLxList(){
		String sql = "select id,miaoshu,qianzhui from TLeixing where del = 'no'";
		List retList = TLeixingDAO.getHibernateTemplate().find(sql);
		
		List lxList = new ArrayList();
		TLeixing lx = new TLeixing();
		lx.setId(-1);
		lx.setMiaoshu("请选择");
		lxList.add(0,lx);
		
		
		for(int i=0;i<retList.size();i++){
			Object[] obj = (Object[])retList.get(i);
			
			lx = new TLeixing();
			lx.setId((Integer)obj[0]);
			lx.setMiaoshu((String)obj[1]);
			
			lxList.add(i+1,lx);
		}
		return lxList;
	}
	/**
	 * @return the fujian
	 */
	
}
