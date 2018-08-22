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

		String checkIdPopupReturn = req.getParameter("checkIdPopupReturn");
		String checkNickPopupReturn = req.getParameter("checkNickPopupReturn");
		
		System.out.println("join check uid :: " + uid);
		System.out.println("join check unick :: " + unick);
		
		System.out.println("join check checkIdPopupReturn :: " + checkIdPopupReturn);
		System.out.println("join check checkNickPopupReturn :: " + checkNickPopupReturn);
		
		req.setAttribute("uid", uid);
		req.setAttribute("unick", unick);
		
		req.setAttribute("checkIdPopupReturn", checkIdPopupReturn);
		req.setAttribute("checkNickPopupReturn", checkNickPopupReturn);
		
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
	
	
	@RequestMapping("/joinConfirm")
	public String joinConfirm(HttpServletRequest req, Model model) {
		
		System.out.println("joinConfirm");
		
		String uid = req.getParameter("uid");
		String upw = req.getParameter("upw");
		String unick = req.getParameter("unick");
		String uphone = req.getParameter("phone1") + "-" + req.getParameter("phone2") + "-" + req.getParameter("phone3");
		String uaddr = req.getParameter("uaddr");
		String ubirth = req.getParameter("ubirth");
		String ugender = req.getParameter("ugender");
		
		UserDao dao = sqlSession.getMapper(UserDao.class);
		dao.joinUser(uid, upw, unick, uphone, uaddr, ubirth, ugender);
		
		
		return "redirect:login";
		
	}
	
	
}
