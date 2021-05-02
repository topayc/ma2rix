package com.ma2rix.music.service.interfaces;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.ma2rix.music.model.domain.ComposeArranger;

@Transactional
public interface ComposeArrangerService {
	public int getComposeArrangeCount();
	public ArrayList<ComposeArranger> getAllComposeArrnagerList();
	public ComposeArranger getComposeArrangeByComposeNo(int composeNo);
	public ComposeArranger getComposeArrangeByArrangeMemberNo(int memberNo);
	public ComposeArranger getComposeArrangeByNo(int composeNo,int arrangeMemberNo);
	
	public void insertComposeArranger(ComposeArranger composeArranger);
	public void deleteComposeArrangerlByNo(int composeNo,int arrangeMemberNo);
	
	public void deleteComposeArrangeByComposeNo(int composeNo);
	public void deleteComposeArrangeByArrangeMemgerNo(int arrangeMemberNo);
	public void updateComposeArrange(ComposeArranger composeArranger);
}
