package com.zs.entity;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private String num;
	private String name;
	private String pass;
	private Integer role;
	private Role r;
	
	// Constructors

	/** default constructor */
	public Users() {
	}

	public Role getR() {
		return r;
	}
	public void setR(Role r) {
		this.r = r;
	}
	/** minimal constructor */
	public Users(String num) {
		this.num = num;
	}

	/** full constructor */
	public Users(String num, String name, String pass, Integer role) {
		this.num = num;
		this.name = name;
		this.pass = pass;
		this.role = role;
	}

	// Property accessors

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getRole() {
		return this.role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

}