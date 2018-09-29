<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("lab94" + (int)(Math.random()*10+1), "OK");
		request.setAttribute("name", "lab94");
	%>
</body>
</html>