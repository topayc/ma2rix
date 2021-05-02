package com.ma2rix.music.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ma2rix.music.dao.interfaces.SponsorDao;
import com.ma2rix.music.model.domain.Sponsor;
import com.ma2rix.music.service.interfaces.SponsorService;

public class SponsorServiceImpl implements SponsorService {

	@Autowired SponsorDao sposorDao; 
	
	@Override
	public Sponsor getSponBySponsorNo(int sponsorNo) {
		return sposorDao.getSponBySponsorNo(sponsorNo);
	}

	@Override
	public Sponsor getSponByMemberNo(int memberNo) {
		return sposorDao.getSponByMemberNo(memberNo);
	}

	@Override
	public void insertSponsor(Sponsor sponsor) {
		sposorDao.insertSponsor(sponsor);
	}

	@Override
	public void deleteSponsor(Sponsor sponsor) {
		sposorDao.deleteSponsor(sponsor);
	}

	@Override
	public void updateSponsor(Sponsor sponsor) {
		sposorDao.updateSponsor(sponsor);
	}

}
