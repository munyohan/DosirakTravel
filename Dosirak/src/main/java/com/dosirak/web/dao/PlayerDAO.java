package com.dosirak.web.dao;

import com.dosirak.web.vo.Player;

public interface PlayerDAO {
	public int addPlayer(Player player);		// �ű� �÷��̾� ���� �� ���
	public Player getPlayer(String mid);		// �α��� �� �Ǵ� �������� �ʿ��� �� ���
}
