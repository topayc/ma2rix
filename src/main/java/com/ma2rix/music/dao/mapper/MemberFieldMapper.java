package com.ma2rix.music.dao.mapper;

import java.util.ArrayList;

import com.ma2rix.music.model.domain.MemberField;
import com.ma2rix.music.model.domain.User;

public interface MemberFieldMapper {
	public ArrayList<MemberField> getMemberFieldsByUser(User user);
	public ArrayList<MemberField> getMemberFieldsByMemberNo(int memberNo);
	public void insertMemberField(MemberField memberField);
	public void deleteMemberField(MemberField memberField);
	public void deleteAllMemberFieldsByMemberNo(int membeNo);
	public void updateMemberField(MemberField memberField);
}
