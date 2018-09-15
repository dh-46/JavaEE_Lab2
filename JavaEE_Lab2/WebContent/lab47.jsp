<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab47_jsp</title>
</head>
<body>
	<h2>lab47</h2>
	<hr>
		Hello!
	<hr>
		<p>48 在尚未編譯的階段就被included 進來 並再編譯</p>
		<%@ include file="lab48.jsp" %>
		<!-- 注意: 夾入的html code應為片段, 而非完整html format -->
		<!-- include 裡的檔案路徑不能用?帶參數  -->
	<hr>
</body>
</html>