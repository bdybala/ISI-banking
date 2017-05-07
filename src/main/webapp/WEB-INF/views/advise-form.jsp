<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

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

	<jsp:include page="main-header.jsp" />
	
	<div class="container-fluid text-center">    
	  <div class="row content">
		<div class="col-sm-2 sidenav">
		  <p>Konta</p>
		  <p><a href="user_account_ekonto.html">eKonto</a></p>
		  <p><a href="user_account_ekontosaver.html">eKontoSaver</a></p>
		</div>
		<div class="col-sm-8 text-left"> 
		  <h1>Przelew</h1>
			<form class="form-horizontal">
			<div class="form-group">
				<div class="col-sm-8"> 
					<select class="col-sm-4"><!--  pobieranie z serwera kont ktore nalezy wyswietlic  -->
					  <option value="eKonto">eKonto</option>
					  <option value="eKontoSaver">eKontoSaver</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-8">
				  <input type="number" class="form-control" id="nrKonta" placeholder="Imię i nazwisko" required> 
			</div>
			</div>
			  <div class="form-group">
				<div class="col-sm-8"> 
				  <input type="<strong>email</strong>" class="form-control" id="transfer_title" placeholder="Podaj adres e-mail" name="transferTitle" required >
				</div>
			</div>
			  <div class="form-group">
				<div class="col-sm-8"> 
				  <input type="text" class="form-control" id="transfer_amount" placeholder="0,00" >
			  </div>
	
			  </div>
			</form>
		  <hr>
		</div>
	  </div>
	</div>
	
		<jsp:include page="footer.jsp" />
		</body>
</html>