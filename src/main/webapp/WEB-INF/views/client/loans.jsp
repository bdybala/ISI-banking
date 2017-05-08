<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>ISIS BANK</title>
<link rel="stylesheet"
	href='<c:url value="/resources/css/styles.css" />'>
<link rel="stylesheet"
	href='<c:url value="/resources/css/bootstrap.min.css" />'>
<link
	href='<c:url value="https://fonts.googleapis.com/css?family=Oxygen:400,300,700" />'
	rel='stylesheet' type='text/css'>
<link
	href='<c:url value="https://fonts.googleapis.com/css?family=Lora" />'
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
					<a href='<c:url value="/offer-investments"/>'>Lokaty</a>
				</p>
				<p>
					<a href='<c:url value="/offer-loans"/>'>Kredyty</a>
				</p>
			</div>
			<div class="col-sm-10 text-left">
				<h1>Twoje kredyty</h1>

				<hr>
				<br />
				<c:forEach items="${loggedClient.accounts}" var="account">
					<h3>Kredyty hipoteczne:</h3>
					<hr>
					<br>
					<c:forEach items="${account.mortgageLoans}" var="loan">
						<table class="table table-striped" style="width: 700px">
							<tbody>
								<tr>
									<td><i>Id:</i></td>
									<td>${loan.id}</td>
								</tr>
								<tr>
									<td><i>Raty:</i></td>
									<td>${loan.installments}</td>
								</tr>
								<tr>
									<td><i>Oprocentowanie:</i></td>
									<td>${loan.interest}%</td>
								</tr>
								<tr>
									<td><i>Suma:</i></td>
									<td>${loan.sum}</td>
								</tr>
								<tr>
									<td><i>Data przyznania:</i></td>
									<td>${loan.grantDate}</td>
								</tr>
								<tr>
									<td><i>Data zakończnenia:</i></td>
									<td>${loan.repaymentDate}</td>
								</tr>
								<tr>
									<td><i>Rozliczone odsetki:</i></td>
									<td>${loan.settledInterest}</td>
								</tr>
								<tr>
									<td><i>Numer rachunku:</i></td>
									<td>${loan.accNr}</td>
								</tr>
								<tr>
									<td><i>Provider:</i></td>
									<td>${loan.provider}</td>
								</tr>
							</tbody>
						</table>
						<br>
						<br>

					</c:forEach>

					<h3>Pożyczki gotówkowe:</h3>
					<hr>
					<br>
					<c:forEach items="${account.cashLoans}" var="loan">
						<table class="table table-striped" style="width: 700px">
							<tbody>
								<tr>
									<td><i>Id:</i></td>
									<td>${loan.id}</td>
								</tr>
								<tr>
									<td><i>Raty:</i></td>
									<td>${loan.installments}</td>
								</tr>
								<tr>
									<td><i>Oprocentowanie:</i></td>
									<td>${loan.interest}%</td>
								</tr>
								<tr>
									<td><i>Suma:</i></td>
									<td>${loan.sum}</td>
								</tr>
								<tr>
									<td><i>Data przyznania:</i></td>
									<td>${loan.grantDate}</td>
								</tr>
								<tr>
									<td><i>Data zakończnenia:</i></td>
									<td>${loan.repaymentDate}</td>
								</tr>
								<tr>
									<td><i>Rozliczone odsetki:</i></td>
									<td>${loan.settledInterest}</td>
								</tr>
								<tr>
									<td><i>Numer rachunku:</i></td>
									<td>${loan.accNr}</td>
								</tr>
								<tr>
									<td><i>Provider:</i></td>
									<td>${loan.provider}</td>
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

	<script src='<c:url value="/resources/js/jquery-2.1.4.min.js" />'
		type="text/javascript"></script>
	<script src='<c:url value="/resources/js/script.js" />'
		type="text/javascript"></script>
	<script src='<c:url value="/resources/js/bootstrap.min.js" />'
		type="text/javascript"></script>
	<script src='<c:url value="/resources/js/sessionTimeoutTimer.js" />'
		type="text/javascript"></script>

</body>
</html>