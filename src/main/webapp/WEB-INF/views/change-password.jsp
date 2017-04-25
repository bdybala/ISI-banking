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
	
								<form id="login-form" action=<c:url value="/change-password"/> method="post" role="form" style="display: block;">
									<div class="form-group">
										<input type="password" name="oldPassword" id="oldPassword" tabindex="1" class="form-control" placeholder="Stare haslo">
									</div>
									<div class="form-group">
										<input type="password" name="newPassword" id="newPassword" th:field="*{newPassword}" tabindex="2" class="form-control" placeholder="Wprowdz nowe haslo">
									</div>	
									<div class="form-group">
										<input type="password" name="confirmPassword" id="confirmPassword"  tabindex="3" class="form-control" placeholder="Potwierdz haslo">
									</div>		
									<input type="submit" name="changePasswordSubmit" id="changePasswordSubmit" tabindex="4" class="form-control btn btn-login" value="Zmien haslo">
									</form>
	
			<div id ="timeLeftToSessionTimeout">
				timeLeftToSessionTimeout
			</div>
			
	<jsp:include page="footer.jsp" />
	
</body>
</html>