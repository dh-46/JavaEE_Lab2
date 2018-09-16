<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<c:if test="${empty param.editid and empty param.name}">
	<c:redirect url="lab69.jsp"/>
</c:if>

<sql:setDataSource 
		driver="com.mysql.jdbc.Driver" 
		url="jdbc:mysql://localhost/iii"
		user="root" password="root"/>
<!-- 回傳的是sortedMap -->
<sql:query var="result">
	SELECT * FROM `cust` WHERE id=?
	<sql:param>${param.editid }</sql:param>
</sql:query>

<c:if test="${!empty param.id }">
	<sql:update>
		UPDATE `cust` SET name=?, tel=?, birthday=? WHERE id=?
		<sql:param>${param.name }</sql:param>
		<sql:param>${param.tel }</sql:param>
		<sql:param>${param.bthday }</sql:param>
		<sql:param>${param.id }</sql:param>
	</sql:update>
	<c:redirect url="lab69.jsp"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab71_Edit</title>
</head>
<body>
	<body>
	<h2>lab71_表單修改</h2>
	<hr>
	<form>
		<input type="hidden" name="id" value="${result.rows[0].id }">
		<!-- result.rows: 抓出的那一列 	-->
		Name: <input name="name" value="${result.rows[0].name }"> <br>
		Tel: <input name="tel" value="${result.rows[0].tel }"> <br>
		Birthday: <input name="bthday" value="${result.rows[0].birthday }"> <br>
		<input type="submit" value="送出修改">
	</form>
</body>
</body>
</html>