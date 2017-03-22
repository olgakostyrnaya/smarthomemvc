var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#checkingLightState").show();
    }
    else {
        $("#checkingLightState").hide();
    }
    $("#light").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/light', function (light) {
            showLightState(JSON.parse(light.body).content);
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendState() {
    stompClient.send("/app/stateLight", {}, JSON.stringify({'state': $("#state").val()}));
}

function showLightState(state) {
    $("#light").append("<tr><td>" + state + "</td></tr>");
}

(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendState(); });
});