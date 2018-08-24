package com.portfolio.spring.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.portfolio.spring.dao.UserDao;
import com.portfolio.spring.dto.UserInfoDto;

@Controller
public class AdminController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/adminUserInfoList")
	public String adminUserInfoList(HttpServletRequest req, Model model) {

		return "admin/adminUserInfoList";
		
	}
	
	@RequestMapping("/adminAddAccount")
	public String adminAddPage(HttpServletRequest req, Model model) {
		
		return "admin/adminAddPage";
		
	}
	
	
	@RequestMapping("/adminAccountConfirm")
	public String adminAccountConfirm(UserInfoDto userInfoDto, HttpServletRequest req, RedirectAttributes redirectAttributes) {
		
		UserDao dao = sqlSession.getMapper(UserDao.class);
		
		userInfoDto.setUauthorityidx(0);
		
		dao.accountAdmin(userInfoDto);
		
		/*HttpSession session = req.getSession();
		
		String uid = (String) session.getAttribute("uid");
		String unick = (String) session.getAttribute("unick");

		System.out.println("adminAccountConfirm uid : "  + uid);
		System.out.println("adminAccountConfirm unick : "  + unick);*/
		
		//redirectAttributes.addAttribute("joinUid", userInfoDto.getUid());
		
		return "redirect:/";
		
	}
	
	
	
}