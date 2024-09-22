<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>


<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script type="text/javascript" src="<%=path %>/jsxx/jsxxBus.js"></script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>			
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="5" background="<%=path %>/img/tbg.gif">&nbsp;<font color="red">${requestScope.sbxx.miaoshu}</font>&nbsp;&nbsp;检测记录查看&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="12%">检测时间</td>
					<td width="15%">检测内容</td>
					<td width="10%">检测人</td>
					<td width="15%">检测金额(元)</td>
					<td width="*">备注</td>
		        </tr>
		        <c:forEach items="${requestScope.wxList}" var="wx">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 ${wx.wxsj}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${wx.wxnr}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${wx.wxr}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${wx.wxje}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${wx.bz}
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
