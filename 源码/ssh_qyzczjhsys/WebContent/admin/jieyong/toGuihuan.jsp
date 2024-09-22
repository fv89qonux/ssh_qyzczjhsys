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
        <script type="text/javascript" src="<%=path %>/My97DatePicker/WdatePicker.js"></script>
   		<script type='text/javascript' src='<%=path %>/dwr/interface/leixingService.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
        <script type='text/javascript'>
        	function changePcje(obj)
        	{
        		var objPcje = document.getElementById("pcje");
        		if(obj.value == 1)
        		{
        			objPcje.readOnly = false;
        		}
        		else
        		{
        			objPcje.readOnly = true;
        			objPcje.value = "";
        		}
        	}
        </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
			<form action="<%=path %>/guihuanAdd.action" name="formAdd" method="post">
				     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr bgcolor="#EEF4EA">
					        <td colspan="3" background="<%=path %>/img/wbg.gif" class='title'><span>设备归还</span></td>
					    </tr>
						<tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         借用人：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
								${requestScope.jyInfo.xsxm }
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         设备编号：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						    	${requestScope.jyInfo.sbbh }
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         设备名称：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
								${requestScope.jyInfo.sbmc }
							</td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         设备描述：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        ${requestScope.jyInfo.lxmc }
							</td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         借用时间：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        ${requestScope.jyInfo.jysj }
							</td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         归还时间：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="ghsj" value="${requestScope.jyInfo.ghsj }" readonly="readonly"/>
							</td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         是否损坏：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <select name="sfsh" onchange="changePcje(this)">
						        	<option value="0">未损坏</option>
						        	<option value="1">损坏</option>
						        </select>
							</td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         赔偿金额：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="pcje" id="pcje" readonly="readonly"/>元
							</td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         备注：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="bz"/>
							</td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        &nbsp;
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="hidden" name="id" value="${requestScope.jyInfo.id }"/>
						       <input type="submit" value="提交"/> 
						       <input type="reset" value="返回" onclick="javascript:history.back()"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>
