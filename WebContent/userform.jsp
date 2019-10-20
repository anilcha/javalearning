<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration Form</title>
<%@include file="header.jsp"%>
</head>
<body>
	<div class="container">
	<div class="col-sd-2"></div>
	<div class="rows col-sd-10 jumbotron">

	<form action="UserController" method="post" class="form-horizontal">
			<fieldset>
			<legend>User Registration Form</legend>
		<div class="form-group">
			<label>Username</label>
			<input type="text" name="user_name" class="form-control">
		</div>
		<div class="form-group">
			<label>Password</label>
			<input type="text" name="password" class="form-control">
		</div>
		<div class="form-group">
			<label>Email</label>
			<input type="Email" name="email" class="form-control">
		</div>
		<div class="form-group">
			<label>Dob</label>
			<input type="date" name="dob" class="form-control">
		</div>
		<div class="form-group">
			<label>Gender</label>
			<input type="radio" name="gender" value="Male">Male
			<input type="radio" name="gender" value="Female">Female
		</div>
		<div class="form-group">
			<label>Hobbies</label>
			<input type="checkbox" name="hobbies" value="reading">Reading
			<input type="checkbox" name="hobbies" value="playing">Playing
		</div>
		<div class="form-group">
			<label>Nationality</label>
			<select name="nationality">
				<option value="Nepal">Nepal</option>
				<option value="USA">USA</option>
				<option value="Chinese">Chinese</option>
				<option value="Brazil">Brazil</option>
				<option value="England">England</option>
				<option value="Norway">Norway</option>
				<option value="Canada">Canada</option>
				<option value="Mexico">Mexico</option>
				<option value="Argentina">Argentina</option>
				<option value="France">France</option>
			</select>
		</div>
			<div class="form-group">
				<input type="submit" value="Submit" class="btn-success">
			</div>
			</fieldset>
			</form>
		</div>
		<div class="col-sd-2"></div>
	</div>
</body>
</html>