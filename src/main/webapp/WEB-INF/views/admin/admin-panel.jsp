<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href=<c:url value="/admin"/>>WIDOK GLOWNY</a></li>

				<!-- Konta klienta -->
				<li class="dropdown"><a href=<c:url value="/admin/clients"/>>Klienci <span class="caret"></span></a>
				</li>

				<!-- Resetowanie hasła -->
				<li><a href=<c:url value="#"/>>Resetowanie hasel</a></li>

				<!-- Konta pracownika -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Konta pracownika <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href=<c:url value="#"/>> Zablokuj</a></li>
						<li class="divider"></li>
						<li><a href=<c:url value="#"/>> Edytuj</a></li>
						<li class="divider"></li>
						<li><a href=<c:url value="#"/>> Historia logów</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
</div>