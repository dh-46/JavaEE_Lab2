<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>	<!-- lab45的錯誤會轉來這裡 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab46(jsp)</title>
</head>
<body>
	Hi this is lab46. I'm a Error page.<br>
	<% out.println(exception); %>
</body>
</html>