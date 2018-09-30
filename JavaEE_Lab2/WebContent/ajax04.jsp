<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String initX = request.getParameter("x");
	String initY = request.getParameter("y");
	
	try {
		double dx = Double.parseDouble(initX);
		double dy = Double.parseDouble(initY);
		double result = dx + dy;
		out.println(result);
	} catch (Exception e) {
		out.println("Error");
	}
	
%>