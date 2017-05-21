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
				<p>NASZA OFERTA KREDYTÓW:</p>

				<!-- Page Content -->
				<div class="container">

					<!-- Page Header -->
					<div class="row">
						<div class="col-lg-12">
							<h1>Kredyty</h1>
						</div>
					</div>
					<!-- /.row -->

					<!-- Projects Row -->
					<div class="row">

						<c:forEach items="${offerMortgageLoans}" var="offerMortgageLoan">
							<div class="col-md-6 portfolio-item">
								<a href=<c:url value="/offer-mortgage"/>> <img
									class="img-responsive" src="http://placehold.it/700x400" alt="">
								</a>
								<h3>
									<a href=<c:url value="/offer-loans#-1?offerMortgageLoanId=${offerMortgageLoan.id}"/>>${offerMortgageLoan.name}</a>
								</h3>
								<p>
									<br /> <i>id:</i> ${offerMortgageLoan.id} <br /> <i>name:</i>
									${offerMortgageLoan.name} <br /> <i>interest:</i>
									${offerMortgageLoan.interest} <br /> <i>interestType:</i>
									${offerMortgageLoan.interestType} <br /> <i>minSum:</i>
									${offerMortgageLoan.minSum} <br /> <i>maxSum:</i>
									${offerMortgageLoan.maxSum} <br /> <i>minInstallments:</i>
									${offerMortgageLoan.minInstallments} <br /> <i>maxInstallments</i>
									${offerMortgageLoan.maxInstallments} <br /> <i>author</i>
									${offerMortgageLoan.manager.firstName}
									${offerMortgageLoan.manager.lastName}
								</p>
							</div>
						</c:forEach>
						
						<c:forEach items="${offerCashLoans}" var="offerCashLoan">
							<div class="col-md-6 portfolio-item">
								<a href=<c:url value="/offer-loans-1"/>> <img
									class="img-responsive" src="http://placehold.it/700x400" alt="">
								</a>
								<h3>
									<a href=<c:url value="/offer-loans#-1?offerMortgageLoanId=${offerCashLoan.id}"/>>${offerCashLoan.name}</a>
								</h3>
								<p>
									<br /> <i>id:</i> ${offerCashLoan.id} <br /> <i>name:</i>
									${offerCashLoan.name} <br /> <i>interest:</i>
									${offerCashLoan.interest} <br /> <i>interestType:</i>
									${offerCashLoan.interestType} <br /> <i>minSum:</i>
									${offerCashLoan.minSum} <br /> <i>maxSum:</i>
									${offerCashLoan.maxSum} <br /> <i>minInstallments:</i>
									${offerCashLoan.minInstallments} <br /> <i>maxInstallments</i>
									${offerCashLoan.maxInstallments} <br /> <i>author</i>
									${offerCashLoan.manager.firstName}
									${offerCashLoan.manager.lastName}
								</p>
							</div>
						</c:forEach>


					</div>
					<!-- /.row -->

					<!-- Projects Row -->
					<div class="row">
						<div class="col-md-6 portfolio-item">
							<a href="#"> <img class="img-responsive"
								src="http://placehold.it/700x400" alt="">
							</a>
							<h3>
								<a href="#">Zapytaj doradce o kredyt</a>
							</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Nam viverra euismod odio, gravida pellentesque urna varius
								vitae.</p>
						</div>
					</div>
					<!-- /.row -->
				</div>


			</div>
		</div>
	</div>
	<script src=<c:url value="/resources/js/jquery-2.1.4.min.js" />></script>
	<script src=<c:url value="/resources/js/script.js" />></script>
	<script src=<c:url value="/resources/js/bootstrap.min.js" />></script>
	<script src=<c:url value="/resources/js/sessionTimeoutTimer.js" />></script>

</body>
</html>