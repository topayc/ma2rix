package com.ma2rix.music.dao;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.CompositionDao;
import com.ma2rix.music.dao.mapper.CompositionMapper;
import com.ma2rix.music.model.command.ComposeArrangeCommand;
import com.ma2rix.music.model.command.CompositionCommand;
import com.ma2rix.music.model.domain.Composition;

@Repository
public class CompositionDaoImpl implements CompositionDao {

	@Autowired CompositionMapper compositionMapper;
	
	@Override
	public int getCompositionCount() {
		return compositionMapper.getCompositionCount();
	}

	@Override
	public ArrayList<Composition> getCompositionList(
			int pageCount, int pageOffset, int orderBy) {
		return compositionMapper.getCompositionList(pageCount, pageOffset, orderBy);
	}

	@Override
	public Composition getCompositionByComposeNo(int composeNo) {
		return compositionMapper.getCompositionByComposeNo(composeNo);
	}

	@Override
	public void insertComposition(Composition composition) {
		compositionMapper.insertComposition(composition);
	}

	@Override
	public void updateComposition(Composition composition) {
		compositionMapper.updateComposition(composition);
	}

	@Override
	public void deleteComposition(int composeNo) {
		compositionMapper.deleteComposition(composeNo);
	}

	@Override
	public ArrayList<CompositionCommand> getCompositionCommandList(
			int pageCount, int pageOffset, int orderBy) {
		return compositionMapper.getCompositionCommandList(pageCount, pageOffset, orderBy);
	}

	@Override
	public CompositionCommand getCompositionCommandByComposeNo(int composeNo) {
		return compositionMapper.getCompositionCommandByComposeNo(composeNo);
	}

	@Override
	public ArrayList<ComposeArrangeCommand> getComposeArrangeCommandsByComposeNo(int composeNo) {
		return compositionMapper.getComposeArrangeCommandsByComposeNo(composeNo);
	}	
}
