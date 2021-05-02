package com.ma2rix.music.dao.mapper;

import java.util.ArrayList;
import com.ma2rix.music.model.domain.ComposeArranger;

public interface ComposeArrangerDao {
	public int getComposeArrangeCount();
	public ArrayList<ComposeArranger> getAllComposeArrnagerList();
	public ComposeArranger getComposeArrangeByComposeNo(int composeNo);
	public ComposeArranger getComposeArrangeByArrangeMemberNo(int memberNo);
	public ComposeArranger getComposeArrangeByNo(int composeNo,int arrangeMemberNo);
	
	public void insertComposeArranger(ComposeArranger composeArranger);
	public void deleteComposeArrangerlByNo(int composeNo,int arrangeMemberNo);
	
	public void deleteComposeArrangeByArrangeNo(int arrangeNo);
	public void deleteComposeArrangeByArrangeMemgerNo(int arrangeMemberNo);
	public void updateComposeArrange(ComposeArranger composeArranger);
	
}
