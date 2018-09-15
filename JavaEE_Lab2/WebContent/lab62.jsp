<%@page import="java.util.HashMap"%>
<%@page import="java.util.LinkedList"%>
<%@page import="tw.org.iii.beans.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 講解觀念
	
	String[] names = {
		"Brad","Eric","Obama", "Xi", "Kim","Donold"
	};
	
	//	放入request中
	request.setAttribute("usernames", names);
	
	//	LinkList也可以放到request
	LinkedList<String> list = new LinkedList<>();
	
	list.add("aaa");
	list.add("daf");
	list.add("weqwr");
	list.add("jkl");
	
	request.setAttribute("list", list);
	
	HashMap<String, String> map = new HashMap<>();
	map.put("name", "john");
	map.put("age", "100");
	map.put("gender", "male");
	request.setAttribute("map", map);
	
	//	四種層級 優先權: 先找最近的 page --> req --> ses --> app
	pageContext.setAttribute("var1", 111);
	request.setAttribute("var1", 222);
	session.setAttribute("var1", 333);
	application.setAttribute("var1", 444);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab62</title>
</head>
<body>
	<h2>EL物件操作</h2>
	<hr>
	<!-- 資料結構所以用[] -->
	User Name 1 : ${usernames[0] }<br>
	User Name 2 : ${usernames[1] }<br>
	List 1 : ${list[0] }<br>
	List 2 : ${list[1] }<br>
	List 3 (有接收參數): ${list[param.i] } <br> 
	<!-- Map key值為唯一 -->
	Map name1 : ${map["name"] }<br>
	Map name2 : ${map.name }<br>
	Map name3 : ${map[param.key]}<br>
	Map age1 : ${map.age }<br>
	Map age2 : ${map["age"] }<br>
	<hr>
	相同名稱不同等級, 會先找最近的 Var1: ${var1 }
	<hr>
	Page Var1 : ${pageScope.var1 }<br>
	Request Var1 : ${requestScope.var1 }<br>
	Session Var1 : ${sessionScope.var1 }<br>
	Application Var1 : ${applicationScope.var1 }<br>
	
	<hr>
	Lottery: <%= labAPIs.lottery() %><br>
	Lottery: ${labAPIs.lottery()}<br>
	SayHi: ${labAPIs.sayHi("John") }<br>
	SayHi: ${labAPIs.sayHi(param.name) }
</body>
</html>