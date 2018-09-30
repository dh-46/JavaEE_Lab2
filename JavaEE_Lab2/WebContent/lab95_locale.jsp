<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Taglib_Format
1.	針對格式化
 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>0930AM1_locale</title>
</head>
<body>
<h2>0930AM1_在地化</h2>
<hr>
<h3>語系設定</h3>
<%	
	//	從request拿到locale
	Locale locale = request.getLocale();
%>
<!-- 偵測瀏覽器的預設語系 -->
Country: <%= locale.getCountry() %><br>
Country:<%= locale.getDisplayCountry() %><br>
Language: <%= locale.getLanguage() %><br>


<!-- 
	res_en_US.properties
	1.	語系包通常是網頁做完後最後處理的事情
	2.	建立於WEB-INF之下
 -->

<!-- 設定語系 
value可以從locale.getDisplayLanguage()/.getCountry() 取得

**開發時建議以英文語系為主, 開發近完成後再加上中文語系包
**zh_TW/en_US: 這類簡寫可查表 (i18N)


-->

<!-- 設定會隨語系變更的內容 -->
<fmt:setLocale value='<%= locale.getLanguage() + "_" + locale.getCountry() %>' />
<fmt:setBundle basename="res"/>
<h1><fmt:message key="companyName" /></h1>
<fmt:message key="hello"/>,<fmt:message key="world"/>
<hr>
<!-- 英文語系 -->
<fmt:setLocale value="en_US"/>
<fmt:setBundle basename="res"/>
<h1><fmt:message key="companyName" /></h1>
<fmt:message key="hello"/>,<fmt:message key="world"/>
<hr>

<!-- -----日期時間(時區)---		 -->
<h3>日期時間(時區)</h3>
Current: <%
	Date now = new Date();
	out.println(now+"<br>");
	
	pageContext.setAttribute("now", now);
%>

<!-- 設定時區 value要查表 -->
<fmt:setTimeZone value="Asia/Tokyo"/>
<!-- 針對now進行日期格式化  	-->
Tokyo(both): <fmt:formatDate value="${now }" type="both" dateStyle="long"/><br>

<fmt:setTimeZone value="Europe/Berlin"/>
Berlin(date): <fmt:formatDate value="${now }" type="date" dateStyle="long"/><br>

<fmt:setTimeZone value="Europe/Paris"/>
Paris(time): <fmt:formatDate value="${now }" type="time" dateStyle="long"/><br>

<fmt:setTimeZone value="Europe/Paris"/>
Paris: <fmt:formatDate value="${now }" type="both" dateStyle="long" pattern="yyyy-MM-dd HH:mm:ss"/>

<hr>
<h3>貨幣數字</h3>
Default: <fmt:formatNumber value="1234567.123456"/><br>
<!-- maxFractionDigits: 設定小數最大值 (四捨五入)	 -->
maxFractionDigits : <fmt:formatNumber value="1234567.1234" maxFractionDigits="2"/><br>
groupingUsed : <fmt:formatNumber value="1234567.1234" maxFractionDigits="2" groupingUsed="group"/><br>
maxIntegerDigits : <fmt:formatNumber value="1234567.1234" maxFractionDigits="2" groupingUsed="group" maxIntegerDigits="4"/><br>
<!-- currencyCode: ISO 4217 -->
Currency : <fmt:formatNumber value="1234567.1234" maxFractionDigits="2" type="currency" currencyCode="TWD" /><br>
Percent: <fmt:formatNumber value="0.25" type="percent"/>
<hr>

</body>
</html>