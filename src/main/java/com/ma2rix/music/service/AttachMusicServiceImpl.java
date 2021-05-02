package com.ma2rix.music.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma2rix.music.dao.interfaces.AttachMusicDao;
import com.ma2rix.music.model.domain.AttachMusic;
import com.ma2rix.music.service.interfaces.AttachMusicService;

@Service
public class AttachMusicServiceImpl implements AttachMusicService {
	
	@Autowired 
	private AttachMusicDao attachMusicDao;
	
	@Override
	public ArrayList<AttachMusic> getAttachMusicsByCode(String code) {
		return attachMusicDao.getAttachMusicsByCode(code);
	}

	@Override
	public AttachMusic getAttachMusicByCodeAndNo(Map<String, String> cond) {
		return attachMusicDao.getAttachMusicByCodeAndNo(cond);
	}

	@Override
	public void insertAttachMusic(AttachMusic attatchMusic) {
		attachMusicDao.insertAttachMusic(attatchMusic);
	}

	@Override
	public void updateAttachMusic(AttachMusic attatchMusic) {
		attachMusicDao.updateAttachMusic(attatchMusic);
	}

	@Override
	public void deleteAttachMusic(AttachMusic attatchMusic) {
		attachMusicDao.deleteAttachMusic(attatchMusic);
	}

	@Override
	public void deleteAttachMusicByAttchNo(int attachNo) {
		attachMusicDao.deleteAttachMusicByAttchNo(attachNo);
	}

	@Override
	public void updateAttachMusicByAttatchNo(int attachNo) {	
		attachMusicDao.updateAttachMusicByAttatchNo(attachNo);
	}

	@Override
	public AttachMusic getAttachMusicByAttachNo(int attachNo) {
		return attachMusicDao.getAttachMusicByAttachNo(attachNo);
	}
}
