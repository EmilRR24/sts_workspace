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