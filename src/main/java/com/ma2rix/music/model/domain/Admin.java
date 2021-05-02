package com.ma2rix.music.model.domain;

import java.io.Serializable;

import org.joda.time.DateTime;

public class Admin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int adminNo;
	private String adminUserId;
	private String adminName;
	private String adminPwd;
	private String adminStatus;
	private int regAdminNo;
	private DateTime redDateTime;
	private int modaAdminNo;
	private DateTime modDateTime;
	
	public Admin() {
		super();
	}

	public int getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(int adminNo) {
		this.adminNo = adminNo;
	}

	public String getAdminUserId() {
		return adminUserId;
	}

	public void setAdminUserId(String adminUserId) {
		this.adminUserId = adminUserId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public String getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

	public int getRegAdminNo() {
		return regAdminNo;
	}

	public void setRegAdminNo(int regAdminNo) {
		this.regAdminNo = regAdminNo;
	}

	public DateTime getRedDateTime() {
		return redDateTime;
	}

	public void setRedDateTime(DateTime redDateTime) {
		this.redDateTime = redDateTime;
	}

	public int getModaAdminNo() {
		return modaAdminNo;
	}

	public void setModaAdminNo(int modaAdminNo) {
		this.modaAdminNo = modaAdminNo;
	}

	public DateTime getModDateTime() {
		return modDateTime;
	}

	public void setModDateTime(DateTime modDateTime) {
		this.modDateTime = modDateTime;
	}
	
	
	
}
