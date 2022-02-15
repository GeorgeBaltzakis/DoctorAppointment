<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import = "MainClasses.Patient" %>
  
  	<%
  	Patient patient = (Patient)request.getAttribute("patient");
  	String name = patient.getName();
  	%>
<h1><%out.print(name) ;%></h1>
</body>
</html>