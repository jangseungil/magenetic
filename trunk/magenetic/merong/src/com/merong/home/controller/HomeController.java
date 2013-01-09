package com.merong.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.merong.home.service.impl.HomeServiceImpl;

@Controller
@RequestMapping("/home")
public class HomeController {

	
	@Autowired
	private HomeServiceImpl homeServiceImpl;
 
	@RequestMapping({"", "/list" })
	public String getBookMarkList(Model model) {
 
		model.addAttribute("HomeVoList", homeServiceImpl.selectBookMarkList());
 
		return "home/home";
 
	}
 

}
