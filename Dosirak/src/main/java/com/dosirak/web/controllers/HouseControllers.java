package com.dosirak.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dosirak.web.dao.BackpackDAO;
import com.dosirak.web.dao.DosirakDAO;
import com.dosirak.web.dao.GiftDAO;
import com.dosirak.web.dao.ItemDAO;
import com.dosirak.web.dao.TicketDAO;
import com.dosirak.web.vo.Backpack;
import com.dosirak.web.vo.Dosirak;
import com.dosirak.web.vo.Gift;
import com.dosirak.web.vo.Item;
import com.dosirak.web.vo.Ticket;
import com.google.gson.Gson;

@Controller
@RequestMapping("/house/*")
public class HouseControllers {
	
	@Autowired
	private ItemDAO idao;
	@Autowired
	private DosirakDAO ddao;
	@Autowired
	private TicketDAO tdao;
	@Autowired
	private GiftDAO gdao;
	@Autowired
	private BackpackDAO bdao;
	
	@RequestMapping(value={"main.do"}, method=RequestMethod.GET)
	public String main() {
		
		return "main.jsp";
	}
	
	@RequestMapping(value={"inventory.do"}, method=RequestMethod.GET)
	public String inventory(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		// String owner = "KHJ@KHJ.COM";		
		String owner = (String) session.getAttribute("mid");
		
		Backpack b = new Backpack();
		b = bdao.getBackpackimg(owner);
		
		List<Item> ilist = new ArrayList<Item>();
		ilist = idao.getUserDosirak(owner);
		
		System.out.println("ilist.size()" + ilist.size());
		System.out.println("imgName : " + b.getDimgname());
		
		model.addAttribute("ilist", ilist);
		model.addAttribute("owner", owner);
		model.addAttribute("b", b);
		
		System.out.println("owner : " + owner);
		
		return "inventory.jsp";
	}
	
	@RequestMapping("inventoryModal.do")
	@ResponseBody
	public String inventoryModal(String img, String kind) {
		System.out.println("img : "+ img);
		System.out.println("종류 : " + kind);
		
		Gson gson = new Gson();
		String jsonT = null;
		
		if(kind.equals("도시락")) {
			
			Dosirak d = new Dosirak();
			d = ddao.getDosirakimg(img);
			System.out.println("d.name : " + d.getdName());
			
			jsonT = gson.toJson(d);
			System.out.println(jsonT);
			
			
		}else if(kind.equals("티켓")) {
			System.out.println("t.kind : " + kind);
			Ticket t = new Ticket();
			t = tdao.getTicketimg(img);
			System.out.println("t.name : " + t.gettName());
			
			jsonT = gson.toJson(t);
			System.out.println(jsonT);
			
		}else if(kind.equals("명물")) {
			
			Gift g = new Gift();
			g = gdao.getGiftimg(img);
			
			System.out.println("g.name : " + g.getgName());
			
			jsonT = gson.toJson(g);
			System.out.println(jsonT);
			
		}
		
		return jsonT;
		
	}
	
	@RequestMapping("inventoryDosirak.do")
	@ResponseBody
	public String inventoryDosirak(String owner) {
		
		List<Item> dlist = new ArrayList<Item>();
		dlist = idao.getUserDosirak(owner);
		
		System.out.println("dlist.size()" + dlist.size());
		
		Gson gson = new Gson();
		String jsonT = gson.toJson(dlist);
		
		
		return jsonT;
		
	}
	
	@RequestMapping("inventoryTicket.do")
	@ResponseBody
	public String inventoryTicket(String owner) {
		
		List<Item> tlist = new ArrayList<Item>();
		tlist = idao.getUserTicket(owner);
		
		System.out.println("tlist.size()" + tlist.size());
		
		Gson gson = new Gson();
		String jsonT = gson.toJson(tlist);
		
		
		return jsonT;
		
	}
	
	@RequestMapping("inventoryGift.do")
	@ResponseBody
	public String inventoryGift(String owner) {
		
		List<Item> glist = new ArrayList<Item>();
		glist = idao.getUserGift(owner);
		
		System.out.println("glist.size()" + glist.size());
		
		Gson gson = new Gson();
		String jsonT = gson.toJson(glist);
		// System.out.println(jsonT);
		
		return jsonT;
		
	}
	
}
