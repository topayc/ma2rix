package com.ma2rix.music.dao.interfaces;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ma2rix.music.model.domain.ComposeArranger;

public interface ComposeArrangerDao {
	public int getComposeArrangeCount();
	public ArrayList<ComposeArranger> getAllComposeArrnagerList();
	public ComposeArranger getComposeArrangeByComposeNo(int composeNo);
	public ComposeArranger getComposeArrangeByArrangeMemberNo(int memberNo);
	public ComposeArranger getComposeArrangeByNo(
			@Param("composeNo") int composeNo,
			@Param("arrangeMemberNo") int arrangeMemberNo
			);
	
	public void insertComposeArranger(ComposeArranger composeArranger);
	public void deleteComposeArrangerlByNo(
			@Param("composeNo") int composeNo,
			@Param("arrangeMemberNo") int arrangeMemberNo
			);
	
	public void deleteComposeArrangeByComposeNo(int composeNo);
	public void deleteComposeArrangeByArrangeMemgerNo(int arrangeMemberNo);
	public void updateComposeArrange(ComposeArranger composeArranger);
	
}
