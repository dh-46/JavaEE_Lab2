<%@page import="tw.org.iii.javaee.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab52</title>
</head>
<body>
	<p>取得Application中的Member物件。</p><hr>
	<%
		Member member = (Member)application.getAttribute("member");
		out.println(member.getName() + ": " + member.getAge());
	%>
</body>
</html>