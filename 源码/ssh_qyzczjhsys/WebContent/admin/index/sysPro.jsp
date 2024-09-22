<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ page import="com.sun.management.OperatingSystemMXBean" %>
<%
String path = request.getContextPath();
%>


<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
	    <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
		  <tr bgcolor="#EEF4EA">
		    <td colspan="2" background="<%=path %>/img/wbg.gif" class='title'><span>系统基本信息</span></td>
		  </tr>
		  <tr bgcolor="#FFFFFF">
		    <td width="25%" bgcolor="#FFFFFF" align="right">操作系统版本：</td>
		    <td width="75%" bgcolor="#FFFFFF"><%=System.getProperty("os.name") %>&nbsp;&nbsp;<%=System.getProperty("os.version") %></td>
		  </tr>
		  
		  <tr bgcolor="#FFFFFF">
		    <td width="25%" bgcolor="#FFFFFF" align="right">JDK版本：</td>
		    <td><%=System.getProperty("java.version") %></td>
		  </tr>
		 

		</table>
	</body>
</html>
