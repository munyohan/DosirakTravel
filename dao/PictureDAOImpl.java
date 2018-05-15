package com.dosirak.web.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.dosirak.web.vo.Picture;

public class PictureDAOImpl extends SqlSessionDaoSupport implements PictureDAO{

	@Override
	public Picture getPicture(int pCode) {
		PictureDAO pdao = getSqlSession().getMapper(PictureDAO.class);
		return pdao.getPicture(pCode);
	}

	@Override
	public List<Picture> getPictureList() {
		PictureDAO pdao = getSqlSession().getMapper(PictureDAO.class);
		return pdao.getPictureList();
	}

	@Override
	public int takePicture(String owner) {
		PictureDAO pdao = getSqlSession().getMapper(PictureDAO.class);
		return pdao.takePicture(owner);
	}
}
