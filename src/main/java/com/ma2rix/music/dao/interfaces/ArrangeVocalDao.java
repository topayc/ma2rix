package com.ma2rix.music.dao.interfaces;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ma2rix.music.model.command.ArrangeVocalCommand;
import com.ma2rix.music.model.domain.ArrangeVocal;

public interface ArrangeVocalDao {
	public int getArrangeVocalCount();
	public ArrayList<ArrangeVocal> getAllArrangeVocalList();
	public ArrayList<ArrangeVocalCommand> getAllArrangeVocalCommandList();
	
	public ArrayList<ArrangeVocalCommand> getArrangeVocalCommandsByArrangeNo(int arrangeNo);
	public ArrangeVocalCommand getArrangeVocalCommandByArrangeNoAndVocalMemberNo(
			int arrangeNo,
			int vocalMemberNo
			);
	
	public ArrangeVocal getArrangeVocalByArrangeNoAndVocalMemberNo(
			int arrangeNo,
			int vocalMemberNo
			);
	public ArrayList<ArrangeVocal> getArrangeVocalByArrangeNo(int arrangeNo);
	public ArrangeVocal getArrangeVocalByVocalMemberNo(int vocalMemberNo);

	public void insertArrangeVocal(ArrangeVocal arrangeVocal);
	public void deleteArrangeVocalByArrangeNoAndVocalMemberNo(
				int arrangeNo,
				int vocalMemberNo
			);
	public void deleteArrangeVocalByArrangeNo(int arrangeNo);
	public void deleteArrangeVocalByVocalMemberNo(int vocalMemberNo);
	public void updateArrangeVocal(ArrangeVocal arrangeVocal);
}
