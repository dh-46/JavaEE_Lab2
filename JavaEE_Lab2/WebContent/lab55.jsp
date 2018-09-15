<%@page import="tw.org.iii.beans.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


   
<!-- 
% 
	// Member member = new Member();
	// member.setId("01");
	// member.setName("John");
%

 -->

<!-- JSP: 盡量不寫java 以提升程式維護性 -->

<!-- 
	1. 	以下改用標籤語法 
	2.	物件變數為id所設定
-->
<!-- useBean: 產生該物件的物件實體, 設定在jsp中其id為member (建構式:無傳參數)-->
<jsp:useBean id="member" class="tw.org.iii.beans.Member"/>

<!-- 
setProperty: 
	property: 物件裡的甚麼屬性
	value: 屬性的值
	name: 是指哪一個物件
-->
<jsp:setProperty property="id" value="002" name="member"/>
<jsp:setProperty property="name" value="John" name="member"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab55_JavaBean</title>
</head>
<body>
	<h1>Lab55_JavaBean_0915AM</h1>
	<hr>
	Hello, <%= member.getName() %>!<br>
	Hello,
	<jsp:getProperty property="name" name="member"/>!<br>
	Your id is 
	<jsp:getProperty property="id" name="member"/>
</body>
</html>

