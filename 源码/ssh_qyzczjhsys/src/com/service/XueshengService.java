package com.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.TXueshengDAO;
import com.model.TAdmin;
import com.model.TXuesheng;

public class XueshengService {
	private TXueshengDAO TXueshengDAO;

	public TXueshengDAO getTXueshengDAO() {
		return TXueshengDAO;
	}

	public void setTXueshengDAO(TXueshengDAO xueshengDAO) {
		TXueshengDAO = xueshengDAO;
	}
	
	//登录名是否重复检查
	public String sameCheck(String loginName)
	{
		String result = "1";
		try{
			String sql = "select loginName from TXuesheng where loginName='"+loginName+"'";
			List xsList = TXueshengDAO.getHibernateTemplate().find(sql);
			if(xsList.size() > 0)
				result = "1";
			else
				result = "0";
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public String editPw(String newPw)
	{
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		 
		TXuesheng xuesheng=(TXuesheng)session.getAttribute("xuesheng");
		xuesheng.setLoginPw(newPw);
		
		TXueshengDAO.getHibernateTemplate().update(xuesheng);
		session.setAttribute("xuesheng", xuesheng);
		
		return "yes";
	}
}
