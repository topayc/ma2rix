package com.ma2rix.music.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ma2rix.music.model.domain.PerformPlayer;

public interface PerformPlayerMapper {
	public int getPerformPlayerCount();
	public ArrayList<PerformPlayer> getPerformPlayersByPlayerMemberNo(int playerMemberNo);
	public ArrayList<PerformPlayer> getPerformPlayersByPerformNo(int performNo);
	public PerformPlayer getPerformPlayersByPerformNoAndPlayerMemberNo(
			@Param("performNo") int performNo,
			@Param("playerMemberNo") int playerMemberNo);
	public void insertPerformPlayer(PerformPlayer performPlayer);
	public void updatePerformPlayer(PerformPlayer performPlayer);
	public void deletePerformPlayer(
			@Param("performNo") int performNo,
			@Param("playerMemberNo") int playerMemberNo);
	
}
