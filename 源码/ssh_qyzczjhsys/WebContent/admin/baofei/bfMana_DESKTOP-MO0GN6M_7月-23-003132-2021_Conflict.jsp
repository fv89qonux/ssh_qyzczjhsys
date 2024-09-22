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
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script type="text/javascript" src="<%=path %>/jsxx/jsxxBus.js"></script>
        <script language="javascript">
           function toDetail(sbid)
           {
                 var url="<%=path %>/baofeiDetail.action?sbid="+sbid;
				 window.showModalDialog(url,"报废历史查看","dialogWidth=600px;dialogHeight=500px;status=yes;help=no;scroll=yes");
           }
           function toWeixiuAdd(sbid)
           {
                 var url="<%=path %>/toBaofeiAdd.action?sbid="+sbid;
				 window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>			
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="5" background="<%=path %>/img/tbg.gif">&nbsp;设备报废管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="15%">设备编号</td>
					<td width="15%">设备名称</td>
					<td width="15%">设备描述</td>
					<td width="15%">购买时间</td>
					<td width="*">操作</td>
		        </tr>
		        <c:forEach items="${requestScope.sbList}" var="sb">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 ${sb.bh}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${sb.miaoshu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${sb.strLx}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${sb.goumaishijian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="报废记录" onclick="toWeixiuAdd(${sb.id})">
						<input type="button" value="报废历史" onclick="toDetail(${sb.id})">
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
