<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href=<c:url value="/admin"/>>PANEL ADMINA</a></li>

				<!-- Konta klienta -->
				<li><a href=<c:url value="/admin/clients"/>>Klienci</a></li>

				<!-- Konta pracownika -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Pracownicy <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href=<c:url value="#"/>> Kasjerzy</a></li>
						<li class="divider"></li>
						<li><a href=<c:url value="#"/>> Kierownicy</a></li>
						<li class="divider"></li>
						<li><a href=<c:url value="#"/>> Kierownicy ds. kredytów</a></li>
					</ul></li>

				<!-- Konta klienta -->
				<li><a href=<c:url value="/admin/clients"/>>Konta </a></li>
				<!-- Oferty lokat i kredytów -->
				<li><a href=<c:url value="/admin/clients"/>>Oferta</a></li>
				<!-- Kredyty -->
				<li><a href=<c:url value="/admin/clients"/>>Kredyty</a></li>
				<!-- Operacje -->
				<li><a href=<c:url value="/admin/clients"/>>Operacje</a></li>
				<!-- Lokaty -->
				<li><a href=<c:url value="/admin/clients"/>>Lokaty</a></li>
				
			</ul>
		</div>
	</nav>
</div>