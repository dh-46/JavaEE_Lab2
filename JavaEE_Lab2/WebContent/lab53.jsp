<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab53</title>
</head>
<body>
	Hello, world?
	<hr>
	<jsp:forward page="lab54.jsp">
		<jsp:param value="123" name="x"/>
		<jsp:param value="456" name="y"/>
	</jsp:forward>
</body>
</html>