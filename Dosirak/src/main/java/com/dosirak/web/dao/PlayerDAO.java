package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.Player;

public interface PlayerDAO {
	
	public int addPlayer(Player player);		// �ű� �÷��̾� ���� �� ���
	public Player getPlayer(String mid);		// �α��� �� �Ǵ� �������� �ʿ��� �� ���
	
	public int updateWorkPlayer(String mid);
	public int updateHomePlayer(String owner, int pay);
	
	public int updateTravelPlayer(String mid, String loc);
	public List<Player> getTravelPlayer(String owner, String loc);
	public int updateHomeafterTravelPlayer(String owner);
	

}
