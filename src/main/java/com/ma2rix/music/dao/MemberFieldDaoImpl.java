package com.ma2rix.music.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.MemberFieldDao;
import com.ma2rix.music.dao.mapper.MemberFieldMapper;
import com.ma2rix.music.model.domain.MemberField;
import com.ma2rix.music.model.domain.User;

@Repository
public class MemberFieldDaoImpl implements MemberFieldDao {

	@Autowired
	MemberFieldMapper memberFieldMapper;


	@Override
	public void insertMemberField(MemberField memberField) {
		memberFieldMapper.insertMemberField(memberField);
	}

	@Override
	public void deleteMemberField(MemberField memberField) {
		memberFieldMapper.deleteMemberField(memberField);
	}

	@Override
	public void updateMemberField(MemberField memberField) {
		memberFieldMapper.updateMemberField(memberField);
	}

	@Override
	public ArrayList<MemberField> getMemberFieldsByUser(User user) {
		return memberFieldMapper.getMemberFieldsByUser(user);
	}

	@Override
	public ArrayList<MemberField> getMemberFieldsByMemberNo(int memberNo) {
		return memberFieldMapper.getMemberFieldsByMemberNo(memberNo);
	}

	@Override
	public void deleteAllMemberFieldsByMemberNo(int memberNo) {
		memberFieldMapper.deleteAllMemberFieldsByMemberNo(memberNo);
	}

}
