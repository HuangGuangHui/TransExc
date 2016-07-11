package com.zs.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.zs.entity.OutDxDetail;

public class BaseDaoOfHibe {
	
	public static Configuration con=new Configuration().configure();
	
	public static List find(String hql) {
		SessionFactory sf=con.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		Query query=ss.createQuery(hql);
		List<OutDxDetail> list=query.list();
		tr.commit();
		ss.close();
		return list;
	}
	
	
	public static Object get(Class c,Serializable id) {
		SessionFactory sf=con.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		Object obj=ss.get(c, id);
		tr.commit();
		ss.close();
		return obj;
	}
	
	public static void save(Object obj) {
		SessionFactory sf=con.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		ss.save(obj);
		tr.commit();
		ss.close();
	}
	
	
	public static void update(Object obj) {
		SessionFactory sf=con.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		ss.update(obj);
		tr.commit();
		ss.close();
	}
	
	public static void delete(Object obj) {
		SessionFactory sf=con.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		ss.delete(obj);
		tr.commit();
		ss.close();
	}
	/*
	public static void main(String[] args) {
		System.out.println(find("from OutDxDetail").size());
	}*/
}
