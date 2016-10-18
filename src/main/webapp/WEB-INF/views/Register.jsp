<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Register</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <form:form class="form-horizontal" action="/Register" method="post" comandName="user">
    <div class="form-group" >
      <div class="col-sm-4">
        <form:input type="text" class="form-control" path="id" placeholder="User ID"/>
      </div>   
      </div> 
      <div class="form-group">
      <div class="col-sm-4">
        <form:input type="text" class="form-control" path="name" placeholder="Name"/>
      </div>
      </div>
      <div class="form-group">
      <div class="col-sm-4">
        <form:input type="email" class="form-control" path="email" placeholder="Enter email"/>
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-4">
        <form:input type="text" class="form-control" path="Mobile" placeholder="Mobile"/>
      </div>
      </div>
      
    <div class="form-group">
      <div class="col-sm-4">
        <form:input type="password" class="form-control" path="pwd" placeholder="Enter password"/>
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-4">
        <form:input type="password" class="form-control" path="pwd" placeholder="Confirm password"/>
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-4">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form:form>
</div>
</body>
</html>

    