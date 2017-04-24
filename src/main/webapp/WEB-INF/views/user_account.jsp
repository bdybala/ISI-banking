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

<body onload="sessionTimeout(${lastAccessTimeInMs},${sessionTimeOutPeriodInMs});">

	
	<jsp:include page="Header.jsp" />
	
	
	<div class="container-fluid text-center">    
	  <div class="row content">
		<div class="col-sm-2 sidenav">
		  <p>OFERTA</p>
		  <p><a href=<c:url value="/offer-investments"/>>Lokaty</a></p>
		  <p><a href=<c:url value="/offer-loans"/>>Kredyty</a></p>
		</div>
		<div class="col-sm-10 text-left"> 
		  <h1>Welcome</h1>
		  <p>OGOLNE INFORMACJE O KONTACH</p>
		  <hr>
	<table class = "table table-striped">
			<tbody>
			
			    <tr>
    
      <td><i>Pesel:</i> </td>
      <td>${loggedClient.pesel}</td>
       </tr>
       			    <tr>
      
      <td><i>Login:</i></td>
      <td>${loggedClient.login}</td>
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
         
      <td><i>Birthday:</i></td>
      <td>${loggedClient.birthday}</td>
       </tr>
     
       
       
			</tbody>
			</table>
			
			
			<br /><br />
		
		
		
			<i>Accounts:</i> ${loggedClient.accounts} <br />
					<c:forEach items="${loggedClient.accounts}" var="account">
			<table class = "table table-bordered">
			<tbody>
			
			    <tr>
    
      <td><i>Name:</i> </td>
      <td>${account.name}</td>
       </tr>
       			    <tr>
      
      <td><i>Account Number:</i></td>
      <td>${account.accNr}</td>
       </tr>
       			    <tr>
    
      <td><i>Balance:</i></td>
      <td>${account.balance}</td>
       </tr>
         
      <td><i>Day Limit:</i></td>
      <td>${account.dayLimit}</td>
       </tr>
           
      <td><i>Interest:</i></td>
      <td>${account.interest}</td>
       </tr>
         
      <td><i>Open Date:</i></td>
      <td>${account.openDate}</td>
       </tr>
         
      <td><i>Pesel:</i></td>
      <td>${account.pesel}</td>
       </tr>
     
       
       
			</tbody>
			</table>
				<br />
			</c:forEach>		
		
			timeLeftToSessionTimeout
			<div id ="timeLeftToSessionTimeout">
				timeLeftToSessionTimeout
			</div>
			
			
		</div>
	  </div>
	</div>
	
	<footer class="panel-footer">
		<div class="container">
		  <div class="row">
			<section id="hours" class="col-sm-6">
			  <span>Otwarty: </span><br>
			  Pon-Piatek: 8:00 - 20:00<br>
			  Sobota: 9:00 - 18:00<br>
			</section>
			<section id="address" class="col-sm-6">
			  <span>Adres:</span><br>
			  Rynek główny<br>
			  Kraków, Polska
			</section>
		  </div>
		  <div class="text-center">&copy; Copyright ISIS BANK DEVELOPEMENT</div>
		</div>
	</footer>
	<script src=<c:url value="/resources/js/jquery-2.1.4.min.js" />></script>
	<script src=<c:url value="/resources/js/script.js" />></script>
	<script src=<c:url value="/resources/js/bootstrap.min.js" />></script>
	<script src=<c:url value="/resources/js/sessionTimeoutTimer.js" />></script>

</body>
</html>