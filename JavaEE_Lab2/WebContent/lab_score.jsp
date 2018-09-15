<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab_score (0915PM1)</title>
</head>
<body>
	<h2>lab_score (0915PM1)</h2>
	<hr>
	<form>
		請輸入您的成績: <input type="text" name="score">
		<input type="submit" value="送出">
		<c:choose>
			<c:when test="${param.score >= 90 }">A</c:when>
			<c:when test="${param.score >= 80 }">B</c:when>
			<c:when test="${param.score >= 70 }">C</c:when>
			<c:when test="${param.score >= 60 }">D</c:when>
			<c:when test="${param.score < 60 }">E</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
	</form>
</body>
</html>