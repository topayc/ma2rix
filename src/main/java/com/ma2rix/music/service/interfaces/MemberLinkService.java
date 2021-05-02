package com.ma2rix.music.service.interfaces;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.ma2rix.music.model.domain.MemberLink;
import com.ma2rix.music.model.domain.User;

@Transactional
public interface MemberLinkService {
	public ArrayList<MemberLink> getMemberLinksByMemberNo(int memberNo);
	public ArrayList<MemberLink> getMemberLinksByUser(User user);
	public void insertMemberLink(MemberLink link);
	public void deleteMemberLink(MemberLink link);
	public void deleteAllMemberLinkByMemberNo(int memberNo);
	public void updateMemberLink(MemberLink link);
}
