var stompClient = null;

function setConnected(connected) {
	document.getElementById('connect').disabled = connected;
	document.getElementById('disconnect').disabled = !connected;
	document.getElementById('conversationDiv').style.visibility
	= connected ? 'visible' : 'hidden';
	document.getElementById('response').innerHTML = '';
}

function connect() {
	var socket = new SockJS('/banking/chat');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/messages', function(messageOutput) {
			showMessageOutput(JSON.parse(messageOutput.body));
		});
	});
}

function disconnect() {
	if(stompClient != null) {
		stompClient.disconnect();
	}
	setConnected(false);
	console.log("Disconnected");
}

function sendMessage() {
	var from = document.getElementById('from').value;
	var text = document.getElementById('text').value;
	stompClient.send("/app/chat", {},
			JSON.stringify({'from':from, 'text':text}));
}

function showMessageOutput(messageOutput) {
	var response = document.getElementById('response');
	var p = document.createElement('p');
	var div = document.createElement('div');
	p.style.wordWrap = 'break-word';
	if(messageOutput.from != document.getElementById('from').value) div.style.backgroundColor = "orange";
	else {
		div.style.backgroundColor = "#cdcdcd";
		div.style.float = "right";

	}
	div.style.width = "450px";
	div.style.position = "relative";
	div.style.clear = "right";
	div.style.margin = "10px";
	div.style.padding = "10px";

	p.appendChild(document.createTextNode(messageOutput.from + ": "
			+ messageOutput.text ));
	var p2 = document.createElement('p');
	p2.style.fontSize = "11px";
	p2.appendChild(document.createTextNode(formatTime(messageOutput.time)));
	div.appendChild(p);
	div.appendChild(p2);
	response.appendChild(div);
}

function formatTime(time) {
	var date = new Date(time);
	var monthNames = [
		"January", "February", "March",
		"April", "May", "June", "July",
		"August", "September", "October",
		"November", "December"
		];

	var day = date.getDate();
	var monthIndex = date.getMonth();
	var year = date.getFullYear();
	var hour = date.getHours();
	var minutes = date.getMinutes();
	var seconds = date.getSeconds();

	return day + ' ' + monthNames[monthIndex] + ' ' + year + ' ' + hour + ':' + minutes + ';' + seconds;
}






