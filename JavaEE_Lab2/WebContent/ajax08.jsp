<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	int r0 = (int) (Math.random() * 49 + 1);
	int r1 = (int) (Math.random() * 49 + 1);
	int r2 = (int) (Math.random() * 49 + 1);
	out.print(r0 + "," + r1 + "," + r2);
%>