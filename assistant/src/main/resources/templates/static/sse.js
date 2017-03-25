//TODO воткнуть на страничку
var source = new EventSource("/answer.sse")
source.onmessage = function(event) {
    document.getElementById("main__messages").innerHtml+="<p>dfsfsdfds</p>"
    console.log("HHHH");
    console.log(event)
}