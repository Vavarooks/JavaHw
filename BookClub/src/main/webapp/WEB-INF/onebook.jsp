<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<title>Book Clubs</title>
</head>
<body>

	<nav class="navbar bg-light">
		<div class="container-fluid">
			<h1 class="col-2">Book View</h1>
			<a href="/view/user">Back</a>
		</div>
	</nav>
	<div class="col d-block mx-auto w-75 my-4">
		<div class="card p-5">
			<h1>
				User:
				<c:out value="${book.user.username}"></c:out>
				had this to say about the book...
			</h1>
			<br>
			<h3>
				Title:
				<c:out value="${book.title}"></c:out>
				, By:
				<c:out value="${book.author}"></c:out>
			</h3>
			<h3>
				<c:out value="${book.review}"></c:out>
			</h3>
			<div class="d-felx text-center">
				<a class="btn btn-warning" href="/edit/${book.id}">Edit</a>
				<form action="/delete/${book.id}" method="post">
					<input type="hidden" name="method" value="delete" />
					<button class="btn btn-danger">Delete</button>
				</form>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>