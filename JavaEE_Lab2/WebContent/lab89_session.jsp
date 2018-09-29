<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>0929AM2_Session</title>
</head>
<body>
	<%
		String sessionId = session.getId();
		out.print(sessionId + "<br>");
		//	同一瀏覽器每次連線配發的sessionID是相同的?
				
		//	這個session是否為新產生的	
		//	瀏覽器關掉後重新連線的第一次會是true, 之後reload都是false => 可知道使用者是否為第一次連線
		out.print(session.isNew());
	
		//	session 帶資料
		session.setAttribute("key1", "value1");
		session.setAttribute("key2", "value2");
	%>
</body>
</html>