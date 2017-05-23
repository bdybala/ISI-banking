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

<!-- added by adamoq -->
<link
	href="https://code.jquery.com/ui/1.10.4/themes/flick/jquery-ui.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-2.1.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

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

				<%-- <br /> <i>Accounts:</i> ${loggedClient.accounts} <br /> --%>
				<div class="balance-info text-center">
					<c:forEach items="${loggedClient.accounts}" var="account">
						<p>

							<tr>
								<td>${account.name}</td>
							</tr>
							- dostępne środki<b>
								<tr>
									<td>${account.balance}</td>
								</tr>
							</b> PLN <br />
						</p>
					</c:forEach>
				</div>
				<br />

				<div>
					<div class="panel panel-default">
						<div class="panel-heading">

							<div class="form-group">
								Historia operacji w dniach
								<t> <input type="text" id="datetime1" /> <input type="text"
									id="datetime2" />
							</div>

						</div>
						<!-- TODO: widok dla pobranych transakcji -->
						<c:forEach items="${loggedClient.accounts}" var="account">

							<table class="table table-striped">
								<thead>
									<tr>
										<th>Rodzaj</th>
										<th>Kwota</th>
										<th>Data zamowienia</th>
										<th>Data realizacji</th>
										<th>Nr konta nadawcy</th>
										<th>Nr konta odbiorcy</th>
										<th>Tytul</th>
									</tr>
								</thead>
								<tbody>
									<!-- Pobieranie histrorii operacji -->
									<c:forEach items="${transferHistory }" var="accountTransfers">
										<c:forEach items="${accountTransfers }" var="transfer">


											<c:set var="className"
												value="${transfer.getClass().getName()}" />
											<c:choose>

												<c:when
													test="${className == 'isi.project.banking.dto.TransferDto'}">
													<c:set var="clientAccNr" value="${account.accNr}" />
													<c:set var="senderAccNr" value="${transfer.accNrSender}" />
													<c:choose>
														<c:when test="${clientAccNr == senderAccNr}">
															<tr>
																<td>Przelew wychodzacy</td>
														</c:when>
														<c:otherwise>
															<tr>
																<td>Przelew przychodzacy</td>
														</c:otherwise>
													</c:choose>
													<td>${transfer.amount}</td>
													<td>${transfer.orderDate}</td>
													<td>${transfer.executionDate}</td>
													<td>${transfer.accNrSender}</td>
													<td>${transfer.accNrReceiver}</td>
													<td>${transfer.title}</td>
													</tr>

												</c:when>
												<c:otherwise>
													<c:choose>
														<c:when
															test="${className == 'isi.project.banking.dto.DepositDto'}">
															<tr>
																<td><span
																	class="glyphicon glyphicon-circle-arrow-up"></span>
																	Wplata</td>
														</c:when>
														<c:otherwise>
															<tr>
																<td><span
																	class="glyphicon glyphicon-circle-arrow-down"></span>
																	Wyplata</td>
														</c:otherwise>
													</c:choose>

													<td>${transfer.amount}</td>
													<td>${transfer.orderDate}</td>
													<td>${transfer.executionDate}</td>
													<td></td>
													<td></td>
													<td></td>
													</tr>

												</c:otherwise>
											</c:choose>

										</c:forEach>
									</c:forEach>

									</div>

								</tbody>
							</table>
						</c:forEach>

					</div>
				</div>

			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(document).ready(function(){
	$('#datetime1').datepicker();
    	 $('#datetime2').datepicker();
    	var date = new Date();
    	$('#datetime2').datepicker("setDate", date);
    	date.setMonth(date.getMonth()-1) 
    	$('#datetime1').datepicker("setDate", date);
    	/* nie dziala huj wie czemu
    	tutaj dziala http://jsfiddle.net/wsodjsyv/ */
    	$("#datetime1").datepicker({
    	        todayBtn:  1,
    	        autoclose: true,
    	    }).on('changeDate', function (selected) {
    	        var minDate = new Date(selected.date.valueOf());
    	        $('#datetime2').datepicker('setStartDate', minDate);
    	    });
    	    
    	    $("#datetime2").datepicker()
    	        .on('changeDate', function (selected) {
    	            var minDate = new Date(selected.date.valueOf());
    	            $('#datetime1').datepicker('setEndDate', minDate);
    	        });
})</script>

	<script src=<c:url value="/resources/js/script.js" />></script>


</body>
</html>