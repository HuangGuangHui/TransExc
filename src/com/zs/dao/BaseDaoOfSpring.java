package com.zs.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class BaseDaoOfSpring implements IBaseDaoOfSpring{
	
	HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	
	
	public List find(String hql) {
		return ht.find(hql);
	}
	
	//∑÷“≥≤È—Ø
	public List findOfFenYe(String hql,int start,int size) {
		return null;
	}
	
	public Object get(Class c,Serializable id) {
		return ht.get(c,id);
	}
	
	public void save(Object obj) {
		ht.save(obj);
	}
	
	public void update(Object obj) {
		ht.update(obj);
	}
	
	public void delete(Object obj) {
		ht.delete(obj);
	}
}
