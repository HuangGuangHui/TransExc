package com.zs.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zs.dao.BaseDaoOfJDBC;
import com.zs.dao.IBaseDaoOfSpring;
import com.zs.entity.Permission;
import com.zs.entity.Role;
import com.zs.entity.RolePermission;
import com.zs.entity.Users;

public class LoginAction extends MyBaseAction{
	
	String hint;
	IBaseDaoOfSpring dao;
	
	
	public IBaseDaoOfSpring getDao() {
		return dao;
	}
	public void setDao(IBaseDaoOfSpring dao) {
		this.dao = dao;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}

	public String login() throws SQLException, IOException {
		hint="";
		String num=getRequest().getParameter("num");
		String pass=getRequest().getParameter("pass");
		if (num!=null) {
			List<Users> users=dao.find("from Users where num='"+num.trim()+"'");
			if (users.size()<1) {
				hint="该用户不存在";
				return "login";
			}else {
				Users u=users.get(0);
				if (pass!=null && u.getPass().equals(pass.trim())) {
					//登录成功
					Role role=(Role) dao.get(Role.class, u.getRole());
					if(role!=null){
						List<RolePermission> list=dao.find("from RolePermission where RId='"+role.getId()+"'");
						for (int i = 0; i < list.size(); i++) {
							Permission p=(Permission) dao.get(Permission.class, list.get(i).getPId());
							list.get(i).setPermission(p);
							list.get(i).setRole(role);
						}
						role.setRolePermissions(list);
						u.setR(role);
					}
					getSession().setAttribute("user", u);
					getResponse().sendRedirect("index.jsp");
				}else {
					hint="密码错误";
					return "login";
				}
			}
		}
		return "login";
	}
	
	/*
	 * 2016年7月18日11:12:48
	 * 张顺
	 * 空方法用于实现安全刷新,解决了刷新导致重复提交的问题
	 * */
	public String safe() {
		return SUCCESS;
	}
	
}
