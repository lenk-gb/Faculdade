<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Advocacia LCA</title>
		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<c:import url="../components/menu.jsp"></c:import>
		<p class="bg-warning text-warning"><c:out value="${aviso}"></c:out></p>
		<p class="bg-succsses text-succsses"><c:out value="${aviso}"></c:out></p>
		<p class="bg-danger text-danger"><c:out value="${erro}"></c:out></p>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>