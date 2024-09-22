<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>


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
					<td height="14" colspan="5" background="<%=path %>/img/tbg.gif">&nbsp;设备查询借用&nbsp;</td>
				</tr></table>
				<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			        <form action="<%=path %>/toJieyong.action" name="formAdd" method="post">
			          	设备编号： <input type="text" name="sbbh" value="${requestScope.sbbh }"/>
			           &nbsp;
			          	设备名称： <input type="text" name="sbmc" value="${requestScope.sbmc }"/>
			           &nbsp;
			           <input type="submit" value="查询"/>
			        </form>
			    </td>
			  </tr>
		    </table>			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
		    
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
						<input type="button" value="借用申请" onclick="sbJieyong(${sb.id})">
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
