package com.ma2rix.music.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import com.ma2rix.music.dao.interfaces.SongWritingDao;
import com.ma2rix.music.model.domain.SongWriting;

public class SongWritingServiceImpl  implements SongWritingDao{
	
	@Autowired SongWritingDao writingDao;
	@Override
	public int getWritingCount() {
		return writingDao.getWritingCount();
	}

	@Override
	public ArrayList<SongWriting> getAllWritings() {
		return writingDao.getAllWritings();
	}

	@Override
	public SongWriting getWritingByWriteNo(int writeNo) {
		return writingDao.getWritingByWriteNo(writeNo);
	}

	@Override
	public SongWriting getWritingsByWriteMemberNo(int writeMemberNo) {
		return writingDao.getWritingsByWriteMemberNo(writeMemberNo);
	}

	@Override
	public void insertWriting(SongWriting songWriting) {
		writingDao.insertWriting(songWriting);
	}

	@Override
	public void updateWriting(SongWriting songWriting) {
		writingDao.updateWriting(songWriting);
	}

	@Override
	public void deleteWriting(int writeNo) {
		writingDao.deleteWriting(writeNo);
	}

	@Override
	public void delelteWritingsByWriteMemberNo(int writeMemberNo) {
		writingDao.delelteWritingsByWriteMemberNo(writeMemberNo);
	}
}
