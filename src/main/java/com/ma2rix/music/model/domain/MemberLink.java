package com.ma2rix.music.model.domain;

import java.io.Serializable;

import org.joda.time.DateTime;

public class MemberLink implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int linkNo;
	private int memberNo;
	private String memberLink;
	private String linkComment;
	private DateTime regDateTime;
	
	public MemberLink(){}

	public MemberLink(int linkNo, int memberNo, String memberLink,
			String linkComment, DateTime regDateTime) {
		super();
		this.linkNo = linkNo;
		this.memberNo = memberNo;
		this.memberLink = memberLink;
		this.linkComment = linkComment;
		this.regDateTime = regDateTime;
	}

	public int getLinkNo() {
		return linkNo;
	}

	public void setLinkNo(int linkNo) {
		this.linkNo = linkNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberLink() {
		return memberLink;
	}

	public void setMemberLink(String memberLink) {
		this.memberLink = memberLink;
	}

	public String getLinkComment() {
		return linkComment;
	}

	public void setLinkComment(String linkComment) {
		this.linkComment = linkComment;
	}

	public DateTime getRegDateTime() {
		return regDateTime;
	}

	public void setRegDateTime(DateTime regDateTime) {
		this.regDateTime = regDateTime;
	}
	
}
