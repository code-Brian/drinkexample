<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cafe Java | New Drink</title>
</head>
<body>
	<h1>Create a new Drink!</h1>
	<form:form action="/drink/create" method="POST" modelAttribute="drink">
		<div>
			<form:label path="name">Name:</form:label>
			<form:input path="name"/>
			<form:errors path="name"/>
		</div>
		<div>
			<form:label path="price">Price:</form:label>
			<form:input path="price"/>
			<form:errors path="price"/>
		</div>
		<button>Submit</button>
	</form:form>
</body>
</html>