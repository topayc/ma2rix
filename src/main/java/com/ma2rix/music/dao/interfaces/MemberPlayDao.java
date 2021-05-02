package com.ma2rix.music.dao.interfaces;

import java.util.ArrayList;

import com.ma2rix.music.model.domain.MemberPlay;
import com.ma2rix.music.model.domain.User;

public interface MemberPlayDao {
	public ArrayList<MemberPlay> getMemberPlaysByMemberNo(int memberNo);
	public ArrayList<MemberPlay> getMemberPlaysByUser(User user);
	public void insertMemberPlay(MemberPlay play);
	public void deleteMemberPlay(MemberPlay play);
	public void updateMemberPlay(MemberPlay play);
	public void deleteAllMemberPlaysByMemberNo(int memberNo);
}
