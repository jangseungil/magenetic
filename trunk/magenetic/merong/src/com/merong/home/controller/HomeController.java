package com.merong.home.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.merong.home.service.impl.HomeServiceImpl;
import com.merong.home.vo.HomeVo;

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
 
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertBookMark(Model model, HttpServletRequest request, HomeVo homeVo) {
		homeServiceImpl.insertBookMark(homeVo);
		return "redirect:/home";
	}
}
