package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.GuestNote;

public interface GuestNoteDAO {
	public List<GuestNote> getGuestNoteList(String host);		// �ش� �� ������ ���� ����Ʈ ��ȯ
	public int addGuestNote(String host, String visitor);					// ���� �� �� �߰�.
}
