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
					<a href=<c:url value="/" /> class="pull-left visible-md visible-lg">
						<div id="logo-img"></div>
					</a>
					<div class="navbar-brand">
						<a href=<c:url value="/" />><h1>ISIS BANK</h1></a>
					</div>

				</div>

				<div id="collapsable-nav" class="collapse navbar-collapse">
					<ul id="nav-list" class="nav navbar-nav navbar-right">
						<li><a href="#"> <span class="glyphicon glyphicon-phone"></span><br>
								Kontakt
						</a></li>

						<li><a href=<c:url value="/register" />> <span
								class="glyphicon glyphicon-registration-mark"></span><br>
								Otwórz rachunek
						</a></li>
						<li><a href=<c:url value="/login" />> <span
								class="glyphicon glyphicon-log-in"></span><br> Zaloguj sie
						</a></li>

					</ul>
				</div>
				<!-- .collapse .navbar-collapse -->
			</div>
			<!-- container -->
		</nav>
	</header>


	<!-- Carousel
    ================================================== -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="first-slide" src="http://placehold.it/930x300"
					alt="First slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Załóż konto w naszym banku.</h1>

						<p>
							<a class="btn btn-lg btn-primary"
								href=<c:url value="/register" /> role="button">Załóż konto</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="second-slide" src="http://placehold.it/930x300"
					alt="Second slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Oferta lokat.</h1>
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">Learn
								more</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="third-slide" src="http://placehold.it/930x300"
					alt="Third slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Oferta kredytów.</h1>
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">Learn
								more</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<!-- .carousel -->

<!--
	<div>
		<a href=<c:url value="/register"/>> Add client</a> <br> <a
			href=<c:url value="/login"/>> Login as client</a> <br> <br>

		<c:forEach items="${clients}" var="client">
			Client:
			<br />
			<i>pesel:</i>  		${client.pesel} 
			<br />
			<i>login:</i>  		${client.login} 
			<br />
			<i>password:</i>  	${client.password}
			<br />
			<i>first name:</i>  	${client.firstName} 
			<br />
			<i>last name:</i>  	${client.lastName} 
			<br />
			<i>e-mail:</i>  		${client.email}
			<br />
			<i>phone:</i>  		${client.nrTel} 
			<br />
			<i>birthday:</i>  	${client.birthday} 
			<br />
			<br />
		</c:forEach>
	</div>
-->
	<jsp:include page="footer.jsp" />
	<script src="resources/js/jquery-2.1.4.min.js"></script>
	<script src="resources/js/script.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
