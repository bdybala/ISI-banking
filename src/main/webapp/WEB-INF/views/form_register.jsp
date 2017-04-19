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

		<form id="register-form" action=<c:url value="/register"/> method="post" role="form" style="display: block;">
			<div class="form-group">
			  <label for="firstName">Imie:</label>
			  <input type="text" class="form-control" id="firstName" required>
			</div>		
			<div class="form-group">
			  <label for="secondName">Drugie imie:</label>
			  <input type="text" class="form-control" id="secondName">
			</div>
			<div class="form-group">
			  <label for="lastName">Nazwisko:</label>
			  <input type="text" class="form-control" id="lastName" required>
			</div>
			<div class="form-group">
			  <label for="pesel">Pesel:</label>
			  <input type="number" class="form-control" id="pesel" required pattern="[0-9]{11}" maxlength="11">
			</div>
			<div class="form-group">
			  <label for="email">Adres e-mail:</label>
			  <input type="email" class="form-control" id="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required>
			</div>
			<div class="form-group">
			  <label for="phoneNumber">Telefon kontaktowy:</label>
			  <input type="number" class="form-control" id="phoneNumber" required maxlength="9">
			</div>
			<div class="form-group col-sm-6">
			  <label for="address">Miasto:</label>
			  <input type="text" class="form-control" id="address" required>
			</div>
			<div class="form-group col-sm-2">
			  <label for="cityNumber">Kod pocztowy:</label>
			  <input type="number" class="form-control" id="cityNumber" pattern="[0-9]{3}" required>
			</div>
			<br>
			<div class="form-group col-sm-6">
			  <label for="street">Ulica:</label>
			  <input type="text" class="form-control" id="street" required>
			</div>		
			<div class="form-group col-sm-3">
			  <label for="houseNumber">Numer domu:</label>
			  <input type="text" class="form-control" id="houseNumber" required>
			</div>
			<div class="form-group col-sm-3">
			  <label for="apartmentNumber">Numer mieszkania:</label>
			  <input type="text" class="form-control" id="apartmentNumber">
			</div>
			<div class="form-group col-sm-3">
			  <label for="birthDate">Data urodzenia:</label>
			  <input type="date" class="form-control" id="birthDate" min="1900-01-01">
			</div>
			<div class="form-group"> 
				<div class="col-sm-offset-5 col-sm-6">
					<button type="submit" class="btn btn-default" name="transferSubmitButton" onclick="registerSubmit"><a href="confirmRegistration.html">Potwierdz</a></button>
				</div>
			</div>
		</form>

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