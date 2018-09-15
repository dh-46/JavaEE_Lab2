<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>加減乘除_EL version</title>
</head>
<body>
	<form method="post">
		<input type="text" name="x" value="${param.x}">
		<select name="op">
			<option value="1">+</option>
			<option value="2">-</option>
			<option value="3">*</option>
			<option value="4">/</option>
		</select>
		<input type="text" name="y" value="${param.y}">
		<input type="submit" value="=">
		${param.x + param.y}
	</form>
</body>
</html>