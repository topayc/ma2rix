package com.ma2rix.music.model.domain;



import java.io.Serializable;

public class Authentication implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int authenticateNo;
	private int memberNo;
	private String authenticateType;
	private String memberUserId;
	private String authenticateKey;
	private String expireDatetime;
	private String authenticateResult;
	
	
	public Authentication() {
		super();
	}
	
	
	public int getAuthenticateNo() {
		return authenticateNo;
	}

	public void setAuthenticateNo(int authenticateNo) {
		this.authenticateNo = authenticateNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getAuthenticateType() {
		return authenticateType;
	}

	public void setAuthenticateType(String authenticateType) {
		this.authenticateType = authenticateType;
	}

	public String getMemberUserId() {
		return memberUserId;
	}

	public void setMemberUserId(String memberUserId) {
		this.memberUserId = memberUserId;
	}

	public String getAuthenticateKey() {
		return authenticateKey;
	}

	public void setAuthenticateKey(String authenticateKey) {
		this.authenticateKey = authenticateKey;
	}

	public String getExpireDatetime() {
		return expireDatetime;
	}

	public void setExpireDatetime(String expireDatetime) {
		this.expireDatetime = expireDatetime;
	}
	
	public String getAuthenticateResult() {
		return authenticateResult;
	}

	public void setAuthenticateResult(String authenticateResult) {
		this.authenticateResult = authenticateResult;
	}

	public Authentication(
			int authenticateNo, 
			int memberNo, 
			String authenticateType, 
			String memberUserId,
			String authenticateKey, 
			String expireDatetime,
			String authenticateResult) {
		super();
		this.authenticateNo = authenticateNo;
		this.memberNo = memberNo;
		this.authenticateType = authenticateType;
		this.memberUserId = memberUserId;
		this.authenticateKey = authenticateKey;
		this.expireDatetime = expireDatetime;
		this.authenticateResult = authenticateResult;
	}
	
}
