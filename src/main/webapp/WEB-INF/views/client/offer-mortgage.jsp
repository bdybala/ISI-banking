<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<link rel="stylesheet" href=<c:url value="/resources/css/styles.css" />>
<link rel="stylesheet"
	href=<c:url value="/resources/css/bootstrap.min.css" />>
<link
	href=<c:url value="https://fonts.googleapis.com/css?family=Oxygen:400,300,700" />
	rel="stylesheet" type='text/css'>
<link
	href=<c:url value="https://fonts.googleapis.com/css?family=Lora" />
	rel="stylesheet" type='text/css'>
	
	<link href=<c:url value="/resources/css/nouislider.min.css" /> rel="stylesheet">

<title>ISIS BANK</title>
</head>
<body>
	<jsp:include page="user-header.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Wniosek
									kredytowy</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form id="mortgage-form" action="" method="post" role="form"
									style="display: block;">

									<table class="table table-striped">
										<tbody>

											<tr>

												<td><i>Pesel:</i></td>
												<td>${loggedClient.pesel}</td>
											</tr>
											<tr>

												<td><i>First Name:</i></td>
												<td>${loggedClient.firstName}</td>
											</tr>

											<td><i>Last Name:</i></td>
											<td>${loggedClient.lastName}</td>
											</tr>

											<td><i>Email:</i></td>
											<td>${loggedClient.email}</td>
											</tr>

											<td><i>Numer telefonu:</i></td>
											<td>${loggedClient.nrTel}</td>
											</tr>




										</tbody>
									</table>

									<div class="form-group">
										<input type="number" name="mortgageAmount" id="mortgageAmount"
											tabindex="1" class="form-control" placeholder="Kwota kredytu">
									</div>
									<div class="form-group">
										<input type="number" name="mortgageLength" id="mortgageLength"
											tabindex="2" class="form-control"
											placeholder="Dlugość trwania kredytu">
									</div>
									<div class="form-group">
										<input type="number" name="mortgageMinSum" id="mortgageMinSum"
											tabindex="3" class="form-control"
											placeholder="minimalna wartosc raty">
									</div>
									<div class="form-group">
										<input type="number" name="mortgageMaxSum" id="mortgageMaxSum"
											tabindex="4" class="form-control"
											placeholder="maksymalna wartosc raty ">
									</div>

									<div id="slider">
							
									
									</div>



									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="mortgage-submit"
													id="mortgage-submit" tabindex="5"
													class="form-control btn btn-login" value="Złóż wniosek">
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

	<script src=<c:url value="/resources/js/nouislider.min.js" />></script>
	<script>
	var slider = document.getElementById('slider');


noUiSlider.create(slider, {
	start: [500, 10000],
	step: 100,
	connect: true,
	
	range: {
		'min': 500,
		'max': 10000
	}
	
});


	</script>

	
	<script src=<c:url value="/resources/js/jquery-2.1.4.min.js" />></script>
	<script src=<c:url value="/resources/js/script.js" />></script>
	<script src=<c:url value="/resources/js/bootstrap.min.js" />></script>
	<script src=<c:url value="/resources/js/sessionTimeoutTimer.js" />></script>

</body>
</html>
