<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.example.CabBooking.Cab.Bean.*" %>
<%@ page import="java.util.*" %>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Book Now</title>
  <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
  </head>
  <body>
   <c:if test="${user == null}">
       <c:redirect url="http://localhost:8200/"></c:redirect>
   </c:if>
   <div style="text-align:center; padding:5px;background-color: Teal;">
   <h1 align="center">Welcome to Suhana Safar Travel Agency</h1>
   <h2 align="center">All Vehicles details</h2>
   </div>
   <br>
   <div class="container">
    <h1 > Thank you</h1>
    <a class="btn btn-primary" href="/CustomerHomePage">Home</a>
   </div> 
  </body>
</html>  