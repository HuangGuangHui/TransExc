package com.zs.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDaoOfSpring {
	
	public List find(String hql);
	
	//∑÷“≥≤È—Ø
	public List findOfFenYe(String hql,int start,int size);
	
	public Object get(Class c,Serializable id);
	
	public void save(Object obj);
	
	public void update(Object obj);
	
	public void delete(Object obj);
	
}
