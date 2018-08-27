package com.portfolio.spring.dao;

import java.util.ArrayList;

import com.portfolio.spring.dto.QnaDto;

public interface QnaDao {

	public void insertQna(QnaDto dto);
	public ArrayList<QnaDto> viewQnalist();
	public QnaDto viewQnaDetail(int idx);
	public void updateQna(QnaDto dto);
}
