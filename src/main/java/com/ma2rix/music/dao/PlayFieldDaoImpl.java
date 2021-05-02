package com.ma2rix.music.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.PlayFieldDao;
import com.ma2rix.music.dao.mapper.PlayFieldMapper;
import com.ma2rix.music.model.domain.PlayField;

@Repository
public class PlayFieldDaoImpl implements PlayFieldDao{
	
	@Autowired
	private PlayFieldMapper playFieldMapper;
	
	@Override
	public ArrayList<PlayField> getAllPlayFields() {
		return playFieldMapper.getAllPlayFields();
	}

	@Override
	public void insertPlayField(PlayField playField) {
		playFieldMapper.insertPlayField(playField);
	}

	@Override
	public void deletePlayField(PlayField playFiel) {
		playFieldMapper.deletePlayField(playFiel);
	}

	@Override
	public void updatePlayField(PlayField playFiel) {
		playFieldMapper.updatePlayField(playFiel);
	}

	@Override
	public PlayField getPlayFieldByFieldNo(int playFieldNo) {
		return playFieldMapper.getPlayFieldByFieldNo(playFieldNo);
	}

}
