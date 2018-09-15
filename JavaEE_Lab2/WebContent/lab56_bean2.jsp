<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="member" class="tw.org.iii.beans.Member"/>

<!-- 
EL: Expression Language 
${ EL }
-->
<!-- 
Bean
	要有setProp才可get否則為null
	html註解僅針對html tags有效 jsp tags無效
	沒給參數的情況下 顯示空白
	參數透過網址列傳送(同get)
 -->
 
<!-- 
	建議盡量不寫百分比式的jsp => 維護性不高
-->
<jsp:setProperty property="id" name="member" value="${param.id }"/>
<jsp:setProperty property="name" name="member" value="${param.name }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab56_jspBean & EL</title>
</head>
<body>
	Hello, 
	<jsp:getProperty property="name" name="member"/> <!-- 其實是去呼叫該物件的getter,setter -->
	:
	<jsp:getProperty property="id" name="member"/>
	<hr>
	Hello, ${member.id } : ${member.name } <!-- 其實是去呼叫該物件的getter,setter -->
	<hr>
	${param.id } : ${param.name }	<!-- param: EL中產生的隱含物件 -->
</body>
</html>