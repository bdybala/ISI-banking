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
	<link rel="stylesheet" href=<c:url value="/resources/css/bootstrap.min.css" />>
	<link href=<c:url value="https://fonts.googleapis.com/css?family=Oxygen:400,300,700" /> rel='stylesheet' type='text/css'>
    <link href=<c:url value="https://fonts.googleapis.com/css?family=Lora" /> rel='stylesheet' type='text/css'>

</head>

<body onload="sessionTimeout(${lastAccessTimeInMs},${sessionTimeOutPeriodInMs});">

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
              <a href=<c:url value="/logout"/>>
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
			  <li><a href=<c:url value="/"/>>MOJ BANK</a></li>
			  <li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">Konta
				<span class="caret"></span></a>
				<ul class="dropdown-menu">
						<!-- dropdown menu: accounts -->
					<c:forEach items="${loggedClient.accounts}" var="account">
						<li><a href="#"> ${account.name}</a></li>
						<li class="divider"></li>
					</c:forEach>
				  <li><a href="#">nowe konto</a></li>
				</ul>
			  </li>
			  <li><a href="user_account_transfer.html">Wykonaj przelew</a></li>
			  <li><a href="#">Lokaty</a></li>
			  
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
			  <li><a href="#">Ustawienia konta</a></li>
			  <li><a href="#">Porozmawiaj z doradca</a>
			  </li>
			</ul>
		  </div>
		</nav>
	</div>
	
	<div class="container-fluid text-center">    
	  <div class="row content">
		<div class="col-sm-2 sidenav">
		  <p>OFERTA</p>
		  <p><a href=<c:url value="/offer-investments"/>>Lokaty</a></p>
		  <p><a href=<c:url value="/offer-loans"/>>Kredyty</a></p>
		</div>
		<div class="col-sm-10 text-left"> 
		  
		  <!-- Page Content -->
		  <div class="container">
					<div class="row">
						<div class="col-md-6 col-md-offset-3">
							<div class="panel panel-login">
								<div class="panel-heading">
									<div class="row">
										<div class="col-xs-6">
											<a href="#" class="active" id="login-form-link">Lokata na wysoki procent</a>
										</div>
									</div>
									<hr>
								</div>
								<div class="panel-body">
									<div class="row">
										<div class="col-lg-12">
											<form id="investment-form" action=<c:url value="/auth"/> method="post" role="form" style="display: block;">
												<p>Lokata na 2%</br>
												Czas trwania: 3 miesiące
												</p>
												<div class="form-group">
													<input type="number" name="offer-amount" id="offer-amount" tabindex="1" class="form-control" placeholder="Kwota" value="">
												</div>
												<p>Rachunek: 			
													<c:forEach items="${loggedClient.accounts}" var="account">
														<br /><i>name:</i>  		${account.name} 
														<br /><i>accNr:</i>  		${account.accNr} 
														<br /><i>balance:</i>  		${account.balance}
													</c:forEach></p>
												<div class="form-group">
													<div class="row">
														<div class="col-sm-6 col-sm-offset-3">
															<input type="submit" name="offer-submit" id="offer-submit" tabindex="4" class="form-control btn btn-offer" value="Potwierdz">
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
			
		  
			<!--  
			<c:forEach items="${offerInvestments}" var="offerInvestment">
				<br /><i>id:</i>  			${offerInvestment.id} 
				<br /><i>name:</i>  		${offerInvestment.name} 
				<br /><i>interest:</i>  	${offerInvestment.interest}
				<br /><i>interestType:</i>  ${offerInvestment.interestType} 
				<br /><i>duration:</i>  	${offerInvestment.duration} 
				<br /><i>minSum:</i>  		${offerInvestment.minSum} 
				<br /><i>maxSum:</i>  		${offerInvestment.maxSum}
				<br /><i>author:</i>  		${offerInvestment.manager.firstName} ${offerInvestment.manager.lastName}
				<br />
				<br />
			</c:forEach>
			-->
			<br /> 
			timeLeftToSessionTimeout
			<div id ="timeLeftToSessionTimeout">
				timeLeftToSessionTimeout
			</div>
			
			
		</div>
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
	<script src=<c:url value="/resources/js/sessionTimeoutTimer.js" />></script>

</body>
</html>