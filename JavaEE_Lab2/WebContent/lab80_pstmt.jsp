<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab80_Prepared Statement</title>
</head>
<body>
	<c:catch var="errorMsg">
		<sql:setDataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/iii" user="root" password="root"/>
		<sql:update var="count">
			INSERT INTO `cust` (name, tel, birthday) VALUES (?,?,?)
			<sql:param>iii2</sql:param>
			<sql:param>0912345678</sql:param>
			<sql:param>1918-09-18</sql:param>
		</sql:update>
		${count } <br>
		<c:if test="${count >= 1}">OK</c:if>
	</c:catch>
	<c:if test="${errorMsg != null }">Error!</c:if>
</body>
</html>