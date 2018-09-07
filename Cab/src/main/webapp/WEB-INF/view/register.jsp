<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	<form action="registerPage" METHOD=POST >
	<table align="center" cellspacing="10">
	<tr><td> Enter LoginID</td><td><input type="text" class="form-control" name="loginid"  required="required" ></td>
	<td>${login_id_message}</td></tr>
	<tr><td>Password</td><td><input type="password" class="form-control" name="password" required = "required"/></td>
	<td>${warning}</td></tr>
	<tr><td>Confirm Password</td><td><input type="password" class="form-control" name=con_password required="required"/></td></tr>
	<tr><td>User Name</td><td><input type="text" class="form-control" name=userName required="required"/></td></tr>
   
   <tr> <td> ${message}</td></tr>
<tr><td>Address</td><td><input type="text" class="form-control" name=userAddress requird="required"/></td></tr>
	<tr><td>Mobile Number</td><td><input type="text" class="form-control" name=userContactNumber required="required"/></td></tr>
	<tr><td><input type="hidden" name="userType" " value="C" required="required"/></td></tr>
	<tr><td></td><td><input type="submit" value="Submit" style="margin: 6%; margin-left: 33%; background-color: #5cb85c; color:#fff; border-color: #4cae4c; padding:3%; font-size:15px;"></td></tr>
	</table>
	</form>
</body>
</html>