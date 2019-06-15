<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<body>
	<div id="site-wrapper">
		<p>Welcome Page of Website</p>
		<h2>Form Submit Example</h2>
		<label>URL :</label> <input type="text" name="url" id="url"
			placeholder="URL" /> <label>Method Type Save:</label> <input type="text"
			name="method" id="method" placeholder="Method Type" /> <label>Body
			:</label> <input type="text" name="body" id="body" placeholder="JSON Body" />
		<button onclick="sendRequestToBackend()">Submit</button>
		<p id = "result"></p>
		<script>
			function sendRequestToBackend() {
				var url = document.getElementById("url").value;
				var method = document.getElementById("method").value;
				var body = document.getElementById("body").value;
				//print(" " url + " " + method + " " + body)
				document.getElementById("url").value = "Hello"
				
				
				const Http = new XMLHttpRequest();
				if (method === "GET") {
				  Http.open(method, url);
				  console.log("Other Req");
				  Http.send();
				} else {
				  Http.open(method, url, true);
	     		  Http.setRequestHeader('Content-Type', 'application/json');
	     		  console.log(body);
	     		  var data = JSON.stringify(body);
	     		  Http.send(data);
				}

				Http.onreadystatechange = (e) => {
				  console.log(Http.responseText)
				  alert(result);
				}
				document.getElementById("url").value = "world"
			}
		</script>
	</div>
</body>
</html>