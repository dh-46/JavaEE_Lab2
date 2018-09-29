<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if (session.getAttribute("account") == null) {
		response.sendRedirect("lab892_login.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>0929AM2 Login View</title>
</head>
<body>
	<h2>DH Company Manage System</h2>
	<hr>
	<!-- 注意attribute會由範圍小抓到大!!	 -->
	Welcome, ${account };
	<a href="lab91_logout.jsp">Logout Link</a>
</body>
</html>