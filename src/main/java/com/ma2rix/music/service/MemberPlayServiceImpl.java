package com.ma2rix.music.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma2rix.music.dao.interfaces.MemberPlayDao;
import com.ma2rix.music.model.domain.MemberPlay;
import com.ma2rix.music.model.domain.User;
import com.ma2rix.music.service.interfaces.MemberPlayService;

@Service
public class MemberPlayServiceImpl implements MemberPlayService {
	
	@Autowired
	MemberPlayDao memberPlayDao;
	
	@Override
	public ArrayList<MemberPlay> getMemberPlaysByMemberNo(int memberNo) {
		return memberPlayDao.getMemberPlaysByMemberNo(memberNo);
	}

	@Override
	public void insertMemberPlay(MemberPlay play) {
		memberPlayDao.insertMemberPlay(play);

	}

	@Override
	public void deleteMemberPlay(MemberPlay play) {
		memberPlayDao.deleteMemberPlay(play);
	}

	@Override
	public void updateMemberPlay(MemberPlay play) {
		memberPlayDao.updateMemberPlay(play);
	}

	@Override
	public ArrayList<MemberPlay> getMemberPlaysByUser(User user) {
		return memberPlayDao.getMemberPlaysByUser(user);
	}

	@Override
	public void deleteAllMemberPlaysByMemberNo(int memberNo) {
		memberPlayDao.deleteAllMemberPlaysByMemberNo(memberNo);
	}

}
