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
		// 讓session失效
		session.invalidate();
		//	response.sendRedirect("lab89_session.jsp");
		response.sendRedirect("lab892_login.jsp");
	%>
</body>
</html>