package com.ma2rix.music.service.interfaces;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.ma2rix.music.model.domain.SongWriting;

@Transactional
public interface SongWritingService {
	public int getWritingCount();
	public ArrayList<SongWriting> getAllWritings();
	public SongWriting getWritingByWriteNo(int writeNo);
	public SongWriting getWritingsByWrieteMemberNo(int writeMemberNo);
	public void insertWriting(SongWriting songWriting);
	public void updateWriting(SongWriting songWriting);
	public void deleteWriting(int writeNo);
	public void delelteWritingsByWriteMemberNo(int writeMemberNo);
}
