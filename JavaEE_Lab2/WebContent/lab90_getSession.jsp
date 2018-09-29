<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>0929AM2_getSession</title>
</head>
<body>
<%
	if (session.getAttribute("key1") == null) {
		response.sendRedirect("lab89_session.jsp");
		return;
	}

	String key1 = (String)session.getAttribute("key1");
	String key2 = (String)session.getAttribute("key2");
	String key3 = (String)session.getAttribute("key3");
	
	out.println(key1 + ":" + key2 + " : " + key3);
%>
</body>
</html>