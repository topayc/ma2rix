package com.ma2rix.music.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.ArrangementDao;
import com.ma2rix.music.dao.mapper.ArrangementMapper;
import com.ma2rix.music.dao.mapper.CommentMapper;
import com.ma2rix.music.model.command.ArrangementCommand;
import com.ma2rix.music.model.command.CommentCommand;
import com.ma2rix.music.model.command.PerformanceCommand;
import com.ma2rix.music.model.domain.Arrangement;
import com.ma2rix.music.model.domain.Performance;

@Repository
public class ArrangementDaoImpl implements ArrangementDao {
	
	@Autowired private ArrangementMapper arrangementMapper;
	@Autowired private CommentMapper commentMapper;	

	@Override
	public int getArrangementCount() {
		return arrangementMapper.getArrangementCount();
	}
	
	@Override
	public ArrayList<ArrangementCommand> getArrangementCommandList(int genreNo,
			int pageCount, int pageOffset, int orderBy, String arrangeStatus) {
		return arrangementMapper.getArrangementCommandList(genreNo, pageCount, pageOffset, orderBy, arrangeStatus);
	}
	
	@Override
	public ArrayList<CommentCommand> getCommentCommandList(String musicClassNo,
			int pageCount, int pageOffset, int orderBy) {
		return commentMapper.getCommentCommandList(musicClassNo, pageCount, pageOffset, orderBy);	
	}
	

	@Override
	public ArrangementCommand getArrangementCommandByArrangeNo(int arrangeNo) {
		return arrangementMapper.getArrangementCommandByArrangeNo(arrangeNo);
	}

	@Override
	public void insertArrangement(Arrangement arrangement) {
		arrangementMapper.insertArrangement(arrangement);
	}

	@Override
	public void updateArrangement(Arrangement arrangement) {
		arrangementMapper.updateArrangement(arrangement);
	}

	@Override
	public void deleteArrangement(int arrangeNo) {
		arrangementMapper.deleteArrangement(arrangeNo);
	}

	@Override
	public ArrayList<Performance> getPerformancesByArrangeNo(int arrangeNo) {
		return arrangementMapper.getPerformancesByArrangeNo(arrangeNo);
	}

	@Override
	public void insertPerformance(Performance performance) {
		arrangementMapper.insertPerformance(performance);;
	}

	@Override
	public void updatePerformance(Performance performance) {
		arrangementMapper.updatePerformance(performance);
	}

	@Override
	public void deletePerformance(Performance performance) {
		arrangementMapper.deletePerformance(performance);
	}

	@Override
	public Arrangement getArrangementByArrangeNo(int arrangeNo) {
		return arrangementMapper.getArrangementByArrangeNo(arrangeNo);
	}

	@Override
	public ArrayList<ArrangementCommand> getAllArrangementCommandList() {
		
		return arrangementMapper.getAllArrangementCommandList();
	}

	@Override
	public ArrayList<PerformanceCommand> getPerformanceCommandsByArrangeNo(
			int arrangeNo) {
		return arrangementMapper.getPerformanceCommandsByArrangeNo(arrangeNo);
	}

	

}
