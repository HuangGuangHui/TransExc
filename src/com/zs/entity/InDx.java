package com.zs.entity;

/**
 * InDx entity. @author MyEclipse Persistence Tools
 */

public class InDx implements java.io.Serializable {

	// Fields

	private Integer id;
	private String equipmentNumber;
	private String type;
	private Double costPackage;
	private Double costBase;
	private Double costLocal;
	private Double costLong;
	private Double costData;
	private Double costShort;
	private Double costComplex;
	private Double costOther;
	private Double costInstead;
	private Double costPreferential;
	private Double costAdvancePay;
	private Double costPaid;
	private Double costGroupPay;
	private Double costMustPay;
	private String month;

	// Constructors

	/** default constructor */
	public InDx() {
	}

	/** full constructor */
	public InDx(String equipmentNumber, String type, Double costPackage,
			Double costBase, Double costLocal, Double costLong,
			Double costData, Double costShort, Double costComplex,
			Double costOther, Double costInstead, Double costPreferential,
			Double costAdvancePay, Double costPaid, Double costGroupPay,
			Double costMustPay, String month) {
		this.equipmentNumber = equipmentNumber;
		this.type = type;
		this.costPackage = costPackage;
		this.costBase = costBase;
		this.costLocal = costLocal;
		this.costLong = costLong;
		this.costData = costData;
		this.costShort = costShort;
		this.costComplex = costComplex;
		this.costOther = costOther;
		this.costInstead = costInstead;
		this.costPreferential = costPreferential;
		this.costAdvancePay = costAdvancePay;
		this.costPaid = costPaid;
		this.costGroupPay = costGroupPay;
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

	public String getEquipmentNumber() {
		return this.equipmentNumber;
	}

	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getCostPackage() {
		return this.costPackage;
	}

	public void setCostPackage(Double costPackage) {
		this.costPackage = costPackage;
	}

	public Double getCostBase() {
		return this.costBase;
	}

	public void setCostBase(Double costBase) {
		this.costBase = costBase;
	}

	public Double getCostLocal() {
		return this.costLocal;
	}

	public void setCostLocal(Double costLocal) {
		this.costLocal = costLocal;
	}

	public Double getCostLong() {
		return this.costLong;
	}

	public void setCostLong(Double costLong) {
		this.costLong = costLong;
	}

	public Double getCostData() {
		return this.costData;
	}

	public void setCostData(Double costData) {
		this.costData = costData;
	}

	public Double getCostShort() {
		return this.costShort;
	}

	public void setCostShort(Double costShort) {
		this.costShort = costShort;
	}

	public Double getCostComplex() {
		return this.costComplex;
	}

	public void setCostComplex(Double costComplex) {
		this.costComplex = costComplex;
	}

	public Double getCostOther() {
		return this.costOther;
	}

	public void setCostOther(Double costOther) {
		this.costOther = costOther;
	}

	public Double getCostInstead() {
		return this.costInstead;
	}

	public void setCostInstead(Double costInstead) {
		this.costInstead = costInstead;
	}

	public Double getCostPreferential() {
		return this.costPreferential;
	}

	public void setCostPreferential(Double costPreferential) {
		this.costPreferential = costPreferential;
	}

	public Double getCostAdvancePay() {
		return this.costAdvancePay;
	}

	public void setCostAdvancePay(Double costAdvancePay) {
		this.costAdvancePay = costAdvancePay;
	}

	public Double getCostPaid() {
		return this.costPaid;
	}

	public void setCostPaid(Double costPaid) {
		this.costPaid = costPaid;
	}

	public Double getCostGroupPay() {
		return this.costGroupPay;
	}

	public void setCostGroupPay(Double costGroupPay) {
		this.costGroupPay = costGroupPay;
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