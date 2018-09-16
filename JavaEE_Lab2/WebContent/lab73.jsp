<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@page import="org.json.*" %>
<%@page import="java.util.*" %>

<!-- <sql:setDataSource 
		driver="com.mysql.jdbc.Driver" 
		url="jdbc:mysql://localhost/iii"
		user="root" password="root"/> -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab73_import</title>
</head>
<body>
	<h2>lab73_import</h2>
	<hr>
	<ol>
		<li>載入頁面原始碼</li>
		<li>適用在讀取JSON資料</li>
	</ol>
	<hr>
	<c:import var="data" url="http://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvAttractions.aspx"/>
	<!-- data 其實就是被放到pageContext裡的attribute中	-->
	
<%
	String strJSON = (String)pageContext.getAttribute("data");
	LinkedList<HashMap<String,String>> data = new LinkedList<>();
	JSONArray root = new JSONArray(strJSON);
	
	for (int i=0; i<root.length(); i++) {
		JSONObject row = root.getJSONObject(i);
		HashMap<String,String> map = new HashMap<>();
		map.put("ID", row.getString("ID"));
		map.put("Name", row.getString("Name"));
		map.put("Tel", row.getString("Tel"));
		map.put("Address", row.getString("Address"));
		map.put("pos", row.getString("Coordinate"));
		data.add(map);
	}
	pageContext.setAttribute("pdata", data);
	%>
	
<table border="1" width="100%">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Tel</th>
		<th>LatLng</th>
	</tr>
	<!-- 尋訪的items是HashMap, 每一個row就是一組HM -->
	<!-- 複習:HashMap&LinkedList -->
	<c:forEach items="${pdata }" var="row">
		<tr>
			<td>${row.ID }</td>
			<td>${row.Name }</td>
			<td>${row.Tel }</td>
			<td>${row.pos }</td>
		</tr>
		<!-- 
			<sql:update>
			INSERT INTO `travel` (sid, name, address, tel, pos) VALUES (?,?,?,?,?)
			<sql:param>${row.ID }</sql:param>
			<sql:param>${row.Name }</sql:param>
			<sql:param>${row.Address }</sql:param>
			<sql:param>${row.Tel }</sql:param>
			<sql:param>${row.pos }</sql:param>
			</sql:update>
		 -->
		
	</c:forEach>

</table>
</body>
</html>