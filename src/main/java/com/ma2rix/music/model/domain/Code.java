package com.ma2rix.music.model.domain;

import org.joda.time.DateTime;


public class Code implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String classCodeNo;
	private String codeNo;
	private String codeName;
	private String codeName2;
	private String codeName3;
	private int codeSort;
	private String useStatus;
	private String classRemarks;
	private int regAdminNo;
	private DateTime regDateTime;
	private int modAdminNo;
	private DateTime modDateTime;

	public Code(){}

	public Code(String classCodeNo, String codeNo, String codeName,
			String codeName2, String codeName3, int codeSort, String useStatus,
			String classRemarks, int regAdminNo, DateTime regDateTime,
			int modAdminNo, DateTime modDateTime) {
		super();
		this.classCodeNo = classCodeNo;
		this.codeNo = codeNo;
		this.codeName = codeName;
		this.codeName2 = codeName2;
		this.codeName3 = codeName3;
		this.codeSort = codeSort;
		this.useStatus = useStatus;
		this.classRemarks = classRemarks;
		this.regAdminNo = regAdminNo;
		this.regDateTime = regDateTime;
		this.modAdminNo = modAdminNo;
		this.modDateTime = modDateTime;
	}

	public String getClassCodeNo() {
		return classCodeNo;
	}

	public void setClassCodeNo(String classCodeNo) {
		this.classCodeNo = classCodeNo;
	}

	public String getCodeNo() {
		return codeNo;
	}

	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getCodeName2() {
		return codeName2;
	}

	public void setCodeName2(String codeName2) {
		this.codeName2 = codeName2;
	}

	public String getCodeName3() {
		return codeName3;
	}

	public void setCodeName3(String codeName3) {
		this.codeName3 = codeName3;
	}

	public int getCodeSort() {
		return codeSort;
	}

	public void setCodeSort(int codeSort) {
		this.codeSort = codeSort;
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
