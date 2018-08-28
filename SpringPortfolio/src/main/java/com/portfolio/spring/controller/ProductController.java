package com.portfolio.spring.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.portfolio.spring.dao.ProductCateDao;
import com.portfolio.spring.dao.ProductDao;
import com.portfolio.spring.dao.UserDao;
import com.portfolio.spring.dto.ProductDto;
import com.portfolio.spring.util.Paging;

@Controller
public class ProductController {

	
	@Autowired
	private SqlSession sqlSession;
	
	
	@RequestMapping("/product")
	public String product(@RequestParam(defaultValue="1") int curPage, HttpServletRequest req, Model model) {
		
		ProductDao dao = sqlSession.getMapper(ProductDao.class);
		
		String searchStr = req.getParameter("search");

		Collection<? extends GrantedAuthority> authority = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

		System.out.println("product list authority :: " + authority.toString());
		
		int cate = 0;
		String strCate = req.getParameter("pd_pdc_idx");
		System.out.println("product cate : " + strCate);	// cate가 0 이면 리스트 전부, 
		if(strCate !=null) cate = Integer.parseInt(strCate);

		int listCnt = 0;
		Paging paging = null;

		if(searchStr == null) {
			
			if(cate == 0) {
				if(authority.toString().equals("[ROLE_ADMIN]")) {
					listCnt = dao.productTotalCnt_Admin();
				}else {
					listCnt = dao.productTotalCnt();
				}
			}else {
				if(authority.toString().equals("[ROLE_ADMIN]")) {
					listCnt = dao.productTotalCateCnt_Admin(cate);
				}else {
					listCnt = dao.productTotalCateCnt(cate);
				}
			}
			System.out.println("list cnt : " + listCnt);
			
			paging = new Paging(listCnt, curPage);
			
			int startIdx = paging.getStartIndex();// + dao.productFirstIdx() - 1;
			int endIdx = paging.getPageSize();
			
			System.out.println("start : " + startIdx);
			System.out.println("endIdx : " + endIdx);
			
			if(cate == 0) {
				if(authority.toString().equals("[ROLE_ADMIN]")) {
					model.addAttribute("productList", dao.productAllList_Admin(startIdx, endIdx));
				}else {
					model.addAttribute("productList", dao.productAllList(startIdx, endIdx));
				}
			}else {
				if(authority.toString().equals("[ROLE_ADMIN]")) {
					model.addAttribute("productList", dao.productCateList_Admin(startIdx, endIdx, cate));
				}else {
					model.addAttribute("productList", dao.productCateList(startIdx, endIdx, cate));
				}
			}
			
		}else {
			
			if(cate == 0) {
				if(authority.toString().equals("[ROLE_ADMIN]")) {
					listCnt = dao.productSearchTotalCnt_Admin(searchStr);
				}else {
					listCnt = dao.productSearchTotalCnt(searchStr);
				}
			}else {
				if(authority.toString().equals("[ROLE_ADMIN]")) {
					listCnt = dao.productSearchTotalCateCnt_Admin(searchStr, cate);
				}else {
					listCnt = dao.productSearchTotalCateCnt(searchStr, cate);
				}
			}
			System.out.println("list cnt : " + listCnt);
			
			paging = new Paging(listCnt, curPage);
			
			int startIdx = paging.getStartIndex();// + dao.productSearhcFirstIdx(searchStr) - 1;
			int endIdx = paging.getPageSize();
			
			System.out.println("start : " + startIdx);
			System.out.println("endIdx : " + endIdx);
			
			if(cate == 0) {
				if(authority.toString().equals("[ROLE_ADMIN]")) {
					model.addAttribute("productList", dao.productSearchAllList_Admin(startIdx, endIdx, searchStr));
				}else {
					model.addAttribute("productList", dao.productSearchAllList(startIdx, endIdx, searchStr));
				}
			}else {
				if(authority.toString().equals("[ROLE_ADMIN]")) {
					model.addAttribute("productList", dao.productSearchCateList_Admin(startIdx, endIdx, searchStr, cate));
				}else {
					model.addAttribute("productList", dao.productSearchCateList(startIdx, endIdx, searchStr, cate));
				}
			}
		}
		
		
		// 기본 카테고리
		ProductCateDao cateDao = sqlSession.getMapper(ProductCateDao.class);		
		model.addAttribute("product_cate", cateDao.productCateList());
		model.addAttribute("selectCate", cate);
		
		model.addAttribute("pageName", "/product");
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("paging", paging);
		model.addAttribute("search", searchStr);
		
		return "product/productList";
		
	}
	
	
	@RequestMapping("/productDelete")
	public String productDelete(HttpServletRequest req) {
		
		int pd_idx = Integer.parseInt(req.getParameter("pd_idx"));
		
		ProductDao dao = sqlSession.getMapper(ProductDao.class);
		
		dao.productDelete(pd_idx);
		
		return "redirect:product";
		
	}
	
	
	@RequestMapping("/productDetail")
	public String productDetail(HttpServletRequest req, Model model){
		
		int pd_idx = Integer.parseInt(req.getParameter("pd_idx"));
		
		String isCheck = req.getParameter("isCheck");
		System.out.println("product detail isCheck :: " + isCheck);
		ProductDao dao = sqlSession.getMapper(ProductDao.class);
		
		model.addAttribute("productDetail", dao.productDetail(pd_idx));
		model.addAttribute("isCheck", isCheck);
		
		return "product/productDetail";
		
	}
	
	
	@RequestMapping("/productModifyConfirm")
	public String productModifyConfirm(MultipartHttpServletRequest req, MultipartFile mf) {
		
		System.out.println("수정완료? :: " + req.getParameter("pd_idx"));
		
		String pd_name = req.getParameter("pd_name");
		String pd_title = req.getParameter("pd_title");
		String pd_content = req.getParameter("pd_content");
		int pd_charge = Integer.parseInt(req.getParameter("pd_charge"));
		int pd_count = Integer.parseInt(req.getParameter("pd_count"));
		int pd_pdc_idx = Integer.parseInt(req.getParameter("pd_pdc_idx"));
		
		// 파일 업로드
		String imagePath = "uploadFile/product";
		
		mf = req.getFile("pd_image");
		String path = req.getRealPath(imagePath);
		String fileName = mf.getOriginalFilename();
		
		System.out.println("path : " + path);
		System.out.println("fileName : " + fileName);
		
		File uploadFile = new File(path + "//" + fileName);
		
		try {
			mf.transferTo(uploadFile);
		}catch (IllegalStateException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		ProductDto dto = new ProductDto(pd_name, pd_title, pd_content, imagePath ,fileName, pd_charge, pd_count, pd_pdc_idx, 0);
		dto.setPd_idx(Integer.parseInt(req.getParameter("pd_idx")));	
		
		ProductDao dao = sqlSession.getMapper(ProductDao.class);
		dao.modifyProduct(dto);
		
		return "redirect:product";
		
	}
	
	
	@RequestMapping("/product_enrollment")
	public String product_enrollment(HttpServletRequest req, Model model) {
		
		String pd_idx = req.getParameter("pd_idx");
		
		ProductCateDao cateDao = sqlSession.getMapper(ProductCateDao.class);		
		model.addAttribute("product_cate", cateDao.productCateList());
		
		if(pd_idx != null) {
		
			ProductDao dao = sqlSession.getMapper(ProductDao.class);
			
			model.addAttribute("productDetail", dao.productDetail(Integer.parseInt(pd_idx)));
		}
			
		return "product/product_enrollmentPage";
		
	}
	
	
	@RequestMapping("/product_enrollmentConfirm")
	public String product_enrollmentConfirm(MultipartHttpServletRequest req, MultipartFile mf){
		
		System.out.println("등록완료?!?!");
		
		String pd_name = req.getParameter("pd_name");
		String pd_title = req.getParameter("pd_title");
		String pd_content = req.getParameter("pd_content");
		int pd_charge = Integer.parseInt(req.getParameter("pd_charge"));
		int pd_count = Integer.parseInt(req.getParameter("pd_count"));
		int pd_pdc_idx = Integer.parseInt(req.getParameter("pd_pdc_idx"));
		
		// 파일 업로드
		String imagePath = "uploadFile/product";
		
		mf = req.getFile("pd_image");
		String path = req.getRealPath(imagePath);
		String fileName = mf.getOriginalFilename();
		
		System.out.println("path : " + path);
		System.out.println("fileName : " + fileName);
		
		File uploadFile = new File(path + "//" + fileName);
		
		try {
			mf.transferTo(uploadFile);
		}catch (IllegalStateException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		ProductDto dto = new ProductDto(pd_name, pd_title, pd_content, imagePath ,fileName, pd_charge, pd_count, pd_pdc_idx, 0);

		ProductDao dao = sqlSession.getMapper(ProductDao.class);
		dao.insertNewProduct(dto);
		
		return "redirect:/";
		
	}
	
	
	@RequestMapping("/productPurchaseCheck")
	public String productPurchaseCheck(HttpServletRequest req, Model model) {
		
		int pd_idx = Integer.parseInt(req.getParameter("pd_idx"));
		
		System.out.println("purchase check pd_idx :: " + pd_idx);
		
		int pd_purchase_count = Integer.parseInt(req.getParameter("pd_purchase_count"));
		String isBag = req.getParameter("isBag");
		System.out.println("purchase check :: isBag :: " + isBag);
		
		model.addAttribute("isBag", isBag);
		model.addAttribute("pd_idx", pd_idx);
		model.addAttribute("pd_purchase_count", pd_purchase_count);
		
		return "/product/productPurchaseCheck";
		
	}
	
	
	@RequestMapping("/productPurchase")
	public String productPurchase(HttpServletRequest req) {
		
		int pd_idx = Integer.parseInt(req.getParameter("pd_idx"));
		int pd_purchase_count = Integer.parseInt(req.getParameter("pd_purchase_count"));
		
		String isBag = req.getParameter("isBag");
		String result="";

		if(isBag.equals("") == false) {
			result = "redirect:productBag";
		}else {
			result = "redirect:product";
		}
		
		System.out.println("purchase isBag :: " + isBag);
		
		System.out.println(" purchase pd_idx :: " + pd_idx);
		System.out.println("purchase pd count :: " + pd_purchase_count);
		// 상품 수량 줄이고 판매수량 올리고 가방에 넣어줘야함.
		// 가방에 넣는거 추가해야함.
		
		ProductDao dao = sqlSession.getMapper(ProductDao.class);
		dao.productPurchase(pd_idx, pd_purchase_count);
		
		int n = dao.productPurchaseResultCount(pd_idx);
		
		System.out.println("남은 수량 :: " + n);
		/*if(n <=0) {
			dao.productDelete(pd_idx);
		}*/
		
		return result;
		
	}
	
	
	@RequestMapping("/productInputBag")
	public String productInputBag(HttpServletRequest req, Principal principal) {
		
		int pd_idx = Integer.parseInt(req.getParameter("pd_idx"));
		String tmpIdx = pd_idx + ",";
		
		HttpSession session = req.getSession();
		String uid = (String) session.getAttribute("uid");
		
		UserDao dao = sqlSession.getMapper(UserDao.class);
		
		if(uid == null) {
			uid = principal.getName();
			
			session.setAttribute("uid", uid);
			session.setAttribute("unick", dao.userNick(uid));
		}
		
		System.out.println("Input bag pd_idx :: " + pd_idx + " / tmpIdx :: " + tmpIdx + " / uid :: " + uid);
		
		// userinfo 에 ubagid 에 넣어줘...    , 로 구분하자.
		
		int uidx = dao.selectUserUidx(uid);
		
		tmpIdx = tmpIdx + dao.selectUserBag(uid);
		
		dao.updateInputBag(uidx, tmpIdx);
		
		return "redirect:product";
		
	}
	
	
	@RequestMapping("/productBag")
	public String productBag(HttpServletRequest reg, Model model) {
		
		HttpSession session = reg.getSession();
		String uid = (String) session.getAttribute("uid");
		
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		String userBag = userDao.selectUserBag(uid);
		int uidx = userDao.selectUserUidx(uid);
		
		System.out.println("userBag :: " + userBag);
		
		ProductDao productDao = sqlSession.getMapper(ProductDao.class);
		ArrayList<ProductDto> bagList = new ArrayList<ProductDto>();
		
		if(userBag.equals("") == false){
			System.out.println("------------");
			String[] strBag = userBag.split(",");
			
			ProductDto dto = new ProductDto();
			
			int result = 0;
			userBag = "";
			// strBag의 값의 상품이 존재하는지 확인해서 다시만들어 ~ 
			for(int i = 0;i<strBag.length;i++) {
				result = productDao.checkProduct(Integer.parseInt(strBag[i]));
				if(result !=0) {
					userBag += (strBag[i] + ","); 
				}
			}
			
			strBag = userBag.split(",");
			userDao.updateInputBag(uidx, userBag);
			
			for(int i = 0;i<strBag.length;i++) {
				dto = productDao.productDetail(Integer.parseInt(strBag[i]));
				if(dto != null)
					bagList.add(dto);
			}
		}
		
		model.addAttribute("bagList", bagList);
		
		return  "product/productBag";
		
	}
	
	
	@RequestMapping("/productUserBagDelete")
	public String productUserBagDelete(HttpServletRequest req) {
		
		int index = Integer.parseInt(req.getParameter("index"));
		int pd_idx = Integer.parseInt(req.getParameter("pd_idx"));
		String tmpIdx = "";
		
		HttpSession session = req.getSession();
		String uid = (String) session.getAttribute("uid");
		
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		int uidx = userDao.selectUserUidx(uid);
		
		String userBag = userDao.selectUserBag(uid);
		
		System.out.println("index : " + index + " / pd_idx : " + pd_idx);
		System.out.println("delete userBag :: " + userBag);
		
		// 문자열 찾아서 삭제 인덱스로
		{
			String[] arrUserBag = userBag.split(",");

			for(int i = 0;i<arrUserBag.length;i++) {
				if(i != index)
					tmpIdx += (arrUserBag[i] + ",");
			}
		}
		
		System.out.println("result userBag :: " + tmpIdx);
		
		userDao.updateInputBag(uidx, tmpIdx);
		
		return "redirect:productBag";
		
	}
	
}
