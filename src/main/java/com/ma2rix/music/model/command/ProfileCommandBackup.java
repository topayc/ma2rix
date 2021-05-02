package com.ma2rix.music.model.command;

import java.util.ArrayList;

import com.ma2rix.music.model.domain.MemberField;
import com.ma2rix.music.model.domain.MemberLink;
import com.ma2rix.music.model.domain.MemberPlay;
import com.ma2rix.music.model.domain.User;

/**
 * @author v
 *
 */
public class ProfileCommandBackup {
	
	private User user;
	private ArrayList<MemberLink> memberLinks;
	private ArrayList<MemberPlay> memberPlays;
	private ArrayList<MemberField> memberFields;
	
	public ProfileCommandBackup() {}

	public ProfileCommandBackup(User user, ArrayList<MemberLink> memberLinks,
			ArrayList<MemberPlay> memberPlays,
			ArrayList<MemberField> memberFields) {
		super();
		this.user = user;
		this.memberLinks = memberLinks;
		this.memberPlays = memberPlays;
		this.memberFields = memberFields;
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

	public ArrayList<MemberPlay> getMemberPlays() {
		return memberPlays;
	}

	public void setMemberPlays(ArrayList<MemberPlay> memberPlays) {
		this.memberPlays = memberPlays;
	}

	public ArrayList<MemberField> getMemberFields() {
		return memberFields;
	}

	public void setMemberFields(ArrayList<MemberField> memberFields) {
		this.memberFields = memberFields;
	}

	
}
