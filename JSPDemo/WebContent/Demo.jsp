<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome!.......</h1>
<%!int a,b,c; 
  String name;
%>
<%
name="Shraddha";
out.println("Welcome to JSP page");
a=50;
b=70;
c=a+b;
out.println("Sum="+c);
%>
Sum of two numbers:<%=10+20 %>
<br>
Sum of numbers:<%=c %>
<br>
<font color="blue"><b>UserName is <%=name %></b></font>
</body>
</html>