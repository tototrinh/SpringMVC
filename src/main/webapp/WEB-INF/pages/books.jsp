<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>User Management</h1>
		<h2>
			<a href="book-new">Add New Book</a> 
			&nbsp;&nbsp;&nbsp; 
			<a href="books">List All Books</a>
		</h2>
		<h2 style="margin-top: 20px">
				List of Users
		</h2>
		<table border="1">
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>Category</th>
				<th>Author</th>
				<th>Actions</th>
			</tr>			
        	<c:forEach items="${listBooks}" var="book"> 
			<tr>
				<td>${book._bookId}</td>
				<td>${book._bookName}</td>
				<td>${book._category._categName}</td>
				<td>${book.getAuthorNames()}</td>
				<td>
					<a href="book-edit?id=${book._bookId}">Edit</a>
					&nbsp;&nbsp;&nbsp;&nbsp; 
					<a href="book-remove/${book._bookId}">Delete</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>