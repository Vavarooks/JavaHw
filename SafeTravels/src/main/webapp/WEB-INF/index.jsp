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
<title>Travel Plans</title>
</head>
<body>

	<h1 class="col-6">Welcome!</h1>
	<br>
	<div class="col-6 card md-4">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Expense</th>
					<th scope="col">Vendor</th>
					<th scope="col">Amount</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${expenses}" var="expense">
					<tr>
						<th scope="row">${expense.id}</th>
						<td><a href="/view/${expense.id}"><c:out value="${expense.name}"></c:out></a></td>
						<td><c:out value="${expense.vendor}"></c:out></td>
						<td><c:out value="$ ${expense.amount}"></c:out></td>
						<td class="d-flex justify-content-evenly"><a href="/edit/${expense.id}" class="btn btn-warning">Edit</a>
							<form action="/delete/${expense.id}" method="post">
								<input type="hidden" name="_method" value="delete"/>
								<button class="btn btn-danger">Delete</button>
							</form>	
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br>
	<div class="col-6 card md-5">
		<form:form modelAttribute="expense" method="POST" action="/home">
			<div class="row">

				<div class="col-4">
					<form:label path="name">Expense</form:label>
					<form:errors path="name" />
					<form:input path="name" type="text" />
				</div>
				<div class="col-4">
					<form:label path="vendor">Vendor</form:label>
					<form:errors path="vendor" />
					<form:input path="vendor" type="text" />
				</div>
				<div class="col-4">
					<form:label path="amount">Amount</form:label>
					<form:errors path="amount" />
					<form:input path="amount" type="number" />
				</div>
				<div class="form-floating col-4">
					<form:textarea class="form-control" path="description"
						style="height: 100px"></form:textarea>
					<form:errors path="description" />
					<form:label path="description">Description</form:label>
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