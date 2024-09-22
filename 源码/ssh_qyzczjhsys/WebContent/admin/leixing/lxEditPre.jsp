<%@ page language="java" pageEncoding="UTF-8"%>
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
			function check()
			{
				var miaoshu = document.formAdd.miaoshu.value;
				if(miaoshu == "")
				{
					alert("描述不能为空!");
					return false;
				}
				
				/*
				var qianzhui = document.formAdd.qianzhui.value;
				if(qianzhui == "")
				{
					alert("前辍不能为空!");
					return false;
				}
				*/
				return true;
			}
        </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
			<form action="<%=path %>/leixingUpd.action" name="formAdd" method="post">
				     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr bgcolor="#EEF4EA">
					        <td colspan="3" background="<%=path %>/img/wbg.gif" class='title'><span>设备厂商修改</span></td>
					    </tr>
						<tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         描述：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="leixing.miaoshu" 
						        	   id="miaoshu" size="20" value="${param.miaoshu }"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" height="22" style="display: none;">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         前辍：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="leixing.qianzhui" 
						        	   id="qianzhui" size="20" value="${param.qianzhui }"/>
							</td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        &nbsp;
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="hidden" name="leixing.id" value="${param.id }"/>
						       <input type="submit" value="提交" onclick="return check();"/> 
						       <input type="reset" value="返回" onclick="javascript:history.back()"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>
