package com.ma2rix.music.dao.interfaces;

import java.util.ArrayList;

import com.ma2rix.music.model.command.ArrangementCommand;
import com.ma2rix.music.model.command.CommentCommand;
import com.ma2rix.music.model.command.PerformanceCommand;
import com.ma2rix.music.model.domain.Arrangement;
import com.ma2rix.music.model.domain.Performance;

public interface ArrangementDao {
	
	public int getArrangementCount();
	public ArrayList<ArrangementCommand> getArrangementCommandList (
			int genreNo, 
			int pageCount, 
			int pageOffset, 
			int orderBy, 
			String arrangeStatus);

	public ArrayList<CommentCommand> getCommentCommandList (
			String musicClassNo, 
			int pageCount, 
			int pageOffset, 
			int orderBy);

	public ArrayList<ArrangementCommand> getAllArrangementCommandList();
	public ArrangementCommand getArrangementCommandByArrangeNo(int arrangeNo);
	public Arrangement getArrangementByArrangeNo(int arrangeNo);
	public void insertArrangement(Arrangement arrangement);
	public void updateArrangement(Arrangement arrangement);
	public void deleteArrangement(int arrangeNo);
	
	public ArrayList<PerformanceCommand> getPerformanceCommandsByArrangeNo(int arrangeNo);
	public ArrayList<Performance>	getPerformancesByArrangeNo(int arrangeNo);
	public void insertPerformance(Performance performance);
	public void updatePerformance(Performance performance);
	public void deletePerformance(Performance performance);
}
