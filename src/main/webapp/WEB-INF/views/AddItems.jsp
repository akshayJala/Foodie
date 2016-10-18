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
        <li><a href="AddItems">View Items</a></li>
        <li><a href="AddSupplier">Suppliers</a></li>
        <li><a href="AddCategory">Categories</a></li>
        <li><a href="Order">Logout</a></li>
		
		
		
</div>
      </ul>
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
<h3>Available Items List</h3>
<c:if test="${!empty itemList}">
<table class="tg">
<tr>
    <th width="80">Item ID</th>
    <th width="120">Item Name</th>
    <th width="200">Item Description</th>
    <th width="80">Price</th>
    <th width="80">Item Category</th>
    <th width="80">Item Supplier</th>
    <th width="60">Edit</th>
    <th width="60">Delete</th>
    </tr>
    <c:forEach items="${itemList}" var="item">
    <tr>
    <td>${item.itemid}</td>
    <td>${item.itemname}</td>
    <td>${item.description}</td>
    <td>${item.price}</td>
    <td>${item.category.categoryname}</td>
    <td>${item.supplier.suppliername}</td>
    <td><a href="<c:url value='item/edit/${item.itemid}'/>">Edit</a></td>
    <td><a href="<c:url value='item/remove/${item.itemid}'/>">Delete</a></td>
    </tr>
    </c:forEach>
    
    </table>
    </c:if>
  <div class="container">
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h3 class="title">Add Item</h3>
	               		<hr />
	               	</div>
	            </div> 
				<div class="main-login main-center">
				<c:url var="addAction" value="/AddItems"></c:url>
<form:form action="AddItems"
   enctype="multipart/form-data" method="post">
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Item Name</label>
							<div class="cols-sm-4">
								<div class="input-group">
									
									<form:input type="text" class="form-control" path="ItemName" name="name" placeholder="Enter item Name"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Item ID</label>
							<div class="cols-sm-4">
								<div class="input-group">
									
									<form:input type="text" class="form-control" path="ItemId" name="name" placeholder="Enter item ID"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Item Price</label>
							<div class="cols-sm-4">
								<div class="input-group">
									
									<form:input type="text" class="form-control" path="price" name="name" placeholder="Enter item Price"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Description</label>
							<div class="cols-sm-4">
								<div class="input-group">
									
									<form:input type="text" class="form-control" path="Description" name="name" placeholder="Enter item description"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Category ID</label>
							<div class="cols-sm-4">
								<div class="input-group">
									
									<form:input type="text" class="form-control" path="Category_id" name="name" placeholder="Enter category id"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Supplier ID</label>
							<div class="cols-sm-4">
								<div class="input-group">
									
									<form:input type="text" class="form-control" path="Supplier_id" name="name" placeholder="Enter supplier id"/>
								</div>
							</div>
						</div>
						

				
 <div class="form-group">
      <label for="inputlg">Upload Image</label>
      <input class="form-control" name="file" type="file"/>
    </div>
    <div class="form-group">
    	<button type="submit" class="btn btn-primary">Update Product</button>
   	</div>
						
          
</form:form>
<br>

</div>



</body>
</html>