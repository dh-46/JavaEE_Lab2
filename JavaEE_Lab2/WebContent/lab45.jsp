<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="lab46.jsp" %>	<!-- 指定錯誤頁面: 拋出例外給lab46 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab45(jsp)</title>
</head>
<body>
	<%
		int a = 10, b = 0;
		
		// try {
			out.println(a/b);
		//} catch (Exception e) {
			//	out.println("Error");
			//	response.sendError(HttpServletResponse.SC_CONFLICT, "Orz");
		//	response.sendRedirect("lab46.jsp");
		//}
	%>
</body>
</html>