package com.ma2rix.music.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma2rix.music.dao.interfaces.MemberFieldDao;
import com.ma2rix.music.model.domain.MemberField;
import com.ma2rix.music.model.domain.User;
import com.ma2rix.music.service.interfaces.MemberFieldService;

@Service
public class MemberFieldServiceImpl implements MemberFieldService {

	@Autowired
	MemberFieldDao memberFieldDao;
	
	@Override
	public ArrayList<MemberField> getMemberFieldsByUser(User user) {
		return memberFieldDao.getMemberFieldsByUser(user);
	}

	@Override
	public void insertMemberField(MemberField memberField) {
		memberFieldDao.insertMemberField(memberField);
	}

	@Override
	public void deleteMemberField(MemberField memberField) {
		memberFieldDao.deleteMemberField(memberField);
	}

	@Override
	public void updateMemberField(MemberField memberField) {
		memberFieldDao.updateMemberField(memberField);

	}

	@Override
	public ArrayList<MemberField> getMemberFieldsByMemberNo(int memberNo) {
		return memberFieldDao.getMemberFieldsByMemberNo(memberNo);
	}

	@Override
	public void deleteAllMemberFieldsByMemberNo(int memberNo) {
		memberFieldDao.deleteAllMemberFieldsByMemberNo(memberNo);
	}

}
