<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.bookmanagement.spring.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% Book book = (Book)request.getAttribute("book");%>
	<div align="center">
		<h1>User Management</h1>
		<h2>
			<a href="book-new">Add New Book</a> 
			&nbsp;&nbsp;&nbsp; 
			<a href="books">List All Books</a>
		</h2>
		<form action="book-save" method="post">
			<table border="1" cellpadding="5">
				<caption>
					<h2>
						<c:choose>
							<c:when test="${book != null}">
						        Edit Book
						        <br />
							</c:when>
							<c:otherwise>
						        Add New Book
						        <br />
							</c:otherwise>
						</c:choose>
					</h2>
				</caption>
				<c:if test="${book != null}">
					<input type="hidden" name="id" value="${book.get_bookId()}" />
				</c:if>
				<tr>
					<th>Book Name:</th>
					<td><input type="text" name="name" size="45"
						value="${book.get_bookName()}" /></td>
				</tr>
				<tr>
					<th>Category:</th>
					<td><input type="text" name="category" size="45"
						value="${book.get_category().get_categName()}" /></td>
				</tr>
				<tr>
					<th>Author:</th>
					<td><input type="text" name="author" size="45"
						value="${book.getAuthorNames()}" /></td>
				</tr>
			</table>
			<input type="submit" value="Save" />
		</form>
	</div>
</body>
</html>