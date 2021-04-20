<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h2>Register</h2>
		<br />
		<form action="clientServlet" method="POST" class="container">
			<div class="form-group">
				<label for="name">Name</label> 
				<input id="name" name="name"
					type="text" placeholder="your name" class="form-control">
			</div>
			<div class="form-group">
				<label for="email">E-mail</label> 
				<input id="email" name="email"
					type="email" placeholder="your email" class="form-control">
			</div>
			<div class="form-group">
				<label or="phone">Phone</label> 
				<input id="phone" name="phone"
					type="text" placeholder="your phone" class="form-control">
			</div>
			<input type="submit" value="Add" id="btn-Login" class="btn btn-primary">
		</form>
	</div>
</body>
</html>