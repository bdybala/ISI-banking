<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
									<li><a href=<c:url value="/logout" />> <span
							class="glyphicon glyphicon-home"></span>
					</a></li>
				<!-- Rachunki -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Rachunki <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<!-- dropdown menu: accounts -->
						<c:forEach items="${loggedClient.accounts}" var="account">
							<li><a href="#"> ${account.name}</a></li>
							<li class="divider"></li>
						</c:forEach>
						<li><a href="#">nowe konto</a></li>
					</ul></li>
				<!-- Transakcje -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> Transakcje <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="user_account_transfer.html"> Przelew jednorazowy</a></li>
						<li class="divider"></li>
						<li><a href="#"> Zlecenie stałe</a></li>
					</ul></li>
				<!-- Lokaty -->
				<li><a href=<c:url value="/investments"/>> Lokaty</a></li>
				<!-- Karty -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Karty <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href=<c:url value="/card"/>> Debetowe</a></li>
						<li class="divider"></li>
						<li><a href=<c:url value="/card"/>> Kredytowe</a></li>
					</ul></li>
				<!-- Kredyty -->
				<li><a href=<c:url value="/loans"/>>Kredyty</a></li>


				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Zalogowany jako
						${loggedClient.firstName} ${loggedClient.lastName} <span
						class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href=<c:url value="/#"/>>Ustawienia konta</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li id="contact"><a href="#">Kontakt z doradcą</a></li>
			</ul>
		</div>
	</nav>
</div>