<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Register</title>
<style type="text/css">
#main{
color: #fff;
}
body{
margin-left: 0px;
margin-right: 0px;
margin-top: 0px;
}
#home{
text-decoration : none;
font-weight: 500;
font-size: 20px;
margin: 2.5%;
margin-bottom: 4%;
}
table{
 padding-top: 2%;
}
td{
color: #fff;
}
</style>
</head>
<body bgcolor=CadetBlue>
	<div style="text-align:center; padding:5px;background-color: Teal;">
	<h3 align="center" style="color: red;">${message}</h3>
	<h1 align="center" style="color: #fff; margin-top: 2%; margin-bottom: 2%;">Welcome</h1>
	</div>
	<div class="container center" ><br>
	<form:form action="registerPage" METHOD="POST" modelAttribute="loginBean">
	<form:hidden path="loginid"/>
	  <fieldset>
	    <form:label path="email">Email</form:label><br/>
	    <form:input path="email" type="email" placeholder="abc@gmail.com" required="required"/>
	    <form:errors path="email"></form:errors>
	  </fieldset><br>
	  
	  <fieldset>
	    <form:label path="password">Password</form:label><br/>
	    <form:password path="password"/>
	    <form:errors path="password"/>
	  </fieldset><br>
	  
	  <fieldset>
	    <form:label path="userName">Name</form:label><br/>
	    <form:input path="userName" type="text" placeholder="abc" required="required"/>
	    <form:errors path="userName"></form:errors>
	  </fieldset><br>
	  
	  <fieldset>
	    <form:label path="userAddress">Address</form:label><br>
	    <form:input path="userAddress" type="text" placeholder="abc colony" required="required"/>
	    <form:errors path="userAddress"></form:errors>
	  </fieldset><br>
	  
	  <fieldset>
	    <form:label path="userContactNumber">Phone No.</form:label><br>
	    <form:input path="userContactNumber" type="text" placeholder="1234567890" required="required"/>
	    <form:errors path="userContactNumber"></form:errors>
	  </fieldset><br>
	  
	  <fieldset>
	    <form:label path="userType">User Type</form:label><br>
	    <form:input path="userType" type="text" placeholder="abc" required="required"/>
	    <form:errors path="userType"></form:errors>
	  </fieldset><br>
	  <form:button class="btn btn-success">submit</form:button>
	</form:form>
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>