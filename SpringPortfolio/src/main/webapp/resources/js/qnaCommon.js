/**
 * 
 */
function move_qna_list(){
	//alert("move_qna_list()");	
	
	location.href = "/qnalist";
}

function qna_write_confirm(){
	//alert("qna_write_confirm()");
	
	var form = document.qnaWrite;
	
	if(form.qna_title.value.trim() == ""){
		alert("제목을 작성해 주세요.");
		return;
	}
	
	if(form.qna_content.value.trim() == ""){
		alert("내용을 작성해 주세요.");
		return;
	}
	
	var url = "/qnaWriteConfirm";
	
	form.action = url;
	form.method = "post";
	
	form.submit();
}

function qna_write(){
	
	location.href = "/qnaWrite";
	
}

function qna_view(qna_idx){
	
	var url = "/qnaView";
	var form = document.createElement("form");
	
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "post");
	form.setAttribute("action", url);
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type","hidden");
	hiddenField.setAttribute("name","qna_idx");
	hiddenField.setAttribute("value",qna_idx);
	
	form.appendChild(hiddenField);
	document.body.appendChild(form);
	
	//alert(qna_idx);
	
	form.submit();
}

function qna_modify(qna_title,qna_content, qna_idx){

	var url = "/qnaWrite";
	var form = document.createElement("form");
	
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "post");
	form.setAttribute("action", url);
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type","hidden");
	hiddenField.setAttribute("name","qna_title");
	hiddenField.setAttribute("value",qna_title);
	
	form.appendChild(hiddenField);
	
	var hiddenField2 = document.createElement("input");
	hiddenField2.setAttribute("type","hidden");
	hiddenField2.setAttribute("name","qna_content");
	hiddenField2.setAttribute("value",qna_content);
	
	form.appendChild(hiddenField2);
	
	var hiddenField3 = document.createElement("input");
	hiddenField3.setAttribute("type","hidden");
	hiddenField3.setAttribute("name","qna_idx");
	hiddenField3.setAttribute("value",qna_idx);
	
	form.appendChild(hiddenField3);
	
	document.body.appendChild(form);
	
	form.submit();
}

function qna_modify_confirm(qna_idx){

	var form = document.qnaWrite;
	
	if(form.qna_title.value.trim() == ""){
		alert("제목을 작성해 주세요.");
		return;
	}
	
	if(form.qna_content.value.trim() == ""){
		alert("내용을 작성해 주세요.");
		return;
	}
	
	var url = "/qnaModifyConfirm";
	form.action = url;
	form.method = "post";
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type","hidden");
	hiddenField.setAttribute("name","qna_idx");
	hiddenField.setAttribute("value",qna_idx);
	
	form.appendChild(hiddenField);
	
	form.submit();
	
}