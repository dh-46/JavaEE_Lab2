<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP002: 變數的生命範圍</title>
</head>
<body>
	<h1>JSP002</h1>
	<hr>
	<p>! => 代表為類別共同的static </p>
	<% int a = 10;%>
	<%! int b = 10;%> <!-- b 是 static; !-->
	a = <%= a++ %><br>
	b = <%= b++ %><br>
</body>
</html>