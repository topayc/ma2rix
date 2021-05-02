package com.ma2rix.music.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.MemberPlayDao;
import com.ma2rix.music.dao.mapper.MemberPlayMapper;
import com.ma2rix.music.model.domain.MemberPlay;
import com.ma2rix.music.model.domain.User;

@Repository
public class MemberPlayDaoImpl implements MemberPlayDao {

	@Autowired
	private MemberPlayMapper memberPlayMapper;
	
	@Override
	public ArrayList<MemberPlay> getMemberPlaysByMemberNo(int memberNo) {
		return memberPlayMapper.getMemberPlaysByMemberNo(memberNo);
	}

	@Override
	public void insertMemberPlay(MemberPlay play) {
		memberPlayMapper.insertMemberPlay(play);
	}

	@Override
	public void deleteMemberPlay(MemberPlay play) {
		memberPlayMapper.deleteMemberPlay(play);
	}

	@Override
	public void updateMemberPlay(MemberPlay play) {
		memberPlayMapper.updateMemberPlay(play);
	}

	@Override
	public ArrayList<MemberPlay> getMemberPlaysByUser(User user) {
		return memberPlayMapper.getMemberPlaysByUser(user);
	}

	@Override
	public void deleteAllMemberPlaysByMemberNo(int memberNo) {
		memberPlayMapper.deleteAllMemberPlaysByMemberNo(memberNo);
	}

}
