package com.portfolio.spring.dao;

import java.util.ArrayList;

import com.portfolio.spring.dto.UserInfoDto;

public interface UserDao {

	public int checkUserId(String str);
	public int checkUserNick(String str);
	
	public void joinUser(String uid, String upw, String unick, String uphone, String uaddr, String ubirth, String ugender);
	
	public ArrayList<UserInfoDto> listDao();
	
}
