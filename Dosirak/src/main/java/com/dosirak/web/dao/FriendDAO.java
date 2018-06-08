package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.Friend;

public interface FriendDAO {
	
	public Friend getFriend(int fCode);			// 코드를 통해 친구 한명 반환
	public List<Friend> getPlayerFriendList(String mid);	// 해당 유저의 모든 친구들 반환
	public Friend getPlayerFriend(String mid, String fid);
	
	public int addFriend(String mid, String fid, String imgname, String vnickname);
}
