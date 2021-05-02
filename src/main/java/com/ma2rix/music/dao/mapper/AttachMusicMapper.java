package com.ma2rix.music.dao.mapper;

import java.util.ArrayList;
import java.util.Map;

import com.ma2rix.music.model.domain.AttachMusic;

public interface AttachMusicMapper {
	public ArrayList<AttachMusic> getAttachMusicsByCode(String code);
	public AttachMusic getAttachMusicByCodeAndNo(Map<String,String> cond);
	public AttachMusic getAttachMusicByAttachNo(int attachNo);
	public void insertAttachMusic(AttachMusic attatchMusic);
	public void updateAttachMusicByAttatchNo(int attachNo);
	public void updateAttachMusic(AttachMusic attatchMusic);
	public void deleteAttachMusic(AttachMusic attatchMusic);
	public void deleteAttachMusicByAttchNo(int  attachNo);
}
