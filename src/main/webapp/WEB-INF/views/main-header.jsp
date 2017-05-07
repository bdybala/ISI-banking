<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

