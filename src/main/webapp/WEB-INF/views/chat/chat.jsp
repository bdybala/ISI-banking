<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Chat WebSocket</title>
<script src=<c:url value="/resources/js/stomp/sockjs-0.3.4.js" />></script>
<script src=<c:url value="/resources/js/stomp/stomp.js" />></script>
<script src=<c:url value="/resources/js/stomp/stomp-client.js" />></script>
        
</head>
<body onload="disconnect()">
	<div>
		<div>
			<input type="text" id="from" placeholder="Choose a nickname" />
		</div>
		<br />
		<div>
			<button id="connect" onclick="connect();">Connect</button>
			<button id="disconnect" disabled="disabled" onclick="disconnect();">
				Disconnect</button>
		</div>
		<br />
		<div id="conversationDiv">
			<input type="text" id="text" placeholder="Write a message..." />
			<button id="sendMessage" onclick="sendMessage();">Send</button>
			<p id="response"></p>
		</div>
	</div>

</body>
</html>