<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>ISIS BANK</title>
<link rel="stylesheet" href=<c:url value="/resources/css/styles.css" />>
<link rel="stylesheet"
	href=<c:url value="/resources/css/bootstrap.min.css" />>
<link
	href=<c:url value="https://fonts.googleapis.com/css?family=Oxygen:400,300,700" />
	rel='stylesheet' type='text/css'>
<link
	href=<c:url value="https://fonts.googleapis.com/css?family=Lora" />
	rel='stylesheet' type='text/css'>

</head>

<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="navbar.jsp" />
<table class="table table-responsive-striped" >
	<tbody>
								<tr>
									<td><i>Imię</i></td>
									<td><i>Nazwisko</i></td>
									<td><i>E-mail</i></td>
									<td><i>Numer telefonu</i></td>
									<td><i>Data urodzin</i></td>
									<td></td><td></td>
								</tr>
	<c:forEach items="${allClients}" var="client">
	<tr>
									<td>${client.firstName } </td>
									<td>${client.lastName } </td>
									<td>${client.email } </td>
									<td>${client.nrTel } </td>
									<td>${client.birthday } </td>
									<td>	<form action=<c:url value="/admin/delete-client" /> method="Post">
			<input type="hidden" name="pesel" value="${client.pesel }"> <button
				type="submit" > <span class="glyphicon glyphicon-trash"></span></button>
		</form> </td>
									<td>	<form action=<c:url value="/admin/clients/edit" /> method="Post">
			<input type="hidden" name="pesel" value="${client.pesel }"> <button type="submit" ><span class="glyphicon glyphicon-edit"></span> </button>
		</form> </td>
								</tr>
		
	
		
	

	</c:forEach>
	<br>
	<br>
	<form action=<c:url value="/admin/add-client" /> method="Post">
		<input type="hidden" name="pesel" value="${client.pesel }"> <button
			type="submit">Dodaj </button> <br> <br>
	</form>

</body>
<script src=<c:url value="/resources/js/jquery-2.1.4.min.js" />></script>
<script src=<c:url value="/resources/js/script.js" />></script>
<script src=<c:url value="/resources/js/bootstrap.min.js" />></script>
</html>