<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab69_客戶資料</title>
</head>
<body>
	<h2>Lab68 Company</h2>
	<hr>
	<a href="lab70.jsp"><button>新增</button></a>
	<hr>
	<sql:setDataSource 
		driver="com.mysql.jdbc.Driver" 
		url="jdbc:mysql://localhost/iii"
		user="root" password="root"/>
	
	<c:if test="${!empty param.delid }">
		<sql:update>
			DELETE FROM `cust` WHERE id = ?
			<sql:param>${param.delid }</sql:param>
		</sql:update>
	</c:if>
	
	<sql:query var="result">
		SELECT * FROM `cust`
	</sql:query>
	
	<table border="1" width="100%">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>TEL</th>
			<th>BIRTHDAY</th>
			<th>刪除</th>
			<th>修改</th>
		</tr>
		<!-- items: 尋訪的對象;	var: 尋訪回來的東西擺到這個變數中	-->
		<c:forEach items="${result.rows }" var="row">
			<tr>
				<td>${row.id }</td>
				<td>${row.name }</td>
				<td>${row.tel }</td>
				<td>${row.birthday }</td>
				<td align="center"><a href="?delid=${row.id }" onclick="return ask('${row.name}')"><button >刪除</button></a></td>
				<td align="center"><a href="lab71.jsp?editid=${row.id }"><button>修改</button></a></td>
			</tr>
		</c:forEach>
		
	</table>
	<script>
		/* JS Review: onclick return true/false; BTW confirm 好像沒學過...*/
		function ask(name) {
			var isDelete = confirm("Do you really want to delete " + name + " ?");
			return isDelete;
		}
	</script>
</body>
</html>