package com.portfolio.spring.dao;

import java.util.ArrayList;

import com.portfolio.spring.dto.ProductDto;

public interface ProductDao {

	public void insertNewProduct(ProductDto productDto);
	public void modifyProduct(ProductDto productDto);
	
	public int productTotalCnt();
	public int productTotalCateCnt(int cate);
	
	public int productSearchTotalCnt(String searchStr);
	public int productSearchTotalCateCnt(String searchStr, int cate);
	
	public int productFirstIdx();
	public int productSearhcFirstIdx(String searchStr);
	
	public ArrayList<ProductDto> productAllList(int startIdx, int endIdx);
	public ArrayList<ProductDto> productCateList(int startIdx, int endIdx, int cate);
	
	public ArrayList<ProductDto> productSearchAllList(int startIdx, int endIdx, String searchStr);
	public ArrayList<ProductDto> productSearchCateList(int startIdx, int endIdx, String searchStr, int cate);
	
	public ProductDto productDetail(int pd_idx);
	
	public void productDelete(int pd_idx);
}
