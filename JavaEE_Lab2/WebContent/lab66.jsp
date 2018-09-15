<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab66_taglibrary_迴圈</title>
</head>
<body>
	<h2>lab66_taglibrary_迴圈</h2>
	<hr>
	<%
		String[] names = {"brad", "john", "tony", "trump", "Cruise"};
		pageContext.setAttribute("names", names);
		
		for ( String name : names) {
			//	use name
		}
		
	%>
	<!-- var=尋訪出的 items: 尋訪的對象; varStatus: 有當次迴圈的屬性; begin-->
	<c:forEach var="name" items="${names }" varStatus="status">
		Index: ${status.index} 
		Name: ${name }<br>
	</c:forEach>
	
	<hr>
	<h3>動態表格</h3>
	<table border="1" width="50%">
		<tr >
			<th>ID</th>
			<th>Name</th>
			<th>Count</th>
			<th>First</th>
			<th>Last</th>
		</tr>
		<!-- count: 迴圈次數, step: 一次跨幾格; begin/end:開始結束位置 -->
		<c:forEach var="name" items="${names }" varStatus="status" begin="0" end="3" step="2">
			<!--<c:choose>
				<c:when test="${status.first }"><tr bgcolor='pink'></c:when>
				<c:when test="${status.last }"><tr bgcolor='yellow'></c:when>
				<c:otherwise><tr bgcolor='green'></c:otherwise>
			</c:choose>-->
			<tr bgcolor="
			<c:choose>
				<c:when test="${status.first }">pink</c:when>
				<c:when test="${status.last }">yellow</c:when>
				<c:otherwise>lightgrey</c:otherwise>
			</c:choose>	
			">
			
			<!--<c:if test="${status.count % 2 == 0 }">
				<tr bgcolor='yellow'>
			</c:if>-->
				<td>${status.index}</td>
				<td>${name }</td>
				<td>${status.count }</td>
				<td>${status.first }</td>
				<td>${status.last }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>