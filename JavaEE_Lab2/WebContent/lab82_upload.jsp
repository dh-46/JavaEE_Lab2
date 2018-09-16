<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab84_0916PM1_file upload</title>
</head>
<body>
	<h3>lab84_0916PM1_file upload</h3>
	<hr>
	<form action="lab85_upload.jsp" method="post" enctype="multipart/form-data">
		<input type="text" name="user"/> <br>
		<input type="file" name="upload"><br>
		<input type="file" name="upload"><br>
		<input type=submit value="Upload"><br>
	</form>
</body>
</html>