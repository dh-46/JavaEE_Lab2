<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab61: 隱含物件</title>
</head>
<body>
<%
	//	以下內容for 觀念講解
	
	//	判斷來源為get/post
	String method = request.getMethod();
	out.println(method);
	
	//	目前這一頁的
	//	HttpServletRequest --> ServletRequest(父類別)
	HttpServletRequest req = (HttpServletRequest)pageContext.getRequest();
	out.println(req.getMethod()+"<hr>");
	out.println(request == req);
	out.println("<hr>");
	
	//	remoteAddr 用戶端ip => 可以用來處理/過濾用戶端
	String ip = request.getRemoteAddr();
	out.println("Remote IP: "+ ip +"<hr>");
	
	//	用戶端使用get方法才會有否則為null
	String query = request.getQueryString();
	out.println("Query String: " + query + "<hr>");
%>

Method = ${pageContext.request.method } <br>
${pageContext.request.remoteAddr } <br>
${pageContext.request.localAddr } <br>
${pageContext.request.serverPort} <br>


</body>
</html>