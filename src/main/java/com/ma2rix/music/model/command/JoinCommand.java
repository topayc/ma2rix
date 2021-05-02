package com.ma2rix.music.model.command;

import java.io.Serializable;
import java.util.ArrayList;

import com.ma2rix.music.model.domain.MemberField;
import com.ma2rix.music.model.domain.MemberLink;
import com.ma2rix.music.model.domain.MemberPlay;
import com.ma2rix.music.model.domain.User;

public class JoinCommand implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean agreePersonalProtect; 
	private boolean agreeUsePolicy;
	
	private User user;
	private ArrayList<MemberLink> memberLinks;
	private ArrayList<MemberField> memberFields;
	private ArrayList<MemberPlay> memberPlays;
	
	public JoinCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JoinCommand(boolean agreePersonalProtect, boolean agreeUsePolicy,
			User user, ArrayList<MemberLink> memberLinks,
			ArrayList<MemberField> memberFields,
			ArrayList<MemberPlay> memberPlays) {
		super();
		this.agreePersonalProtect = agreePersonalProtect;
		this.agreeUsePolicy = agreeUsePolicy;
		this.user = user;
		this.memberLinks = memberLinks;
		this.memberFields = memberFields;
		this.memberPlays = memberPlays;
	}
	public boolean isAgreePersonalProtect() {
		return agreePersonalProtect;
	}
	public void setAgreePersonalProtect(boolean agreePersonalProtect) {
		this.agreePersonalProtect = agreePersonalProtect;
	}
	public boolean isAgreeUsePolicy() {
		return agreeUsePolicy;
	}
	public void setAgreeUsePolicy(boolean agreeUsePolicy) {
		this.agreeUsePolicy = agreeUsePolicy;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ArrayList<MemberLink> getMemberLinks() {
		return memberLinks;
	}
	public void setMemberLinks(ArrayList<MemberLink> memberLinks) {
		this.memberLinks = memberLinks;
	}
	public ArrayList<MemberField> getMemberFields() {
		return memberFields;
	}
	public void setMemberFields(ArrayList<MemberField> memberFields) {
		this.memberFields = memberFields;
	}
	public ArrayList<MemberPlay> getMemberPlays() {
		return memberPlays;
	}
	public void setMemberPlays(ArrayList<MemberPlay> memberPlays) {
		this.memberPlays = memberPlays;
	}
	
	
}
