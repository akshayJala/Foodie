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
   <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
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
  <body>
  <nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
   
     <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
     </li> <a class="navbar-brand" href="Home"><strong>Foodiee</strong></a></li>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        
         <ul class="nav navbar-nav navbar-right">
        <li><a href="SignUp" ><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      </ul>
	   <ul class="nav navbar-nav navbar-right">
        <li><a href="Login" ><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
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
	<a href="#About" class="btn btn-lg btn-info">More info</a>
	</div>
	</div>
	</div>
<div class="container">
<div class="row">
    <div class="col-md-6">
    <div class="form-group">
   <form class="form-horizontal col-sm-12">
          <div class="form-group"><label>Name</label><input class="form-control required" placeholder="Your name" data-placement="top" data-trigger="manual" data-content="Must be at least 3 characters long, and must only contain letters." type="text"></div>
          <div class="form-group"><label>Message</label><textarea class="form-control" placeholder="Your message here.." data-placement="top" data-trigger="manual"></textarea></div>
          <div class="form-group"><label>E-Mail</label><input class="form-control email" placeholder="email@you.com (so that we can contact you)" data-placement="top" data-trigger="manual" data-content="Must be a valid e-mail address (user@gmail.com)" type="text"></div>
          <div class="form-group"><label>Phone</label><input class="form-control phone" placeholder="999-999-9999" data-placement="top" data-trigger="manual" data-content="Must be a valid phone number (999-999-9999)" type="text"></div>
          <div class="form-group"><button type="submit" class="btn btn-success pull-right">Send It!</button> <p class="help-block pull-left text-danger hide" id="form-error">&nbsp; The form is not valid. </p></div>
        </form>
    </div>
    
</div>
<div class="col-md-6">
<p><span class="glyphicon glyphicon-map-marker"></span>Hyderabad</p>
      			<p><span class="glyphicon glyphicon-phone"></span>Phone: +91 9999999999</p>
      			<p><span class="glyphicon glyphicon-envelope"></span>Email: abc@mail.com</p>
</div>
</div>
</div>


</body>
  </html>