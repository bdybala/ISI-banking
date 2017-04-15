<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

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
		<form:form method = "POST" action = "/login">
         <table>
            <tr>
               <td><form:label path = "login">login</form:label></td>
               <td><form:input path = "login" /></td>
            </tr>
            <tr>
               <td><form:label path = "password">password</form:label></td>
               <td><form:input path = "password" /></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form:form>
		
		
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
