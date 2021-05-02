package com.ma2rix.music.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma2rix.music.dao.interfaces.ArrangeVocalDao;
import com.ma2rix.music.model.command.ArrangeVocalCommand;
import com.ma2rix.music.model.domain.ArrangeVocal;
import com.ma2rix.music.service.interfaces.ArrangeVocalService;

@Service
public class ArrangeVocalServiceImpl implements ArrangeVocalService {

	@Autowired ArrangeVocalDao arrangeVocalDao;
	@Override
	public int getArrangeVocalCount() {
		return arrangeVocalDao.getArrangeVocalCount();
	}

	@Override
	public ArrayList<ArrangeVocal> getAllArrangeVocalList() {
		return arrangeVocalDao.getAllArrangeVocalList();
	}

	@Override
	public ArrayList<ArrangeVocalCommand> getAllArrangeVocalCommandList() {
		return arrangeVocalDao.getAllArrangeVocalCommandList();
	}

	@Override
	public ArrayList<ArrangeVocalCommand> getArrangeVocalCommandsByArrangeNo(
			int arrangeNo) {
		return arrangeVocalDao.getArrangeVocalCommandsByArrangeNo(arrangeNo);
	}

	@Override
	public ArrangeVocalCommand getArrangeVocalCommandByArrangeNoAndVocalMemberNo(
			int arrangeNo, int vocalMemberNo) {
		return arrangeVocalDao.getArrangeVocalCommandByArrangeNoAndVocalMemberNo(arrangeNo, vocalMemberNo);
	}

	@Override
	public ArrangeVocal getArrangeVocalByArrangeNoAndVocalMemberNo(
			int arrangeNo, int vocalMemberNo) {
		return arrangeVocalDao.getArrangeVocalByArrangeNoAndVocalMemberNo(arrangeNo, vocalMemberNo);
	}

	@Override
	public ArrayList<ArrangeVocal> getArrangeVocalByArrangeNo(int arrangeNo) {
		return arrangeVocalDao.getArrangeVocalByArrangeNo(arrangeNo);
	}

	@Override
	public ArrangeVocal getArrangeVocalByVocalMemberNo(int vocalMemberNo) {
		return arrangeVocalDao.getArrangeVocalByVocalMemberNo(vocalMemberNo);
	}

	@Override
	public void insertArrangeVocal(ArrangeVocal arrangeVocal) {
		arrangeVocalDao.insertArrangeVocal(arrangeVocal);
	}

	@Override
	public void deleteArrangeVocalByArrangeNoAndVocalMemberNo(int arrangeNo,
			int vocalMemberNo) {
		arrangeVocalDao.deleteArrangeVocalByArrangeNoAndVocalMemberNo(arrangeNo, vocalMemberNo);
	}

	@Override
	public void deleteArrangeVocalByArrangeNo(int arrangeNo) {
		arrangeVocalDao.deleteArrangeVocalByArrangeNo(arrangeNo);
	}

	@Override
	public void deleteArrangeVocalByVocalMemberNo(int vocalMemberNo) {
		arrangeVocalDao.deleteArrangeVocalByVocalMemberNo(vocalMemberNo);
	}

	@Override
	public void updateArrangeVocal(ArrangeVocal arrangeVocal) {
		arrangeVocalDao.updateArrangeVocal(arrangeVocal);
	}
	
	

}
