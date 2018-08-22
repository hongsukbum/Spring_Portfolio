package com.portfolio.spring.dto;

public class Product_DTO {
	private int pd_idx;
	private String pd_name;
	private String pd_title;
	private String pd_content;
	private String pd_image;
	private int    pd_charge;
	private int    pd_count;
	private int    pd_pdc_idx;
	private char   pd_pdcsc_idx;
	
	public Product_DTO(int pd_idx, String pd_name, String pd_title,  String pd_content, String pd_image, int pd_charge, int pd_count, int pd_pdc_idx, char pd_pdcsc_idx) {
		this.pd_idx = pd_idx;
		this.pd_name = pd_name;
		this.pd_title = pd_title;
		this.pd_content = pd_content;
		this.pd_image = pd_image;
		this.pd_charge = pd_charge;
		this.pd_count = pd_count;
		this.pd_pdc_idx = pd_pdc_idx;
		this.pd_pdcsc_idx = pd_pdcsc_idx;
	}

	public int getPd_idx() {
		return pd_idx;
	}

	public void setPd_idx(int pd_idx) {
		this.pd_idx = pd_idx;
	}

	public String getPd_name() {
		return pd_name;
	}

	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}

	public String getPd_title() {
		return pd_title;
	}

	public void setPd_title(String pd_title) {
		this.pd_title = pd_title;
	}

	public String getPd_content() {
		return pd_content;
	}

	public void setPd_content(String pd_content) {
		this.pd_content = pd_content;
	}

	public String getPd_image() {
		return pd_image;
	}

	public void setPd_image(String pd_image) {
		this.pd_image = pd_image;
	}

	public int getPd_charge() {
		return pd_charge;
	}

	public void setPd_charge(int pd_charge) {
		this.pd_charge = pd_charge;
	}

	public int getPd_count() {
		return pd_count;
	}

	public void setPd_count(int pd_count) {
		this.pd_count = pd_count;
	}

	public int getPd_pdc_idx() {
		return pd_pdc_idx;
	}

	public void setPd_pdc_idx(int pd_pdc_idx) {
		this.pd_pdc_idx = pd_pdc_idx;
	}

	public char getPd_pdcsc_idx() {
		return pd_pdcsc_idx;
	}

	public void setPd_pdcsc_idx(char pd_pdcsc_idx) {
		this.pd_pdcsc_idx = pd_pdcsc_idx;
	}
}
