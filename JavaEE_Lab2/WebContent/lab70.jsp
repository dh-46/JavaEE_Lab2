<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<c:if test="${!empty param.name }">
	<sql:setDataSource driver="com.mysql.jdbc.Driver" 
		url="jdbc:mysql://localhost/iii" user="root" password="root"/>
	<sql:update var="count">
		INSERT INTO `cust` (name,tel,birthday) VALUES (?,?,?)
		<sql:param>${param.name }</sql:param>
		<sql:param>${param.tel }</sql:param>
		<sql:param>${param.bthday }</sql:param>
	</sql:update>
	
	<c:redirect url="lab69.jsp"/>
	
</c:if>
<!-- <c:if test="${param.name != null }"></c:if> -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab70_Insert</title>
</head>
<body>
	<h2>lab70_資料新增</h2>
	<hr>
	<form>
		Name: <input name="name"> <br>
		Tel: <input name="tel"> <br>
		Birthday: <input name="bthday"> <br>
		<input type="submit" value="送出新增">
	</form>
</body>
</html>