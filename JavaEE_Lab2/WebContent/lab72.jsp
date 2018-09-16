<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page errorPage="error.jsp" %>


		
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab72_SQL交易</title>
</head>
<body>
	<sql:setDataSource 
		driver="com.mysql.jdbc.Driver" 
		url="jdbc:mysql://localhost/iii"
		user="root" password="root"/>
	<!-- 一次性的交易行為, 交易內任意行為失敗則全都不做 -->
	<sql:transaction>
		<sql:update var="count">
			INSERT INTO `cust` (name, tel, birthday) VALUES (?,?,?)
			<sql:param>test1</sql:param>
			<sql:param>123456</sql:param>
			<sql:param>1999-01-01</sql:param>
		</sql:update>
		
		<sql:query var="lastid">
			SELECT last_insert_id() AS newid
		</sql:query>
	</sql:transaction>
	
	<c:if test="${count > 0 }">
		Last ID: ${lastid.rows[0].newid }
	</c:if>
</body>
</html>