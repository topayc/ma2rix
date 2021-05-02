package com.ma2rix.music.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.ArrangeVocalDao;
import com.ma2rix.music.dao.mapper.ArrangeVocalMapper;
import com.ma2rix.music.model.command.ArrangeVocalCommand;
import com.ma2rix.music.model.domain.ArrangeVocal;


@Repository
public class ArrangeVocalDaoImpl implements ArrangeVocalDao {

	@Autowired ArrangeVocalMapper arrangeVocalMapper;

	@Override
	public int getArrangeVocalCount() {
		return arrangeVocalMapper.getArrangeVocalCount();
	}

	@Override
	public ArrayList<ArrangeVocal> getAllArrangeVocalList() {
		return arrangeVocalMapper.getAllArrangeVocalList();
	}

	@Override
	public ArrayList<ArrangeVocalCommand> getAllArrangeVocalCommandList() {
		return arrangeVocalMapper.getAllArrangeVocalCommandList();
	}

	@Override
	public ArrayList<ArrangeVocalCommand> getArrangeVocalCommandsByArrangeNo(
			int arrangeNo) {
		return arrangeVocalMapper.getArrangeVocalCommandsByArrangeNo(arrangeNo);
	}

	@Override
	public ArrangeVocalCommand getArrangeVocalCommandByArrangeNoAndVocalMemberNo(
			int arrangeNo, int vocalMemberNo) {
		return arrangeVocalMapper.getArrangeVocalCommandByArrangeNoAndVocalMemberNo(arrangeNo, vocalMemberNo);
	}

	@Override
	public ArrangeVocal getArrangeVocalByArrangeNoAndVocalMemberNo(
			int arrangeNo, int vocalMemberNo) {
		return arrangeVocalMapper.getArrangeVocalByArrangeNoAndVocalMemberNo(arrangeNo, vocalMemberNo);
	}

	@Override
	public ArrayList<ArrangeVocal> getArrangeVocalByArrangeNo(int arrangeNo) {
		return arrangeVocalMapper.getArrangeVocalByArrangeNo(arrangeNo);
	}

	@Override
	public ArrangeVocal getArrangeVocalByVocalMemberNo(int vocalMemberNo) {
		return arrangeVocalMapper.getArrangeVocalByVocalMemberNo(vocalMemberNo);
	}

	@Override
	public void insertArrangeVocal(ArrangeVocal arrangeVocal) {
		arrangeVocalMapper.insertArrangeVocal(arrangeVocal);
	}

	@Override
	public void deleteArrangeVocalByArrangeNoAndVocalMemberNo(int arrangeNo,
			int vocalMemberNo) {
		arrangeVocalMapper.deleteArrangeVocalByArrangeNoAndVocalMemberNo(arrangeNo, vocalMemberNo);
	}

	@Override
	public void deleteArrangeVocalByArrangeNo(int arrangeNo) {
		arrangeVocalMapper.deleteArrangeVocalByArrangeNo(arrangeNo);
	}

	@Override
	public void deleteArrangeVocalByVocalMemberNo(int vocalMemberNo) {
		arrangeVocalMapper.deleteArrangeVocalByVocalMemberNo(vocalMemberNo);
	}

	@Override
	public void updateArrangeVocal(ArrangeVocal arrangeVocal) {
		arrangeVocalMapper.updateArrangeVocal(arrangeVocal);
	}
	
	

}
