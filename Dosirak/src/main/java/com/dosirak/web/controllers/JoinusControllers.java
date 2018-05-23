package com.dosirak.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dosirak.web.dao.PlayerDAO;
import com.dosirak.web.vo.Player;

@Controller
@RequestMapping("/joinus/*")
public class JoinusControllers {
	
	@Autowired
	private PlayerDAO plDao;
	
	@RequestMapping(value={"login.do"}, method=RequestMethod.GET)
	public String login() {
		System.out.println("midZZZZ");
		return "login.jsp";
		
	}
	
	@RequestMapping(value={"login.do"}, method=RequestMethod.POST)
	public String login(String mid, String pwd, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		System.out.println("mid : " + mid);
		Player player = plDao.getPlayer(mid);
		
		/*HttpSession session = request.getSession();
	    String mid = (String)session.getAttribute("mid");
	    model.addAttribute("mid", mid);*/
		
		HttpSession session = request.getSession();
		
		model.addAttribute("player", player);
		model.addAttribute("mid", mid);
		model.addAttribute("pwd", pwd);
		
		if(player == null) {
			System.out.println("아이디 입력 오류");
			return "redirect:login.do?error=MIDX"; 
		} else if (!player.getPwd().equals(pwd)) {
			System.out.println("비밀번호 입력 오류");
			return "redirect:login.do?error=PWDX";
		} else {
			System.out.println("로그인 성공");
			session.setAttribute("mid", mid);
			session.setAttribute("nickname", player.getNickname());
			
			System.out.println("mid : " + mid);
			
			return "redirect:../house/main.do"; //웰컴 로그인 창 만들지 말지 결정해야됨
		}
	}
	
	@RequestMapping(value={"join.do"}, method=RequestMethod.GET)
	public String join() {
		return "join.jsp";
	}
	
	@RequestMapping(value={"join.do"}, method=RequestMethod.POST)
	public String join(Player player) {
		
		int af = plDao.addPlayer(player);
		
		if(af == 1) {
			System.out.println("회원가입 성공");
			return "redirect:login.do";
		} else {
			System.out.println("회원가입 실패");
			return "errorPage.jsp"; // 에러페이지 만들어야됨
		}
	}

}
