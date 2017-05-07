<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<nav id="header-nav" class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a href=<c:url value="/"/> class="pull-left visible-md visible-lg">
					<div id="logo-img"></div>
				</a>
				<div class="navbar-brand">
					<a href=<c:url value="/"/>> Investment Group</a>
				</div>
			</div>
			<div id="collapsable-nav" class="collapse navbar-collapse">
				<ul id="nav-list" class="nav navbar-nav navbar-right">
				<li>Czas do konca sesji: <p id="timeLeftToSessionTimeout"> </li>
					<li><a href=<c:url value="/logout" />> <span
							class="glyphicon glyphicon-log-out"></span><br> Wyloguj się
					</a></li>

				</ul>
			</div>
			<!-- .collapse .navbar-collapse -->
				

		</div>
		<!-- container -->
	</nav>
</header>
<script src=<c:url value="/resources/js/sessionTimeoutTimer.js" />></script>

