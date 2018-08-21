package com.portfolio.spring.DTO;

public class User_Info_DTO{
	private int uidx;
	private String uid;
	private String unick;
	private String uphone;
	private String uaddr;
	private String ubirth;
	private char ugender;
	private String ujoinDate;
	private boolean uenabled;
	private char uauthorityidx;
	private int ubagId;
	
	public User_Info_DTO(int uidx, String uid, String unick, String uphone, String uaddr, String ubirth, char ugender, String ujoinDate, boolean uenabled, char uauthorityidx, int ubagId) 
	{
		this.uidx = uidx;
		this.uid = uid;
		this.unick = unick;
		this.uphone = uphone;
		this.uaddr = uaddr;
		this.ubirth = ubirth;
		this.ugender = ugender;
		this.ujoinDate = ujoinDate;
		this.uenabled = uenabled;
		this.uauthorityidx = uauthorityidx;
		this.ubagId = ubagId;
	}

	public int getUidx() {
		return uidx;
	}

	public void setUidx(int uidx) {
		this.uidx = uidx;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUnick() {
		return unick;
	}

	public void setUnick(String unick) {
		this.unick = unick;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getUaddr() {
		return uaddr;
	}

	public void setUaddr(String uaddr) {
		this.uaddr = uaddr;
	}

	public String getUbirth() {
		return ubirth;
	}

	public void setUbirth(String ubirth) {
		this.ubirth = ubirth;
	}

	public char getUgender() {
		return ugender;
	}

	public void setUgender(char ugender) {
		this.ugender = ugender;
	}

	public String getUjoinDate() {
		return ujoinDate;
	}

	public void setUjoinDate(String ujoinDate) {
		this.ujoinDate = ujoinDate;
	}

	public boolean isUenabled() {
		return uenabled;
	}

	public void setUenabled(boolean uenabled) {
		this.uenabled = uenabled;
	}

	public char getUauthorityidx() {
		return uauthorityidx;
	}

	public void setUauthorityidx(char uauthorityidx) {
		this.uauthorityidx = uauthorityidx;
	}

	public int getUbagId() {
		return ubagId;
	}

	public void setUbagId(int ubagId) {
		this.ubagId = ubagId;
	}
}