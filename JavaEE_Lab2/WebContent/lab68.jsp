<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab68_JDBC2(taglib:sql)</title>
</head>
<body>
	
	<!-- 替代Class.forName; driver可省略 -->
	<sql:setDataSource driver="com.mysql.jdbc.Driver" 
		url="jdbc:mysql://localhost/iii" user="root" password="root"/>
	
	<!-- query得到的resultset會擺在var變數中 -->
	<sql:query var="resultAll" sql="select * from gifts" ></sql:query>
	
	<c:set var="count" value="${resultAll.rowCount }"></c:set>
	<c:set var="start" value="${(param.page-1) * 10 }"></c:set>
	<c:set var="start" value="${(start < 0)? 0 : start }"></c:set>
	
	
	<sql:query var="result">
		select * from `gifts` limit ${start }, 10;
	</sql:query>
	
	
	<!-- API中 getRowCount方法 => getter/setter -->
	<!-- 
		${result.rowCount} 
		${result.columnNames[0] }
	-->
	<h2>Lab68_JSP+JDBC</h2>
	<hr>
	<a href='lab68.jsp?page=${(param.page <= 0)? 1 :param.page - 1 }'>上一頁</a> ${param.page == null? 1 : param.page } <a href='lab68.jsp?page=${param.page == null? param.page + 2 : param.page + 1 }'>下一頁</a>
	
	<table border="1" width="100%">
		<tr>
			<th width="10%">編號</th>
			<th width="20%">名稱</th>
			<th width="20%">地點</th>
			<th width="50%">特色</th>
		</tr>
		<c:forEach items="${result.rows }" var="row">
			<tr>
				<td>${row.id }</td>
				<td>${row.name }</td>
				<td>${row.place }</td>
				<td>${row.feature }</td>
			</tr>
		</c:forEach>
	</table>
	
	
	
</body>
</html>