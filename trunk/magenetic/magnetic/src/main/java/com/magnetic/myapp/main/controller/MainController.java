package com.magnetic.myapp.main.controller;

import java.util.Collection;

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
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, String sendMsg) {
		return "home";
	}
	
	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public @ResponseBody String sendMsg(HttpServletRequest request, Model model, String sendMsg) {
		
		HttpSession session = request.getSession();
		session.setAttribute("idlNm", "guest");
				
		notifyAllClients("receive", sendMsg);
		return sendMsg;
	}
	
	public void sendMessage(MainVo mainVo) {
		notifyAllClients("receive", mainVo.getContent());
	}
	
	//연결된 클라이언트로 Push
	private void notifyAllClients(String eventType, String message) {
		getScriptProxy().addFunctionCall(eventType, message);
	}
 
    //연결된 클라이언트 조회
	private ScriptProxy getScriptProxy() {
		WebContext context = WebContextFactory.get();
		Collection sessions = context.getScriptSessionsByPage(context.getCurrentPage());
		return new ScriptProxy(sessions);
	}

}
