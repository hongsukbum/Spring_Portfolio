/**
 * 
 */

function productEnrollment(){
	
	var form = document.productForm;
	var url = "/product_enrollmentConfirm"
	
	var pd_name = form.pd_name.value;
	var pd_title = form.pd_title.value;
	var pd_content = form.pd_content.value;
	var pd_image = form.pd_image.value;
	var pd_charge = form.pd_charge.value;
	var pd_count = form.pd_count.value;
	
	var pd_image_tmp = pd_image.split(".");
	
	if(pd_name == ""){
		alert("상품 이름을 등록하세요.");
		return;
	}
	
	if(pd_title == ""){
		alert("상품 기본 설명을 등록하세요.");
		return;
	}
	
	if(pd_content == ""){
		alert("상품 상세 설명을 등록하세요.");
		return;
	}
	
	if(pd_image == ""){
		alert("상품 이미지를 등록하세요.");
		return;
	}
	
	if(pd_image_tmp[1] != "png" && pd_image_tmp[1] != "jpg"){
		alert("png 나 jpg 파일을 등록해주세요.");
		return;
	}
	
	if(pd_charge == ""){
		alert("상품 가격을 등록하세요.");
		return;
	}
	
	if(pd_count == ""){
		alert("상품 수량을 등록하세요.");
		return;
	}
	
	form.action = url;
	form.method = "post";
	form.encoding = "multipart/form-data";

	form.submit();
	
}
