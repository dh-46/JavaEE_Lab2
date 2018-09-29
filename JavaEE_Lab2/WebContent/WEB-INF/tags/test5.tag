<%@tag import="java.util.HashMap"%>
<%@ tag dynamic-attributes="product" %>
<% 
	//	把動態的參數放到Map中
	HashMap<String,String> ps = (HashMap<String,String>)jspContext.getAttribute("product");
	
	out.print("<tr>");
	
	//	確認是否有值
	if (ps.containsKey("name")) {
		out.print("<td>"+ ps.get("name") +"</td>");	
	}
	
	if (ps.containsKey("price")) {
		out.print("<td>"+ ps.get("price") +"</td>");	
	}
	
	out.print("</tr>");

%>