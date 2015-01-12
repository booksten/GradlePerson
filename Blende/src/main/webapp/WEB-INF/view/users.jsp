<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${name}</title>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script>
$(document).ready(function(){
});

function getEmployees(){
	var request = $.ajax({
		url : "/blende/person",
		type : "get",
	});
	
	request.done(function(persons){
		var div = document.getElementById("people")
		
		for(var i=0; i<persons.length; i++){
			var person = persons[i];
			var row = document.getElementById("prow").cloneNode(true);
			row.id = person.id;
			row.innerHTML = person.id + " " + person.firstName + " " + person.lastName;
			div.appendChild(row);
		}
		
	});
}

function init(){
	getEmployees();
}
	
</script>
</head>
<body onload="init()">
	<div id="people">
		
	</div>
	<div id="prow">
	</div>
</body>
</html>