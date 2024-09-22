package com.action;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.dao.TShebeiDAO;
import com.dao.TShenqingDAO;
import com.model.TShenqing;
import com.model.TXuesheng;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Util;

public class ShenqingAction extends ActionSupport{
	private TShenqingDAO TShenqingDAO;
	private TShebeiDAO TShebeiDAO;
	
	private int id;		//申请表主键
	private int sbid;
	private int spjg;	//借用审批结果
	private String spyj;	//审批意见
	private String message;
	private String path;
	public TShenqingDAO getTShenqingDAO() {
		return TShenqingDAO;
	}
	public void setTShenqingDAO(TShenqingDAO shenqingDAO) {
		TShenqingDAO = shenqingDAO;
	}
	public TShebeiDAO getTShebeiDAO() {
		return TShebeiDAO;
	}
	public void setTShebeiDAO(TShebeiDAO shebeiDAO) {
		TShebeiDAO = shebeiDAO;
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
	public int getSpjg() {
		return spjg;
	}
	public void setSpjg(int spjg) {
		this.spjg = spjg;
	}

	public String getSpyj() {
		return spyj;
	}
	public void setSpyj(String spyj) {
		this.spyj = spyj;
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
	
	public String shenqingAdd()
	{
		Map session = ActionContext.getContext().getSession();
		TXuesheng xuesheng = (TXuesheng)session.get("xuesheng");
	
		GregorianCalendar gc = new GregorianCalendar();
		
		TShenqing sq = new TShenqing();
		sq.setXsid(xuesheng.getId());
		sq.setSbid(sbid);
		sq.setSqsj(Util.splitDate(gc.getTime()));
		sq.setZt(0);
		TShenqingDAO.save(sq);
		
		//设备的状态置为已借
		String sql = "update TShebei set zt = 1 where id = "+sbid;
		TShebeiDAO.getHibernateTemplate().bulkUpdate(sql);
		
		this.setMessage("借用申请成功,等待审批中!");
		this.setPath("toJieyong.action");
		return "succeed";
	}
	
	public String shenqingList()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		Map session = ActionContext.getContext().getSession();
		TXuesheng xuesheng = (TXuesheng)session.get("xuesheng");
		
		List sqList = new ArrayList();
		
		String sql = "select tb.bh,tb.miaoshu,tc.miaoshu lx,ta.sqsj,ta.zt,ta.id," +
					 "ta.spsj,spyj " +
					 "from t_shenqing ta,t_shebei tb,t_leixing tc " +
					 "where ta.sbid=tb.id and tb.lxid = tc.id and ta.xsid="+xuesheng.getId();
		
		Session sqlSession = TShebeiDAO.getSessionFactory().openSession();
		SQLQuery sqlQuery = sqlSession.createSQLQuery(sql);
		List objList = sqlQuery.list();
		for (Object object : objList) {
			Object[] obj = (Object[])object;
			
			TShenqing sq = new TShenqing();
			sq.setSbbh((String)obj[0]);
			sq.setSbmc((String)obj[1]);
			sq.setSblx((String)obj[2]);
			sq.setSqsj((String)obj[3]);
			
			int zt = (Integer)obj[4];
			sq.setStrZt(getZtMs(zt));
			sq.setZt(zt);
			
			sq.setId((Integer)obj[5]);
			sq.setSpsj((String)obj[6]);
			sq.setSpyj((String)obj[7]);
			
			sqList.add(sq);
		}
		sqlSession.close();
		request.put("sqList", sqList);		
		return "sqList";
	}
	
	public String toShenhe()
	{
		List sqList = new ArrayList();
		String sql = "select tb.xingming,tc.bh,tc.miaoshu,td.miaoshu lx,ta.sqsj,ta.id " +
					 "from t_shenqing ta,t_xuesheng tb,t_shebei tc,t_leixing td " +
					 "where ta.xsid=tb.id and ta.sbid=tc.id and tc.lxid = td.id and ta.zt=0";
		Session sqlSession = TShebeiDAO.getSessionFactory().openSession();
		SQLQuery sqlQuery = sqlSession.createSQLQuery(sql);
		List objList = sqlQuery.list();
		for (Object object : objList) {
			Object[] obj = (Object[])object;
			
			TShenqing sq = new TShenqing();
			sq.setXsxm((String)obj[0]);
			sq.setSbbh((String)obj[1]);
			sq.setSbmc((String)obj[2]);
			sq.setSblx((String)obj[3]);
			sq.setSqsj((String)obj[4]);
			sq.setId((Integer)obj[5]);
			
			sqList.add(sq);
		}
		sqlSession.close();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("sqList", sqList);
		
		return "toShenhe";
	}
	
	//跳转到审批页面
	public String toShenpi()
	{
		TShenqing sq = new TShenqing();
		String sql = "select tb.xingming,tc.bh,tc.miaoshu,td.miaoshu lx,ta.sqsj,ta.id " +
					 "from t_shenqing ta,t_xuesheng tb,t_shebei tc,t_leixing td " +
					 "where ta.xsid=tb.id and ta.sbid=tc.id and tc.lxid = td.id and ta.id="+id;
		Session sqlSession = TShebeiDAO.getSessionFactory().openSession();
		SQLQuery sqlQuery = sqlSession.createSQLQuery(sql);
		List objList = sqlQuery.list();
		for (Object object : objList) {
			Object[] obj = (Object[])object;
			
			sq.setXsxm((String)obj[0]);
			sq.setSbbh((String)obj[1]);
			sq.setSbmc((String)obj[2]);
			sq.setSblx((String)obj[3]);
			sq.setSqsj((String)obj[4]);
			sq.setId((Integer)obj[5]);
		}
		sqlSession.close();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("sqInfo", sq);
		
		return "toShenpi";
	}
	
	//借用审批结果保存
	public String shenpiAdd()
	{
		GregorianCalendar gc = new GregorianCalendar();
		String spsj = Util.splitDate(gc.getTime());
		
		TShenqing sq = TShenqingDAO.findById(id);
		sq.setSpsj(spsj);
		sq.setSpyj(spyj);
		sq.setZt(spjg);
		
		TShenqingDAO.getHibernateTemplate().update(sq);
		if(spjg==2){
			//不同意借用,将设备状态置为闲置
			String sql = "update TShebei set zt = 0 where id="+sq.getSbid();
			TShebeiDAO.getHibernateTemplate().bulkUpdate(sql);
		}
		
		this.setMessage("借用申请审批成功!");
		this.setPath("toShenhe.action");
		return "succeed";
	}
	
	//根据状态获取状态描述
	private String getZtMs(int zt)
	{
		String result = "";
		switch(zt){
			case 0:
				result = "审批中";
				break;
			case 1:
				result = "同意借用";
				break;
			case 2:
				result = "不同意借用";
				break;
			case 3:
				result = "完成借用";
				break;
			default:
				break;
		}
		return result;
	}
}
