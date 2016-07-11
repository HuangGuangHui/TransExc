package com.zs.entity;

/**
 * InHz entity. @author MyEclipse Persistence Tools
 */

public class InHz implements java.io.Serializable {

	// Fields

	private Integer id;
	private String equipmentNumber;
	private String name;
	private Double cost;
	private String month;

	// Constructors

	/** default constructor */
	public InHz() {
	}

	/** full constructor */
	public InHz(String equipmentNumber, String name, Double cost, String month) {
		this.equipmentNumber = equipmentNumber;
		this.name = name;
		this.cost = cost;
		this.month = month;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEquipmentNumber() {
		return this.equipmentNumber;
	}

	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCost() {
		return this.cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}