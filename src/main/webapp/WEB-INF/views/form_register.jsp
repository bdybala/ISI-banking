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

	<div class="container">
    	<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Zarejestruj się</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form id="login-form" action=<c:url value="/register"/> method="post" role="form" style="display: block;">
									<div class="form-group">
										<input type="text" name="login" id="login" tabindex="1" class="form-control" placeholder="Login" value="">
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Haslo">
									</div>
									<div class="form-group">
										<input type="text" name="pesel" id="pesel" tabindex="2" class="form-control" placeholder="Pesel">
									</div>
									<div class="form-group">
										<input type="text" name="firstName" id="firstName" tabindex="2" class="form-control" placeholder="Imiona">
									</div>
									<div class="form-group">
										<input type="text" name="lastName" id="lastName" tabindex="2" class="form-control" placeholder="Nazwisko">
									</div>
									<div class="form-group">
										<input type="text" name="email" id="email" tabindex="2" class="form-control" placeholder="E-mail">
									</div>
									<div class="form-group">
										<input type="text" name="nrTel" id="nrTel" tabindex="2" class="form-control" placeholder="Nr telefonu">
									</div>
									<div class="form-group">
										<input type="text" name="birthday" id="birthday" tabindex="2" class="form-control" placeholder="Data urodzenia">
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Zarejestruj się">
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-lg-12">
												<div class="text-center">
													<a href="recover_password.html" tabindex="5" class="forgot-password">Zapomniales hasla?</a>
												</div>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
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