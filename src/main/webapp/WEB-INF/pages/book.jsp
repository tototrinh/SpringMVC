<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.bookmanagement.spring.model.*"%>
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
		<form action="book-save" method="post">
			<table border="1">
				<caption>
					<c:choose>
						<c:when test="${not empty book}">
							<h2>Edit Book</h2>
							<br />
						</c:when>
						<c:otherwise>
							<h2>Add New Book</h2>
							<br />
						</c:otherwise>
					</c:choose>

				</caption>
				<c:if test="${not empty book}">
					<input type="hidden" name="id" value="${book.bookId}" />
				</c:if>
				<tr>
					<th>Book Name:</th>
					<td><input type="text" name="name" size="45"
						value="${book.bookName}" /></td>
				</tr>
				<tr>
					<th>Category:</th>
					<td><input type="text" name="category" size="45"
						value="${book.category.categName}" /></td>
				</tr>
				<tr>
					<th>Author:</th>
					<td><input type="text" name="author" size="45"
						value="${book.authorNames}" /></td>
				</tr>
			</table>
			<input type="submit" value="Save" />
		</form>
	</div>
</body>
</html>