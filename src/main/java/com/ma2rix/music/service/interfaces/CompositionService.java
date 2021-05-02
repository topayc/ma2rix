package com.ma2rix.music.service.interfaces;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.ma2rix.music.model.command.ComposeArrangeCommand;
import com.ma2rix.music.model.command.ComposeUpdateCommand;
import com.ma2rix.music.model.command.CompositionCommand;
import com.ma2rix.music.model.domain.Composition;

@Transactional
public interface CompositionService {
	
	public static final int PAGE_OFFSET = 10;
	
	public int getCompositionCount();
	public ArrayList<Composition> getCompositionList(int genreNo, 
			int pageCount, int pageOffse, int orderby);
	public ArrayList<CompositionCommand> getCompositionCommandList(
			int pageCount, 
			int pageOffset, 
			int orderBy);

	public CompositionCommand getCompositionCommandByComposeNo(int composeNo);
	public Composition getCompositionByComposeNo(int composeNo);
	public void insertComposition(Composition composition);
	public void updateComposition(Composition composition);
	public void deleteComposition(int composeNo);
	public void updateCompositionUpdateCommand(ComposeUpdateCommand composeUpdateCommand);
	public ArrayList<ComposeArrangeCommand>  getComposeArrangeCommandsByComposeNo(int composeNo);
}
