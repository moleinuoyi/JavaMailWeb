<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:include page="include/MainHeader.jsp"></jsp:include>
		<center>
			<shiro:hasRole name="admin">welcome has admin role<br></shiro:hasRole>
			<shiro:hasRole name="teacher">welcome has teacher role<br></shiro:hasRole>
			<shiro:hasRole name="student">welcome has student role<br></shiro:hasRole>
			Hi Waite,this is the index!<br><shiro:principal></shiro:principal>
		</center>
	</body>
</html>