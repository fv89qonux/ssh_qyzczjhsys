<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户注册</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
    <script type="text/javascript" src="<%=path %>/My97DatePicker/WdatePicker.js"></script>
    		<script type='text/javascript' src='<%=path %>/dwr/interface/xueshengService.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
    <script type="text/javascript">
    	function check()
    	{
    		var loginName = document.getElementById("name").value;
    		var loginPass = document.getElementById("pw").value;
    		var loginPass2 = document.getElementById("pw2").value;
    		
    		if(loginName == "")
    		{
    			alert("用户名不能为空!");
    			return false;
    		}
    		
    		if(loginPass == "")
    		{
    			alert("密码不能为空!");
    			return false;
    		}
    		
    		if(loginPass != loginPass2)
    		{
    			alert("两次输入的密码不一致!");
    			return false;
    		}
    		xueshengService.sameCheck(loginName,callback);
    	}
    	
		function callback(data)
		{
		    if(data=="1")
		    {
		        alert("注册用户已存在!");
		        return false;
		    }
		    
		    document.formAdd.submit();
		}    	
    </script>

  </head>
  
	<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
		<form action="<%=path %>/xueshengAdd.action" method="post" name="formAdd">
				     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr bgcolor="#EEF4EA">
					        <td colspan="3" background="<%=path %>/img/wbg.gif" class='title'><span>用户注册信息</span></td>
					    </tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						          登录名：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="xuesheng.loginName" id="name">
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         登录密码：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="password" name="xuesheng.loginPw" id="pw">
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						          密码确认：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="password" name="loginPass2" id="pw2">
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						          真实姓名：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="xuesheng.xingming" id="xm">
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						          性别：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <select name="xuesheng.xingbie">
						        	<option value="男">男</option>
						        	<option value="女">女</option>
						        </select>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
								工号：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="xuesheng.xuehao" id="xh">
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        &nbsp;
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="button" value="注册" onclick="check()"/>&nbsp; 
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>						
				 </table>
		</form>				 				 
  </body>
</html>
