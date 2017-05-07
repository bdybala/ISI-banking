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
<link rel="stylesheet"
	href=<c:url value="/resources/css/bootstrap.min.css" />>
<link
	href=<c:url value="https://fonts.googleapis.com/css?family=Oxygen:400,300,700" />
	rel='stylesheet' type='text/css'>
<link
	href=<c:url value="https://fonts.googleapis.com/css?family=Lora" />
	rel='stylesheet' type='text/css'>

</head>

<body>
	<jsp:include page="admin-header.jsp" />
	<div>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<ul class="nav navbar-nav">
					<li><a href=<c:url value="/"/>>WIDOK GLOWNY</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Konta Klienta <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href=<c:url value="/admin/block-user"/>>Zablokuj</a></li>
							<li class="divider"></li>
							<li><<a href=<c:url value="/admin/edit-user"/>>Edytuj</a></li>
							<li class="divider"></li>
							<li><<a href=<c:url value="/admin/log-history-user"/>>Historia
									logow</a></li>
						</ul></li>
					<li><a href=<c:url value="/admin/eset-password"/>>Resetowanie
							hasel</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Konta pracownika <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href=<c:url value="/admin/block-employee"/>>Zablokuj</a></li>
							<li class="divider"></li>
							<li><<a href=<c:url value="/admin/edit-employee"/>>Edytuj</a></li>
							<li class="divider"></li>
							<li><<a href=<c:url value="/admin/log-history-employee"/>>Historia
									logow</a></li>
						</ul></li>
					</li>
				</ul>
			</div>
		</nav>
	</div>





</body>
</html>