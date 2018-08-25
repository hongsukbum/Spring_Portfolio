package com.portfolio.spring.dao;

import java.util.ArrayList;

import com.portfolio.spring.dto.ProductDto;

public interface ProductDao {

	public void insertNewProduct(ProductDto productDto);
	
	public int productTotalCnt();
	public int productSearchTotalCnt(String searchStr);
	
	public int productFirstIdx();
	public int productSearhcFirstIdx(String searchStr);
	
	public ArrayList<ProductDto> productList(int startIdx, int endIdx);
	public ArrayList<ProductDto> productSearchList(int startIdx, int endIdx, String searchStr);
	
	public ProductDto productDetail(int pd_idx);
	
	public void productDelete(int pd_idx);
}
