package com.portfolio.spring.DTO;

public class Product_Bag_DTO {
	private String pdb_uid;
	private int    pdb_pdIdx;
	private int    pbd_idx;
	private String pdb_date;
	private int    pdb_count;
	private char   pdb_state;
	
	public Product_Bag_DTO(String pdb_uid, int pdb_pdIdx, int pdb_idx, String pdb_date, int pdb_count, char pdb_state) {
		this.pdb_uid = pdb_uid;
		this.pbd_idx = pdb_idx;
		this.pdb_pdIdx = pdb_pdIdx;
		this.pdb_date = pdb_date;
		this.pdb_count = pdb_count;
		this.pdb_state = pdb_state;
	}

	public String getPdb_uid() {
		return pdb_uid;
	}

	public void setPdb_uid(String pdb_uid) {
		this.pdb_uid = pdb_uid;
	}

	public int getPdb_pdIdx() {
		return pdb_pdIdx;
	}

	public void setPdb_pdIdx(int pdb_pdIdx) {
		this.pdb_pdIdx = pdb_pdIdx;
	}

	public int getPbd_idx() {
		return pbd_idx;
	}

	public void setPbd_idx(int pbd_idx) {
		this.pbd_idx = pbd_idx;
	}

	public String getPdb_date() {
		return pdb_date;
	}

	public void setPdb_date(String pdb_date) {
		this.pdb_date = pdb_date;
	}

	public int getPdb_count() {
		return pdb_count;
	}

	public void setPdb_count(int pdb_count) {
		this.pdb_count = pdb_count;
	}

	public char getPdb_state() {
		return pdb_state;
	}

	public void setPdb_state(char pdb_state) {
		this.pdb_state = pdb_state;
	}
}
