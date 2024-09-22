package com.action;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.dao.TJieyongDAO;
import com.dao.TShebeiDAO;
import com.dao.TShenqingDAO;
import com.model.TJieyong;
import com.model.TShebei;
import com.model.TShenqing;
import com.model.TXuesheng;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Util;

public class JieyongAction extends ActionSupport{
	private TJieyongDAO TJieyongDAO;
	private TShebeiDAO TShebeiDAO;
	private TShenqingDAO TShenqingDAO;
	
	private int id;		//借用表主键
	private int sbid;
	private int sqid;	//审请表主键
	
	private String message;
	private String path;
	public TJieyongDAO getTJieyongDAO() {
		return TJieyongDAO;
	}

	public void setTJieyongDAO(TJieyongDAO jieyongDAO) {
		this.TJieyongDAO = jieyongDAO;
	}
	
	public TShebeiDAO getTShebeiDAO() {
		return TShebeiDAO;
	}

	public void setTShebeiDAO(TShebeiDAO shebeiDAO) {
		TShebeiDAO = shebeiDAO;
	}

	public TShenqingDAO getTShenqingDAO() {
		return TShenqingDAO;
	}

	public void setTShenqingDAO(TShenqingDAO shenqingDAO) {
		TShenqingDAO = shenqingDAO;
	}

	public int getSbid() {
		return sbid;
	}

