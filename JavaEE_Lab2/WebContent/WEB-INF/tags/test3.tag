<!-- 
自訂標籤3
加減乘除
 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 收到參數x,y -->
<%@ attribute name="x" required="true" %>
<%@ attribute name="y" required="true" %>

<!-- 宣告變數 -->
<%@ variable name-given="add" %>
<%@ variable name-given="subtract" %>
<%@ variable name-given="multi" %>
<%@ variable name-given="divide" %>

<!-- 引用core taglib 並運用EL進行運算
	c:set = 放入pageContext的attribute
	這裡也可以改寫成Java	 -->
<c:set var="add" value="${x + y }"/>
<c:set var="subtract" value="${x - y }"/>
<c:set var="multi" value="${x * y }" />
<c:set var="divide" value="${x / y }" />

<!-- 標籤會是執行完後才送到HTML -->
<!--  這裡是設定執行 -->
<jsp:doBody/>