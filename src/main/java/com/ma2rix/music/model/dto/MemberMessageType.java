package com.ma2rix.music.model.dto;

public class MemberMessageType {
	private String code;
	private String codeString;
	public MemberMessageType() {
		super();
	}
	public MemberMessageType(String code, String codeString) {
		super();
		this.code = code;
		this.codeString = codeString;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCodeString() {
		return codeString;
	}
	
	public void setCodeString(String codeString) {
		this.codeString = codeString;
	}
}
