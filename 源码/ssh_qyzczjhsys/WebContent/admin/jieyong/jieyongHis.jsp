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
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>			
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="4" background="<%=path %>/img/tbg.gif">&nbsp;借用历史查看&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="15%">设备编号</td>
					<td width="15%">设备名称</td>
					<td width="15%">设备描述</td>
					<td width="15%">状态</td>
		        </tr>
		        <c:forEach items="${requestScope.jyList}" var="jy">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 ${jy.sbbh}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${jy.sbmc}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${jy.lxmc}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${jy.strZt}
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
