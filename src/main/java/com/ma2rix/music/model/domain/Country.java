package com.ma2rix.music.model.domain;

import java.io.Serializable;

import org.joda.time.DateTime;

public class Country  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String countryNo;
	private String countryNo2;
	private int countryNo3;
	private String countryName;
	private String countryEname;
	private String useStatus;
	private int regAdminNo;
	private DateTime regDateTime;
	private int modAdminNo;
	private DateTime modDateTime;
	
	public Country(){}

	public Country(String countryNo, String countryNo2, int countryNo3,
			String countryName, String countryEname, String useStatus,
			int regAdminNo, DateTime regDateTime, int modAdminNo,
			DateTime modDateTime) {
		super();
		this.countryNo = countryNo;
		this.countryNo2 = countryNo2;
		this.countryNo3 = countryNo3;
		this.countryName = countryName;
		this.countryEname = countryEname;
		this.useStatus = useStatus;
		this.regAdminNo = regAdminNo;
		this.regDateTime = regDateTime;
		this.modAdminNo = modAdminNo;
		this.modDateTime = modDateTime;
	}

	public String getCountryNo() {
		return countryNo;
	}

	public void setCountryNo(String countryNo) {
		this.countryNo = countryNo;
	}

	public String getCountryNo2() {
		return countryNo2;
	}

	public void setCountryNo2(String countryNo2) {
		this.countryNo2 = countryNo2;
	}

	public int getCountryNo3() {
		return countryNo3;
	}

	public void setCountryNo3(int countryNo3) {
		this.countryNo3 = countryNo3;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryEname() {
		return countryEname;
	}

	public void setCountryEname(String countryEname) {
		this.countryEname = countryEname;
	}

	public String getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
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

	
	
}
