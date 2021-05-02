package com.ma2rix.music.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ma2rix.music.model.command.ComposeArrangeCommand;
import com.ma2rix.music.model.command.CompositionCommand;
import com.ma2rix.music.model.domain.Composition;

public interface CompositionMapper {
	public int getCompositionCount();
	public ArrayList<Composition> getCompositionList(
			@Param("pageCount") int pageCount,
			@Param("pageOffder") int pageOffset, 
			@Param("orderBy") int orderBy);
	
	public ArrayList<CompositionCommand> getCompositionCommandList(
			@Param("pageCount") int pageCount,
			@Param("pageOffder") int pageOffset, 
			@Param("orderBy") int orderBy);
	
	public CompositionCommand getCompositionCommandByComposeNo(int composeNo);
	public Composition getCompositionByComposeNo(int composeNo);
	public void insertComposition(Composition composition);
	public void updateComposition(Composition composition);
	public void deleteComposition(int composeNo);
	public ArrayList<ComposeArrangeCommand> getComposeArrangeCommandsByComposeNo(int composeNo);
}
