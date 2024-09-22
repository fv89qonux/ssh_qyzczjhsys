<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>菜单</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=path %>/css/base.css" type="text/css" />
	<link rel="stylesheet" href="<%=path %>/css/menu.css" type="text/css" />
	<style type="text/css">
	    div {
			padding:0px;
			margin:0px;
		}
		
		body {
		 scrollbar-base-color:#5998DB;
		 scrollbar-arrow-color:#FFFFFF;
		 scrollbar-shadow-color:#5998DB;
		 padding:0px;
		 margin:auto;
		 text-align:center;
		 background-color:#5998DB;
		}
		
		dl.bitem {
			width:148px;
			margin:0px 0px 5px 4px;
		}
		
		dl.bitem dt {
		  background:url(<%=path %>/img/menubg.gif);
		  height:26px;
		  line-height:26px;
		  text-align:center;
		  cursor:pointer;
		}
			dl.bitem dt b {color:white}
		dl.bitem dd {
		  padding:3px 3px 3px 3px;
		  background-color:#fff;
		}
		
		.fllct
		{
			float:left;
			
			width:90px;
		}
		
		.flrct
		{
			padding-top:3px;
			float:left;
		}
		
		div.items
		{
			line-height:22px;
			background:url(<%=path %>/img/arr4.gif) no-repeat 10px 9px;
		}
		
		span.items
		{
			padding:10px 0px 10px 22px;
			background:url(<%=path %>/img/arr4.gif) no-repeat 10px 12px;
		}
		
		ul {
		  padding-top:3px;
		}
		
		li {
		  height:22px;
		}
		
		.sitemu li {
			padding:0px 0px 0px 22px;
			line-height:24px;
			background:url(<%=path %>/img/arr4.gif) no-repeat 10px 9px;
		}
	</style>
	<script language='javascript'>var curopenItem = '1';</script>
	<script language="javascript" type="text/javascript" src="<%=path %>/js/menu.js"></script>
	<base target="main" />
  </head>
  
  <body target="main">
    <c:if test="${sessionScope.userType==0}">
	<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0'>
	  <tr>
	    <td style='padding-left:3px;padding-top:8px' valign="top">
	      <dl class='bitem'>
	        <dt onClick='showHide("items1_1")'><b>系统用户管理</b></dt>
	        <dd style='display:block' class='sitem' id='items1_1'>
	          <ul class='sitemu'>
	            <li><a href='<%=path %>/admin/index/admininfo.jsp' target='main'>个人密码修改</a> </li>
	            <li><a href='<%=path %>/xueshengMana.action' target='main'>系统用户管理</a> </li>
	          </ul>
	        </dd>
	      </dl>
	      <dl class='bitem'>
	        <dt onClick='showHide("items1_2")'><b>设备厂商管理</b></dt>
	        <dd style='display:block' class='sitem' id='items1_2'>
	          <ul class='sitemu'>
	            <li><a href='<%=path %>/admin/leixing/lxAdd.jsp' target='main'>设备厂商添加</a> </li>
	            <li><a href='<%=path %>/leixingMana.action' target='main'>设备厂商管理</a> </li>
	          </ul>
	        </dd>
	      </dl>
	      <dl class='bitem'>
	        <dt onClick='showHide("items1_3")'><b>设备管理</b></dt>
	        <dd style='display:block' class='sitem' id='items1_3'>
	          <ul class='sitemu'>
	            <li><a href='<%=path %>/toAddShebei.action' target='main'>设备添加</a></li>
	            <li><a href='<%=path %>/shebeiMana.action' target='main'>设备管理</a></li>
	            <li><a href='<%=path %>/shebeiQuery.action' target='main'>设备查询</a> </li>
	          </ul>
	        </dd>
	      </dl>
	      <dl class='bitem'>
	        <dt onClick='showHide("items1_4")'><b>设备借用管理</b></dt>
	        <dd style='display:block' class='sitem' id='items1_4'>
	          <ul class='sitemu'>
	            <li><a href='<%=path %>/toShenhe.action' target='main'>设备借用审核</a> </li>
	            <li><a href='<%=path %>/jydjList.action' target='main'>设备借用登记</a> </li>
	            <li><a href='<%=path %>/toGuihuanMana.action' target='main'>设备归还管理</a> </li>
	            <li><a href='<%=path %>/jieyongAll.action' target='main'>借用统计</a> </li>
	          </ul>
	        </dd>
	      </dl>
	      <dl class='bitem'>
	        <dt onClick='showHide("items1_6")'><b>设备维修管理</b></dt>
	        <dd style='display:block' class='sitem' id='items1_6'>
	          <ul class='sitemu'>
	            <li><a href='<%=path %>/toWeixiuMana.action' target='main'>设备维修管理</a> </li>
	          </ul>
	        </dd>
	      </dl>
	      <dl class='bitem'>
	        <dt onClick='showHide("items1_6")'><b>设备检测管理</b></dt>
	        <dd style='display:block' class='sitem' id='items1_6'>
	          <ul class='sitemu'>
	            <li><a href='<%=path %>/toJianceMana.action' target='main'>设备检测管理</a> </li>
	          </ul>
	        </dd>
	      </dl>
	      
	      <dl class='bitem'>
	        <dt onClick='showHide("items1_6")'><b>设备报废管理</b></dt>
	        <dd style='display:block' class='sitem' id='items1_6'>
	          <ul class='sitemu'>
	            <li><a href='<%=path %>/toBaofeiMana.action' target='main'>设备报废管理</a> </li>
	          </ul>
	        </dd>
	      </dl>
		</td>
	  </tr>
	</table>
	</c:if>
	
	
	
	
	
	<c:if test="${sessionScope.userType==1}">
	<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0'>
	  <tr>
	    <td style='padding-left:3px;padding-top:8px' valign="top">
	      <dl class='bitem'>
	        <dt onClick='showHide("items1_1")'><b>修改个人密码</b></dt>
	        <dd style='display:block' class='sitem' id='items1_1'>
	          <ul class='sitemu'>
	            <li><a href='<%=path %>/admin/index/userinfo.jsp' target='main'>修改个人密码</a> </li>
	          </ul>
	        </dd>
	      </dl>
	      <dl class='bitem'>
	        <dt onClick='showHide("items1_2")'><b>设备借用申请</b></dt>
	        <dd style='display:block' class='sitem' id='items1_2'>
	          <ul class='sitemu'>
	            <li><a href='<%=path %>/toJieyong.action' target='main'>发起借用申请</a> </li>
	            <li><a href='<%=path %>/shenqingList.action' target='main'>申请结果查看</a> </li>
	            <li><a href='<%=path %>/jieyongHis.action' target='main'>借用历史查询</a> </li>
	          </ul>
	        </dd>
	      </dl>
		</td>
	  </tr>
	</table>
	</c:if>
  </body>
</html>
