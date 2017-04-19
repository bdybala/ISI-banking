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
	<header>
		<nav id="header-nav" class="navbar navbar-default">
			<div class="container">
				<div class="navbar-header">
					<a href=<c:url value="/"/> class="pull-left visible-md visible-lg">
						<div id="logo-img"></div>
					</a>
					<div class="navbar-brand">
						<a href=<c:url value="/" />><h1>ISIS BANK</h1></a>
					</div>
				</div>
			</div>
			<!-- container -->
		</nav>
	</header>

	<div class="form-main-content container">
		<p class="text-center">WNIOSEK O ZALOZENIA KONTA</p>

		<form:form method="POST" action="/register">
			<table>
				<tr>
					<td><form:label path="pesel">pesel</form:label></td>
					<td><form:input path="pesel" /></td>
				</tr>
				<tr>
					<td><form:label path="login">login</form:label></td>
					<td><form:input path="login" /></td>
				</tr>
				<tr>
					<td><form:label path="password">password</form:label></td>
					<td><form:input path="password" /></td>
				</tr>
				<tr>
					<td><form:label path="firstName">firstName</form:label></td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td><form:label path="lastName">lastName</form:label></td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td><form:label path="email">email</form:label></td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td><form:label path="nrTel">nrTel</form:label></td>
					<td><form:input path="nrTel" /></td>
				</tr>
				<tr>
					<td><form:label path="birthday">birthday</form:label></td>
					<td><form:input path="birthday" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>

	</div>


	<footer class="panel-footer">
		<div class="container">
			<div class="row">
				<section id="hours" class="col-sm-6">
					<span>Otwarty: </span><br> Pon-Piatek: 8:00 - 20:00<br>
					Sobota: 9:00 - 18:00<br>
				</section>
				<section id="address" class="col-sm-6">
					<span>Adres:</span><br> Rynek główny<br> Kraków, Polska
				</section>
			</div>
			<div class="text-center">&copy; Copyright ISIS BANK
				DEVELOPEMENT</div>
		</div>
	</footer>
	<script src=<c:url value="/resources/js/jquery-2.1.4.min.js" />></script>
	<script src=<c:url value="/resources/js/script.js" />></script>
	<script src=<c:url value="/resources/js/bootstrap.min.js" />></script>
</body>
</html>