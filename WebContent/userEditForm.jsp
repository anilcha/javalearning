 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Edit Form</title>
<%@include file="header.jsp"%>
</head>
<body>
	<div>
	<form action="UserController" method="post">
	
	<div>
			<label>Id</label>
			<input type="text" name="id" readonly="readonly" value="${user.id}">
		</div>
		<div>
			<label>Username</label>
			<input type="text" name="user_name" value="${user.user_name}">
		</div>
		<div>
			<label>Password</label>
			<input type="text" name="password" value="${user.password}">
		</div>
		<div>
			<label>Email</label>
			<input type="Email" name="email" value="${user.email}">
		</div>
		<div>
			<label>Dob</label>
			<input type="date" name="dob" value="${user.dob}">
		</div>
		<div>
			<label>Gender</label>
			<input type="radio" name="gender" value="Male" ${user.gender == 'Male'? 'checked' : ''}>Male
			<input type="radio" name="gender" value="Memale" ${user.gender == 'Female'? 'checked' : ''}>Female
		</div>
		<div>
			<label>Hobbies</label>	
			<input type="checkbox" name="hobbies" value="Reading" <c:if test="${fn:contains(user.hobbies, 'Reading')}">checked</c:if>>Reading
			<input type="checkbox" name="hobbies" value="Playing" <c:if test="${fn:contains(user.hobbies, 'Playing')}">checked</c:if>>Playing
		</div>
		<div>
			<label>Nationality</label>
			<select name="nationality">
				<option value="Nepal" ${user.nationality == 'Nepal'? 'selected' : ''}>Nepal</option>
				<option value="USA" ${user.nationality == 'USA'? 'selected' : ''}>USA</option>
				<option value="Chinese" ${user.nationality == 'Chinese'? 'selected' : ''}>Chinese</option>
				<option value="India" ${user.nationality == 'India'? 'selected' : ''}>India</option>
				<option value="Brazil" ${user.nationality == 'Brazil'? 'selected' : ''}>Brazil</option>
				<option value="England" ${user.nationality == 'England'? 'selected' : ''}>England</option>
				<option value="Norway" ${user.nationality == 'Norway'? 'selected' : ''}>Norway</option>
				<option value="Canada" ${user.nationality == 'Canada'? 'selected' : ''}>Canada</option>
				<option value="Mexico" ${user.nationality == 'Mexico'? 'selected' : ''}>Mexico</option>
				<option value="Argentina" ${user.nationality == 'Argentina'? 'selected' : ''}>Argentina</option>
				<option value="France" ${user.nationality == 'France'? 'selected' : ''}>France</option>
			</select>
		</div>
			<div>
				<input type="submit" value="Submit">
			</div>
			</form>
	</div>
</body>
</html>