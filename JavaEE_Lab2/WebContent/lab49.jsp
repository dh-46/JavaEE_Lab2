<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab49_JSP標籤(0909PM2)</title>
</head>
<body>
<h2>JSP 標籤</h2>
<hr>
<jsp:include page="lab50.jsp">
	<jsp:param value="john" name="name"/>
	<jsp:param value="18" name="age"/>
</jsp:include>	
</body>
</html>