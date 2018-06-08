package com.dosirak.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dosirak.web.dao.BackpackDAO;
import com.dosirak.web.dao.CityDAO;
import com.dosirak.web.dao.DosirakDAO;
import com.dosirak.web.dao.FriendDAO;
import com.dosirak.web.dao.GiftDAO;
import com.dosirak.web.dao.HistoryDAO;
import com.dosirak.web.dao.PictureDAO;
import com.dosirak.web.dao.PlayerDAO;
import com.dosirak.web.dao.TicketDAO;
import com.dosirak.web.vo.Backpack;
import com.dosirak.web.vo.City;
import com.dosirak.web.vo.Dosirak;
import com.dosirak.web.vo.Friend;
import com.dosirak.web.vo.Gift;
import com.dosirak.web.vo.History;
import com.dosirak.web.vo.Picture;
import com.dosirak.web.vo.Player;
import com.dosirak.web.vo.Record;
import com.dosirak.web.vo.Ticket;
import com.google.gson.Gson;

@Controller
@RequestMapping("/house/*")
public class WorkTravelControllers {
	
	@Autowired
	private HistoryDAO hdao;
	@Autowired
	private PlayerDAO pdao;
	@Autowired
	private BackpackDAO bdao;
	@Autowired
	private TicketDAO tdao;
	@Autowired
	private CityDAO cdao;
	@Autowired
	private DosirakDAO ddao;
	@Autowired
	private FriendDAO fdao;
	@Autowired
	private GiftDAO gdao;
	@Autowired
	private PictureDAO pidao;
	
	@RequestMapping(value={"workProc.do"}, method=RequestMethod.POST)
	public String workProc(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String owner = (String) session.getAttribute("mid");
		Player p = pdao.getPlayer(owner);
		
		int af = pdao.updateWorkPlayer(owner);
		af += hdao.insertBeforeWorkHistory(owner, p.getGold()); // �� �ϰ� ���ƿ��� �ð�(30�� ��) ����� ���� �����丮�� �μ�Ʈ
		
		if(af == 2) {
			System.out.println("����");
		}else {
			System.out.println("����");
		}
		
		return "redirect:../house/main.do";
		
	}
	
	@RequestMapping(value={"travelProc.do"}, method=RequestMethod.POST)
	public String travelProc(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		String owner = (String) session.getAttribute("mid");
		
		Backpack b = bdao.getBackpack(owner);
		
		String errorCode = null;
		String comeBackHomeTime = null;

		if(b.getdCode() == 0 || b.gettCode() == 0) {
			
			return "redirect:../house/main.do?errorCode=checkX";
		
		}else {
		
			Ticket t = tdao.getTicket(b.gettCode()); // Ƽ�Ͽ� ���� ����
			List<City> clist = cdao.getCountryCityList(t.getCountry()); // ���� ���� ���� ����Ʈ
			
			Dosirak d = ddao.getDosirak(b.getdCode());
			
			System.out.println("d.getMaxLv() : " + d.getMaxLv());
			System.out.println("d.getMinLv() : " + d.getMinLv());
			int level = (int)(Math.random() * d.getMaxLv()) + d.getMinLv();
			System.out.println("level : " + level);
			
			for(int i=0; i<clist.size(); i++) {
				if(clist.get(i).getcLevel() == level) {
					int time = clist.get(i).getTravelTime();
					City c = cdao.getCity(level, t.getCountry());
					System.out.println("�� ��� ���బ��? : " + t.getCountry());
					
					int af = pdao.updateTravelPlayer(owner, c.getCity());
					
					if(af == 1) {
						System.out.println("���� ��ġ ������Ʈ ����");
						
					}else {
						System.out.println("���� ��ġ ������Ʈ ����");
					}
					
					System.out.println("���� �� time : " + time);
					hdao.insertBeforeTravelHistory(owner, time);
					
					comeBackHomeTime = hdao.getComeBackHomeTime(owner, "����");
				
				}
			}
			return "redirect:../house/main.do?errorCode=checkO";
		}
		
		// model.addAttribute("errorCode", errorCode);
		// return "redirect:../house/main.do";
		
		
	}
	
	/*@RequestMapping("travelProc.do")
	@ResponseBody
	public String travelProc(String owner) {
		
		Backpack b = bdao.getBackpack(owner);
		
		// String errorMsg = null;
		String comeBackHomeTime = null;
		
		if(b.getdCode() == 0 || b.gettCode() == 0) {
			// errorMsg = "���ö� �� Ƽ���� ���� ���ּ���.";
		}else {
		
			int af = pdao.updateTravelPlayer(owner);
		
			if(af == 1) {
				System.out.println("����");
				Ticket t = tdao.getTicket(b.gettCode()); // Ƽ�Ͽ� ���� ����
				List<City> clist = cdao.getCountryCityList(t.getCountry()); // ���� ���� ���� ����Ʈ
				
				
				Dosirak d = ddao.getDosirak(b.getdCode());
				
				System.out.println("d.getMaxLv() : " + d.getMaxLv());
				System.out.println("d.getMinLv() : " + d.getMinLv());
				int level = (int)(Math.random() * d.getMaxLv()) + d.getMinLv();
				System.out.println("level : " + level);
				
				for(int i=0; i<clist.size(); i++) {
					if(clist.get(i).getcLevel() == level) {
						int time = clist.get(i).getTravelTime();
						System.out.println("���� �� time : " + time);
						hdao.insertBeforeTravelHistory(owner, time);
						
						comeBackHomeTime = hdao.getComeBackHomeTime(owner, "����");
					}
				}
			}else {
				System.out.println("����");
			}
		
		}

		Gson gson = new Gson();
		String jsonT = gson.toJson(comeBackHomeTime);
		System.out.println("jsonT : " + jsonT);
		return jsonT;
		
	}*/
	
