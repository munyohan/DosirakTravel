package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.GuestNote;

public interface GuestNoteDAO {
	public List<GuestNote> getGuestNoteList(String host);		// 해당 집 주인의 방명록 리스트 반환
	public int addGuestNote(String host, String visitor);					// 방명록 한 개 추가.
}
