<%@page import="bean.EmployeeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Employee Details</h1>
<table border="3">
<tr>
<td>ID</td>
<td>NAME</td>
<td>SALARY</td>
<td>DESIGNATION</td>
</tr>
<% 
List<EmployeeBean> li=(List<EmployeeBean>)application.getAttribute("obj");
out.println(li.size());
for(EmployeeBean emp:li){
%>
<tr>
<td><%= emp.getId() %></td>
<td><%= emp.getName() %></td>
<td><%= emp.getSalary() %></td>
<td><%= emp.getDesg() %></td>
<% } %>
</tr>
</table>
</body>
</html>