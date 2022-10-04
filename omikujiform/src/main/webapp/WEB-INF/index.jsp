<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<title>Omikuji Form</title>
</head>
<body>
	<h1 class="center">Send an Omikuji!</h1>
	<div class=" container d-block mx-auto w-50 my-4 border p-4">
		<form action="/submit" method="Post">
			<div class="mb-3">
				<label>Pick any number from 5 to 25</label>
					<select name="number">
						<c:forEach var="number" items="${numbers}">
							<c:if test="${number ge 5}">
								<option value="${number}">${number}</option>
							</c:if>
						</c:forEach>
					</select>					  
			</div>
			<br/>
			<label>Enter the name of any city</label>
			<div class="mb-3">
				<input type="text" name="city">
			</div>
			<br/>
			<label>Enter the name of any real person</label>
			<div class="mb-3">
				<input type="text" name="name">
			</div>
			<br/>
			<label>Enter a professional endeavor or hobby</label>
			<div class="mb-3">
				<input type="text" name="job">
			</div>
			<br/>
			<label>Enter any type of living thing</label>
			<div class="mb-3">
				<input type="text" name="things">
			</div>
			<br/>
			<label>Say something nice to someone:</label>
			<div class="mb-3">
				<textarea name="nice"></textarea>
			</div>
			<div class="mb-3">
			<button type="submit" class="btn btn-secondary">Submit</button>
			</div>
		</form>
	</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>