	public void setSbid(int sbid) {
		this.sbid = sbid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSqid() {
		return sqid;
	}

	public void setSqid(int sqid) {
		this.sqid = sqid;
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
	
	//跳转到借用登记列表页
	public String jydjList()
	{
		List sqList = new ArrayList();
		String sql = "select tb.xingming,tc.bh,tc.miaoshu,td.miaoshu lx,ta.sqsj,ta.id " +
					 "from t_shenqing ta,t_xuesheng tb,t_shebei tc,t_leixing td " +
					 "where ta.xsid=tb.id and ta.sbid=tc.id and tc.lxid = td.id and ta.zt=1";
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
		
		return "toJydj";
	}
	
	public String jydjAdd(){
		GregorianCalendar gc = new GregorianCalendar();
		String jysj = Util.splitDate(gc.getTime()); 
			
		TShenqing sq = TShenqingDAO.findById(sqid);
		sq.setZt(3);
		TShenqingDAO.getHibernateTemplate().update(sq);
		
		TJieyong jy = new TJieyong();
		jy.setXsid(sq.getXsid());
		jy.setSbid(sq.getSbid());
		jy.setJysj(jysj);
		jy.setZt(0);
		TJieyongDAO.save(jy);
		
		this.setMessage("借用登记完成!");
		this.setPath("jydjList.action");
		return "succeed";
	}
	
	//借用历史查看
	public String jieyongHis()
	{
		List jyList = new ArrayList();
		
		Map session = ActionContext.getContext().getSession();
		TXuesheng xuesheng = (TXuesheng)session.get("xuesheng");
		
		String sql = "select tb.bh,tb.miaoshu,tc.miaoshu lx,ta.zt "+
					 "from t_jieyong ta,t_shebei tb,t_leixing tc "+
					 "where ta.sbid=tb.id and tb.lxid = tc.id and ta.xsid = "+xuesheng.getId();
		Session sqlSession = TShebeiDAO.getSessionFactory().openSession();
		SQLQuery sqlQuery = sqlSession.createSQLQuery(sql);
		List objList = sqlQuery.list();
		for (Object object : objList) {
			Object[] obj = (Object[])object;
			
			TJieyong jy = new TJieyong();
			
			jy.setSbbh((String)obj[0]);
			jy.setSbmc((String)obj[1]);
			jy.setLxmc((String)obj[2]);
			
			int zt = (Integer)obj[3];
			jy.setStrZt(getZtMs(zt));
			jyList.add(jy);
		}
		sqlSession.close();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("jyList", jyList);
		return ActionSupport.SUCCESS;
	}
	
	//借用历史查看
	public String jieyongAll()
	{
		List jyList = new ArrayList();
		
		//Map session = ActionContext.getContext().getSession();
		//TXuesheng xuesheng = (TXuesheng)session.get("xuesheng");
		
		String sql = "select tb.bh,tb.miaoshu,tc.miaoshu lx,ta.zt "+
					 "from t_jieyong ta,t_shebei tb,t_leixing tc "+
					 "where ta.sbid=tb.id and tb.lxid = tc.id ";
		Session sqlSession = TShebeiDAO.getSessionFactory().openSession();
		SQLQuery sqlQuery = sqlSession.createSQLQuery(sql);
		List objList = sqlQuery.list();
		for (Object object : objList) {
			Object[] obj = (Object[])object;
			
			TJieyong jy = new TJieyong();
			
			jy.setSbbh((String)obj[0]);
			jy.setSbmc((String)obj[1]);
			jy.setLxmc((String)obj[2]);
			
			int zt = (Integer)obj[3];
			jy.setStrZt(getZtMs(zt));
			jyList.add(jy);
		}
		
		int jieyongshuliang = jyList.size();
		
		sqlSession.close();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("jyList", jyList);
		request.put("jieyongshuliang", jieyongshuliang);
		return ActionSupport.SUCCESS;
	}
	
	//根据状态获取状态描述
	private String getZtMs(int zt)
	{
		String result = "";
		switch(zt){
			case 0:
				//result = "审批中";
				result = "使用中";
				break;
			case 1:
				//result = "同意借用";
				result = "已归还";
				break;
			case 2:
				result = "不同意借用";
				break;
			case 3:
				result = "已归还";
				break;
			default:
				break;
		}
		return result;
	}
	
	//转到设备归还管理界面
	public String toGuihuanMana()
	{
		List jyList = new ArrayList();
		String sql = "select tb.xingming,tc.bh,tc.miaoshu,td.miaoshu lx,ta.id,ta.jysj " +
					 "from t_jieyong ta,t_xuesheng tb,t_shebei tc,t_leixing td " +
					 "where ta.xsid=tb.id and ta.sbid=tc.id and tc.lxid = td.id and ta.zt=0";
		Session sqlSession = TShebeiDAO.getSessionFactory().openSession();
		SQLQuery sqlQuery = sqlSession.createSQLQuery(sql);
		List objList = sqlQuery.list();
		for (Object object : objList) {
			Object[] obj = (Object[])object;
			
			TJieyong jy = new TJieyong();
			
			jy.setXsxm((String)obj[0]);
			jy.setSbbh((String)obj[1]);
			jy.setSbmc((String)obj[2]);
			jy.setLxmc((String)obj[3]);
			jy.setId((Integer)obj[4]);
			jy.setJysj((String)obj[5]);
			
			jyList.add(jy);
		}
		sqlSession.close();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("jyList", jyList);
		
		return "toGuihuanMana";
	}
	
	public String toGuihuan(){
		TJieyong jy = new TJieyong();
		String sql = "select tb.xingming,tc.bh,tc.miaoshu,td.miaoshu lx,ta.id,ta.jysj " +
					 "from t_jieyong ta,t_xuesheng tb,t_shebei tc,t_leixing td " +
					 "where ta.xsid=tb.id and ta.sbid=tc.id and tc.lxid = td.id and ta.id="+id;
		Session sqlSession = TShebeiDAO.getSessionFactory().openSession();
		SQLQuery sqlQuery = sqlSession.createSQLQuery(sql);
		List objList = sqlQuery.list();
		for (Object object : objList) {
			Object[] obj = (Object[])object;
			
			jy.setXsxm((String)obj[0]);
			jy.setSbbh((String)obj[1]);
			jy.setSbmc((String)obj[2]);
			jy.setLxmc((String)obj[3]);
			jy.setId((Integer)obj[4]);
			jy.setJysj((String)obj[5]);
		}
		GregorianCalendar gc = new GregorianCalendar();
		String ghsj = Util.splitDate(gc.getTime());
		jy.setGhsj(ghsj);
		
		sqlSession.close();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("jyInfo", jy);
		return "toGuihuan";
	}
	public String guihuanAdd()
	{
		ActionContext ctx = ActionContext.getContext();       
	      
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
		
		String ghsj = (String)request.getParameter("ghsj");
		int sfsh = Integer.parseInt(request.getParameter("sfsh"));
		long pcje = "".equals(request.getParameter("pcje"))?0:Long.parseLong(request.getParameter("pcje"));
		String bz = (String)request.getParameter("bz");
		
		TJieyong jy = TJieyongDAO.findById(id);
		jy.setGhsj(ghsj);
		jy.setSfsh(sfsh);
		jy.setPcje(pcje);
		jy.setBz(bz);
		jy.setZt(1);
		
		TJieyongDAO.getHibernateTemplate().update(jy);
		
		TShebei sb = TShebeiDAO.findById(jy.getSbid());
		/*if(sfsh==1){
			//设备损坏,将设备状态置为2维修中
			sb.setZt(2);
			
			//向维修表中插入一条记录
			TWeixiu wx = new TWeixiu();
			wx.setSbid(jy.getSbid());
			wx.setZt(0);
			TWeixiuDAO.save(wx);
		}else{
			//未损坏,将设备状态置为0空闲
			sb.setZt(0);
		}*/
		sb.setZt(0);
		TShebeiDAO.attachDirty(sb);
		
		this.setMessage("设备归还完成!");
		this.setPath("toGuihuanMana.action");
		return "succeed";
	}
}
