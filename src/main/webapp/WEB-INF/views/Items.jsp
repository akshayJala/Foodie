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
  body{
  font-family: josefin slab;
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
	<h3>Welcome Admin!</h3>
	</div>
	</div>
	</div>
	
<ul><h3><center>Available Items List</center></h3></ul>
<div class="container" id="itemTable" style="width:1145px;">
		<table class="table table-hover" id="itemList">
			<thead>
				<tr>
					<th>Image</th>
					<th>Item ID</th>
					<th>Item Name</th>
					<th>Item Price</th>
					<th>Description</th>
					<th>Category</th>
					<th>Supplier</th>
					
					
				
					
					
					<th>View 
					
					/ Add to Cart
					
					
					 
					/Edit/Delete
					
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itemList}" var="item">
					<tr>
						  <td style="width: 171px"><img
							src="<c:url value="/resources/images/${item.itemId}.jpg"/>" style="width: 100px;height: 90px;"/></td>
						<td>${item.itemId}</td>
						<td>${item.itemName}</td>
						<td>${item.price}</td>
						<td style="width: 180px">${item.description}</td>
						<td>${item.category_id}</td>
					<td>${item.supplier_id}</td>
						
					<td><a href="item/edit/${item.itemId}" class="btn btn-success" style="margin-left: 5px"> <span
									class="glyphicon glyphicon-edit"></span></a>
								<a href="item/remove/${item.itemId}" class="btn btn-danger" style="margin-left: 5px"> <span
									class="glyphicon glyphicon-trash"></span></a></td>	
						
							
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container">
<div class="row">
<div class="col-sm-4">
<li><a href="AddItems">AddItems</a></li>
</div>
</div>
</body>
</html>