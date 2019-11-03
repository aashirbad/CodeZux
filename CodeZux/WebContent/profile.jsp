<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user profile</title>
</head>
<body>
<% for (int i = 0 ; i < 10; i ++)
	{ out.print("\t");%>
<h1>Hey</h1>
<h2> ${uid}</h2>
<%} %>

</body>
</html>