package com.merong.home.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.appengine.api.datastore.Query;
import com.merong.home.service.impl.HomeServiceImpl;
import com.merong.home.vo.HomeVo;
import com.merong.home.vo.ScoreVo;
import com.merong.home.vo.SortVo;
import com.merong.home.vo.UserVo;

@Controller
@RequestMapping("/home")
public class HomeController {

	
	@Autowired
	private HomeServiceImpl homeServiceImpl;
 
	@RequestMapping({"", "/list" })
	public String goHome(Model model) {
		model.addAttribute("HomeVoList", homeServiceImpl.selectBookMarkList(new SortVo(Query.SortDirection.DESCENDING)));
		return "home/home";
	}
	
	@RequestMapping(value = "/bookMark")
	public String getBookMarkList(Model model) {
		model.addAttribute("HomeVoList", homeServiceImpl.selectBookMarkList(new SortVo(Query.SortDirection.DESCENDING)));
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
	
	@RequestMapping(value = "/scoreDashBoard")
	public String goscoreDashBoard(Model model) {
		model.addAttribute("rankingInfoList", homeServiceImpl.selectRankingList(new SortVo(Query.SortDirection.DESCENDING)));
		model.addAttribute("scoreVoList", homeServiceImpl.selectScoreHistoryList(new SortVo(Query.SortDirection.DESCENDING)));
		model.addAttribute("userVoList", homeServiceImpl.selectUserList(new SortVo(Query.SortDirection.DESCENDING)));
		return "scoreDashBoard/scoreDashBoard";
	}
	
	@RequestMapping(value = "/scoreDashBoard/insert", method = RequestMethod.POST)
	public String insertScore(Model model, ScoreVo scoreVo) {
		
		homeServiceImpl.insertScore(scoreVo);
		return "redirect:/home/scoreDashBoard";
	}
 
	
	
	@RequestMapping(value = "/user")
	public String selectUserList(Model model, UserVo userVo) {
		model.addAttribute("userVoList", homeServiceImpl.selectUserList(new SortVo(Query.SortDirection.DESCENDING)));
		return "user/userList";
	}
	
	@RequestMapping(value = "/user/insert", method = RequestMethod.POST)
	public String goInsertUser(Model model, UserVo userVo) {
		homeServiceImpl.insertUser(userVo);
		return "redirect:/home/user";
	}
	
	@RequestMapping(value = "/user/delete/{name}")
	public String deleteUser(@PathVariable String name, Model model, UserVo userVo) {
		userVo.setName(name);
		homeServiceImpl.deleteUser(userVo);
		return "redirect:/home/user";
	}
	
	
	@RequestMapping(value = "/catchMeIfYouCan")
	public String catchIfYouCan(Model model, UserVo userVo) {
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/graph")
	public String selectGraph(Model model) {
		model.addAttribute("rankingInfoList", homeServiceImpl.selectRankingList(new SortVo(Query.SortDirection.DESCENDING)));
		model.addAttribute("rankingInfoList", homeServiceImpl.selectChartByDate(new SortVo(Query.SortDirection.ASCENDING)));
		return "graph/graph";
	}

	
}













