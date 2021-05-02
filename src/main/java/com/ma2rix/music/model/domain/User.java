package com.ma2rix.music.model.domain;



import java.io.Serializable;

import org.joda.time.DateTime;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int memberNo;
	private String memberUserId;
	private String memberName;
	private String memberPwd;
	private String memberPwdConfirm;
	private String memberRoute;
	private String memberNickName;
	private String memberImage;
	private String countryNo;
	private String memberCity;
	private String memberIntroduce;
	private String memberHomePage;
	private String homePageComment;
	private String memberStatus;
	private String emailReceive;
	private int communityMemberNo;
	private int sponsorAmout;
	private DateTime lastDateTime;
	private DateTime regDateTime;
	private int modAdminNo;
	private DateTime modDateTime;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getMemberNo() {
		return memberNo;
	}



	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}



	public String getMemberUserId() {
		return memberUserId;
	}



	public void setMemberUserId(String memberUserId) {
		this.memberUserId = memberUserId;
	}



	public String getMemberName() {
		return memberName;
	}



	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}



	public String getMemberPwd() {
		return memberPwd;
	}



	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}



	public String getMemberPwdConfirm() {
		return memberPwdConfirm;
	}



	public void setMemberPwdConfirm(String memberPwdConfirm) {
		this.memberPwdConfirm = memberPwdConfirm;
	}



	public String getMemberRoute() {
		return memberRoute;
	}



	public void setMemberRoute(String memberRoute) {
		this.memberRoute = memberRoute;
	}



	public String getMemberNickName() {
		return memberNickName;
	}



	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}



	public String getMemberImage() {
		return memberImage;
	}



	public void setMemberImage(String memberImage) {
		this.memberImage = memberImage;
	}



	public String getCountryNo() {
		return countryNo;
	}



	public void setCountryNo(String countryNo) {
		this.countryNo = countryNo;
	}



	public String getMemberCity() {
		return memberCity;
	}



	public void setMemberCity(String memberCity) {
		this.memberCity = memberCity;
	}



	public String getMemberIntroduce() {
		return memberIntroduce;
	}



	public void setMemberIntroduce(String memberIntroduce) {
		this.memberIntroduce = memberIntroduce;
	}



	public String getMemberHomePage() {
		return memberHomePage;
	}



	public void setMemberHomePage(String memberHomePage) {
		this.memberHomePage = memberHomePage;
	}



	public String getHomePageComment() {
		return homePageComment;
	}



	public void setHomePageComment(String homePageComment) {
		this.homePageComment = homePageComment;
	}



	public String getMemberStatus() {
		return memberStatus;
	}



	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}



	public String getEmailReceive() {
		return emailReceive;
	}



	public void setEmailReceive(String emailReceive) {
		this.emailReceive = emailReceive;
	}



	public int getCommunityMemberNo() {
		return communityMemberNo;
	}



	public void setCommunityMemberNo(int communityMemberNo) {
		this.communityMemberNo = communityMemberNo;
	}



	public int getSponsorAmout() {
		return sponsorAmout;
	}



	public void setSponsorAmout(int sponsorAmout) {
		this.sponsorAmout = sponsorAmout;
	}



	public DateTime getLastDateTime() {
		return lastDateTime;
	}



	public void setLastDateTime(DateTime lastDateTime) {
		this.lastDateTime = lastDateTime;
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



	public User(int memberNo, String memberUserId, String memberName,
			String memberPwd, String memberPwdConfirm, String memberRoute,
			String memberNickName, String memberImage, String countryNo,
			String memberCity, String memberIntroduce, String memberHomePage,
			String homePageComment, String memberStatus, String emailReceive,
			int communityMemberNo, int sponsorAmout, DateTime lastDateTime,
			DateTime regDateTime, int modAdminNo, DateTime modDateTime) {
		super();
		this.memberNo = memberNo;
		this.memberUserId = memberUserId;
		this.memberName = memberName;
		this.memberPwd = memberPwd;
		this.memberPwdConfirm = memberPwdConfirm;
		this.memberRoute = memberRoute;
		this.memberNickName = memberNickName;
		this.memberImage = memberImage;
		this.countryNo = countryNo;
		this.memberCity = memberCity;
		this.memberIntroduce = memberIntroduce;
		this.memberHomePage = memberHomePage;
		this.homePageComment = homePageComment;
		this.memberStatus = memberStatus;
		this.emailReceive = emailReceive;
		this.communityMemberNo = communityMemberNo;
		this.sponsorAmout = sponsorAmout;
		this.lastDateTime = lastDateTime;
		this.regDateTime = regDateTime;
		this.modAdminNo = modAdminNo;
		this.modDateTime = modDateTime;
	}



	public void initLastLoginDateTime() {
		
		this.lastDateTime = new DateTime();
	}
	
	public void initModDateTime() {
		this.lastDateTime = new DateTime();
		
	}
	
    
	
}
