package com.portfolio.spring.dao;

import java.util.ArrayList;

import com.portfolio.spring.dto.ProductDto;

public interface ProductDao {

	public void insertNewProduct(ProductDto productDto);
	
	public int productTotalCnt();
	
	public int productFirstIdx();
	
	public ArrayList<ProductDto> productList(int startIdx, int endIdx);
	
}
