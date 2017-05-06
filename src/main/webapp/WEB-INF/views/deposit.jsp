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

	<jsp:include page="Header.jsp" />
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
				<p>NASZA OFERTA LOKAT:</p>

				<!-- Page Content -->
				<div class="container">

					<!-- Page Header -->
					<div class="row">
						<div class="col-lg-12">
							<h1>Lokaty</h1>
						</div>
					</div>
					<!-- /.row -->

					<!-- Projects Row -->
					<div class="row">

						<c:forEach items="${deposit}" var="deposit">
						<p>
							<div class="col-md-6 portfolio-item">
								
								</a>
								<p>
								<table class="table table-striped">
									<tbody>

										<tr>

											<td><i>id:</i></td>
											<td>${deposit.id}</td>
										</tr>
										<tr>

											<td><i>balance:</i></td>
											<td>${deposit.balance}</td>
										</tr>
										<tr>

											<td><i>orderDate:</i></td>
											<td>${deposit.orderDate}</td>
										</tr>

										<td><i>executionDate:</i></td>
										<td>${deposit.executionDate}</td>
										</tr>

										<td><i>accNr:</i></td>
										<td>${deposit.accNr}</td>
										</tr>

								



									</tbody>
								</table>
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

				<br /> timeLeftToSessionTimeout
				<div id="timeLeftToSessionTimeout">timeLeftToSessionTimeout</div>


			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	<script src=<c:url value="/resources/js/jquery-2.1.4.min.js" />></script>
	<script src=<c:url value="/resources/js/script.js" />></script>
	<script src=<c:url value="/resources/js/bootstrap.min.js" />></script>
	<script src=<c:url value="/resources/js/sessionTimeoutTimer.js" />></script>

</body>
</html>