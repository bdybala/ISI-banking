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
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#collapsable-nav" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="navbar-brand">
				<a href=<c:url value="/"/>><h1>ISIS BANK</h1></a>
			</div>
			
			</div>
			
			<div id="collapsable-nav" class="collapse navbar-collapse">
			<ul id="nav-list" class="nav navbar-nav navbar-right">

            <li>
              <a href="spis.html">
                <span class="glyphicon glyphicon-log-in"></span><br> Zaloguj sie</a>
            </li>

				
			</ul>
         </div><!-- .collapse .navbar-collapse -->
		  </div><!-- container -->
		</nav>
	</header>
	
	
	
	
	<div class="pasek">
		<ol id="menu">
			<li><a href=<c:url value="/"/> img src ="/images/100x10.png" alt="Logo"/> 
			<li><a href="#">Transakcje</a>
			<li><a href="#">Przelewy</a>
			<li><a href="#"> Karty </a>
			<li><a href="log.php"> Lokaty </a>
			<li><a href="#"> Konta </a>
			<li><a href="#"> Moje Konto </a>
				<ul>
					<li><a href="#">Moje dane</a>
					<li><a href="#">Wyloguj</a>
				</ul>
		</ol>

	</div>

	<div class="main">

		<br> <b>Zgodnie z wcześniejszymi zapowiedziami, stara wersja
			serwisu internetowego iPKO zostanie wyłączona w nocy z 3 na 4
			kwietnia 2017.</b><br> Zachęcamy - zacznij korzystać już dziś z
		nowego iPKO dostępnego pod adresem https://www.ipko.pl - wersja
		demonstracyjna serwisu nowe iPKO - filmy instruktażowe <br> <b>
			Przypominamy kluczowe zalety serwisu nowe iPKO:<br>
		</b> <br> <br>
		
		<a href=<c:url value="/client"/>> Add client</a></b> <br>
		<a href=<c:url value="/login"/>> Login as client</a></b> <br> <br>
		
		<c:forEach items="${clients}" var="client">
			Client:
			<br /><i>pesel:</i>  		${client.pesel} 
			<br /><i>login:</i>  		${client.login} 
			<br /><i>password:</i>  	${client.password}
			<br /><i>first name:</i>  	${client.firstName} 
			<br /><i>last name:</i>  	${client.lastName} 
			<br /><i>e-mail:</i>  		${client.email}
			<br /><i>phone:</i>  		${client.nrTel} 
			<br /><i>birthday:</i>  	${client.birthday} 
			<br />
			<br />
		</c:forEach>

	</div>
	<div id="left_menu">
		<ol id="lmenu">
			<li><a href="#"> Menu1 </a></li>
			<li><a href="#">Menu2</a></li>
			<li><a href="#">Menu3</a></li>
			<li><a href="#"> Menu4 </a></li>
			<li><a href="log.php"> Menu5 </a></li>
			<li><a href="#"> Menu6 </a></li>
			<li><a href="#"> Menu7</a></li>
			<li><a href="#">Menu2</a></li>
			<li><a href="#">Menu3</a></li>
			<li><a href="#"> Menu4 </a></li>
			<li><a href="log.php"> Menu5 </a></li>
			<li><a href="#"> Menu6 </a></li>
			<li><a href="#"> Menu7</a></li>

		</ol>
	</div>
	<footer class="panel-footer">
		<div class="container">
		  <div class="row">
			<section id="hours" class="col-sm-4">
			  <span>Otwarty: </span><br>
			  Pon-Piatek: 8:00 - 20:00<br>
			  Sobota: 9:00 - 18:00<br>
			</section>
			<section id="address" class="col-sm-4">
			  <span>Adres:</span><br>
			  Rynek główny<br>
			  Kraków, Polska
			</section>
		  </div>
		  <div class="text-center">&copy; Copyright ISIS BANK DEVELOPEMENT</div>
		</div>
	</footer>
	
	</body>
</html>
