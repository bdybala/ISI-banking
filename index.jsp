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
				<img class="first-slide" src="http://the-hive.london/wp-content/uploads/2016/08/business-cash-coin-concept-900x300.jpg"
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
				<img class="second-slide" src="data:image/jpeg;base64,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"
					alt="Second slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Oferta lokat.</h1>
						<p>
							<a class="btn btn-lg btn-primary" href=<c:url value="/invest" /> role="button">Dowiedz się więcej</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="third-slide" src="https://assets.nerdwallet.com/blog/wp-content/uploads/2016/01/what-is-credit-builder-loan-story-570x225.jpg"
					alt="Third slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Oferta kredytów.</h1>
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">Dowiedz się więcej</a>
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

	<jsp:include page="footer.jsp" />
	<script src="resources/js/jquery-2.1.4.min.js"></script>
	<script src="resources/js/script.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
