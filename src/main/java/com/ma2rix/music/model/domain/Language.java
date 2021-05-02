package com.ma2rix.music.model.domain;

import org.joda.time.DateTime;

public class Language {
	private int languageNo;
	private String lnaguageName;
	private String languageFullName;
	private String languageFullEname;
	private String useStatus;
	private int regAdminNo;
	private DateTime regDateTime;
	private int modAdminNo;
	private DateTime modDateTime;
	public Language() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Language(int languageNo, String lnaguageName,
			String languageFullName, String languageFullEname,
			String useStatus, int regAdminNo, DateTime regDateTime,
			int modAdminNo, DateTime modDateTime) {
		super();
		this.languageNo = languageNo;
		this.lnaguageName = lnaguageName;
		this.languageFullName = languageFullName;
		this.languageFullEname = languageFullEname;
		this.useStatus = useStatus;
		this.regAdminNo = regAdminNo;
		this.regDateTime = regDateTime;
		this.modAdminNo = modAdminNo;
		this.modDateTime = modDateTime;
	}
	public int getLanguageNo() {
		return languageNo;
	}
	public void setLanguageNo(int languageNo) {
		this.languageNo = languageNo;
	}
	public String getLnaguageName() {
		return lnaguageName;
	}
	public void setLnaguageName(String lnaguageName) {
		this.lnaguageName = lnaguageName;
	}
	public String getLanguageFullName() {
		return languageFullName;
	}
	public void setLanguageFullName(String languageFullName) {
		this.languageFullName = languageFullName;
	}
	public String getLanguageFullEname() {
		return languageFullEname;
	}
	public void setLanguageFullEname(String languageFullEname) {
		this.languageFullEname = languageFullEname;
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
