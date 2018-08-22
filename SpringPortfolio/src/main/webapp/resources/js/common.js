/**
 * 
 */

function goJoinPage(){
	
	location.href = "join";
	
}


//maxlength 체크
function maxLengthCheck(object){
	
	if (object.value.length > object.maxLength){
		object.value = object.value.slice(0, object.maxLength);
	}    
	
}

