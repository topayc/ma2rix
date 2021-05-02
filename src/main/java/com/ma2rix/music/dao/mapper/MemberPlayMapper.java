package com.ma2rix.music.dao.mapper;

import java.util.ArrayList;

import com.ma2rix.music.model.domain.MemberPlay;
import com.ma2rix.music.model.domain.User;

public interface MemberPlayMapper {
	public ArrayList<MemberPlay> getMemberPlaysByMemberNo(int memberNo);
	public ArrayList<MemberPlay> getMemberPlaysByUser(User user);
	public void insertMemberPlay(MemberPlay play);
	public void deleteMemberPlay(MemberPlay play);
	public void deleteAllMemberPlaysByMemberNo(int memberNo);
	public void updateMemberPlay(MemberPlay play);
}