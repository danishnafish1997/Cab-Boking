<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.CabBooking.Cab.Bean.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get All Vehicles</title>
</head>
<body bgcolor=CadetBlue>
	<div style="text-align:center; padding:5px;background-color: Teal;">
	<h1 align="center">Welcome</h1>
	<h2 align="center">Detais of all the Vehicle Present</h2>
	</div>
	<% List<VehicleBean> list=(List<VehicleBean>)request.getAttribute("listOfVehicles"); %>
	
	
	<table align="center" bgcolor="white" border="2">
	<tr><td><b>Vehicle name</b></td><td><b>Vehicle Number</b></td><td><b>Seating Capacity</b></td>
	<td><b>Vehicle Type</b></td></tr>
	<%
	for (Iterator iterator=list.iterator(); iterator.hasNext();)
	{
		VehicleBean vehicleBean=(VehicleBean)iterator.next();%>
	<tr><td><%=vehicleBean.getVehicleName() %></td><td><%=vehicleBean.getVehicleNumber() %></td>
	<td><%=vehicleBean.getVehicleType() %></td></tr>
	<% } %>
	</table>
	
	<a href="home">GO to home</a>
</body>
</html>