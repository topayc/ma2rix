package com.ma2rix.music.model.domain;

import org.joda.time.DateTime;



public class CodeClass {
	
	public static final String MEMBER_FIELDS ="MA005";
	private String codeClassNo;
	private String codeClassName;
	private String useStatus;
	private String classRemarks;  
	private int regAdminNo;
	private DateTime regDateTime;
	private int modAdminNo;
	private DateTime modDateTime;

		
	public CodeClass(){}


	public CodeClass(String codeClassNo, String codeClassName,
			String useStatus, String classRemarks, int regAdminNo,
			DateTime regDateTime, int modAdminNo, DateTime modDateTime) {
		super();
		this.codeClassNo = codeClassNo;
		this.codeClassName = codeClassName;
		this.useStatus = useStatus;
		this.classRemarks = classRemarks;
		this.regAdminNo = regAdminNo;
		this.regDateTime = regDateTime;
		this.modAdminNo = modAdminNo;
		this.modDateTime = modDateTime;
	}


	public String getCodeClassNo() {
		return codeClassNo;
	}


	public void setCodeClassNo(String codeClassNo) {
		this.codeClassNo = codeClassNo;
	}


	public String getCodeClassName() {
		return codeClassName;
	}


	public void setCodeClassName(String codeClassName) {
		this.codeClassName = codeClassName;
	}


	public String getUseStatus() {
		return useStatus;
	}


	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
	}


	public String getClassRemarks() {
		return classRemarks;
	}


	public void setClassRemarks(String classRemarks) {
		this.classRemarks = classRemarks;
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
