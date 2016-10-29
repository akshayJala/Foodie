<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  
  <title>Items</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .navbar {
      padding-top: 15px;
      padding-bottom: 15px;
      border: 0;
      border-radius: 0;
      margin-bottom: 0;
      font-size: 18px;
	  font-family: josefin slab;
      letter-spacing: 5px;
	  background-color: orange;
	  color: white;
	  opacity: 0.9;
	  alpha: filter (opacity=40);
  }
  .navbar li a, .navbar .navbar-brand { 
      color: white !important;
  }
  .navbar-brand{
  font-size: 40px;
  }
  .navbar-nav  li a:hover {
      color: teal !important;
	  font-size: 18px;
  }
</style>
 

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
   
     <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
     </li> <a class="navbar-brand" href="Home"><strong>Foodie</strong></a></li>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="AdminHome">Home</a></li>
        <li><a href="Order">Logout</a></li>

		
		</ul>
		
</div>
      
    </div>
  </div>
</nav>
<body>
 <div class="col-md-12 jumbotron" style="padding-top: 65px">
<div class="row">


		
	<div class="text-center">
	<h3>Welcome ${user.userName}!</h3>
	<p></p>
	</div>
	</div>
	</div>
	
<h3>Your cart..</h3>
<div class="container" id="itemTable" style="width:1145px;">
		<table class="table table-hover" id="itemList">
			<thead>
				<tr>
					<th>Image</th>
					<th>Cart ID</th>
					<th>Item Name</th>
					<th>Quantity</th>
					
					<th>Total Price</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cartList}" var="c">
					<tr>
						  <td style="width: 171px"><img
							src="<c:url value="/resources/images/${item.itemId}.jpg"/>" style="width: 100px;height: 90px;"/></td>
						<td>${c.cartId}</td>
						<td>${c.itemName}</td>
						<td>${c.quantity}</td>
					<td>${c.price}</td>
						<td>${c.total_price}</tr>	
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<div class="row">
<div class="col-sm-4">
<li><a href="Items">Add more</a></li>
</div>
</body>
</html>