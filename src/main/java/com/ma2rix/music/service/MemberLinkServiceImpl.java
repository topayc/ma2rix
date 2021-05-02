package com.ma2rix.music.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma2rix.music.dao.interfaces.MemberLinkDao;
import com.ma2rix.music.model.domain.MemberLink;
import com.ma2rix.music.model.domain.User;
import com.ma2rix.music.service.interfaces.MemberLinkService;

@Service
public class MemberLinkServiceImpl implements MemberLinkService {
	
	@Autowired
	MemberLinkDao memberLinkDao;
	
	@Override
	public ArrayList<MemberLink> getMemberLinksByMemberNo(int memberNo) {
		return memberLinkDao.getMemberLinksByMemberNo(memberNo);
	}

	@Override
	public void insertMemberLink(MemberLink link) {
		memberLinkDao.insertMemberLink(link);
	}

	@Override
	public void deleteMemberLink(MemberLink link) {
		memberLinkDao.deleteMemberLink(link);
	}

	@Override
	public void updateMemberLink(MemberLink link) {
		memberLinkDao.updateMemberLink(link);
	}

	@Override
	public ArrayList<MemberLink> getMemberLinksByUser(User user) {
		return memberLinkDao.getMemberLinksByUser(user);
	}

	@Override
	public void deleteAllMemberLinkByMemberNo(int memberNo) {
		memberLinkDao.deleteAllMemberLinksByMemberNo(memberNo);
	}

}
