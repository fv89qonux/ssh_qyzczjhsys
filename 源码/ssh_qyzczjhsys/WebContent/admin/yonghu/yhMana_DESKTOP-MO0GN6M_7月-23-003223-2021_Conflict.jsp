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
           function xsChange(id,zt)
           {
               if(confirm('您确定更改当前用户状态?'))
               {
                   window.location.href="<%=path %>/ztChange.action?id="+id+"&zt="+zt;
               }
           }
       
           function passUpd(id)
           {
			   if(confirm('密码将被重置为111111,确认操作?'))
               {
					window.location.href="<%=path %>/pwChange.action?id="+id;
			   }
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
	
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="6" background="<%=path %>/img/tbg.gif">&nbsp;用户管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%">姓名</td>
					<td width="8%">性别</td>
					<td width="10%">工号</td>
					<td width="10%">登录名</td>
					<td width="10%">状态</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.xsList}" var="xs">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${xs.xingming}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${xs.xingbie}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${xs.xuehao}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${xs.loginName}
					</td>
					<c:if test="${xs.del=='yes'}">
						<td bgcolor="#FFFFFF" align="center">
							已停用
						</td>
						<td bgcolor="#FFFFFF" align="center">
							<input type="button" onclick="xsChange(${xs.id},'no')" value="启用"/>
							<input type="button" onclick="passUpd(${xs.id})" value="初始密码"/>
						</td>
					</c:if>	
					<c:if test="${xs.del=='no'}">
						<td bgcolor="#FFFFFF" align="center">
							正常
						</td>
						<td bgcolor="#FFFFFF" align="center">
							<input type="button" onclick="xsChange(${xs.id},'yes')" value="停用"/>
							<input type="button" onclick="passUpd(${xs.id})" value="初始密码"/>
						</td>
					</c:if>		
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
