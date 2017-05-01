<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			  <li><a href=<c:url value="/investments"/>>Lokaty</a></li>
			  
			  <li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">Karty
				<span class="caret"></span></a>
				<ul class="dropdown-menu">
				  <li><a href=<c:url value="/card"/>>Debetowe</a></li>
				  <li class="divider"></li>
				  <li><<a href=<c:url value="/card"/>>Kredytowe</a></li>
				</ul>
			  </li>
			  <li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">Kredyty
				<span class="caret"></span></a>
				<ul class="dropdown-menu">
				  <li><a href=<c:url value="/offer-loans"/>>Gotowkowy</a></li>
				  <li class="divider"></li>
				  <li><a href=<c:url value="/offer-loans"/>>Hipoteczny</a></li>
				</ul>
			  </li>
			  	  <li ><a href="#">Porozmawiaj z doradca</a>	  </li>
			   <li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">Zalogowany jako ${loggedClient.firstName} ${loggedClient.lastName}
				<span class="caret"></span></a>
				<ul class="dropdown-menu">
				  <li><a href=<c:url value="/#"/>>Ustawienia konta</a></li>
				  <li class="divider"></li>
				  <li><a href=<c:url value="/logout"/>>Wyloguj się</a></li>
				</ul>
			  </li>
			</ul>
		  </div>
		</nav>
	</div>