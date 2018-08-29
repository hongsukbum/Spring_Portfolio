package com.portfolio.spring.dao;

import java.util.ArrayList;

import com.portfolio.spring.dto.ProductPurchaseBagDto;

public interface ProductPurchaseBagDao {

	public void purchaseProduct(ProductPurchaseBagDto dto);
	
	public ArrayList<ProductPurchaseBagDto> purchaseList(String pdb_uid);
	
	public int productTotalCnt();
	
	public ArrayList<ProductPurchaseBagDto> productAllList(String uid, int startIdx, int endIdx);
	
}
