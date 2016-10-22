<!DOCTYPE html>
<html lang="en">
<head>
  
  <title>Home</title>
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
  .row{
  padding-left: 20px;
  
  }
  @media (max-width: 600px) {
    .img-caption {
      display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */;
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
     </li> <a class="navbar-brand" href="#"><strong>Foodie</strong></a></li>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="AdminHome">Home</a></li>
        <li><a href="Order">Logout</a></li>
       
      
		
		
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
<div class="row">
<div class="col-sm-4">
<li><a href="AddItems">AddItems</a></li>
</div>
<div class="col-sm-4">
<li><a href="AddCategory">AddCategories</a></li>
</div>
<div class="col-sm-4">
<li><a href="AddSupplier">AddSuppliers</a></li>
</div>
</div>
<div class="row">
<div class="col-sm-4">
<li><a href="Items">ItemsList</a></li>
</div>
<div class="col-sm-4">
<li><a href="CategoryList">CategorieList</a></li>
</div>
<div class="col-sm-4">
<li><a href="SupplierList">SupplierList</a></li>
</div>
</div>

 </body>
 </html>