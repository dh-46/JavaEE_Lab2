<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Lab93</h2>
<hr>
<%
	// request.getAttribute("test1");
	//pageContext.setAttribute("test1", "100");
	session.setAttribute("test1", "200");
	application.setAttribute("test1", "300");
	
	
%>

default: ${test1 }<br>
page: ${pageScope.test1 } <br>
request: ${requestScope.test1 } <br>
session: ${sessionScope.test1 } <br>
application: ${applicationScope.test1 } <br>
</body>
</html>