package com.magnetic.myapp.main.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.ScriptProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.magnetic.myapp.main.service.MainService;
import com.magnetic.myapp.main.vo.MainVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	@Autowired
	private MainService mainService;
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * move to login 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goLogin(HttpServletRequest request, Model model, MainVo mainVo) {
		HttpSession session = request.getSession();
		if (session.getAttribute("name") != null) {
			return "home";
		}
		return "login";
	}
	
	/**
	 * login process
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String actionLogin(HttpServletRequest request, Model model, MainVo mainVo) {
		HttpSession session = request.getSession();
		if (session.getAttribute("name") != null) {
			return "home";
		} else {
			session.setAttribute("name", mainVo.getName());
		}
		return "redirect:/";
	}
	
	/**
	 * logout
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String actionLogout(HttpServletRequest request, Model model, MainVo mainVo) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	/**
	 * move to home
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model, String sendMsg) {
		return "home";
	}
	
	/**
	 * dwr
	 * sendMessage
	 */
	public void sendMessage(MainVo mainVo) {
		HttpSession session = WebContextFactory.get().getSession(); 
		mainVo.setName((String)session.getAttribute("name"));
		notifyAllClients("receive", mainVo);
	}
	
	/**
	 * dwr
	 * connect
	 */
	public void connect(MainVo mainVo) {
		HttpSession session = WebContextFactory.get().getSession(); 
		mainVo.setName((String)session.getAttribute("name"));
		
		
		notifyAllClients("connect", mainVo);
		List<MainVo> mainVoList = null;
		//mainVoList.add
	}
	
	//연결된 클라이언트로 Push
	private void notifyAllClients(String eventType, MainVo mainVo) {
		getScriptProxy().addFunctionCall(eventType, mainVo);
	}
 
    //연결된 클라이언트 조회
	private ScriptProxy getScriptProxy() {
		WebContext context = WebContextFactory.get();
		Collection sessions = context.getScriptSessionsByPage(context.getCurrentPage());
		
		return new ScriptProxy(sessions);
	}
	
	
	/**
	 * move to login 
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String goTest(HttpServletRequest request, Model model, MainVo mainVo) {
		return "Test";
	}

}














