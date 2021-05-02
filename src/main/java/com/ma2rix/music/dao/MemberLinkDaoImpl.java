package com.ma2rix.music.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.MemberLinkDao;
import com.ma2rix.music.dao.mapper.MemberLinkMapper;
import com.ma2rix.music.model.domain.MemberLink;
import com.ma2rix.music.model.domain.User;

@Repository
public class MemberLinkDaoImpl implements MemberLinkDao {

	@Autowired
	MemberLinkMapper memberLinkMapper;
	
	@Override
	public ArrayList<MemberLink> getMemberLinksByMemberNo(int memberNo) {
		return memberLinkMapper.getMemberLinksByMemberNo(memberNo);
	}

	@Override
	public void insertMemberLink(MemberLink link) {
		memberLinkMapper.insertMemberLink(link);
	}

	@Override
	public void deleteMemberLink(MemberLink link) {
		memberLinkMapper.deleteMemberLink(link);
	}

	@Override
	public void updateMemberLink(MemberLink link) {
		memberLinkMapper.updateMemberLink(link);
	}

	@Override
	public ArrayList<MemberLink> getMemberLinksByUser(User user) {
		return memberLinkMapper.getMemberLinksByUser(user);
	}

	@Override
	public void deleteAllMemberLinksByMemberNo(int memberNo) {
		memberLinkMapper.deleteAllMemberLinksByMemberNo(memberNo);
		
	}

}
