package com.ma2rix.music.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.SongWritingDao;
import com.ma2rix.music.dao.mapper.SongWritingMapper;
import com.ma2rix.music.model.domain.SongWriting;

@Repository
public class SongWritingDaoImpl implements SongWritingDao {
	
	@Autowired SongWritingMapper writingMapper;
	
	@Override
	public int getWritingCount() {
		return writingMapper.getWritingCount();
	}

	@Override
	public ArrayList<SongWriting> getAllWritings() {
		return writingMapper.getAllWritings();
	}

	@Override
	public SongWriting getWritingByWriteNo(int writeNo) {
		return writingMapper.getWritingByWriteNo(writeNo);
	}

	@Override
	public SongWriting getWritingsByWriteMemberNo(int writeMemberNo) {
		return writingMapper.getWritingsByWriteMemberNo(writeMemberNo);
	}

	@Override
	public void insertWriting(SongWriting songWriting) {
		writingMapper.insertWriting(songWriting);
	}

	@Override
	public void updateWriting(SongWriting songWriting) {
		writingMapper.updateWriting(songWriting);
	}

	@Override
	public void deleteWriting(int writeNo) {
		writingMapper.deleteWriting(writeNo);
	}

	@Override
	public void delelteWritingsByWriteMemberNo(int writeMemberNo) {
		writingMapper.delelteWritingsByWriteMemberNo(writeMemberNo);
	}
}
