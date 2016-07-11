package com.zs.entity;

/**
 * OutDxDetail entity. @author MyEclipse Persistence Tools
 */

public class OutDxDetail implements java.io.Serializable {

	// Fields

	private Integer id;
	private String type;
	private String department;
	private String equipmentNumber;
	private String note;
	private String monthMonry;
	private String firstDepartment;
	private String invoice;
	private String month;

	// Constructors

	/** default constructor */
	public OutDxDetail() {
	}

	/** full constructor */
	public OutDxDetail(String type, String department, String equipmentNumber,
			String note, String monthMonry, String firstDepartment,
			String invoice, String month) {
		this.type = type;
		this.department = department;
		this.equipmentNumber = equipmentNumber;
		this.note = note;
		this.monthMonry = monthMonry;
		this.firstDepartment = firstDepartment;
		this.invoice = invoice;
		this.month = month;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEquipmentNumber() {
		return this.equipmentNumber;
	}

	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getMonthMonry() {
		return this.monthMonry;
	}

	public void setMonthMonry(String monthMonry) {
		this.monthMonry = monthMonry;
	}

	public String getFirstDepartment() {
		return this.firstDepartment;
	}

	public void setFirstDepartment(String firstDepartment) {
		this.firstDepartment = firstDepartment;
	}

	public String getInvoice() {
		return this.invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}