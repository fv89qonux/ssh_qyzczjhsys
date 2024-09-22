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
        <script language="javascript">
	           function shenhe(id)
	           {
					window.location.href="<%=path %>/toShenpi.action?id="+id;
	           }
         </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>			
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="6" background="<%=path %>/img/tbg.gif">&nbsp;借用审核&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="15%">借用人</td>
					<td width="15%">设备编号</td>
					<td width="15%">设备名称</td>
					<td width="15%">设备描述</td>
					<td width="15%">申请时间</td>
					<td width="15%">操作</td>
		        </tr>
		        <c:forEach items="${requestScope.sqList}" var="sq">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 ${sq.xsxm}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${sq.sbbh}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${sq.sbmc}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${sq.sblx}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${sq.sqsj}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <input type="button" value="审核" onclick="shenhe(${sq.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
