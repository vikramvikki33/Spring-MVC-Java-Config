package com.sounds.bvs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController {

	@RequestMapping(value={"/", "welcome**"}, method=RequestMethod.GET)
	public String userLogin(Model model) {
		model.addAttribute("Logger", "UserLogin");
		return "index";
	}

	public String adminLogin(Model model) {
		model.addAttribute("Logger", "Administrator");
		return "admin";
	}
}
