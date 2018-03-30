<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">LOGIN DETAILS</h1>
<form action="Employee" align="center" method="POST">
 EMPID:<input type="number" name="id"><br><br>
 NAME:<input type="text" name="name"><br><br>
 SALARY:<input type="number" name="salary"><br><br>
 DESG:<input type="text" name="desg"><br><br>
 <input type="submit" value="submit">
</form><br>
<a href="Employee"><p style="text-align:center">Display Employee Details</p></a>
</body>
</html>