	@RequestMapping("updateHomePlayer.do")
	@ResponseBody
	public String updateHomePlayer(String owner, int pay) {
		
		pdao.updateHomePlayer(owner, pay);
		Player p = pdao.getPlayer(owner);
		hdao.insertWorkHistory(owner, p.getGold(), pay);

		Gson gson = new Gson();
		String jsonT = gson.toJson(p);
		System.out.println(jsonT);
		
		return jsonT;
		
	}
	
	@RequestMapping("afterTravelStatus.do")
	@ResponseBody
	public String afterTravelStatus(String owner) {
		
		Player p = pdao.getPlayer(owner);
		List<Player> plist = pdao.getTravelPlayer(owner, p.getLoc());
		
		// ���� �� ���� ģ�� �߰�
		for(int i=0; i<plist.size(); i++) {
			
			Friend f = fdao.getPlayerFriend(owner, plist.get(i).getMid());
			if(f == null) {
				int af = fdao.addFriend(owner, plist.get(i).getMid(), plist.get(i).getImgName(), plist.get(i).getNickname());
				if(af == 1) {
					hdao.insertTravelFriendHistory(owner, f.getMid());
					System.out.println("���࿡�� ���� ģ�� �߰� ����");
				}else {
					System.out.println("���࿡�� ���� ģ�� �߰� ����");
				}	
			}else {
				hdao.insertTravelFriendHistory(owner, owner);
			}
		}
		
		// �� �� ���� ȹ��
		Gift g;
		
		Gift Hg1 = gdao.getTravelGift(p.getLoc(), "��");
		Gift Hg2 = gdao.getTravelGift(p.getLoc(), "��");
		
		List<Integer> hclist = hdao.getHistoryCode(owner, "��ȹ��");
		
		int haCheck = 0;	
		for(int i=0; i<hclist.size(); i++) {
			System.out.println("hclist.get(i) : " + hclist.get(i));
			if(Hg2.getgCode() == hclist.get(i)) { // �� ���� ���� ��
				haCheck = 1;
			}
		}
		
		if(haCheck == 0) {
			g = gdao.getTravelGift(p.getLoc(), "��");
		}else {
			int random = (int) (Math.random()*100) + 1;
			System.out.println("������ �󸶰� �����淡 �ܵ� ������ : " + random);
			if(random <= 70) {
				g = gdao.getTravelGift(p.getLoc(), "��");
			}else {
				g = gdao.getTravelGift(p.getLoc(), "��");
			}
		}
		
		int af = hdao.insertTravelHistory(owner, "��ȹ��", g.getgCode());
		
		Picture pi = pidao.getCityPicture(p.getLoc());
		af += hdao.insertTravelHistory(owner, "����ȹ��", pi.getpCode());
		if(af == 2) {
			System.out.println("���� �� ��, ���� �����丮 �μ�Ʈ �� Ȩ���� ���� ���� ����");
		}else {
			System.out.println("���� �� ��, ���� �����丮 �μ�Ʈ �� Ȩ���� ���� ���� ����");
		}
				
		/* �� ���� ������ ���� ������ �ִ� ���� �������� �ڵ�	

		int sangCheck = 0;
		for(int i=0; i<hclist.size(); i++) {
			System.out.println("hclist.get(i) : " + hclist.get(i));
			if(Hg1.getgCode() == hclist.get(i)) { // �� ���� ���� ��(ex.��+���ʰ� �ִ� ����)
				sangCheck = 1;
			}else { // �� ���� ���� ��(ex.���ʰ� �ִ� ����)
				sangCheck = 0;
			}
		}
		
		if(sangCheck == 1) {
			// ��+���ʰ� �ִ� ����
		}else {
			// ���ʰ� �ִ� ����
		} */
		
		// ��� â ������ ���� ��, ����
		//List<History> hlist = hdao.getRecordHistory(owner);
		Record r = hdao.getRecordHistory(owner);
		int af1 = pdao.updateHomeafterTravelPlayer(owner);
		af1 += bdao.updateDosirak(owner);
		af1 += bdao.updateTicket(owner);
		if(af1 == 3) {
			System.out.println("Ȩ���� ���� ���� ���� �� ���� ���ö�, Ƽ�� ���� ����");
		}else {
			System.out.println("Ȩ���� ���� ���� ���� �� ���� ���ö�, Ƽ�� ���� ����");
		}
		
		
		Gson gson = new Gson();
		String jsonT = gson.toJson(r);
		System.out.println(jsonT);
		
		return jsonT;
	
	}

}