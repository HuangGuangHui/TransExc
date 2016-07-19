package com.zs.action;

import com.zs.dao.IBaseDaoOfSpring;
import com.zs.entity.Role;
import com.zs.entity.Users;


/*2016年7月19日14:36:52
 * 张顺
 * 个人中心
 * */
public class PersonalCenterAction extends MyBaseAction{
	IBaseDaoOfSpring dao;
	
	Users oneself;
	
	
	public Users getOneself() {
		return oneself;
	}
	public void setOneself(Users oneself) {
		this.oneself = oneself;
	}
	public IBaseDaoOfSpring getDao() {
		return dao;
	}
	public void setDao(IBaseDaoOfSpring dao) {
		this.dao = dao;
	}
	
	
	/*2016年7月19日14:36:38
	 * 张顺
	 * 查看个人信息
	 * */
	public String query() {
		Object obj=getSession().getAttribute("user");
		if (obj!=null) {
			oneself=(Users) dao.get(Users.class, ((Users)obj).getNum());
			Role r=(Role) dao.get(Role.class, oneself.getRole());
			oneself.setR(r);
		}
		return "center";
	}
	
	
	public String update() {
		Object obj=getSession().getAttribute("user");
		if (obj!=null) {
			Users u=(Users) dao.get(Users.class, ((Users)obj).getNum());
			u.setName(oneself.getName());
			u.setPass(oneself.getPass());
			dao.update(u);
			Role r=(Role) dao.get(Role.class, u.getRole());
			u.setR(r);
			getSession().setAttribute("user", u);
		}
		return "center";
	}
	
	public String logout() {
		getSession().setAttribute("user", null);
		return "login";
	}
}
