<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href=<c:url value="/cashiersupervisor"/>>WIDOK
						GLOWNY</a></li>

				<!-- Przygotowanie ofert -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> Oferta<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href=<c:url value="#"/>> Dodaj</a></li>
						<li class="divider"></li>
						<li><a href=<c:url value="#"/>> Edytuj</a></li>
						<li class="divider"></li>
						<li><a href=<c:url value="#"/>> Usuń</a></li>
					</ul></li>

				<!-- Operacje wobec klienta -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Klient <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href=<c:url value="#"/>> Zablokuj kartę</a></li>
						<li class="divider"></li>
						<li><a href=<c:url value="#"/>> Zablokuj konto</a></li>
						<li class="divider"></li>
						<li><a href=<c:url value="#"/>> Historia transakcji</a></li>
					</ul></li>

				<!-- Podgląd wniosków o blokadę konta danego kredytobiorcy -->
				<li><a href=<c:url value="#"/>> Wnioski</a></li>

			</ul>
		</div>
	</nav>
</div>