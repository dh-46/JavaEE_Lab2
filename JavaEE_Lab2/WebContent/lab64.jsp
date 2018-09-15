<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab64_c:catch</title>
</head>
<body>
	<!-- try catch -->
	<c:catch var="errormg">
	<% 
		String num = request.getParameter("n"); 
		int n = Integer.parseInt(num);
		out.println(n);
	%>
	</c:catch>
	Hello, world!<br>
	<!-- 利用EL顯示出該catch的例外 -->
	${errormg }
</body>
</html>