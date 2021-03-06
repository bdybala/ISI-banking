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

	DELETE CLIENT KURWA
	<br>

	<form:form modelAttribute="cl" action="delete-client" method="POST">
		<form:select path="pesel">
			<form:option value="0">--SELECT--</form:option>
			<c:forEach items="${allClients}" var="client">
				<form:option value="${client.pesel}">
					#${client.pesel}  ${client.firstName} ${client.lastName}
				</form:option>
			</c:forEach>
		</form:select>
		<input type="submit" value="usuń">
	</form:form>



</body>
<script src=<c:url value="/resources/js/jquery-2.1.4.min.js" />></script>
<script src=<c:url value="/resources/js/script.js" />></script>
<script src=<c:url value="/resources/js/bootstrap.min.js" />></script>
</html>