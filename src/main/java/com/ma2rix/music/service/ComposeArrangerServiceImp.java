package com.ma2rix.music.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma2rix.music.dao.interfaces.ComposeArrangerDao;
import com.ma2rix.music.model.domain.ComposeArranger;
import com.ma2rix.music.service.interfaces.ComposeArrangerService;

@Service
public class ComposeArrangerServiceImp implements ComposeArrangerService {

	@Autowired ComposeArrangerDao caDao;
	
	@Override
	public int getComposeArrangeCount() {
		return caDao.getComposeArrangeCount();
	}

	@Override
	public ArrayList<ComposeArranger> getAllComposeArrnagerList() {
		return caDao.getAllComposeArrnagerList();
	}

	@Override
	public ComposeArranger getComposeArrangeByComposeNo(int composeNo) {
		return caDao.getComposeArrangeByComposeNo(composeNo);
	}

	@Override
	public ComposeArranger getComposeArrangeByArrangeMemberNo(int memberNo) {
		return caDao.getComposeArrangeByArrangeMemberNo(memberNo);
	}

	@Override
	public ComposeArranger getComposeArrangeByNo(int composeNo,
			int arrangeMemberNo) {
		return caDao.getComposeArrangeByNo(composeNo, arrangeMemberNo);
	}

	@Override
	public void insertComposeArranger(ComposeArranger composeArranger) {
		caDao.insertComposeArranger(composeArranger);
	}

	@Override
	public void deleteComposeArrangerlByNo(int composeNo, int arrangeMemberNo) {
		caDao.deleteComposeArrangerlByNo(composeNo, arrangeMemberNo);
	}

	@Override
	public void deleteComposeArrangeByComposeNo(int composeNo) {
		caDao.deleteComposeArrangeByComposeNo(composeNo);
	}

	@Override
	public void deleteComposeArrangeByArrangeMemgerNo(int arrangeMemberNo) {
		caDao.deleteComposeArrangeByArrangeMemgerNo(arrangeMemberNo);
	}

	@Override
	public void updateComposeArrange(ComposeArranger composeArranger) {
		caDao.updateComposeArrange(composeArranger);
	}
}
