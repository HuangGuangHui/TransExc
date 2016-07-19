package com.zs.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.zs.dao.IBaseDaoOfSpring;
import com.zs.entity.InYd;
import com.zs.entity.Role;
import com.zs.entity.Users;
import com.zs.util.Page;

public class ManagerUsersAction extends MyBaseAction{
	IBaseDaoOfSpring dao;
	List<Users> users;
	Page page;
	Users user;
	
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<Users> getUsers() {
		return users;
	}
	public void setUsers(List<Users> users) {
		this.users = users;
	}
	public IBaseDaoOfSpring getDao() {
		return dao;
	}
	public void setDao(IBaseDaoOfSpring dao) {
		this.dao = dao;
	}
	
	public String query() throws UnsupportedEncodingException{
		//带上数据过去
		List<Role> roles=dao.find("from Role");
		getRequest().setAttribute("roles",roles);
		//---------------
		String hql="from Users";
		String num=getRequest().getParameter("num");
		String name=getRequest().getParameter("name");
		String role=getRequest().getParameter("role");
		if (num!=null) {
			hql=hql+" where num like '%"+num.trim()+"%'";
			getRequest().setAttribute("num", num.trim());
		}else {
			hql=hql+" where num like '%%'";
			getRequest().setAttribute("num", "");
		}
		if(name!=null) {
			hql=hql+" and name like '%"+name.trim()+"%'";
			getRequest().setAttribute("name", name.trim());
		}else {
			hql=hql+" and name like '%%'";
			getRequest().setAttribute("name", "");
		}
		if(role!=null) {
			hql=hql+" and role='"+role.trim()+"' ";
			getRequest().setAttribute("role", role);
		}else {
			getRequest().setAttribute("role", "");
		}
		//---------------
		int count;
		if (0==dao.find(hql).size()%10) {
			count=dao.find(hql).size()/10;
		}else {
			count=dao.find(hql).size()/10+1;
		}
		if (getRequest().getParameter("pageOn")==null) {
			page=new Page(1,count, 10);
		}else {
			int no=Integer.valueOf(getRequest().getParameter("pageOn"));
			page=new Page(no,count, 10);
		}
		users=dao.findOfFenYe(hql, (page.getPageOn()-1)*page.getSize(), page.getSize());
		//带上角色信息
		for (int i = 0; i < users.size(); i++) {
			Role r=(Role) dao.get(Role.class, users.get(i).getRole());
			users.get(i).setR(r);
		}
		return "users";
	}
	
	public String addOrUpdate() throws UnsupportedEncodingException {
		//获取cz，根据cz来决定采取哪种操作
		String cz=getRequest().getParameter("cz");
		if (cz!=null) {
			if (cz.equals("add")) {
				if (user.getNum()!=null 
						&& !"".equals(user.getNum().trim())
						&& user.getRole()!=null 
						&& !"".equals(user.getRole())) {
					dao.save(user);
				}
			}else if (cz.equals("update")) {
				String id=getRequest().getParameter("id");
				String rid=getRequest().getParameter("rid");
				if (user.getNum()!=null && !"".equals(user.getNum().trim())) {
					dao.update(user);
				}
			}
		}
		return query();
	}
	
	public String delete() throws UnsupportedEncodingException {
		String num=getRequest().getParameter("n");
		if (num!=null) {
			Users u=(Users) dao.get(Users.class, num.trim());
			dao.delete(u);
		}
		//清除下标志
		return query();
	}
}
