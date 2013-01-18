package com.merong.home.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.merong.home.service.impl.HomeServiceImpl;
import com.merong.home.vo.UserVo;

@Controller
@RequestMapping("/m/login")
public class MLoginController {

	
	@Autowired
	private HomeServiceImpl homeServiceImpl;
 
	@RequestMapping(value = "")
	public String loginPage(Model model, UserVo userVo) {
		return "login/mlogin";
	}
	
	@RequestMapping(value = "/goLogin")
	public String goLogin(Model model, UserVo userVo, HttpSession session) {
		
		if("동북".equals(userVo.getId()) && "1212".equals(userVo.getPassWord())) {
			session.setAttribute("loginResult", "success");
		}else{
			if(!"동북".equals(userVo.getId())) {
				session.setAttribute("loginResult", "id");
			}
			
			if(!"1212".equals(userVo.getPassWord())) {
				session.setAttribute("loginResult", "pass");
			}
			
			if(!"동북".equals(userVo.getId()) && !"1212".equals(userVo.getPassWord())) {
				session.setAttribute("loginResult", "idpass");
			}
		}
		
		return "login/mlogin";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(Model model, UserVo userVo, HttpSession session) {
		session.invalidate();
		
		return "redirect:/m/home/scoreDashBoard";
	}
	
}













