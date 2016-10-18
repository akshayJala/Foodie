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
<div class="content">
<h3>Why don't you start with something special?</h3>
   <div class="row">
    <div class="col-md-2">
      <div class="panel panel-warning">
        <div class="panel-heading">Barbecue</div>
        <div class="panel-body"><img src="C:\Users\user\Desktop\New folder\panel1.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Fishes have rich protiens
		</div>
		
		
      </div>
	  </div>
	  <div class="col-md-2">
	<p>jkaebfre uwegbvirv ubgvirv urvberv usbvwrv urbvwr uvgbrv ubvwrv </p>
	<p>Item code: 123</p>
	<p>Price : Rs.125</p>
		<p><button type="button" href="#" class="btn btn-info">Buy Now</button></p>
	<p><button type="button" href="#" class="btn btn-warning">Add to cart</button></p>
	</div>
	<div class="col-md-2">
      <div class="panel panel-success">
        <div class="panel-heading">Many loves chicken</div>
        <div class="panel-body"><img src="C:\Users\user\Desktop\New folder\panel2.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">How about crispy meat?</div>
      </div>
    </div>
	<div class="col-md-2">
	<p>jkaebfre uwegbvirv ubgvirv urvberv usbvwrv urbvwr uvgbrv ubvwrv </p>
	<p>Item code: 123</p>
	<p>Price : Rs.125</p>
		<p><button type="button" href="#" class="btn btn-info">Buy Now</button></p>
	<p><button type="button" href="#" class="btn btn-warning">Add to cart</button></p>
	</div>
	<div class="col-md-2">
      <div class="panel panel-success">
        <div class="panel-heading">Recommended!</div>
        <div class="panel-body"><img src="C:\Users\user\Desktop\New folder\panel3.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Just forget about this world!</div>
      </div>
    </div>
	<div class="col-md-2">
	<p>jkaebfre uwegbvirv ubgvirv urvberv usbvwrv urbvwr uvgbrv ubvwrv </p>
	<p>Item code: 123</p>
	<p>Price : Rs.125</p>
	<p><button type="button" href="#" class="btn btn-info">Buy Now</button></p>
	<p><button type="button" href="#" class="btn btn-warning">Add to cart</button></p>
	</div>
    </div>
	
    
    
  </div>
</div><br>

<div class="container">
<div class="content">
<h3>Make Yourself HEAVY!</h3><br>
  <div class="row">
    <div class="col-md-4">
      <div class="panel panel-success">
        <div class="panel-heading">Be a HYDERABADI!</div>
        <div class="panel-body"><img src="C:\Users\user\Desktop\New folder\panel4.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Make your life worth living!</div>
      </div>
    </div>
    <div class="col-md-4">
      <div class="panel panel-success">
        <div class="panel-heading">Challenge!</div>
        <div class="panel-body"><img src="C:\Users\user\Desktop\New folder\panel5.jpg"class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">What's your capacity?</div>
      </div>
    </div>
    <div class="col-md-4">
      <div class="panel panel-success">
        <div class="panel-heading">Surprise Surprise!!</div>
        <div class="panel-body"><img src="C:\Users\user\Desktop\New folder\panel6.jpg"class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Celebrate your happiness!</div>
      </div>
    </div>
  </div>
</div><br><br>
<div class="container">
<h3>Try Now!!</h3>
<div class="row">
    <div class="col-md-4">
	<a href="#" class="thumbnail">
	<img src="C:\Users\user\Desktop\New folder\chicken65.JPG">
	</a>
<h3>Chicken 65</h3>
<p>Chicken 65 is a spicy, deep-fried chicken dish 
originating from Chennai, India, as an entrée, or quick snack.</p>
</div>
</div>

   </div>
    </div>


</body>
</html>