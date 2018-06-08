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
import com.dosirak.web.dao.FriendDAO;
import com.dosirak.web.dao.GiftDAO;
import com.dosirak.web.dao.HistoryDAO;
import com.dosirak.web.dao.ItemDAO;
import com.dosirak.web.dao.PlayerDAO;
import com.dosirak.web.dao.TicketDAO;
import com.dosirak.web.vo.Backpack;
import com.dosirak.web.vo.Dosirak;
import com.dosirak.web.vo.Friend;
import com.dosirak.web.vo.Gift;
import com.dosirak.web.vo.Item;
import com.dosirak.web.vo.Player;
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
	@Autowired
	private PlayerDAO pdao;
	@Autowired
	private FriendDAO fdao;
	@Autowired
	private HistoryDAO hdao;
	
	@RequestMapping(value={"main.do"}, method=RequestMethod.GET)
	   public String main(String errorCode, Model model, HttpServletRequest request) {
	      
	      HttpSession session = request.getSession();
	      String owner = (String) session.getAttribute("mid");
	      String actDate = null;
	      
	      System.out.println("errorCode : " + errorCode);
	      
	      Player p = new Player();
	      p = pdao.getPlayer(owner);
	      
	      
	      
	      System.out.println("p.getStatus() : " + p.getStatus());
	      
	      if(p.getStatus().equals("WORK")) {
	    	  actDate = hdao.getComeBackHomeTime(owner, "일");
	      }else if(p.getStatus().equals("TRAVEL")) {
	    	  actDate = hdao.getComeBackHomeTime(owner, "여행");
	    	  System.out.println("여행 actDate : " + actDate);
	      }
	      
	      model.addAttribute("p", p);
	      model.addAttribute("actDate", actDate);
	      model.addAttribute("owner", owner);
	      model.addAttribute("errorCode", errorCode);
	      
	      return "main.jsp";
	      
	  }
	
	@RequestMapping(value={"friendmain.do"}, method=RequestMethod.GET)
	   public String friendmain(String fid, Model model) {

	      Player p = new Player();
	      p = pdao.getPlayer(fid);
	      
	      model.addAttribute("p", p);
	      model.addAttribute("owner", fid);
	      
	      return "friendmain.jsp";
	  }
	
	@RequestMapping(value={"inventory.do"}, method=RequestMethod.GET)
	public String inventory(String tabCheck, Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String owner = (String) session.getAttribute("mid");
		
		Backpack b = new Backpack();
		b = bdao.getBackpackimg(owner);
		
		Player p = new Player();
		p = pdao.getPlayer(owner);
		
		List<Item> ilist = new ArrayList<Item>();
		
		if(tabCheck.equals("dosirak")) {
			ilist = idao.getUserDosirak(owner);
		}else if(tabCheck.equals("ticket")) {
			ilist = idao.getUserTicket(owner);
		}else {
			ilist = idao.getUserGift(owner);
		}
		
		System.out.println("ilist.size()" + ilist.size());
		System.out.println("imgName : " + b.getDimgname());
		
		model.addAttribute("ilist", ilist);
		model.addAttribute("owner", owner);
		model.addAttribute("b", b);
		model.addAttribute("p", p);
		
		System.out.println("owner : " + owner);
		
		return "inventory.jsp";
	}
	
	@RequestMapping(value={"inventoryReg.do"}, method=RequestMethod.POST)
	public String inventoryReg(String inventoryKind, String inventoryCode, Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();	
		String owner = (String) session.getAttribute("mid");
		String tabCheck = null;
		
		int code = Integer.parseInt(inventoryCode);
		
		Backpack b = bdao.getBackpack(owner);
		Item di = idao.getDamount(owner, code);
		Item ti = idao.getTamount(owner, code);
		
		if(inventoryKind.equals("도시락")) {
			if(b == null) {
				bdao.insertBmodal(owner, code, 0);
				if(di.getAmount() == 1) {
					idao.deleteDosirak(owner, code);
				}else {
					idao.updateRegDosirak(code, owner); // -1
				}
			}else {
				bdao.updateBDmodal(owner, code);
				if(di.getAmount() == 1) {
					idao.deleteDosirak(owner, code);
				}else {
					idao.updateRegDosirak(code, owner); // -1
					idao.updateCancelDosirak(b.getdCode(), owner); // +1
				}
			}
			
			return "redirect:../house/inventory.do?tabCheck=dosirak";
			
		}else if(inventoryKind.equals("티켓")) {
			if(b == null) {
				bdao.insertBmodal(owner, 0, code);
				if(ti.getAmount() == 1) {
					idao.deleteTicket(owner, code);
				}else {
					idao.updateRegTicket(code, owner); // -1
					
				}
			}else {
				bdao.updateBTmodal(owner, code);
				if(ti.getAmount() == 1) {
					idao.deleteTicket(owner, code);
				}else {
					idao.updateRegTicket(code, owner); // -1
					idao.updateCancelTicket(b.gettCode(), owner); // +1
				}
			}
			
			return "redirect:../house/inventory.do?tabCheck=ticket";
			
		}else {
			
			return "redirect:../house/inventory.do?tabCheck=gift";
			
		}
		
		
		
	}
	
	@RequestMapping(value={"inventoryDproc.do"}, method=RequestMethod.POST)
	public String inventoryDproc(String sdCode, Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();	
		String owner = (String) session.getAttribute("mid");
			
		int dCode = Integer.parseInt(sdCode);
		int af = bdao.updateDosirak(owner);
		
		Item i = idao.getDamount(owner, dCode);
		
		if(i==null) {
			Item newi = new Item();
			newi.setdCode(dCode);
			newi.setmCode(0);
			newi.settCode(0);
			newi.setpCode(0);
			newi.setItemkind("도시락");
			newi.setAmount(1);
			
			af += idao.takeItem(owner, newi);
		}else {
			af += idao.updateCancelDosirak(dCode, owner);
		}
		
		if(af==2) { 
			System.out.println("업데이트 성공");	
			return "redirect:../house/inventory.do";
		}else {
			System.out.println("업데이트 실패");
			return "redirect:../errorPage.jsp";
		}
	}
	
	@RequestMapping(value={"inventoryTproc.do"}, method=RequestMethod.POST)
	public String inventoryTproc(String stCode, HttpServletRequest request) {
		
		HttpSession session = request.getSession();	
		String owner = (String) session.getAttribute("mid");
		
		int tCode = Integer.parseInt(stCode);
		int af = bdao.updateTicket(owner);
		
		Item i = idao.getTamount(owner, tCode);
		
		if(i==null) {
			Item newi = new Item();
			newi.setdCode(0);
			newi.setmCode(0);
			newi.settCode(tCode);
			newi.setpCode(0);
			newi.setItemkind("티켓");
			newi.setAmount(1);
		
			af += idao.takeItem(owner, newi);
		}else {
			af += idao.updateCancelTicket(tCode, owner);
		}
		
		if(af==2) { 
			System.out.println("업데이트 성공");	
			return "redirect:../house/inventory.do";
			
		}else {
			System.out.println("업데이트 실패");
			return "redirect:../errorPage.jsp";
		}
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
	
	@RequestMapping("inventoryCancelDModal.do")
	@ResponseBody
	public String inventoryCancelDModal(String img) {
		
		Dosirak d = new Dosirak();
		d = ddao.getDosirakimg(img);

		Gson gson = new Gson();
		String jsonT = gson.toJson(d);
		System.out.println("여기여기여기여기 : "+ img);
		System.out.println(jsonT);
		
		return jsonT;
		
	}
	
	@RequestMapping("inventoryCancelTModal.do")
	@ResponseBody
	public String inventoryCancelTModal(String img) {
		
		Ticket t = new Ticket();
		t = tdao.getTicketimg(img);
		
		Gson gson = new Gson();
		String jsonT = gson.toJson(t);
		
		System.out.println(jsonT);
		
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
		
		return jsonT;
		
	}

	@RequestMapping("friendmodal.do")
	@ResponseBody
	public String friendmodal(String owner) {
		System.out.println("여기여기 : "+ owner);
		List<Friend> flist = new ArrayList<Friend>();
		flist = fdao.getPlayerFriendList(owner);

		Gson gson = new Gson();
		String jsonT = gson.toJson(flist);
		System.out.println("여기는 house컨트롤러 친구출력 : "+ jsonT);
		System.out.println(jsonT);
		
		return jsonT;
		
	}
	
	
	@RequestMapping("Modalmainfriendhouse.do")
	@ResponseBody
	public String Modalmainfriendhouse(String fid) {
		
		System.out.println("모달친구 : "+ fid);
		Player p = new Player();
		p = pdao.getPlayer(fid);
		
		Gson gson = new Gson();
		String jsonT = gson.toJson(p);
		System.out.println(".... : "+ jsonT);
		System.out.println(jsonT);
		
		return jsonT;
	
	}
	
	@RequestMapping("getStatus.do")
	@ResponseBody
	public String getStatus(String owner) {

		Player p = new Player();
		p = pdao.getPlayer(owner);
		
		Gson gson = new Gson();
		String jsonT = gson.toJson(p);
		System.out.println("getStatus : "+ jsonT);
		System.out.println(jsonT);
		
		return jsonT;
	
	}
	
	// 여행 떠날 때 백팩 조회 : getBackpack 사용
	
}
