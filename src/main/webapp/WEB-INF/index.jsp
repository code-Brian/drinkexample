<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cafe Java</title>
</head>
<body>
	<h1>Welcome to Cafe Java</h1>
	<a href="/drink/create"><button>New Drink</button></a>
	<h3>Drink List:</h3>
	 <c:forEach var="drink" items="${allDrinks}">
		<p><c:out value="${drink.name}"/> | <fmt:formatNumber value="${drink.price}" type="currency"/></p>
		<a href="/drink/${drink.id}/update"><button>Edit</button></a>
		<form action="/drink/${drink.id}" method="POST">
			<input type="hidden" name="_method" value="DELETE"/>
			<button>Delete</button>
		</form>
	</c:forEach>
</body>
</html>