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

<body
	onload="sessionTimeout(${lastAccessTimeInMs},${sessionTimeOutPeriodInMs});">


	<jsp:include page="user-header.jsp" />
	<jsp:include page="user-navbar.jsp" />
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<p>OFERTA</p>
				<p>
					<a href=<c:url value="/offer-investments"/>>Lokaty</a>
				</p>
				<p>
					<a href=<c:url value="/offer-loans"/>>Kredyty</a>
				</p>
			</div>
			<div class="col-sm-10 text-left">
				<h1>Twoje lokaty</h1>

				<hr>
				<br />

				<c:forEach items="${loggedClient.accounts}" var="account">
					<c:forEach items="${account.investments}" var="investment">

						<table class="table table-striped" style="width: 700px">
							<tbody>
								<tr>
									<td><i>Nazwa lokaty:</i></td>
									<td>${investment.name}</td>
								</tr>
								<tr>
									<td><i>Id:</i></td>
									<td>${investment.id}</td>
								</tr>
								<tr>
									<td><i>Oprocentowanie:</i></td>
									<td>${investment.interest}%</td>
								</tr>
								<tr>
									<td><i>Balans:</i></td>
									<td>${investment.balance}</td>
								</tr>
								<tr>
									<td><i>Data przyznania:</i></td>
									<td>${investment.openDate}</td>
								</tr>
								<tr>
									<td><i>Data zakończnenia:</i></td>
									<td>${investment.closeDate}</td>
								</tr>
								<tr>
									<td><i>Numer rachunku:</i></td>
									<td>${investment.accNr}</td>
								</tr>

							</tbody>
						</table>
						<br>
						<br>
					</c:forEach>
				</c:forEach>
			</div>
		</div>
	</div>
	<script src=<c:url value="/resources/js/jquery-2.1.4.min.js" />></script>
	<script src=<c:url value="/resources/js/script.js" />></script>
	<script src=<c:url value="/resources/js/bootstrap.min.js" />></script>
	<script src=<c:url value="/resources/js/sessionTimeoutTimer.js" />></script>

</body>
</html>