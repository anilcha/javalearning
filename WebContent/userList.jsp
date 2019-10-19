<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
<%@include file="header.jsp"%>
</head>
<body>
	<h1>User List</h1>
	<a href="UserController?actions=add">Add</a>
	<c:if test="${!empty users}">
		<table>
			<thead>
				<tr>
					<th>SN</th>						
					<th>ID</th>
					<th>User_Name</th>
					<th>Password</th>
					<th>Email</th>
					<th>Gender</th>
					<th>Hobbies</th>
					<th>Dob</th>
					<th>Nationality</th>
					<th>Action</th>
				</tr>
			</thead>
		<tbody>
			<c:forEach items="${users}" var="u" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td>${u.id}</td>
					<td>${u.user_name}</td>
					<td>${u.password}</td>
					<td>${u.email}</td>
					<td>${u.gender}</td>
					<td>${u.hobbies}</td>
					<td>${u.nationality}</td>
					<td>${u.dob}</td>
					<td>
						<a href="UserController?actions=edit&id=${u.id}">Edit</a>
						<a href="UserController?actions=delete&id=${u.id}">Delete</a>
					</td>			
				</tr>			
			</c:forEach>		
		</tbody>
	</table>	
	</c:if>	
</body>
</html>