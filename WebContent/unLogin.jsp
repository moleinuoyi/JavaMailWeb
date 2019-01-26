<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>index</title>
		<meta http-equiv="refresh" content="5;login.jsp">
		<script type="text/javascript">
			var time = 6;
			function returnUrlByTime(){
				window.setTimeout('returnUrlByTime()',1000);
				time = time-1;
				document.getElementById("layer").innerHTML = time;
			}
		</script>
	</head>
	<body onload="returnUrlByTime()">
	<center>
		<h3>还没有登录！</h3>
		<a href="login.jsp">点击此处返回登陆</a><br>
		<span id="layer">5</span>秒后转入登录界面
		<h1><center>欢迎来到我的网络</center></h1>
	</center>
	</body>
</html>