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
		<form:form modelAttribute="ninjaModel" method="POST"
			action="/add/ninja">
			<div class="row">
					<form:errors path="*"/>
				<div class="col-4">
					<form:label path="firstName">First Name</form:label>
					<form:input path="firstName" type="text" />
				</div>
				<div class="col-4">
					<form:label path="lastName">Last Name</form:label>
					<form:input path="lastName" type="text" />
				</div>
				<div class="col-4">
					<form:label path="age">Age</form:label>
					<form:input path="age" type="number"/>
				</div>
				<div class="col-4">
					<form:select class="form-select" path="Dojo">
						<form:label path="Dojo">Dojos</form:label>
						<c:forEach items="${dojoModels}" var="dojoModel">
							<form:option value="${dojoModel.id}"><c:out value="${dojoModel.name}"></c:out></form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="d-flex justify-content-center">
					<button class="btn btn-primary w-25">Submit</button>
				</div>
			</div>
		</form:form>
	</div>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>