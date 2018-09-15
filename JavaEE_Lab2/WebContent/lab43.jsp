<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// 這裡面的都是區域變數
	String x = request.getParameter("x");
	String y = request.getParameter("y");
	String op = request.getParameter("op");
	
	int intX = 0;
	int intY = 0;
	int answer = 0;
	
		if (x != null && y != null) {
			try {
				intX = Integer.parseInt(x);
				intY = Integer.parseInt(y);
				
				switch (op) {
				case "1":
					answer = intX + intY;
					break;
				case "2":
					answer = intX - intY;
					break;
				case "3":
					answer = intX * intY;
					break;
				case "4":
					answer = intX / intY;
					break;
				default:
					op = "1";
					break;
				}
				
			} catch (Exception exception) {
				intX = 0;
				intY = 0; 
			}
		} else {
			intX = 0;
			intY = 0;
		}
		
		
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab43(JSP)_X+Y=?</title>
</head>
<body>
	<form>
		<input type="text" name="x" value="<%= intX %>"> 
		<select name="op">
			<option value="1" <%= op.equals("1")?"selected":"" %>>+</option>
			<option value="2" <%= op.equals("2")?"selected":"" %>>-</option>
			<option value="3" <%= op.equals("3")?"selected":"" %>>x</option>
			<option value="4" <%= op.equals("4")?"selected":"" %>>/</option>
		</select> <input type="text" name="y" value="<%= intY %>"> <input type="submit" value="=">
		<%= answer %>
	</form>

</body>
</html>