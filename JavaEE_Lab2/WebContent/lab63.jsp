<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- prefix 慣例: core=>c -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	// pageContext.setAttribute("x", 1234);
%>

<jsp:useBean id="member1" class="tw.org.iii.beans.Member"/>
<jsp:useBean id="member2" class="tw.org.iii.beans.Member"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab63_taglibaray_0915PM1</title>
</head>
<body>
	<h2>lab63_taglibaray_0915PM1</h2>
	<ol>
		<li>後期運用: 資料庫</li>
	</ol>
	<hr>
	<c:out value="Hello"/><br>
	<c:out value="可以混合EL=>"/>
	<c:out value="${'Heeeello, world!' }"/><br>
	<c:out value="${x }" default="no value"/><br>
	${x != null ? x:"no value" }<br>
	<hr>
	<!-- 用標籤語法給變數: 變數名稱, 值, 存活範圍-->
	<!-- = pageContext.setAttribute("var1", 1234); -->
	<c:set var="var1" value="123" scope="page"/>
	Var1: ${var1 }<br>
	<!-- set中 var是必要選項 值也可以寫在標籤間 -->
	<c:set var="var2">1234</c:set>
	Var2: ${var2 }<br>
	<hr>
	<!-- set target="某物件(用EL表示)" property="屬性" -->
	<c:set target="${member1 }" property="id">001</c:set>
	<c:set target="${member1 }" property="name">John</c:set>
	
	<c:set target="${member2 }" property="id">002</c:set>
	<c:set target="${member2 }" property="name">Tom</c:set>
	
	${member1.name }<br>
	${member2.name }
	
	<hr>
	<!-- remove 刪除某個變數 -->
	<c:remove var="var1"/>
	Var1: <c:out value="${var1 }" default="no value"></c:out>
	
</body>
</html>