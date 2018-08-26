package com.portfolio.spring.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.portfolio.spring.dao.ProductCateDao;
import com.portfolio.spring.dao.ProductDao;
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
		System.out.println("search :: " + searchStr);
		
		int cate = 0;
		String strCate = req.getParameter("pd_pdc_idx");
		System.out.println("product cate : " + strCate);	// cate가 0 이면 리스트 전부, 
		if(strCate !=null) cate = Integer.parseInt(strCate);
		
		int listCnt = 0;
		Paging paging = null;

		if(searchStr == null) {
			
			if(cate == 0) {
				listCnt = dao.productTotalCnt();
			}else {
				listCnt = dao.productTotalCateCnt(cate);
			}
			System.out.println("list cnt : " + listCnt);
			
			paging = new Paging(listCnt, curPage);
			
			int startIdx = paging.getStartIndex();// + dao.productFirstIdx() - 1;
			int endIdx = paging.getPageSize();
			
			System.out.println("start : " + startIdx);
			System.out.println("endIdx : " + endIdx);
			
			if(cate == 0) {
				model.addAttribute("productList", dao.productAllList(startIdx, endIdx));
			}else {
				model.addAttribute("productList", dao.productCateList(startIdx, endIdx, cate));
			}
			
		}else {
			
			if(cate == 0) {
				listCnt = dao.productSearchTotalCnt(searchStr);
			}else {
				listCnt = dao.productSearchTotalCateCnt(searchStr, cate);
			}
			System.out.println("list cnt : " + listCnt);
			
			paging = new Paging(listCnt, curPage);
			
			int startIdx = paging.getStartIndex();// + dao.productSearhcFirstIdx(searchStr) - 1;
			int endIdx = paging.getPageSize();
			
			System.out.println("start : " + startIdx);
			System.out.println("endIdx : " + endIdx);
			
			if(cate == 0) {
				model.addAttribute("productList", dao.productSearchAllList(startIdx, endIdx, searchStr));
			}else {
				model.addAttribute("productList", dao.productSearchCateList(startIdx, endIdx, searchStr, cate));
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
		
		ProductDao dao = sqlSession.getMapper(ProductDao.class);
		
		model.addAttribute("productDetail", dao.productDetail(pd_idx));
		
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
	
}
