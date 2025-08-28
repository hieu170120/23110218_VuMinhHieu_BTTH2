<%@page import="vdmvctrenlop.LoginModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Login Success</title>
</head>
<body>
	<p>You are successfully logged in!</p>
	<%
	LoginModel bean = (LoginModel) request.getAttribute("bean");
	out.print("Welcome, " + bean.getName());
	%>
</body>
</html>