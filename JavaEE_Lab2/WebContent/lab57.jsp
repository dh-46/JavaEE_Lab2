<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSTL: Java Scriptlet Tag Library -->


<!-- 百分比@ import改寫成jsp標籤jsp:directive -->

<jsp:directive.page import="tw.org.iii.beans.Member"/>

<%
	Member member = new Member("007", "James");
%>

<!-- jsp 宣告 -->
<jsp:declaration>
	int i;
	String name;
</jsp:declaration>

<jsp:scriptlet>
	i = 10;
	name = "Bond";
</jsp:scriptlet>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab57: </title>
</head>
<body>
	Welcome, <%= member.getName() %>
	<hr>
	Member= <jsp:expression>member</jsp:expression>
	<hr>
	i = <jsp:expression>i</jsp:expression>
	<hr>
	name = <jsp:expression>name</jsp:expression>
	<!-- Expression 相較之下直接寫百分比好像更不錯? 但是仍要了解XD -->
</body>
</html>