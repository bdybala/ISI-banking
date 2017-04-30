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
	<link rel="stylesheet" href=<c:url value="/resources/css/bootstrap.min.css" />>
	<link href=<c:url value="https://fonts.googleapis.com/css?family=Oxygen:400,300,700" /> rel='stylesheet' type='text/css'>
    <link href=<c:url value="https://fonts.googleapis.com/css?family=Lora" /> rel='stylesheet' type='text/css'>

</head>

<body>

	<jsp:include page="Header.jsp" />
	<div class="container">
    	<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Zaloguj sie</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form id="login-form" action=<c:url value="/login"/> method="post" role="form" style="display: block;">
									<div class="form-group">
										<input type="text" name="login" id="login" tabindex="1" class="form-control" placeholder="Identyfikator" value="">
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Haslo">
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Zaloguj sie">
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-lg-12">
												<div class="text-center">
													<a href="recover_password.html" tabindex="5" class="forgot-password">Zapomniales hasla?</a>
												</div>
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
	<jsp:include page="footer.jsp" />
</body>
</html>