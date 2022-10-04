<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruit Loops</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	<h1 class="center">Fruit Basket</h1>
	<div class="container text-center">
		<table class="col-sm box table table-bordered">
			<thead class="table-light">
				<tr class="col-6">
					<th scope="col">Fruit</th>
					<th scope="col">Price</th>
		    	</tr>
		    </thead>	
			    <c:forEach var="onefruit" items="${FruitController}">
					<tr class="space">
			        <td class="col-6"> 
			        	<c:out value=" ${onefruit.name}"></c:out> 
			        </td>
			        <td> 
			        	<c:out value=" ${onefruit.price}"></c:out> 
			        </td>
					</tr>
			    </c:forEach>
	    </table>
	</div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>