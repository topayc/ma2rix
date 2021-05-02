package com.ma2rix.music.dao.mapper;

import java.util.ArrayList;

import com.ma2rix.music.model.domain.PG;

public interface PGMapper {
	public int getPGCount();
	public ArrayList<PG> getAllPGList();
	public PG getPGByNo(int pgNo);
	public PG getPGByName(String name);
	public ArrayList<PG> getPGByStatus(String pgStatus);
	
	public void updatePG(PG pg);
	public void insertPG(PG pg);
	public void deleteRG(PG pg);
	
}
