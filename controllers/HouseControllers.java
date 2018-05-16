package com.dosirak.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dosirak.web.dao.PlayerDAO;

@Controller
@RequestMapping("/house/*")
public class HouseControllers {

	@Autowired
	private PlayerDAO plDao;
	
	@RequestMapping("/house/logoutProc.do")
	public String logoutProc(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:../joinus/login.jsp";
		
	}
}
