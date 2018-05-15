package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.Picture;

public interface PictureDAO {
	public Picture getPicture(int pCode);		// ���� �ϳ� ��ȯ
	public List<Picture> getPictureList();		// ���� ��� ��ȯ
	public int takePicture(String owner);		// ���� �ϳ� ����
}
