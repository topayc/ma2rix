package com.ma2rix.music.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ma2rix.music.model.command.ArrangementCommand;
import com.ma2rix.music.model.command.CommentCommand;
import com.ma2rix.music.model.command.PerformanceCommand;
import com.ma2rix.music.model.domain.Arrangement;
import com.ma2rix.music.model.domain.Performance;

public interface ArrangementMapper {
	
	public int getArrangementCount();
	public ArrayList<ArrangementCommand> getArrangementCommandList (
			@Param("genreNo") int genreNo, 
			@Param("pageCount") int pageCount, 
			@Param("pageOffset") int pageOffset, 
			@Param("orderBy") int orderBy,
			@Param("arrangeStatus") String arrangeStatus			
			);
	
	public ArrayList<ArrangementCommand> getAllArrangementCommandList();
	public ArrangementCommand getArrangementCommandByArrangeNo(int arrangeNo);
	public Arrangement getArrangementByArrangeNo(int arrangeNo);
	public void insertArrangement(Arrangement arrangement);
	public void updateArrangement(Arrangement arrangement);
	public void deleteArrangement(int arrangeNo);
	
	public ArrayList<PerformanceCommand> getPerformanceCommandsByArrangeNo(int arrangeNo);
	public ArrayList<Performance> getPerformancesByArrangeNo(int arrangeNo);
	public void insertPerformance(Performance performance);
	public void updatePerformance(Performance performance);
	public void deletePerformance(Performance performance);
}
