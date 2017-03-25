//TODO воткнуть на страничку
function ready() {
    console.log("Ready. Try to listening /answer.sse");
    var source = new EventSource("/answer.sse");
    source.onmessage = function (event) {
        document.getElementById("main__messages").innerHtml += "<p>dfsfsdfds</p>";
        console.log("=======");
        console.log(event);
        console.log("=======");
    }
}

document.addEventListener("DOMContentLoaded", ready);