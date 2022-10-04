<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Receipt</title>
</head>
<body>
	<h1>Customer Name: <c:out value="${customer}"/></h1>
	<h2>Item Name: <c:out value="${item}"/></h2>
	<h3>Price: <c:out value="${cost}"/></h3>
	<h3>Description: <c:out value="${details}"/></h3>
	<h3>Vendor: <c:out value="${seller}"/></h3>
</body>
</html>