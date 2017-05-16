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
	
	<script src="jquery-3.2.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/locale/pl.js" integrity="sha256-H6L26BWbdqmD2F7C+En+WYLy9TIxvuFGBAUQHGljuTE=" crossorigin="anonymous"></script>

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
<script type="text/javascript">
$(document).ready(function() {
        $(function () {
            $('#datetimepicker6').datetimepicker();
            $('#datetimepicker7').datetimepicker({
                useCurrent: false //Important! See issue #1075
            });
            $("#datetimepicker6").on("dp.change", function (e) {
                $('#datetimepicker7').data("DateTimePicker").minDate(e.date);
            });
            $("#datetimepicker7").on("dp.change", function (e) {
                $('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
            });
        });
    });
</script>


<div class="container">
    <div class='col-md-5'>
        <div class="form-group">
            <div class='input-group date' id='datetimepicker6'>
                <input type='text' class="form-control" />
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
            </div>
        </div>
    </div>
    <div class='col-md-5'>
        <div class="form-group">
            <div class='input-group date' id='datetimepicker7'>
                <input type='text' class="form-control" />
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
            </div>
        </div>
    </div>
</div>




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
					<div class="panel panel-primary">
						<div class="panel-heading">Historia operacji
						
	
						
						
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
								
								
								<c:set var="className" value="${transfer.getClass().getName()}"/>
									<c:choose>

										<c:when test = "${className == 'isi.project.banking.model.transfer.Transfer'}">
											<c:set var="clientAccNr" value="${account.accNr}"/>
								<c:set var="senderAccNr" value="${transfer.accNrSender}"/>
											<c:choose>												
												<c:when test = "${clientAccNr == senderAccNr}">
													 <tr>
        												<td>Przelew wychodzacy </td>
												</c:when>
												<c:otherwise>
													 <tr>
       													 <td>Przelew przychodzacy </td>
												</c:otherwise>
											</c:choose>
											  <td>${transfer.amount} </td>
									        <td>${transfer.orderDate} </td>
									        <td>${transfer.executionDate} </td>
									        <td>${transfer.accNrSender} </td>
									        <td>${transfer.accNrReceiver} </td>
									        <td>${transfer.title} </td>
									      </tr>
										
										</c:when>
										<c:otherwise>
											<c:choose>												
												<c:when test = "${className == 'isi.project.banking.model.transfer.Deposit'}">
													  <tr>
    												    <td><span class="glyphicon glyphicon-circle-arrow-up"></span>  Wplata </td>
												</c:when>
												<c:otherwise>
													<tr>
    												    <td><span class="glyphicon glyphicon-circle-arrow-down"></span>  Wyplata </td>
												</c:otherwise>
											</c:choose>
											
											 
        <td>${transfer.amount} </td>
        <td>${transfer.orderDate} </td>
        <td>${transfer.executionDate} </td>
        <td> </td>  <td> </td>  <td> </td>
      </tr>
											
										</c:otherwise>
									</c:choose>
									
								</c:forEach>
							</c:forEach>
							
					</div>
					
					</tbody> </table>
					</c:forEach>
					
				</div>
			</div>

		</div>
	</div>
	</div>
	<script src=<c:url value="/resources/js/jquery-2.1.4.min.js" />></script>
	<script src=<c:url value="/resources/js/script.js" />></script>
	<script src=<c:url value="/resources/js/bootstrap.min.js" />></script>

</body>
</html>