package com.ma2rix.music.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.PGDao;
import com.ma2rix.music.dao.mapper.PGMapper;
import com.ma2rix.music.model.domain.PG;

@Repository
public class PGDaoImpl implements PGDao {

	@Autowired PGMapper pgMapper;

	@Override
	public int getPGCount() {
		return pgMapper.getPGCount();
	}

	@Override
	public ArrayList<PG> getAllPGList() {
		return pgMapper.getAllPGList();
	}

	@Override
	public PG getPGByNo(int pgNo) {
		return pgMapper.getPGByNo(pgNo);
	}

	@Override
	public PG getPGByName(String name) {
		return pgMapper.getPGByName(name);
	}

	@Override
	public ArrayList<PG> getPGByStatus(String pgStatus) {
		return pgMapper.getPGByStatus(pgStatus);
	}

	@Override
	public void updatePG(PG pg) {
		pgMapper.updatePG(pg);
	}

	@Override
	public void insertPG(PG pg) {
		pgMapper.insertPG(pg);
	}

	@Override
	public void deleteRG(PG pg) {
		pgMapper.deleteRG(pg);
		
	}

}
