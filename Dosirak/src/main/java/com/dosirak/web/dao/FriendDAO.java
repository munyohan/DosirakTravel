package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.Friend;

public interface FriendDAO {
	
	public Friend getFriend(int fCode);			// �ڵ带 ���� ģ�� �Ѹ� ��ȯ
	public List<Friend> getPlayerFriendList(String mid);	// �ش� ������ ��� ģ���� ��ȯ
	public Friend getPlayerFriend(String mid, String fid);
	
	public int addFriend(String mid, String fid, String imgname, String vnickname);
}
