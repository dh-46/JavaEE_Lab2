<%@page import="tw.org.iii.javaee.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab51_JSP帶入物件</title>
</head>
<body>
<%	
	Member member = new Member("Alex", "alex", 30);	// 產生物件實體
	application.setAttribute("member", member);	// 放到application中
	
%>
</body>
</html>