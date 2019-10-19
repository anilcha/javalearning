<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration Form</title>
<%@include file="header.jsp"%>
</head>
<body>
	<div>
	<form action="UserController" method="post">
	
		<div>
			<label>User_Name</label>
			<input type="text" name="user_name">
		</div>
		<div>
			<label>Password</label>
			<input type="text" name="password">
		</div>
		<div>
			<label>Email</label>
			<input type="Email" name="email">
		</div>
		<div>
			<label>Dob</label>
			<input type="date" name="dob">
		</div>
		<div>
			<label>Gender</label>
			<input type="radio" name="gender" value="Male">Male
			<input type="radio" name="gender" value="Female">Female
		</div>
		<div>
			<label>Hobbies</label>
			<input type="checkbox" name="hobbies" value="reading">Reading
			<input type="checkbox" name="hobbies" value="playing">Playing
		</div>
		<div>
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
			<div>
				<input type="submit" value="Submit">
			</div>
			</form>
	</div>
</body>
</html>