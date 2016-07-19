package com.zs.entity;

/**
 * RolePermission entity. @author MyEclipse Persistence Tools
 */

public class RolePermission implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer RId;
	private Integer PId;
	private Role role;
	private Permission permission;

	// Constructors

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	/** default constructor */
	public RolePermission() {
	}

	/** full constructor */
	public RolePermission(Integer RId, Integer PId) {
		this.RId = RId;
		this.PId = PId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRId() {
		return this.RId;
	}

	public void setRId(Integer RId) {
		this.RId = RId;
	}

	public Integer getPId() {
		return this.PId;
	}

	public void setPId(Integer PId) {
		this.PId = PId;
	}

}