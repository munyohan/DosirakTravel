package com.dosirak.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dosirak.web.dao.PlayerDAO;
import com.dosirak.web.vo.Player;

public class WorkTravelControllers {
	
	private PlayerDAO pdao;
	
	@RequestMapping(value={"work.do"}, method=RequestMethod.POST)
	public String workRroc() {
		
		Player p = new Player();
		p.setStatus("WORK");
		
		return null;
		
	}
	
	@RequestMapping(value={"travel.do"}, method=RequestMethod.POST)
	public String travelProc() {
		
		Player p = new Player();
		p.setStatus("TRAVEL");
		
		return null;
	}
	
	

}
