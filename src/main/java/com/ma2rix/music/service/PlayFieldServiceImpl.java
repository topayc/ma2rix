package com.ma2rix.music.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma2rix.music.dao.interfaces.PlayFieldDao;
import com.ma2rix.music.model.domain.PlayField;
import com.ma2rix.music.service.interfaces.PlayFieldService;

@Service
public class PlayFieldServiceImpl implements PlayFieldService {
	
	@Autowired 
	private PlayFieldDao playFieldDao;
	
	@Override
	public ArrayList<PlayField> getAllPlayFields() {
		return playFieldDao.getAllPlayFields();
	}

	@Override
	public void insertPlayField(PlayField playField) {
		playFieldDao.insertPlayField(playField);
	}

	@Override
	public void deletePlayField(PlayField playFiel) {
		playFieldDao.deletePlayField(playFiel);
	}

	@Override
	public void updatePlayField(PlayField playFiel) {
		playFieldDao.updatePlayField(playFiel);
	}

	@Override
	public PlayField getPlayFieldByFieldNo(int playFieldNo) {
		return playFieldDao.getPlayFieldByFieldNo(playFieldNo);
	}

}
