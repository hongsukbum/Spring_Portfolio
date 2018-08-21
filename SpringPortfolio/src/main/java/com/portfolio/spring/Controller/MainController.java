package com.portfolio.spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String mainPage(Model model) {
		
		return "mainPage";
		
	}
	
	
	@RequestMapping("/product")
	public String product(Model model) {
		
		return "product";
		
	}
	
	
	@RequestMapping("/userinfo")
	public String userInfo(Model model) {
		
		return "admin/userInfo";
		
	}
	
}
