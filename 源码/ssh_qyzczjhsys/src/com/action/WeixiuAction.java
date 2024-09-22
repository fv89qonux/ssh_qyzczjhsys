package com.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.dao.TShebeiDAO;
import com.dao.TWeixiuDAO;
import com.model.TShebei;
import com.model.TWeixiu;
import com.opensymphony.xwork2.ActionSupport;

public class WeixiuAction extends ActionSupport {
	private TWeixiuDAO TWeixiuDAO;
	private TShebeiDAO TShebeiDAO;
	private TWeixiu weixiu;
	
	private int id;
	private int sbid;
	
	private String message;
	private String path;
	public TWeixiuDAO getTWeixiuDAO() {
		return TWeixiuDAO;
	}

	public void setTWeixiuDAO(TWeixiuDAO weixiuDAO) {
		TWeixiuDAO = weixiuDAO;
	}

	public TShebeiDAO getTShebeiDAO() {
		return TShebeiDAO;
	}

	public void setTShebeiDAO(TShebeiDAO shebeiDAO) {
		TShebeiDAO = shebeiDAO;
	}

	public TWeixiu getWeixiu() {
		return weixiu;
	}

	public void setWeixiu(TWeixiu weixiu) {
		this.weixiu = weixiu;
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

	public String toWeixiuMana()
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
	
	public String toWeixiuAdd()
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
		return "toWeixiuAdd";
	}
	
	public String weixiuUpd()
	{
		weixiu.setZt(1);
		TWeixiuDAO.save(weixiu);
		
		/*TShebei sb = TShebeiDAO.findById(weixiu.getSbid());
		sb.setZt(0);
		TShebeiDAO.getHibernateTemplate().update(sb);*/
		
		this.setMessage("维修记录保存成功！");
		this.setPath("toWeixiuMana.action");
		return "succeed";
	}
	
	public String weixiuDetail()
	{
		List wxList = new ArrayList();
		
		String sql = "select ta.id,ta.wxsj,ta.wxnr,ta.wxr,ta.wxje,ta.bz " +
					 "from t_weixiu ta where ta.sbid="+sbid;
		
		Session sqlSession = TWeixiuDAO.getSessionFactory().openSession();
		SQLQuery sqlQuery = sqlSession.createSQLQuery(sql);
		List objList = sqlQuery.list();
		for (Object object : objList) {
			Object[] obj = (Object[])object;
			
			TWeixiu wx = new TWeixiu();
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
