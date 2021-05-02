package com.ma2rix.music.model.domain;

import java.io.Serializable;

import org.joda.time.DateTime;

public class PG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int pgNo;
	private String feeType;
	private float feeUnit;
	private String agencyId;
	private String pgStatus;
	private int regAdminNo;
	private DateTime regDateTime;
	private int modAdminNo;
	private DateTime modDateTime;
	public PG() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PG(int pgNo, String feeType, float feeUnit, String agencyId,
			String pgStatus, int regAdminNo, DateTime regDateTime,
			int modAdminNo, DateTime modDateTime) {
		super();
		this.pgNo = pgNo;
		this.feeType = feeType;
		this.feeUnit = feeUnit;
		this.agencyId = agencyId;
		this.pgStatus = pgStatus;
		this.regAdminNo = regAdminNo;
		this.regDateTime = regDateTime;
		this.modAdminNo = modAdminNo;
		this.modDateTime = modDateTime;
	}
	public int getPgNo() {
		return pgNo;
	}
	public void setPgNo(int pgNo) {
		this.pgNo = pgNo;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public float getFeeUnit() {
		return feeUnit;
	}
	public void setFeeUnit(float feeUnit) {
		this.feeUnit = feeUnit;
	}
	public String getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}
	public String getPgStatus() {
		return pgStatus;
	}
	public void setPgStatus(String pgStatus) {
		this.pgStatus = pgStatus;
	}
	public int getRegAdminNo() {
		return regAdminNo;
	}
	public void setRegAdminNo(int regAdminNo) {
		this.regAdminNo = regAdminNo;
	}
	public DateTime getRegDateTime() {
		return regDateTime;
	}
	public void setRegDateTime(DateTime regDateTime) {
		this.regDateTime = regDateTime;
	}
	public int getModAdminNo() {
		return modAdminNo;
	}
	public void setModAdminNo(int modAdminNo) {
		this.modAdminNo = modAdminNo;
	}
	public DateTime getModDateTime() {
		return modDateTime;
	}
	public void setModDateTime(DateTime modDateTime) {
		this.modDateTime = modDateTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
