<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>0929AM2_Request</title>
</head>
<body>
<h2>Lab92</h2>
<hr>
<%
	//	試玩request屬性範圍
	int test1 = (int)(Math.random()*49+1);
	out.print("test1: " + test1 + "<br>");
	
	request.setAttribute("test1", test1);
	
	//	sendRedirect是直接轉向
	//	response.sendRedirect("lab93_request2.jsp");
	
	//	改用dispatcher 才會把request帶過去
	//	request.getRequestDispatcher("lab93_request2.jsp").forward(request, response);
	
	//	改用include
	request.getRequestDispatcher("lab93_request2.jsp").include(request, response);
%>
</body>
</html>