package com.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.dao.TShebeiDAO;
import com.dao.TJianceDAO;
import com.model.TShebei;
import com.model.TJiance;
import com.opensymphony.xwork2.ActionSupport;

public class JianceAction extends ActionSupport {
	private TJianceDAO TJianceDAO;
	private TShebeiDAO TShebeiDAO;
	private TJiance jiance;
	
	private int id;
	private int sbid;
	
	private String message;
	private String path;
	public TJianceDAO getTJianceDAO() {
		return TJianceDAO;
	}

	public void setTJianceDAO(TJianceDAO jianceDAO) {
		TJianceDAO = jianceDAO;
	}

	public TShebeiDAO getTShebeiDAO() {
		return TShebeiDAO;
	}

	public void setTShebeiDAO(TShebeiDAO shebeiDAO) {
		TShebeiDAO = shebeiDAO;
	}


	public TJiance getJiance() {
		return jiance;
	}

	public void setJiance(TJiance jiance) {
		this.jiance = jiance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSbid() {
		return sbid;
	}

	public void setSbid(int sbid) {
		this.sbid = sbid;
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

	public String toJianceMana()
	{
		List sbList = new ArrayList();
		String sql = "select tb.id,tb.bh,tb.miaoshu,tc.miaoshu lx,tb.goumaishijian " +
					 "from t_shebei tb,t_leixing tc " +
					 "where tb.lxid=tc.id";
		
		Session sqlSession = TShebeiDAO.getSessionFactory().openSession();
		SQLQuery sqlQuery = sqlSession.createSQLQuery(sql);
		List objList = sqlQuery.list();
		for (Object object : objList) {
			Object[] obj = (Object[])object;
			
			TShebei sb = new TShebei();
			sb.setId((Integer)obj[0]);
			sb.setBh((String)obj[1]);
			sb.setMiaoshu((String)obj[2]);
			sb.setStrLx((String)obj[3]);
			sb.setGoumaishijian((String)obj[4]);
			
			sbList.add(sb);
		}
		sqlSession.close();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("sbList", sbList);
		return ActionSupport.SUCCESS;
	}
	
	public String toJianceAdd()
	{
		TShebei shebei = new TShebei();
		
		String sql = "select tb.id,tb.bh,tb.miaoshu,tc.miaoshu lx " +
		 		 	 "from t_shebei tb,t_leixing tc " +
		 		 	 "where tb.lxid=tc.id and tb.id="+sbid;

		Session sqlSession = TShebeiDAO.getSessionFactory().openSession();
		SQLQuery sqlQuery = sqlSession.createSQLQuery(sql);
		List objList = sqlQuery.list();
		for (Object object : objList) {
			Object[] obj = (Object[])object;
			
			shebei.setId((Integer)obj[0]);
			shebei.setBh((String)obj[1]);
			shebei.setMiaoshu((String)obj[2]);
			shebei.setStrLx((String)obj[3]);
		}
		sqlSession.close();		
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("sbInfo", shebei);
		return "toJianceAdd";
	}
	
	public String jianceUpd()
	{
		jiance.setZt(1);
		TJianceDAO.save(jiance);
		
		/*TShebei sb = TShebeiDAO.findById(jiance.getSbid());
		sb.setZt(0);
		TShebeiDAO.getHibernateTemplate().update(sb);*/
		
		this.setMessage("维修记录保存成功！");
		this.setPath("toJianceMana.action");
		return "succeed";
	}
	
	public String jianceDetail()
	{
		List wxList = new ArrayList();
		
		String sql = "select ta.id,ta.wxsj,ta.wxnr,ta.wxr,ta.wxje,ta.bz " +
					 "from t_jiance ta where ta.sbid="+sbid;
		
		Session sqlSession = TJianceDAO.getSessionFactory().openSession();
		SQLQuery sqlQuery = sqlSession.createSQLQuery(sql);
		List objList = sqlQuery.list();
		for (Object object : objList) {
			Object[] obj = (Object[])object;
			
			TJiance wx = new TJiance();
			wx.setId((Integer)obj[0]);
			wx.setWxsj((String)obj[1]);
			wx.setWxnr((String)obj[2]);
			wx.setWxr((String)obj[3]);
			Double bdWxje = (Double)obj[4];
			wx.setWxje(bdWxje.longValue());
			wx.setBz((String)obj[5]);
			
			wxList.add(wx);
		}
		sqlSession.close();
		
		TShebei sb = TShebeiDAO.findById(sbid);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("wxList", wxList);
		request.put("sbxx", sb);
		return "toDetail";
	}
}
