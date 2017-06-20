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

<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="navbar.jsp" />


	<div class="panel-body">
		<div class="row">
			<div class="col-lg-12">
				<form id="register-form" action=<c:url value="/admin/edit-client"/>
					method="post" role="form" style="display: block;">
					<div class="form-group">
						<input type="text" name="login" id="login" tabindex="1"
							class="form-control" placeholder="Login" value="${clientToEdit.login }">
					</div>
					<!-- <div class="form-group">
						<input type="password" name="password" id="password" tabindex="2"
							class="form-control" placeholder="Haslo">
					</div> -->
					<div class="form-group">
						<input type="text" name="pesel" id="pesel" tabindex="3"
							class="form-control" placeholder="Pesel" required
							pattern="[0-9]{11}" maxlength="11" value="${clientToEdit.pesel}" contenteditable="false">
					</div>
					<div class="form-group">
						<input type="text" name="firstName" id="firstName" tabindex="4"
							class="form-control" placeholder="Imiona" required value="${clientToEdit.firstName }">
					</div>
					<div class="form-group">
						<input type="text" name="lastName" id="lastName" tabindex="5"
							class="form-control" placeholder="Nazwisko" required value="${clientToEdit.lastName }">
					</div>
					<div class="form-group">
						<input type="email" name="email" id="email" tabindex="6"
							class="form-control" placeholder="E-mail"
							pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required value="${clientToEdit.email }">
					</div>
					<div class="form-group">
						<input type="text" name="nrTel" id="nrTel" tabindex="7"
							class="form-control" placeholder="Nr telefonu" 
							pattern="[0-9]{9}" maxlength="9" value="${clientToEdit.nrTel }">
					</div>
					<div class="form-group">
						<div class="row">
							<div class="col-sm-6 col-sm-offset-3">
								<input type="submit" name="register-submit" id="register-submit"
									tabindex="9" class="form-control btn btn-login"
									value="Zapisz zmiany">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


</body>
<script src=<c:url value="/resources/js/jquery-2.1.4.min.js" />></script>
<script src=<c:url value="/resources/js/script.js" />></script>
<script src=<c:url value="/resources/js/bootstrap.min.js" />></script>
</html>