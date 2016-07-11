package com.zs.action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zs.dao.BaseDaoOfJDBC;

public class LoginAction extends ActionSupport{
	
	String hint;
	
	
	
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}

	public String login() throws SQLException {
		// TODO Auto-generated method stub
		List list=new BaseDaoOfJDBC().query("select * from table_test1");
		System.out.println(list);
		return SUCCESS;
	}
	
}
