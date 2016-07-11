package com.zs.entity;

/**
 * InYd entity. @author MyEclipse Persistence Tools
 */

public class InYd implements java.io.Serializable {

	// Fields

	private Integer id;
	private String address;
	private String equipmentNumber;
	private String name;
	private Double cost;
	private Double costMustPay;
	private String month;

	// Constructors

	/** default constructor */
	public InYd() {
	}

	/** full constructor */
	public InYd(String address, String equipmentNumber, String name,
			Double cost, Double costMustPay, String month) {
		this.address = address;
		this.equipmentNumber = equipmentNumber;
		this.name = name;
		this.cost = cost;
		this.costMustPay = costMustPay;
		this.month = month;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Double getCostMustPay() {
		return this.costMustPay;
	}

	public void setCostMustPay(Double costMustPay) {
		this.costMustPay = costMustPay;
	}

	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}