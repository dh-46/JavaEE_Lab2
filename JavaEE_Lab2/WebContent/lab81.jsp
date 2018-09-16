<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab81_taglib-fn</title>
</head>
<body>
	<h2>lab81_0916PM1_function</h2>
	<hr>
	<ol>
		<li>通常與EL搭配使用</li>
		<li>記得看API https://tomcat.apache.org/taglibs/standard/apidocs/org/apache/taglibs/standard/functions/Functions.html</li>
	</ol>
	<hr>
	<!-- 任何var都可以指定scope, 如果沒指定都是在pageContext底下 -->
	<c:set var="var1" value="I am a test var" />
	<!-- https://tomcat.apache.org/taglibs/standard/apidocs/org/apache/taglibs/standard/functions/Functions.html -->
	<c:if test="${fn:contains(var1, 'test') }">
		OK
	</c:if>
	<%	
		//	以下java與上方tags 意思一樣
		String var2 = (String)pageContext.getAttribute("var1");
		out.println(var2.contains("test"));
	%>
	
</body>
</html>