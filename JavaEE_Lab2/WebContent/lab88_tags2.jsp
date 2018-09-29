<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/mytags.tld" prefix="iii"	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>0929AM_</title>
</head>
<body>
	<iii:HelloDH/>
	<hr>
	456
	<iii:HelloDH2>World<br>
		<!-- 因為限定scriptless 所以不能寫百分比(會直接Error)
			也不能寫Javascript (會無效)
			 -->
	</iii:HelloDH2>
	123
	<hr>
	<iii:tag3 itemName="Camera" price="120">I'm body 1</iii:tag3><br>
	<iii:tag3 itemName="Camera2" price="1202"> I'm body 2</iii:tag3>
</body>
</html>