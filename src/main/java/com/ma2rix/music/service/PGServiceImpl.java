package com.ma2rix.music.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma2rix.music.dao.interfaces.PGDao;
import com.ma2rix.music.model.domain.PG;
import com.ma2rix.music.service.interfaces.PGService;

@Service
public class PGServiceImpl implements PGService {

	@Autowired PGDao pgDao;
	
	@Override
	public int getPGCount() {
		return pgDao.getPGCount();
	}

	@Override
	public ArrayList<PG> getAllPGList() {
		return pgDao.getAllPGList();
	}

	@Override
	public PG getPGByNo(int pgNo) {
		return pgDao.getPGByNo(pgNo);
	}

	@Override
	public PG getPGByName(String name) {
		return pgDao.getPGByName(name);
	}

	@Override
	public ArrayList<PG> getPGByStatus(String pgStatus) {
		return pgDao.getPGByStatus(pgStatus);
	}

	@Override
	public void updatePG(PG pg) {
		pgDao.updatePG(pg);
	}

	@Override
	public void insertPG(PG pg) {
		pgDao.insertPG(pg);
	}

	@Override
	public void deleteRG(PG pg) {
		pgDao.deleteRG(pg);
	}

}
