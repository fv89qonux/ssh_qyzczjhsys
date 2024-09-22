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
        <script language="javascript">
           function lxDel(id)
           {
               if(confirm('您确定删除吗?'))
               {
                   window.location.href="<%=path %>/leixingDel.action?id="+id;
               }
           }
           function lxAdd()
           {
                 var url="<%=path %>/admin/leixing/lxAdd.jsp";
				 window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>			
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="5" background="<%=path %>/img/tbg.gif">&nbsp;设备厂商管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="15%">描述</td>
					<td width="15%" style="display:none; ">前辍</td>
					<td width="*">操作</td>
		        </tr>
		        <c:forEach items="${requestScope.lxList}" var="lx">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 ${lx.miaoshu}
					</td>
					<td bgcolor="#FFFFFF" align="center" style="display:none; ">
						 ${lx.qianzhui}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<form action="<%=path %>/admin/leixing/lxEditPre.jsp" method="post">
					        <input type="hidden" name="id" value="${lx.id}"/>
					        <input type="hidden" name="miaoshu" value="${lx.miaoshu}"/>
					        <input type="hidden" name="qianzhui" value="${lx.qianzhui}"/>
						    <input type="submit" value="编辑"/>
						    <input type="button" onclick="lxDel(${lx.id})" value="删除"/>
						</form>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="lxAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
