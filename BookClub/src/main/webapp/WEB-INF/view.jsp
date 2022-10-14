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
			<h1>
				Hello There <span class="badge bg-secondary"><c:out
						value="${user.username}"></c:out></span>
			</h1>
			<a class="btn btn-danger" href="/logout">Logout</a>
		</div>
	</nav>
	<div class="d-felx">
		<div class="text-center">
			<h4>Books from Everyone Shelfs</h4>
			<a href="/create/book">+ Add to my shelf</a>
		</div>
			<br>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Title</th>
					<th scope="col">Author Name</th>
					<th scope="col">Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${book}" var="book">
					<tr>
						<th scope="row"><c:out value="${book.id}"></c:out></th>
						<td><a href="/book/${book.id}"><c:out
									value="${book.title}"></c:out></a></td>
						<td><c:out value="${book.author}"></c:out></td>
						<td><c:out value="${book.user.username}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>