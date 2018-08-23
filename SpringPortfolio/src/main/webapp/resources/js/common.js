/**
 * 
 */

function goJoinPage(){
	
	location.href = "join";
	
}


function pageBack(){
	
	history.back();
	
}


function pageMain(){
	
	location.href = "/";
	
}


function pageModify(){
	location.href = "userinfoPage";
}


//maxlength 체크
function maxLengthCheck(object){
	
	if (object.value.length > object.maxLength){
		object.value = object.value.slice(0, object.maxLength);
	}    
	
}
