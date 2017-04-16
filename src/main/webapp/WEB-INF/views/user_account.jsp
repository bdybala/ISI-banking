<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>ISIS BANK</title>
	<link rel="stylesheet" href=<c:url value="/resources/css/styles.css" />>
	<link rel="stylesheet" href=<c:url value="/resources/css/bootstrap.min.css" />>
	<link href=<c:url value="https://fonts.googleapis.com/css?family=Oxygen:400,300,700" /> rel='stylesheet' type='text/css'>
    <link href=<c:url value="https://fonts.googleapis.com/css?family=Lora" /> rel='stylesheet' type='text/css'>

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
				<a href=<c:url value="/"/>><h1>ISIS BANK</h1></a>
			</div>
			
			</div>
			
			<div id="collapsable-nav" class="collapse navbar-collapse">
			<ul id="nav-list" class="nav navbar-nav navbar-right">

            <li>
              <a href="logOut.html">
                <span class="glyphicon glyphicon-log-out"></span><br> Wyloguj sie</a>
            </li>

				
			</ul>
         </div><!-- .collapse .navbar-collapse -->
		  </div><!-- container -->
		</nav>
	</header>
	
	<div>
		<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
			<ul class="nav navbar-nav">
			  <li><a href="user_account.html">Home</a></li>
			  <li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">Konta
				<span class="caret"></span></a>
				<ul class="dropdown-menu">
				  <li><a href="user_account_ekonto.html">eKonto</a></li>
				  <li class="divider"></li>
				  <li><a href="#">eKontoSaver</a></li>
				  <li class="divider"></li>
				  <li><a href="#">eKontoCHUJWIECO</a></li>
				</ul>
			  </li>
			  <li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">Karty
				<span class="caret"></span></a>
				<ul class="dropdown-menu">
				  <li><a href="#">Debetowe</a></li>
				  <li class="divider"></li>
				  <li><a href="#">Kredytowe</a></li>
				</ul>
			  </li>
			  <li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">Kredyty
				<span class="caret"></span></a>
				<ul class="dropdown-menu">
				  <li><a href="#">Gotowkowy</a></li>
				  <li class="divider"></li>
				  <li><a href="#">Hipoteczny</a></li>
				</ul>
			  </li>
			  <li><a href="#">Page 3</a></li>
			</ul>
		  </div>
		</nav>
		<div>
			HISTORIA Operacji<br /><br />
			Logged as:<br />
			<i>PESEL:</i> ${loggedClient.pesel} <br />
			<i>Login:</i> ${loggedClient.login} <br /> 
			<i>First name:</i> ${loggedClient.firstName} <br />
			<i>Last name:</i> ${loggedClient.lastName} <br />
			<i>E-mail:</i> ${loggedClient.email} <br />
			<i>Phone:</i> ${loggedClient.nrTel} <br />
			<i>Birthday:</i> ${loggedClient.birthday} <br />
		</div>
	</div>
	
	<footer class="panel-footer">
		<div class="container">
		  <div class="row">
			<section id="hours" class="col-sm-6">
			  <span>Otwarty: </span><br>
			  Pon-Piatek: 8:00 - 20:00<br>
			  Sobota: 9:00 - 18:00<br>
			</section>
			<section id="address" class="col-sm-6">
			  <span>Adres:</span><br>
			  Rynek główny<br>
			  Kraków, Polska
			</section>
		  </div>
		  <div class="text-center">&copy; Copyright ISIS BANK DEVELOPEMENT</div>
		</div>
	</footer>
	
	
	
	<script src=<c:url value="/resources/js/jquery-2.1.4.min.js" />></script>
	<script src=<c:url value="/resources/js/script.js" />></script>
	<script src=<c:url value="/resources/js/bootstrap.min.js" />></script>

</body>
</html>