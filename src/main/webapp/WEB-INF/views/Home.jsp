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
      display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */
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
        <li><a href="Home">Home</a></li>
        <li><a href="About">Know Us</a></li>
        <li><a href="Contact">Contact Us</a></li>
		<li><a href="Order">Order Your Meal</a></li>
		
		
</div>
      </ul>
    </div>
  </div>
</nav>
  <body>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="C:\Users\user\Desktop\New folder\01.jpg" alt="family" width="800" height="200">
        <div class="carousel-caption">
          <h3>The Family Combos</h3>
          <p>Best choice for families..</p>
        </div>      
      </div>

      <div class="item">
        <img src="C:\Users\user\Desktop\New folder\02.jpg" alt="BBQ" width="800" height="200">
        <div class="carousel-caption">
          <h3>Barbecue</h3>
          <p>Who doesn't love it?</p>
        </div>      
      </div>
    
      <div class="item">
        <img src="C:\Users\user\Desktop\New folder\03.jpg" alt="veg" width="800" height="200">
        <div class="carousel-caption">
          <h3>Do you know?</h3>
          <p>There are hundreds of recepies in veg!!</p>
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
<div class="container">

<h1>Our special recepies..</h1><br>
<h3>Why don't you start with something special?</h3>
  <div class="row">
    <div class="col-md-4">
      <div class="panel panel-success">
        <div class="panel-heading">Barbecue</div>
        <div class="panel-body"><img src="C:\Users\user\Desktop\New folder\panel1.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Fishes have rich protiens</div>
      </div>
    </div>
    <div class="col-md-4">
      <div class="panel panel-success">
        <div class="panel-heading">Many loves chicken</div>
        <div class="panel-body"><img src="C:\Users\user\Desktop\New folder\panel2.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">How about crispy meat?</div>
      </div>
    </div>
    <div class="col-md-4">
      <div class="panel panel-success">
        <div class="panel-heading">RECOMMENDED STARTER!</div>
        <div class="panel-body"><img src="C:\Users\user\Desktop\New folder\panel3.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Just forget about this world!</div>
      </div>
    </div>
  </div>
</div><br>

<div class="container">
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
</body>
</html>