<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>借用申请</title>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script type="text/javascript" src="<%=path %>/jsxx/jsxxBus.js"></script>
        <script language="javascript">
           function sbJieyong(sbid)
           {
                 var url="<%=path %>/shenqingAdd.action?sbid="+sbid;
				 window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>			
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="7" background="<%=path %>/img/tbg.gif">&nbsp;申请结果查看&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="15%">设备编号</td>
					<td width="15%">设备名称</td>
					<td width="15%">设备描述</td>
					<td width="15%">申请时间</td>
					<td width="15%">审批时间</td>
					<td width="15%">审批意见</td>
					<td width="10%">状态</td>
					<!--<td width="*">操作</td>-->
		        </tr>
		        <c:forEach items="${requestScope.sqList}" var="sq">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
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
						 ${sq.spsj}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${sq.spyj}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${sq.strZt}
					</td>
					<!-- 
						<td bgcolor="#FFFFFF" align="center">
							<input type="button" value="借用申请" onclick="sbJieyong(${sb.id})">
						</td>
					-->
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
