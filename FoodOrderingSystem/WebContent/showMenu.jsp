<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Food Ordering System</title>
<style>
body {
  background-image: url('papaswaadpics/food3.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 5px;
  text-align: left;    
}
button {
  margin:auto;
  display:block;
}
</style>
</head>
<body style="background-color: pink">
<c:choose>
<c:when test="${elist.size()>0 }">
  
<h1><font color="orange">MENU !</font></h1>
   <table style="width:100%">
<tr>
		<td><font color="yellow"><b>Food Id</b></font></td>
		<td><font color="yellow"><b>Food Name</b></font></td>
		<td><font color="yellow"><b>Price</b></font></td>
		<td><font color="yellow"><b>Quantity</b></font></td>
	</tr>
<c:forEach var="elist" items="${elist}">
<tr>
	<tr>
	<td><font color="white">${elist.foodId}</font></td> 
	<td><font color="white">${elist.foodName}</font></td>
	<td><font color="white">${elist.price}</font></td>
	<td><font color="white">${elist.quantity}</font></td>
</tr>
</c:forEach>
</table>
<br>
</c:when>
<c:otherwise>
  <h3><center>No Data Found</center></h3>
</c:otherwise>
</c:choose>
<center><a href ="goHome.obj">Go Home</a></center><br><br>
</body>
</html>