package com.ma2rix.music.dao.interfaces;



import java.util.ArrayList;

import com.ma2rix.music.model.domain.MemberLink;
import com.ma2rix.music.model.domain.User;

public interface MemberLinkDao {
	public ArrayList<MemberLink> getMemberLinksByMemberNo(int memberNo);
	public ArrayList<MemberLink> getMemberLinksByUser(User user);
	public void insertMemberLink(MemberLink link);
	public void deleteMemberLink(MemberLink link);
	public void deleteAllMemberLinksByMemberNo(int memberNo);
	public void updateMemberLink(MemberLink link);

}
