package com.portfolio.spring.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolio.spring.dao.UserDao;

@Controller
public class LoginController {

	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/login")
	public String loginPage(Model model) {
		
		return "security/loginPage";
		
	}
	
	
	@RequestMapping("/join")
	public String joinPage(HttpServletRequest req, Model model) throws UnsupportedEncodingException {
		
		req.setCharacterEncoding("UTF-8");
		
		String uid = req.getParameter("uid");
		String unick = req.getParameter("unick");
		
		System.out.println("join check uid :: " + uid);
		System.out.println("join check unick :: " + unick);
		
		req.setAttribute("uid", uid);
		req.setAttribute("unick", unick);
		
		return "joinPage";
		
	}
	
	
	@RequestMapping("/checkUserId")
	public String checkUserId(HttpServletRequest req, Model model) throws UnsupportedEncodingException {

		req.setCharacterEncoding("UTF-8");
		
		String uid = req.getParameter("uid");
		
		UserDao dao = sqlSession.getMapper(UserDao.class);
		int n = dao.checkUserId(uid);
		
		System.out.println(uid + "checkIdResult 0 사용가능 :: " + n);
		
		req.setAttribute("checkIdResult", n);
		
		return "checkUser";
		
	}
		
	
	@RequestMapping("/checkUserNick")
	public String checkUserNick(HttpServletRequest req, Model model) throws UnsupportedEncodingException {

		req.setCharacterEncoding("UTF-8");
		
		String unick = req.getParameter("unick");
		
		UserDao dao = sqlSession.getMapper(UserDao.class);
		int n = dao.checkUserNick(unick);
		
		System.out.println(unick + "checkNickResult 0 사용가능 :: " + n);
		
		req.setAttribute("checkNickResult", n);
		
		return "checkUser";
		
	}
	
	
}
