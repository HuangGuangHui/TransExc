package com.zs.action;

import com.zs.dao.IBaseDaoOfSpring;

public class ManualModeAction extends MyBaseAction{
	IBaseDaoOfSpring dao;

	public IBaseDaoOfSpring getDao() {
		return dao;
	}
	public void setDao(IBaseDaoOfSpring dao) {
		this.dao = dao;
	}
	
	
	
}
