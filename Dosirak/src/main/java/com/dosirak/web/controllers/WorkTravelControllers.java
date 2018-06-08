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
		af += hdao.insertBeforeWorkHistory(owner, p.getGold()); // 일 하고 돌아오는 시간(30분 후) 계산을 위해 히스토리에 인서트
		
		if(af == 2) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
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
		
			Ticket t = tdao.getTicket(b.gettCode()); // 티켓에 따른 나라
			List<City> clist = cdao.getCountryCityList(t.getCountry()); // 나라에 따른 도시 리스트
			
			Dosirak d = ddao.getDosirak(b.getdCode());
			
			System.out.println("d.getMaxLv() : " + d.getMaxLv());
			System.out.println("d.getMinLv() : " + d.getMinLv());
			int level = (int)(Math.random() * d.getMaxLv()) + d.getMinLv();
			System.out.println("level : " + level);
			
			for(int i=0; i<clist.size(); i++) {
				if(clist.get(i).getcLevel() == level) {
					int time = clist.get(i).getTravelTime();
					City c = cdao.getCity(level, t.getCountry());
					System.out.println("넌 어디를 여행갔니? : " + t.getCountry());
					
					int af = pdao.updateTravelPlayer(owner, c.getCity());
					
					if(af == 1) {
						System.out.println("여행 위치 업데이트 성공");
						
					}else {
						System.out.println("여행 위치 업데이트 실패");
					}
					
					System.out.println("여행 중 time : " + time);
					hdao.insertBeforeTravelHistory(owner, time);
					
					comeBackHomeTime = hdao.getComeBackHomeTime(owner, "여행");
				
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
			// errorMsg = "도시락 및 티켓을 장착 해주세요.";
		}else {
		
			int af = pdao.updateTravelPlayer(owner);
		
			if(af == 1) {
				System.out.println("성공");
				Ticket t = tdao.getTicket(b.gettCode()); // 티켓에 따른 나라
				List<City> clist = cdao.getCountryCityList(t.getCountry()); // 나라에 따른 도시 리스트
				
				
				Dosirak d = ddao.getDosirak(b.getdCode());
				
				System.out.println("d.getMaxLv() : " + d.getMaxLv());
				System.out.println("d.getMinLv() : " + d.getMinLv());
				int level = (int)(Math.random() * d.getMaxLv()) + d.getMinLv();
				System.out.println("level : " + level);
				
				for(int i=0; i<clist.size(); i++) {
					if(clist.get(i).getcLevel() == level) {
						int time = clist.get(i).getTravelTime();
						System.out.println("여행 중 time : " + time);
						hdao.insertBeforeTravelHistory(owner, time);
						
						comeBackHomeTime = hdao.getComeBackHomeTime(owner, "여행");
					}
				}
			}else {
				System.out.println("실패");
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
		
		// 여행 중 만난 친구 추가
		for(int i=0; i<plist.size(); i++) {
			
			Friend f = fdao.getPlayerFriend(owner, plist.get(i).getMid());
			if(f == null) {
				int af = fdao.addFriend(owner, plist.get(i).getMid(), plist.get(i).getImgName(), plist.get(i).getNickname());
				if(af == 1) {
					hdao.insertTravelFriendHistory(owner, f.getMid());
					System.out.println("여행에서 만난 친구 추가 성공");
				}else {
					System.out.println("여행에서 만난 친구 추가 실패");
				}	
			}else {
				hdao.insertTravelFriendHistory(owner, owner);
			}
		}
		
		// 명물 및 사진 획득
		Gift g;
		
		Gift Hg1 = gdao.getTravelGift(p.getLoc(), "상");
		Gift Hg2 = gdao.getTravelGift(p.getLoc(), "하");
		
		List<Integer> hclist = hdao.getHistoryCode(owner, "명물획득");
		
		int haCheck = 0;	
		for(int i=0; i<hclist.size(); i++) {
			System.out.println("hclist.get(i) : " + hclist.get(i));
			if(Hg2.getgCode() == hclist.get(i)) { // 하 명물이 있을 때
				haCheck = 1;
			}
		}
		
		if(haCheck == 0) {
			g = gdao.getTravelGift(p.getLoc(), "하");
		}else {
			int random = (int) (Math.random()*100) + 1;
			System.out.println("랜덤이 얼마가 나오길래 잔디만 나오지 : " + random);
			if(random <= 70) {
				g = gdao.getTravelGift(p.getLoc(), "하");
			}else {
				g = gdao.getTravelGift(p.getLoc(), "상");
			}
		}
		
		int af = hdao.insertTravelHistory(owner, "명물획득", g.getgCode());
		
		Picture pi = pidao.getCityPicture(p.getLoc());
		af += hdao.insertTravelHistory(owner, "사진획득", pi.getpCode());
		if(af == 2) {
			System.out.println("여행 후 명물, 사진 히스토리 인서트 및 홈으로 상태 변경 성공");
		}else {
			System.out.println("여행 후 명물, 사진 히스토리 인서트 및 홈으로 상태 변경 실패");
		}
				
		/* 상 명물의 유무에 따라 폴더에 있는 사진 가져오는 코드	

		int sangCheck = 0;
		for(int i=0; i<hclist.size(); i++) {
			System.out.println("hclist.get(i) : " + hclist.get(i));
			if(Hg1.getgCode() == hclist.get(i)) { // 상 명물이 있을 때(ex.양+건초가 있는 사진)
				sangCheck = 1;
			}else { // 상 명물이 없을 때(ex.건초가 있는 사진)
				sangCheck = 0;
			}
		}
		
		if(sangCheck == 1) {
			// 양+건초가 있는 사진
		}else {
			// 건초가 있는 사진
		} */
		
		// 모달 창 일지에 보낼 명물, 사진
		//List<History> hlist = hdao.getRecordHistory(owner);
		Record r = hdao.getRecordHistory(owner);
		int af1 = pdao.updateHomeafterTravelPlayer(owner);
		af1 += bdao.updateDosirak(owner);
		af1 += bdao.updateTicket(owner);
		if(af1 == 3) {
			System.out.println("홈으로 상태 변경 성공 및 백팩 도시락, 티켓 삭제 성공");
		}else {
			System.out.println("홈으로 상태 변경 성공 및 백팩 도시락, 티켓 삭제 실패");
		}
		
		
		Gson gson = new Gson();
		String jsonT = gson.toJson(r);
		System.out.println(jsonT);
		
		return jsonT;
	
	}

}