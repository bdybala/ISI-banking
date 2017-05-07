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

			<!-- Left navbar -->
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

				<!-- Page Content -->
				<div class="container">
					<div class="row">
						<div class="col-md-6 col-md-offset-3">
							<div class="panel panel-login">
								<div class="panel-heading">
									<div class="row">
										<div class="col-xs-6">
											<a href="#" class="active" id="login-form-link">
												${investmentOfferShown.name} </a>
										</div>
									</div>
									<hr>
								</div>
								<div class="panel-body">
									<div class="row">
										<div class="col-lg-12">
											<form id="investment-form" 
											action=<c:url value="/put-up-investment"/>
												method="post" role="form" style="display: block;">
												<p>
													Lokata na ${investmentOfferShown.interest}% ${investmentOfferShown.interestType}
													<br /> Czas trwania: ${investmentOfferShown.duration} miesiące
												</p>
												<div class="form-group">
													<!-- TODO slider in range: ${investmentOfferShown.minSum} - ${investmentOfferShown.maxSum} -->
													<input type="number" name="balance" id="balance"
														tabindex="1" class="form-control" placeholder="Kwota"
														value="" />
													<!-- TODO choose AccNr from account lists ${loggedClient.accounts} -->
													<input type="text" name="accNr" tabindex="2" 
														class="form-control" placeholder="Numer konta"
														value="" />
													<input type="hidden" name="offerInvestmentId" value=${param.offerInvestmentId} />
													<input type="hidden" name="investmentDuration" value=${investmentOfferShown.duration} />
													<input type="hidden" name="interest" value=${investmentOfferShown.interest} />
													<input type="hidden" name="name" value="${investmentOfferShown.name}" />${investmentOfferShown.name}
												</div>
												<p>
													Rachunek:
													<c:forEach items="${loggedClient.accounts}" var="account">
														<br />
														<i>name:</i>  		${account.name} 
														<br />
														<i>accNr:</i>  		${account.accNr} 
														<br />
														<i>balance:</i>  		${account.balance}
													</c:forEach>
												</p>
												<div class="form-group">
													<div class="row">
														<div class="col-sm-6 col-sm-offset-3">
															<input type="submit" name="offer-submit"
																id="offer-submit" tabindex="4"
																class="form-control btn btn-offer" value="Potwierdz">
														</div>
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>


				<!--  
			<c:forEach items="${offerInvestments}" var="offerInvestment">
				<br /><i>id:</i>  			${offerInvestment.id} 
				<br /><i>name:</i>  		${offerInvestment.name} 
				<br /><i>interest:</i>  	${offerInvestment.interest}
				<br /><i>interestType:</i>  ${offerInvestment.interestType} 
				<br /><i>duration:</i>  	${offerInvestment.duration} 
				<br /><i>minSum:</i>  		${offerInvestment.minSum} 
				<br /><i>maxSum:</i>  		${offerInvestment.maxSum}
				<br /><i>author:</i>  		${offerInvestment.manager.firstName} ${offerInvestment.manager.lastName}
				<br />
				<br />
			</c:forEach>
			-->



			</div>
		</div>
	</div>

	<script src=<c:url value="/resources/js/jquery-2.1.4.min.js" />></script>
	<script src=<c:url value="/resources/js/script.js" />></script>
	<script src=<c:url value="/resources/js/bootstrap.min.js" />></script>
	<script src=<c:url value="/resources/js/sessionTimeoutTimer.js" />></script>

</body>
</html>