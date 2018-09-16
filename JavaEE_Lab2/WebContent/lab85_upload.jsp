<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//取得檔案上傳位址
	String uploadPath = pageContext.getServletContext().getInitParameter("upload-dir");
	//	http://www.servlets.com/cos/javadoc/com/oreilly/servlet/MultipartRequest.html
	//	MultipartRequest mreq = new MultipartRequest(request, uploadPath, "UTF-8");
	MultipartRequest mreq = new MultipartRequest(request, uploadPath,64*1024*1024 ,"UTF-8");
	
	String value = mreq.getParameter("user");
	out.println("user => " + value + "<br>");
	
	Enumeration<String> items = mreq.getFileNames();
	while(items.hasMoreElements()){
		String field = items.nextElement();
		File file = mreq.getFile(field);
		
		if (file != null) {
			out.println(field + " : " + file.getName()+ "<br>");
		}
	}
%>
</body>
</html>