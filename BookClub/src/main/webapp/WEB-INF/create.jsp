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
<title>Books</title>
</head>
<body>
	<nav class="navbar bg-light">
		<div class="container-fluid">
		<h1>Add a Book to Your Shelf</h1>
			<a class="btn btn-danger" href="/view/user">back to the shelves</a>
		</div>
	</nav>
	<div class="d-flex">
		<div class="d-block border border-dark p-4 card mx-auto w-50">
			<form:form modelAttribute="newBook" method="POST" action="/create/book">
				<form:input path="user" type="hidden" value="${id}"/>
				<div class="row">
					<div class="col-12">
						<form:label path="title" class="form-label">title</form:label>
						<form:errors path="title" class="text-danger" />
						<form:input path="title" type="text" class="form-control" />
					</div>
					<div class="col-12">
						<form:label path="author" class="form-label">author</form:label>
						<form:errors path="author" class="text-danger" />
						<form:input path="author" type="text" class="form-control" />
					</div>
					<div class="col-12">
						<form:label path="review" class="form-label">Thoughts</form:label>
						<form:errors path="review" class="text-danger" />
						<form:textarea path="review" type="text" class="form-control"></form:textarea>
					</div>
					<div>
						<button class="btn btn-primary mt-3">Submit</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>

		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
			crossorigin="anonymous"></script>
</body>
</html>