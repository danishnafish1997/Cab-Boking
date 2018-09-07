<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.CabBooking.Cab.Bean.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking History</title>
</head>
<body bgcolor=CadetBlue>
	<div style="text-align:center; padding:5px;background-color: Teal;">
	<h1 align="center">Hello <%=session.getAttribute("loginid") %></h1>
	<h1 align="center">Welcome</h1>
	</div>
	<h1 align="center"> Booked Ticket Details </h1>
	<%  ArrayList<BookingBean> bookingBean= (ArrayList<BookingBean>)request.getAttribute("bookingBean");
	System.out.println(bookingBean);%>
	<table align="center" bgcolor="white">
	<tr><td><b>BookingID</b></td><td><b>Vehicle Number</b></td>
	<td><b>BookingDate</b></td> </tr>
	<%
	for (Iterator iterator=bookingBean.iterator(); iterator.hasNext();)
	{
		BookingBean booking=(BookingBean)iterator.next();%>
	<tr><td><%=booking.getBookingId() %></td><td><%=booking.getVehicleNumber() %></td>
	<td><%=booking.getBookingDate().toString().substring(0, 11) %></td></tr>
	<% } %>
	</table>
</body>
</html>