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
		
		int listCnt = 0;
		Paging paging = null;
		
		listCnt = dao.productTotalCnt();
		System.out.println("list cnt : " + listCnt);
		
		paging = new Paging(listCnt, curPage);
		
		int startIdx = paging.getStartIndex() + dao.productFirstIdx();
		int endIdx = startIdx + paging.getPageSize() - 1;
		
		System.out.println("start : " + startIdx);
		System.out.println("endIdx : " + endIdx);
		
		model.addAttribute("productList", dao.productList(startIdx, endIdx));
		model.addAttribute("pageName", "/product");
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("paging", paging);
		
		return "product/productList";
		
	}
	
	
	@RequestMapping("/product_enrollment")
	public String product_enrollment() {
		
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
		
		ProductDto dto = new ProductDto(pd_name, pd_title, pd_content, imagePath ,fileName, pd_charge, pd_count, 0, 0);

		ProductDao dao = sqlSession.getMapper(ProductDao.class);
		dao.insertNewProduct(dto);
		
		return "redirect:/";
		
	}
	
}
