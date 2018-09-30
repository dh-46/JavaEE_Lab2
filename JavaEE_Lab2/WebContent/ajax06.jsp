<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//	查看前端發送方法 (若有限定get/post, 這裡可以先處理)
	String method = request.getMethod();
	//out.println(method);
	
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
