package com.ma2rix.music.service.interfaces;

import java.util.ArrayList;

import com.ma2rix.music.model.domain.PlayField;

public interface PlayFieldService {
	public ArrayList<PlayField> getAllPlayFields();
	public PlayField getPlayFieldByFieldNo(int playFieldNo);
	public void insertPlayField(PlayField playField);
	public void deletePlayField(PlayField playFiel);
	public void updatePlayField(PlayField playFiel);
}
