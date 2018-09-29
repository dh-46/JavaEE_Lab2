<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
0929 Taglib-自訂標籤	 
1. 建立標籤庫
	=> 目錄/WEB-INF/tags
	=> xxx.tag (附檔名不用.tag也可)
	=> 一個檔案一個標籤
2.	使用方法
	=> tagdir=路徑
3.	tag檔可寫普通文字與JSP
	-->

<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>0929_Taglib--自訂標籤</title>
</head>
<body>
	<h1>0929_Taglib--Custom Tags</h1>
	<hr>
	<t:test1/><br>
	<t:test2 user="John"/>
	<hr>
	<h4>運用Custom Tags運算</h4>
	<t:test3 x="10" y="3">
		<!-- doBody 是運作在這裡  也限定設定的值只在doBody的範圍內執行	-->
		10 + 3 = ${add } <br>
		10 - 3 = ${subtract } <br>
		10 * 3 = ${multi } <br>
		10 / 3 = ${divide } <br>
	</t:test3>
	<p>在標籤範圍外</p>
	10 / 3 = ${divide } <br>
	<hr>
	<t:test4/>
	<hr>
	<h4>寫個表格</h4>
	<table border="1" width="100%">
		<tr>
			<th>Name</th>
			<th>Price</th>
		</tr>
		<!-- 搭配for each & SQL 就可以連資料庫 	-->
		<!-- 一個標籤配一個檔案 維護上要注意標籤命名 -->
		<t:test5 name="Camera" price="100"/>
		<t:test5 name="PC" price=""/>
		<t:test5 name="iPhone" price="999"/>
	</table>
	
</body>
</html>