package com.portfolio.spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String loginPage(Model model) {
		
		return "security/loginPage";
		
	}
	
	
	@RequestMapping("/join")
	public String joinPage(Model model) {
		
		return "joinPage";
		
	}
		
	
	
}
