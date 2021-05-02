package com.ma2rix.music.dao.mapper;

import java.util.ArrayList;

import com.ma2rix.music.model.domain.SongWriting;

public interface SongWritingMapper {
	public int getWritingCount();
	public ArrayList<SongWriting> getAllWritings();
	public SongWriting getWritingByWriteNo(int writeNo);
	public SongWriting getWritingsByWriteMemberNo(int writeMemberNo);
	public void insertWriting(SongWriting songWriting);
	public void updateWriting(SongWriting songWriting);
	public void deleteWriting(int writeNo);
	public void delelteWritingsByWriteMemberNo(int writeMemberNo);
	
}
