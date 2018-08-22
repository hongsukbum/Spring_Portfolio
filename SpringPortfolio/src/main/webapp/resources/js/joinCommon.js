/**
 * 
 */

function checkId(){
	
	var form = document.joinForm;
	var str = form.uid.value;
	
	if(str == ""){
		alert("중복 체크할 아이디를 입력해주세요.");
	}else{
		
		var url = "/checkUser";

		
		window.open("", "popupView", "width=500, height=300, scrollbars=no");
		
		form.uid.value = str;
		form.action = url;
		form.method = "post";
		form.target="popupView";
		
		form.submit();
		
	}
	
}


function checkUsedId(){
	
	var form = opener.window.joinForm;
	var str = form.uid.value;
	
	var url = "/join";
	opener.document.getElementById("uid").value = str;
	opener.window.location = url;
	
	
	close();
	
}
