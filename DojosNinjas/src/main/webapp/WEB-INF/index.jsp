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
<title>Dojos and Ninjas</title>
</head>
<body>

	<h1 class="col-6">Welcome!</h1>
	<br>
	<div class="col-6 card md-4">
		<form:form modelAttribute="dojoModel" method="POST" action="/dojo">
			<div class="row">

				<div class="col-4">
					<form:label path="name">Dojo Name</form:label>
					<form:errors path="*"/>
					<form:input path="name" type="text" />
				</div>
				<div class="d-flex justify-content-center">
					<button class="btn btn-primary w-25">Submit</button>
				</div>
			</div>
		</form:form>
	</div>
	<br>
	<div class="col-6 card md-4">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Dojos</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach items="${dojoModels}" var="dojoModels">
						<th scope="row">${dojoModels.id}</th>
						<td><a href="/view/${dojoModels.id}"> 
								<c:out value="${dojoModels.name}"></c:out>
							</a>
						</td>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</div>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>