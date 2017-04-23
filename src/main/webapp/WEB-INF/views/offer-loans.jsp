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
		  Logged as:<br />
			<i>PESEL:</i> ${loggedClient.pesel} <br />
			<i>Login:</i> ${loggedClient.login} <br /> 
			<i>First name:</i> ${loggedClient.firstName} <br />
			<i>Last name:</i> ${loggedClient.lastName} <br />
			<i>E-mail:</i> ${loggedClient.email} <br />
			<i>Phone:</i> ${loggedClient.nrTel} <br />
			<i>Birthday:</i> ${loggedClient.birthday} <br />
			<br /><br />
			<i>Accounts:</i> ${loggedClient.accounts} <br />
			
			<c:forEach items="${loggedClient.accounts}" var="account">
				<br /><i>name:</i>  		${account.name} 
				<br /><i>accNr:</i>  		${account.accNr} 
				<br /><i>balance:</i>  		${account.balance}
				<br /><i>dayLimit:</i>  	${account.dayLimit} 
				<br /><i>interest:</i>  	${account.interest} 
				<br /><i>openDate:</i>  	${account.openDate} 
				<br /><i>pesel:</i>  		${account.pesel}
				<br />
				<br />
			</c:forEach>
			
			<br /> 
			timeLeftToSessionTimeout
			<div id ="timeLeftToSessionTimeout">
				timeLeftToSessionTimeout
			</div>
			
			
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