package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.Picture;

public interface PictureDAO {
	public Picture getPicture(int pCode);		// 사진 하나 반환
	public List<Picture> getPictureList();		// 사진 모두 반환
	public int takePicture(String owner);		// 사진 하나 제공
}
