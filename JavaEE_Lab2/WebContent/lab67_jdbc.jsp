<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.lang.Class" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab67</title>
</head>
<body>
<c:catch var="errorMsg">
<%
	//	JSP 可不寫
	//	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii", "root", "root");
	Statement stmt = conn.createStatement();
	String sql = "INSERT INTO `cust` (name,tel,birthday) VALUES ('Brad2', '12345','2000-09-01')";
	stmt.execute(sql);
	out.println("OK");
%>
</c:catch>
<c:if test="${errorMsg != null }">ERROR</c:if>

</body>
</html>