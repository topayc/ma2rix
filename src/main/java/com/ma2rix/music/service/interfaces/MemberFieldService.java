package com.ma2rix.music.service.interfaces;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.ma2rix.music.model.domain.MemberField;
import com.ma2rix.music.model.domain.User;

@Transactional
public interface MemberFieldService {
	public ArrayList<MemberField> getMemberFieldsByUser(User user);
	public ArrayList<MemberField> getMemberFieldsByMemberNo(int memberNo);
	public void insertMemberField(MemberField memberField);
	public void deleteMemberField(MemberField activity);
	public void deleteAllMemberFieldsByMemberNo(int memberNo);
	public void updateMemberField(MemberField memberField);
}
