<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Book Now</title>
  <link href="${contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
   <c:if test="${user == null}">
       <c:redirect url="http://localhost:8200/"></c:redirect>
   </c:if>
  <%@include file="navigation.jsp" %>
   <br><br><br>
   <div class="container col-lg-5">
    <table class="table table-responsive-sm table-bordered table-dark">
     <thead>
       <tr>
         <th>Driver Id</th> <td>${driver.driverId}</td>
       </tr>
       <tr>
         <th>Driver Name</th> <td>${driver.driverName}</td>
       </tr>
       <tr>  
         <th>Vehicle Number</th><td>${driver.vehicleNumber}</td>
       </tr>
        <tr>
         <th>Vehicle Name</th><td>${vehicle.vehicleName} </td>
       </tr>
       <tr>
         <th>Contact Number</th><td>${driver.driverContactNumber}</td>
       </tr>
       <tr></tr>
     </thead>
   
    </table>
   </div> 
   
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>  