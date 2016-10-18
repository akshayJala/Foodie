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

<h3>Available Supplier List</h3>
<c:if test="${!empty itemList}">
<table class="tg">
<tr>
    <th width="80">Supplier ID</th>
    <th width="120">Supplier Name</th>
    <th width="200">Supplier Address</th>
    <th width="60">Edit</th>
    <th width="60">Delete</th>
    </tr>
    <c:forEach items="${supplierList}" var="item">
    <tr>
    <td>${supplier.supplierid}</td>
    <td>${supplier.suppliername}</td>
    <td>${supplier.address}</td>
    <td><a href="<c:url value='item/edit/${supplier.supplierid}'/>">Edit</a></td>
    <td><a href="<c:url value='item/remove/${supplier.supplierid}'/>">Delete</a></td>
    </tr>
    </c:forEach>
    
    </table>
    </c:if>


  <div class="container">
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h4 class="title">Add Supplier</h4>
	               		<hr />
	               	</div>
	            </div> 
				<div class="main-login main-center">
				<c:url var="addAction" value="/AddSupplier"></c:url>
<form:form action="AddSupplier" method="post">
						
						
					
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Supplier ID</label>
							<div class="cols-sm-4">
								<div class="input-group">
									
									<form:input type="text" class="form-control" path="SupplierId" name="name" placeholder="Enter Supplier id"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Supplier Name</label>
							<div class="cols-sm-4">
								<div class="input-group">
									
									<form:input type="text" class="form-control" path="SupplierName" name="name" placeholder="Enter Supplier Name"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Address</label>
							<div class="cols-sm-4">
								<div class="input-group">
									
									<form:input type="text" class="form-control" path="Address" name="name" placeholder="Enter Address"/>
								</div>
							</div>
						</div>
						
    <div class="form-group">
    	<button type="submit" class="btn btn-primary">Add Supplier</button>
   	</div>
						
          
</form:form>
    

</body>
</html>