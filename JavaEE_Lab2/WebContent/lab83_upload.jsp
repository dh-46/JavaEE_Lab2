<%@page import="org.apache.commons.fileupload.*" %>
<%@page import="org.apache.commons.fileupload.disk.*" %>
<%@page import="org.apache.commons.fileupload.servlet.*" %>
<%@page import="java.io.*, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
    
<%
	//	取得檔案上傳位址
	String uploadPath = pageContext.getServletContext().getInitParameter("upload-dir");
	//	這裡的new File 只是暫存?
	DiskFileItemFactory factory = new DiskFileItemFactory(64*1024*1024, new File(uploadPath));
	ServletFileUpload upload = new ServletFileUpload(factory);
	List<FileItem> items = upload.parseRequest(request);
	int i = 1;
	for (FileItem item : items) {
		String name = item.getName();
		String field = item.getFieldName();
		String s = item.getString();
		long size = item.getSize();
		if (name == null) {
			out.println(field+":"+s + "<br>");
		}else {
			if (size > 0) {
				out.println("save: " + name);
				//	真正寫出是在這裡
				item.write(new File(uploadPath, "p" + i + ".jpeg"));
				i++;
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab83_upload2(use API)</title>
</head>
<body>

</body>
</html>