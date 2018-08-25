/**
 * 
 */
function fn_paging(num, strSearch, url){
	//// get 방식.
	//location.href = "/userInfo?curPage=" + num;
	
	var form = document.createElement("form");
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Post");
	form.setAttribute("action", url);
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "curPage");
	hiddenField.setAttribute("value", num);
	
	if(strSearch != ""){
		var hiddenField_search = document.createElement("input");
		hiddenField_search.setAttribute("type", "hidden");
		hiddenField_search.setAttribute("name", "search");
		hiddenField_search.setAttribute("value", strSearch);
	
		form.appendChild(hiddenField_search);
	}
	
	form.appendChild(hiddenField);
	document.body.appendChild(form);
	
	form.submit();
	
}


function fn_Search(url){

	var form = document.getElementById('searchForm');
	var str = document.getElementById('search').value;
	
	if(str == ""){
		alert("검색어를 입력해주세요.");
		return;
	}
	
	form.setAttribute("method", "post");
	form.setAttribute("action", url);
	
	form.submit();
	
}
	