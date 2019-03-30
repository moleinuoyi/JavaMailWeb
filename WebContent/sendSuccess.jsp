<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="refresh" content="5;mail_send.jsp">
		<title>Insert title here</title>
		<script type="text/javascript">
			var time = 6;
			function returnUrlByTime(){
				window.setTimeout('returnUrlByTime()',1000);
				time = time-1;
				document.getElementById("layer").innerHTML = time;
			}
		</script>
	</head>
	<body>
		<center>
			<h3>发送成功！</h3>
			<a href="mail_send.jsp">再写一封</a><br>
			<span id="layer">5</span>秒后转入收信箱
			<h1><center>欢迎来到mail.zwt.com</center></h1>
		</center>
	</body>
</html>