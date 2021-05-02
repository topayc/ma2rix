package com.ma2rix.music.dao;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.AttachMusicDao;
import com.ma2rix.music.dao.mapper.AttachMusicMapper;
import com.ma2rix.music.model.domain.AttachMusic;

@Repository
public class AttachMusicDaoImpl implements AttachMusicDao {
	
	@Autowired
	private AttachMusicMapper attachMusicMapper; 
	
	@Override
	public ArrayList<AttachMusic> getAttachMusicsByCode(String code) {
		return attachMusicMapper.getAttachMusicsByCode(code);
	}

	@Override
	public AttachMusic getAttachMusicByCodeAndNo(Map<String, String> cond) {
		return attachMusicMapper.getAttachMusicByCodeAndNo(cond);
	}

	@Override
	public void insertAttachMusic(AttachMusic attatchMusic) {
		attachMusicMapper.insertAttachMusic(attatchMusic);
	}

	@Override
	public void updateAttachMusic(AttachMusic attatchMusic) {
		attachMusicMapper.updateAttachMusic(attatchMusic);
	}

	@Override
	public void deleteAttachMusic(AttachMusic attatchMusic) {
		attachMusicMapper.deleteAttachMusic(attatchMusic);
	}

	@Override
	public void deleteAttachMusicByAttchNo(int attachNo) {
		attachMusicMapper.deleteAttachMusicByAttchNo(attachNo);
	}

	@Override
	public void updateAttachMusicByAttatchNo(int attachNo) {
		attachMusicMapper.updateAttachMusicByAttatchNo(attachNo);
		
	}

	@Override
	public AttachMusic getAttachMusicByAttachNo(int attachNo) {
		return attachMusicMapper.getAttachMusicByAttachNo(attachNo);
	}

}
