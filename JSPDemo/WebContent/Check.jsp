<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.Login" %>
<%!String name; %>
<%
  name=request.getParameter("user");

  //RequestDispatcher rd1=request.getRequestDispatcher("Home.jsp");
  //RequestDispatcher rd2=request.getRequestDispatcher("Login.jsp");
  
  Login ll=new Login();
  ll.setUser(name);
  ll.setPass(request.getParameter("pass"));
  if(ll.checkUser().equals("success")){
	  out.println("Success!.......");
	  //rd1.forward(request,response);
%>
   <jsp:forward page="Home.jsp"></jsp:forward>
 <%	    
  }
  else{
	  out.println("Failure to login");
	  //rd2.include(request,response);                                                                                                                                                                                                                                          
%>
<jsp:include page="Login.jsp"></jsp:include>
<% 	  
  }
%>
</body>
</html>