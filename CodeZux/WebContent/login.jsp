<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>

	<form action ="LogInAction"  method = "post">
		<table>

			<tr><th>User ID : </th> <td><input style = "text" name = "uid"></td></tr>
	
			<tr><th>Password: </th> <td><input style = "text" name = "upassword"></td></tr>
			
			<tr><td></td><td><input type = "submit" values = "Log In "></td></tr>
		</table>
	</form>

</body>
</html>