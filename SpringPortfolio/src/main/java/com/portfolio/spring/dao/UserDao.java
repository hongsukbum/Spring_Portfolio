package com.portfolio.spring.dao;

import java.util.ArrayList;

import com.portfolio.spring.dto.UserInfoDto;

public interface UserDao {

	public int checkUserId(String str);
	public int checkUserNick(String str);
	
	public void joinUser(String uid, String upw, String unick, String uphone, String uaddr, String ubirth, String ugender);
	
	public void modifyUser(String uid, String upw, String unick, String uphone, String uaddr, String ubirth, String ugender);
	
	public String userNick(String uid);
	public UserInfoDto userInfo(String uid);
	
}