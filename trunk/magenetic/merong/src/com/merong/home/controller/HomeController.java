package com.merong.home.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.merong.home.service.impl.HomeServiceImpl;
import com.merong.home.vo.HomeVo;
import com.merong.home.vo.ScoreVo;

@Controller
@RequestMapping("/home")
public class HomeController {

	
	@Autowired
	private HomeServiceImpl homeServiceImpl;
 
	@RequestMapping({"", "/list" })
	public String goHome(Model model) {
		model.addAttribute("HomeVoList", homeServiceImpl.selectBookMarkList());
		return "home/home";
	}
	
	@RequestMapping(value = "/bookMark")
	public String getBookMarkList(Model model) {
		model.addAttribute("HomeVoList", homeServiceImpl.selectBookMarkList());
		return "bookmark/bookmark";
	}
 
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertBookMark(Model model, HttpServletRequest request, HomeVo homeVo) {
		homeServiceImpl.insertBookMark(homeVo);
		return "redirect:/home/bookMark";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteBookMark(Model model, HttpServletRequest request, HomeVo homeVo) {
		homeServiceImpl.insertBookMark(homeVo);
		return "redirect:/home/bookMark";
	}
	
	@RequestMapping(value = "/html5")
	public String goHtml5(Model model) {
		return "html5/html5";
	}
	
	@RequestMapping(value = "/html5/insert", method = RequestMethod.POST)
	public String insertScore(Model model, ScoreVo scoreVo) {
		
		System.out.println(scoreVo.getGubun());
		homeServiceImpl.insertScore(scoreVo);
		return "redirect:/home/html5";
	}
 
}













