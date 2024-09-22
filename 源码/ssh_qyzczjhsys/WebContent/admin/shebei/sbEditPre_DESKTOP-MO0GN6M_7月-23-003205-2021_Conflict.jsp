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
        <script type="text/javascript" src="<%=path %>/My97DatePicker/WdatePicker.js"></script>
   		<script type='text/javascript' src='<%=path %>/dwr/interface/leixingService.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
        
        <script language="javascript">
			function check()
			{
				var miaoshu = document.getElementById("miaoshu").value;
				var lx = document.getElementById("lx").value;
				var gmsj = document.getElementById("goumaishijian").value;
				
				if(miaoshu == "")
				{
					alert("设备名称不能为空!");
					return false;
				}
				
				if(lx == -1)
				{
					alert("设备描述不能为空!");
					return false;
				}
				
				if(gmsj == "")
				{
					alert("购买时间不能为空!");
					return false;
				}
				return true;
			}
			
			function getSbbh(obj)
			{
				var selVal = obj.value;
				if(selVal != -1)
				{
					leixingService.getSbhbByLxid(selVal,callback);
				}
			}
			
			function callback(data)
			{
			    document.getElementById("bh").value = data;
			}			
        </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
			<form action="<%=path %>/shebeiUpd.action" name="formAdd" method="post">
				     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr bgcolor="#EEF4EA">
					        <td colspan="3" background="<%=path %>/img/wbg.gif" class='title'><span>设备修改</span></td>
					    </tr>
						<tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         设备描述：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						    	<select name="shebei.lxid" id="lx">
							    	<c:forEach items="${requestScope.lxList}" var="lx">
							    		<c:if test="${lx.id==sbInfo.lxid }">
							        		<option value="${lx.id }" selected="selected">${lx.miaoshu }</option>
							        	</c:if>
							        	<c:if test="${lx.id!=sbInfo.lxid }">
							        		<option value="${lx.id }">${lx.miaoshu }</option>
							        	</c:if>
							        </c:forEach>
						        </select>
						    </td>
						</tr>					    
						<tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         设备名称：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="shebei.miaoshu" 
						        	   id="miaoshu" size="20" value="${sbInfo.miaoshu }"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         编号：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="shebei.bh" id="bh" 
						        	   size="20" readonly="readonly" value="${sbInfo.bh }"/>
							</td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         购买时间：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="shebei.goumaishijian" id="goumaishijian" value="${sbInfo.goumaishijian }"
						        	   size="20" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
							</td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        &nbsp;
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="hidden" name="shebei.id" value="${sbInfo.id }"/>
						       <input type="submit" value="提交" onclick="return check();"/> 
						       <input type="reset" value="返回" onclick="javascript:history.back()"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>
