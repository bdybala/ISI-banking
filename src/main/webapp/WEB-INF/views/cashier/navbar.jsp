<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href=<c:url value="/cashier"/>>WIDOK GLOWNY</a></li>
								
								
				<!-- Otwieranie konta klienta -->
				<li><a href=<c:url value="#"/>> Utwórz rachunek</a></li>

				<!-- Wpłaty/Wypłaty -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Operacje na kontach <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href=<c:url value="/cashier/payoff"/>> Wypłata gotówki</a></li>
						<li class="divider"></li>
						<li><a href=<c:url value="/cashier/remittance"/>> Wpłata gotówki</a></li>
						<li class="divider"></li>
						<li><a href=<c:url value="/cashier/transfer"/>> Przelew</a></li>
					</ul></li>
					
				<!-- Wnioski kredytowe -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Kredyty <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href=<c:url value="/cashier/mortgage"/>> Hipoteczne</a></li>
						<li class="divider"></li>
						<li><a href=<c:url value="/cashier/credit"/>> Gotówkowe</a></li>
					</ul></li>
				<!-- Wyszukaj klienta -->
				<li><a href=<c:url value="#"/>> Wyszukaj klienta</a></li>

			</ul>
		</div>
	</nav>
</div>