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
		
		//model.addAttribute("uid", "admin");
		
		/*service = new UserInfoService();
		service.execute(model);*/
		
		/*UserDao dao = sqlSession.getMapper(UserDao.class);

		model.addAttribute("list", dao.listDao());*/
		
		String uid = req.getParameter("uid");
		
		System.out.println("check uid :: " + uid);
		
		return "joinPage";
		
	}
	
	
	@RequestMapping("/checkUser")
	public String checkUser(HttpServletRequest req, Model model) throws UnsupportedEncodingException {

		req.setCharacterEncoding("UTF-8");
		
		String uid = req.getParameter("uid");
		
		System.out.println("check uid :: " + uid);
		
		UserDao dao = sqlSession.getMapper(UserDao.class);
		int n = dao.checkUserId(uid);
		
		System.out.println("check result :: " + n);
		
		req.setAttribute("checkIdResult", n);
		
		return "checkUser";
		
	}
		
	
	
}
