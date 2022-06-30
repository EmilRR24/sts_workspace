 var loggle = document.getElementById("loginHide");
 var roggle = document.getElementById("registrationHide");
 
 function loginToggle(){
	roggle.style.display = "none";
	if (loggle.style.display === "block"){
		loggle.style.display = "none";
		
	}
	else{
		loggle.style.display = "block";
	}
}

function registerToggle(){
	loggle.style.display = "none";
	if(roggle.style.display === "block"){
		roggle.style.display = "none";
	}
	else{
		roggle.style.display = "block";
	}
}

var addoggle = document.getElementById("addHide");
var spendoggle = document.getElementById("spendHide");

function addToggle(){
	spendoggle.style.display = "none";
	if (addoggle.style.display === "block"){
		addoggle.style.display = "none";
	}
	else{
		addoggle.style.display = "block";
	}
}

function spendToggle(){
	addoggle.style.display = "none";
	if(spendoggle.style.display === "block"){
		spendoggle.style.display = "none";
	}
	else{
		spendoggle.style.display = "block";
	}
}

var updateoggle = document.getElementById("updateHide");

function updateToggle(){
	if(updateoggle.style.display === "block"){
		updateoggle.style.display = "none";
	}
	else{
		updateoggle.style.display = "block";
	}
}