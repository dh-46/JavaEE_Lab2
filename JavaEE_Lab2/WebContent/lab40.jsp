<%@page import="java.util.Calendar"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	1.	%裡面寫java 
	2.	page 關鍵字存放該頁面的?-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP01</title>
</head>
<body>
	<h1>JSP001</h1>
	<hr>
	<% 
		int a = 10, b = 3;
		out.println(a/b + "<br>");
		int lottery = (int)(Math.random()*49+1);
	%>
	樂透號碼: <% out.println(lottery); %><br> 
	樂透號碼: <%= lottery %><br> <!-- 等於簡寫 -->
	<%= Calendar.getInstance().get(Calendar.HOUR_OF_DAY) %> <!-- 伺服器的時間 -->
</body>
</html>