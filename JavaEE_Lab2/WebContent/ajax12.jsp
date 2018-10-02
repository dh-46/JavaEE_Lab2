<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%	
	String account = request.getParameter("account");
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii", "root", "root");
	Statement stmt = conn.createStatement();
	String sql = "select count(*) as count from `accounts` where account = " + "'" + account + "'";
	ResultSet rs = stmt.executeQuery(sql);
	rs.next();
	String result = rs.getString("count");
	out.print(result);
%>