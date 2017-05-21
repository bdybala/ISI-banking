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
	<jsp:include page="main-header.jsp" />
		<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-12">
								<p>Wylogowano pomyślnie!</p>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 col-sm-offset-3">
								<a href=<c:url value="/login" /> class="button">Zaloguj się ponownie</a>
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-sm-6 col-sm-offset-3">
								<a href=<c:url value="/" /> class="button">Przejdź do strony głównej</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>