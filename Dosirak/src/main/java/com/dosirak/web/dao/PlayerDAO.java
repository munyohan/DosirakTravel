package com.dosirak.web.dao;

import com.dosirak.web.vo.Player;

public interface PlayerDAO {
	public int addPlayer(Player player);		// 신규 플레이어 가입 시 사용
	public Player getPlayer(String mid);		// 로그인 시 또는 유저정보 필요할 때 사용
}
