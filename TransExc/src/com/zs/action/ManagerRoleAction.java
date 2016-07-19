package com.zs.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.zs.dao.IBaseDaoOfSpring;
import com.zs.entity.Permission;
import com.zs.entity.Role;
import com.zs.entity.RolePermission;
import com.zs.entity.Users;
import com.zs.util.Page;

public class ManagerRoleAction extends MyBaseAction{
	IBaseDaoOfSpring dao;
	List<Role> roles;
	Page page;
	Role role;
	
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public IBaseDaoOfSpring getDao() {
		return dao;
	}
	public void setDao(IBaseDaoOfSpring dao) {
		this.dao = dao;
	}
	
	
	
	public String query() throws UnsupportedEncodingException{
		//带上数据过去
		List<Permission> pers=dao.find("from Permission");
		getRequest().setAttribute("pers",pers);
		//---------------
		String hql="from Role";
		String id=getRequest().getParameter("id");
		String name=getRequest().getParameter("name");
		if (id!=null) {
			hql=hql+" where id like '%"+id.trim()+"%'";
			getRequest().setAttribute("id", id.trim());
		}else {
			hql=hql+" where id like '%%'";
			getRequest().setAttribute("num", "");
		}
		if(name!=null) {
			hql=hql+" and name like '%"+name.trim()+"%'";
			getRequest().setAttribute("name", name.trim());
		}else {
			hql=hql+" and name like '%%'";
			getRequest().setAttribute("name", "");
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
		roles=dao.findOfFenYe(hql, (page.getPageOn()-1)*page.getSize(), page.getSize());
		//带上角色信息
		for (int i = 0; i < roles.size(); i++) {
			List<RolePermission> list=dao.find("from RolePermission where RId='"+roles.get(i).getId()+"'");
			for (int j = 0; j < list.size(); j++) {
				Permission p=(Permission) dao.get(Permission.class, list.get(j).getPId());
				list.get(j).setPermission(p);
				list.get(j).setRole(roles.get(i));
			}
			roles.get(i).setRolePermissions(list);
		}
		return "role";
	}
	
	public String addOrUpdate() throws UnsupportedEncodingException {
		//获取cz，根据cz来决定采取哪种操作
		String cz=getRequest().getParameter("cz");
		List<Permission> list=new ArrayList();
		List<Permission> pers=dao.find("from Permission");
		for (int i = 0; i < pers.size(); i++) {
			String str=getRequest().getParameter("per"+pers.get(i).getId());
			if (str!=null) {
				list.add(pers.get(i));
			}
		}
		//------------------------
		if (cz!=null) {
			if (cz.equals("add")) {
				if (role.getName()!=null) {
					dao.save(role);
					Role r=(Role) dao.find("from Role where name='"+role.getName()+"' and description='"+role.getDescription()+"' order by id desc").get(0);
					for (int i = 0; i < list.size(); i++) {
						RolePermission rp=new RolePermission(r.getId(), list.get(i).getId());
						dao.save(rp);
					}
				}
			}else if (cz.equals("update")) {
				if (role.getName()!=null && role.getId()!=null) {
					dao.update(role);
					List<RolePermission> rps=dao.find("from RolePermission where RId='"+role.getId()+"'");
					for (int i = 0; i < rps.size(); i++) {
						dao.delete(rps.get(i));
					}
					for (int i = 0; i < list.size(); i++) {
						RolePermission rp=new RolePermission(role.getId(), list.get(i).getId());
						dao.save(rp);
					}
				}
			}
		}
		return query();
	}
	
	public String delete() throws UnsupportedEncodingException {
		String id=getRequest().getParameter("rid");
		if (id!=null) {
			Role r=(Role) dao.get(Role.class, Integer.valueOf(id.trim()));
			//删除前先处理相关联的表
			List<RolePermission> rps=dao.find("from RolePermission where RId='"+r.getId()+"'");
			for (int i = 0; i < rps.size(); i++) {
				dao.delete(rps.get(i));
			}
			List<Users> us=dao.find("from Users where role='"+r.getId()+"'");
			for (int i = 0; i < us.size(); i++) {
				us.get(i).setRole(0);//暂时用0代表还没有分配权限的意思
				dao.update(us.get(i));
			}
			dao.delete(r);
		}
		return query();
	}
	
	
}
