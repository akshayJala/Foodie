<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
  
  <title>OrderNow</title>
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
  
  .carousel-inner img {
      width: 100%; /* Set width to 100% */
	  height: 300;
      margin: fixed;
  }
  .carousel-caption h3 {
      color: #fff !important;
  }
  @media (max-width: 600px) {
    .carousel-caption {
      display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */
    }
	.img-caption h3 {
      color: #fff !important;
  }
  .jumbotron{
  background-image: url();
  
  }
  #background{
  width: 100%;
  height: 100%;
  padding-top: 0.1px;
  padding-right: 0px;
  }
  #bg-img{
  width: 100%;
  position: absolute;
  }
  
  #content{
  font-family: josefin slab;
  color: #FFF;
  letter-spacing: 3px;
  font-size: 18px;
  width: 100%;
  height: 100%;
  position: relative;
  padding-top: 165px;
  }
  .col-md-12{
  font-family: josefin slab;
  }
  .col-md-4{
  padding-left: 30px;
  width: 50%;}
  .row{
  padding-left: 20px;
  
  }
  @media (max-width: 600px) {
    .img-caption {
      display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */}
	  .container1{
	  padding-top: 95px;
	  }
    .footer{
                bottom: 0px;
                position: fixed;
                background-color: orange;
				opacity: 0.9;
                color: white;
                width: 100%;
                text-align: left;
            }

  </style>
  <body>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
   
     <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
     </li> <a class="navbar-brand" href="#"><strong>Foodiee</strong></a></li>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="Cart" ><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
      </ul>
        
	   <ul class="nav navbar-nav navbar-right">
        <li><a href="Order" ><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </ul>
		
		
</div>
      </ul>
    </div>
  </div>
</nav>
 

    <div class="col-md-12 jumbotron" style="padding-top: 65px">
<div class="row">


		
	<div class="text-center">
	<h1>Order Online!</h1>
	<p>We have the best chefs around India to make 
	your tummy full with fresh and delicious food!</p>
	<a href="About" class="btn btn-lg btn-info">More info</a>
	</div>
	</div>
	</div>
<div class="container">
  <h2>Your Cart</h2>
  <div class="panel panel-default">
    <div class="panel-heading">Your item has been added to the cart</div>
    <div class="panel-body">
    	<c:forEach var="c" items="${ViewCart}">
    	<div class="row">
    		<div class="col-lg-4">
    		<img src="/resources/images/${item.itemId}.jpg" style="float: left;max-width: 100px;max-height: 100px;"/>
			${c.cartGroupId.productId.name}</div>
			<div class="col-lg-4">
				<input type="number" value="${c.quantity}"/>
			</div>
			<div class="col-sm-2">$ ${c.total_Price}</div>
			<div class="col-sm-2">
				
				<a href="/Cart/delete?c=${c.cartId}"><img src="/ecomerce/resources/images/delete.png" width="20" height="20"></a>
			</div>
    	</div>
    	<p style="visibility: hidden;">${sum=sum+c.totatPrice}</p>
    	</c:forEach>
    </div>
    <div class="panel-footer">
    	<div class="row">
			<div class="col-lg-8" style="font-size: 30px;">Total</div>
			<div class="col-sm-4" style="font-size: 30px;">$ ${sum}</div>
    	</div>
    	<div class="row">
			<div class="col-lg-8"></div>
			<div class="col-sm-4">
				<a href="../User/shipTo?c=${cart.cartId}" class="btn btn-info" role="button">Proceed to Shipment</a>
			</div>
    	</div>
    </div>
    </div>
</div>
</body>
</html>