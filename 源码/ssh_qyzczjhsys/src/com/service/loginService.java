package com.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.TAdminDAO;
import com.dao.TXueshengDAO;
import com.model.TAdmin;
import com.model.TXuesheng;

public class loginService
{
	private TAdminDAO adminDAO;
	private TXueshengDAO TXueshengDAO;
	
	public TAdminDAO getAdminDAO()
	{
		return adminDAO;
	}
	public void setAdminDAO(TAdminDAO adminDAO)
	{
		this.adminDAO = adminDAO;
	}
	public TXueshengDAO getTXueshengDAO() {
		return TXueshengDAO;
	}
	public void setTXueshengDAO(TXueshengDAO xueshengDAO) {
		TXueshengDAO = xueshengDAO;
	}
	
	public String login(String userName,String userPw,int userType)
	{
		String result="no";
		
		if(userType==0)//系统管理员登陆
		{
			String sql="from TAdmin where userName=? and userPw=?";
			Object[] con={userName,userPw};
			List adminList=adminDAO.getHibernateTemplate().find(sql,con);
			if(adminList.size()==0)
			{
				 result="no";
			}
			else
			{
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				 TAdmin admin=(TAdmin)adminList.get(0);
				 session.setAttribute("userType", 0);
	             session.setAttribute("admin", admin);
	             result="yes";
			}
		}
		if(userType==1)//学生登陆
		{
			String sql="from TXuesheng where loginName=? and loginPw=? and del='no'";
			Object[] con={userName,userPw};
			List xsList = TXueshengDAO.getHibernateTemplate().find(sql,con);
			if(xsList.size()==0)
			{
				 result="no";
			}
			else
			{
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				 TXuesheng xuesheng = (TXuesheng)xsList.get(0);
				 session.setAttribute("userType", 1);
	             session.setAttribute("xuesheng", xuesheng);
	             result="yes";
			}
		}
		if(userType==2)//老师登陆
		{
			
		}
		return result;
	}

    public String adminPwEdit(String userPwNew)
    {
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		 
		TAdmin admin=(TAdmin)session.getAttribute("admin");
		admin.setUserPw(userPwNew);
		
		adminDAO.getHibernateTemplate().update(admin);
		session.setAttribute("admin", admin);
		
		return "yes";
    }
    
}
