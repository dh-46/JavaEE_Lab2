<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@page import="tw.org.iii.beans.labAPIs" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab65_c:if (判斷式)</title>
</head>
<body>
	<h2>lab65_c:if (判斷式)</h2>
	<hr>
	<!-- test: 測的東西?  result: 結果(test運算結果會放到這)	-->
	<c:if test='${param.num == "Brad" }' var="result">
		Hello, OK!
	</c:if><br>
	${result }
	
	<hr>
	<c:set var="score">
		${labAPIs.toIntString(Math.random()*101) }
	</c:set>
	${score }
	
	<!-- switch -->
	<c:choose>
		<c:when test='${score >= "90" }'>A</c:when>
		<c:when test='${score >= "80" }'>B</c:when>
		<c:when test='${score >= "70" }'>C</c:when>
		<c:when test='${score >= "60" }'>D</c:when>
		<c:otherwise>E</c:otherwise>
	</c:choose>
	
</body>
</html>