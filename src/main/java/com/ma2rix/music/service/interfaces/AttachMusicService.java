package com.ma2rix.music.service.interfaces;

import java.util.ArrayList;
import java.util.Map;

import com.ma2rix.music.model.domain.AttachMusic;

public interface AttachMusicService {
	public ArrayList<AttachMusic> getAttachMusicsByCode(String code);
	public AttachMusic getAttachMusicByCodeAndNo(Map<String,String> cond);
	public AttachMusic getAttachMusicByAttachNo(int attachNo);
	public void insertAttachMusic(AttachMusic attatchMusic);
	public void updateAttachMusic(AttachMusic attatchMusic);
	public void deleteAttachMusic(AttachMusic attatchMusic);
	public void updateAttachMusicByAttatchNo(int attachNo);
	public void deleteAttachMusicByAttchNo(int  attachNo);

}
