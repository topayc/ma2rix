package com.ma2rix.music.dao.mapper;

import java.util.ArrayList;
import com.ma2rix.music.model.domain.PlayField;

public interface PlayFieldMapper {
	public ArrayList<PlayField> getAllPlayFields();
	public PlayField getPlayFieldByFieldNo(int playFieldNo);
	public void insertPlayField(PlayField playField);
	public void deletePlayField(PlayField playFiel);
	public void updatePlayField(PlayField playFiel);
}
