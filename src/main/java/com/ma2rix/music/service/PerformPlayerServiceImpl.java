package com.ma2rix.music.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma2rix.music.dao.interfaces.PerformPlayerDao;
import com.ma2rix.music.model.domain.PerformPlayer;
import com.ma2rix.music.service.interfaces.PerformPlayerService;

@Service
public class PerformPlayerServiceImpl implements PerformPlayerService {
	
	@Autowired PerformPlayerDao pfDao;
	
	public int getPerformPlayerCount() {
		return pfDao.getPerformPlayerCount();
	}

	@Override
	public ArrayList<PerformPlayer> getPerformPlayersByPlayerMemberNo(
			int playerMemberNo) {
		return pfDao.getPerformPlayersByPlayerMemberNo(playerMemberNo);
	}

	@Override
	public ArrayList<PerformPlayer> getPerformPlayersByPerformNo(int performNo) {
		return pfDao.getPerformPlayersByPerformNo(performNo);
	}

	@Override
	public PerformPlayer getPerformPlayerByPerformNoAndPlayerMemberNo(
			int performNo, int playerMemberNo) {
		return pfDao.getPerformPlayerByPerformNoAndPlayerMemberNo(performNo, playerMemberNo);
	}

	@Override
	public void insertPerformPlayer(PerformPlayer performPlayer) {
		pfDao.insertPerformPlayer(performPlayer);
	}

	@Override
	public void updatePerfomPlayer(PerformPlayer performPlayer) {
		pfDao.updatePerfomPlayer(performPlayer);
	}

	@Override
	public void deletePerformPlayer(int performNo, int playerMemberNo) {
		pfDao.deletePerformPlayer(performNo, playerMemberNo);
	}

}
