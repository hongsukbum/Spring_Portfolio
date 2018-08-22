/**
 * 
 */

function checkId(){
	
	var parentForm = document.joinForm;
	var str = parentForm.uid.value;
	var popup;
	
	if(str == ""){
		alert("중복 체크할 아이디를 입력해주세요.");
	}else{
		
		var url = "/checkUserId";
		
		popup = window.open("", "popupView","width=500, height=300, scrollbars=no");
		
		popup.focus();
		
		parentForm.uid.value = str;
		parentForm.action = url;
		parentForm.method = "post";
		parentForm.target="popupView";
		
		parentForm.submit();
			
	}
	
}


function usedId(){
	
	var form = document.joinForm;
	var str = form.uid.value;
	var url = "/join";
	
	form.uid.value = str;
	form.action = url;
	form.method = "post";
	form.target = "joinPage";	// 부모창 이름 지정하고 그리로 데이터 전송..
	
	form.submit();
	
	self.close();
	
}


function checkNick(){
	
	var parentForm = document.joinForm;
	var str = parentForm.unick.value;
	var popup;
	
	if(str == ""){
		alert("중복 체크할 닉네임을 입력해주세요.");
	}else{
		
		var url = "/checkUserNick";
		
		popup = window.open("", "popupView","width=500, height=300, scrollbars=no");
		
		popup.focus();
		
		parentForm.unick.value = str;
		parentForm.action = url;
		parentForm.method = "post";
		parentForm.target="popupView";
		
		parentForm.submit();
			
	}
	
}


function usedNick(){
	
	var form = document.joinForm;
	var str = form.unick.value;
	var url = "/join";
	
	form.unick.value = str;
	form.action = url;
	form.method = "post";
	form.target = "joinPage";	// 부모창 이름 지정하고 그리로 데이터 전송..
	
	form.submit();
	
	self.close();
	
}


function joinConfirm(){
	
	
	
}













