<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 回應ajax01的呼叫 	-->
<%
	Enumeration<String> keys = request.getHeaderNames();
	while (keys.hasMoreElements()) {
		String key = keys.nextElement();
		out.println(key + " : " + request.getHeader(key)+"<br>");
	}
%>
<hr>
Hello, world!
<%= (int)(Math.random()*49+1)  %>