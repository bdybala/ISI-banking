<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>ISIS Chat</title>
<link rel="stylesheet" href=<c:url value="/resources/css/styles.css" />>
<script src=<c:url value="/resources/js/stomp/sockjs-0.3.4.js" />></script>
<script src=<c:url value="/resources/js/stomp/stomp.js" />></script>
<script src=<c:url value="/resources/js/stomp/stomp-client.js" />></script>
        
</head>
<body onload="disconnect()">
<h3>I.S.I.S. Group  Welcome to our chat.</h3>
<nav id="header-nav" class="navbar navbar-default">
<center>
	<div id = "chat-form">
		<div style="background:white"> <center>
			<input type="text" style = "text-align: center;"id="from" placeholder="Choose a nickname" />
		<br>
		<br />
		
			<button id="connect" onclick="connect();">Connect</button>
			<button id="disconnect" disabled="disabled" onclick="disconnect();">
				Disconnect</button> </center>
		</div>
		<br />
		<div id="conversationDiv">
			<input type="text" id="text" placeholder="Write a message..." />
			<button id="sendMessage" onclick="sendMessage();">Send</button>
		
		</div>
	</div> </center>
	</nav>
	<p id="response" ></p>
</body>
</html>