<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Food</title>
<style>
body {
  background-image: url('papaswaadpics/food.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
  }
table {
  font-family: verdana;
  font-size: 15px;
}
</style>
<script type="text/javascript">
    function redirect()
    
    
     
    {
    var url = "http://localhost:8099/successOrder.jsp";
    window.location(url);
    }
</script>
</head>
<body style="background-color: pink">
   <h1><font color="orange">ORDER HERE!</font></h1>
   <form:form action="placeOrder.obj" method="post"
      modelAttribute="ord">
      <table style="width:100%" border="1" >
         <tr>
            <td><strong><font color="white">Customer Name</font></strong></td>
            <td><form:input path="name" /> 
            <form:errors path="name" /></td>
         </tr>
         <tr>
            <td><strong><font color="white">Address</font></strong></td>
            <td><form:input path="addr" /> 
            <form:errors path="addr" /></td>
         </tr>
         <tr>
         	<td><strong><font color="white">Mobile</font></strong></td>
         	<td><form:input path="mobile" /> 
         	<form:errors path="mobile" /></td>
         </tr>         
         <tr>
            <td><strong><font color="white">Item Name</font></strong></td>
            <td><form:select path="foods">
                  <form:option value="Select"></form:option>
                  <form:options items="${flist}"/>
               </form:select><form:errors path="foods" /></td>
               </tr>
               <tr>
            <td><strong><font color="white">Quantity</font></strong></td>
             <td><form:select path="quantity">
                  <form:option value="Select"></form:option>
                  <form:options items="${qtylist}"/>
               </form:select><form:errors path="quantity" /></td>
         </tr>
         <tr>
            <td><input type="submit" value="Place Order" />
                 <input type="reset" value="Cancel"></td>
            <td><a href ="goHome.obj">Go Home</a><br><br></td>
         </tr></table>
         </form:form>
</body>
</html>