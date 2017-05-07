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
				<h1>Welcome</h1>
				<p>OGOLNE INFORMACJE O KONTACH</p>
				<hr>
				<table class="table table-striped">
					<tbody>
						<tr>
							<td><i>Pesel:</i></td>
							<td>${loggedClient.pesel}</td>
						</tr>
						<tr>
							<td><i>Login:</i></td>
							<td>${loggedClient.login}</td>
						</tr>
						<tr>
							<td><i>First Name:</i></td>
							<td>${loggedClient.firstName}</td>
						</tr>
						<tr>
							<td><i>Last Name:</i></td>
							<td>${loggedClient.lastName}</td>
						</tr>
						<tr>
							<td><i>Email:</i></td>
							<td>${loggedClient.email}</td>
						</tr>
						<tr>
							<td><i>Numer telefonu:</i></td>
							<td>${loggedClient.nrTel}</td>
						</tr>
						<tr>
							<td><i>Birthday:</i></td>
							<td>${loggedClient.birthday}</td>
						</tr>
					</tbody>
				</table>


				<br /> <br /> <i>Accounts:</i> ${loggedClient.accounts} <br />
				<c:forEach items="${loggedClient.accounts}" var="account">
					<c:forEach items="${account.investments}" var="investment">
						<i>id: </i> ${investment.id} <br />
						<i>name: </i> ${investment.name} <br />
						<i>openDate: </i> ${investment.openDate} <br />
						<i>closeDate: </i> ${investment.closeDate} <br />
						<i>interest: </i> ${investment.interest} <br />
						<i>balance: </i> ${investment.balance} <br />
						<i>accNr: </i> ${investment.accNr} <br />
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