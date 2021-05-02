package com.ma2rix.music.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.ComposeArrangerDao;
import com.ma2rix.music.dao.mapper.ComposeArrangerMapper;
import com.ma2rix.music.model.domain.ComposeArranger;

@Repository
public class ComposeArrangerDaoImpl implements ComposeArrangerDao {

	
	@Autowired ComposeArrangerMapper caMapper;
	
	@Override
	public int getComposeArrangeCount() {
		return caMapper.getComposeArrangeCount();
	}

	@Override
	public ArrayList<ComposeArranger> getAllComposeArrnagerList() {
		return caMapper.getAllComposeArrnagerList();
	}

	@Override
	public ComposeArranger getComposeArrangeByComposeNo(int composeNo) {
		return caMapper.getComposeArrangeByComposeNo(composeNo);
	}

	@Override
	public ComposeArranger getComposeArrangeByArrangeMemberNo(int memberNo) {
		return caMapper.getComposeArrangeByArrangeMemberNo(memberNo);
	}

	@Override
	public ComposeArranger getComposeArrangeByNo(int composeNo,
			int arrangeMemberNo) {
		return caMapper.getComposeArrangeByNo(composeNo, arrangeMemberNo);
	}

	@Override
	public void insertComposeArranger(ComposeArranger composeArranger) {
		caMapper.insertComposeArranger(composeArranger);
	}

	@Override
	public void deleteComposeArrangerlByNo(int composeNo, int arrangeMemberNo) {
		caMapper.deleteComposeArrangerlByNo(composeNo, arrangeMemberNo);
	}

	@Override
	public void deleteComposeArrangeByComposeNo(int composeNo) {
		caMapper.deleteComposeArrangeByComposeNo(composeNo);
	}

	@Override
	public void deleteComposeArrangeByArrangeMemgerNo(int arrangeMemberNo) {
		caMapper.deleteComposeArrangeByArrangeMemgerNo(arrangeMemberNo);
	}

	@Override
	public void updateComposeArrange(ComposeArranger composeArranger) {
		caMapper.updateComposeArrange(composeArranger);
	}

}
