<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		
	</head>
	<body topmargin="0" leftmargin="0" bgcolor="#f3f3f3" align="center"> 
		<jsp:include page="include/MainHeader.jsp"></jsp:include>
		<form action="${pageContext.request.contextPath }/login.action" method="post">
			<table align="center">
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
	            	<td>密码：</td>
					<td><input type="password" name="password"></td>
	            </tr>
	            <tr>
					<td><input type="reset" vlue="重置"></td>
					<td><input type="submit" vlue="提交"></td>
				</tr>
			</table>
		</form>
		<center>!!<font color="red">
			<%
				String error = (String)session.getAttribute("errorLogin");
				if(error == null){
					error = "";
				}
			%>
			<%=error %>
			<%session.setAttribute("errorLogin",""); %>
		</font>!!</center>
	</body>
</html>