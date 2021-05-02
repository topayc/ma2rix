package com.ma2rix.music.service.interfaces;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.ma2rix.music.model.domain.MemberPlay;
import com.ma2rix.music.model.domain.User;

@Transactional
public interface MemberPlayService {
	public ArrayList<MemberPlay> getMemberPlaysByMemberNo(int memberNo);
	public ArrayList<MemberPlay> getMemberPlaysByUser(User user);
	public void insertMemberPlay(MemberPlay play);
	public void deleteMemberPlay(MemberPlay play);
	public void updateMemberPlay(MemberPlay play);
	public void deleteAllMemberPlaysByMemberNo(int memberNo);
}
