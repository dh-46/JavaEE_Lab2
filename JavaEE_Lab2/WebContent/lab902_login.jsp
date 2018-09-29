<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//	session is New 避免利用網址列輸入帳號密碼
	if (session.isNew() || request.getParameter("account") == null || request.getParameter("password") == null) {
		response.sendRedirect("lab892_login.jsp");
		return;
	}	
	
	// 檢查帳號密碼
	String account = request.getParameter("account");
	String password = request.getParameter("password");
	
	if (account.equals("dh46") && password.equals("123")) {
		session.setAttribute("account", account);
		response.sendRedirect("lab912_view.jsp");
	} else {
		response.sendRedirect("lab892_login.jsp");
	}
	
	//	session 不要放太多資料, 盡量只有重要的判斷資訊, 以免影響伺服器效能
%>
