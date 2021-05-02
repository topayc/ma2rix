package com.ma2rix.music.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.SponsorDao;
import com.ma2rix.music.dao.mapper.SponsorMapper;
import com.ma2rix.music.model.domain.Sponsor;

@Repository
public class SponsorDaoImpl implements SponsorDao {

	@Autowired SponsorMapper sponsorMapper;
		
	@Override
	public Sponsor getSponBySponsorNo(int sponsorNo) {
		return sponsorMapper.getSponBySponsorNo(sponsorNo) ;
	}

	@Override
	public Sponsor getSponByMemberNo(int memberNo) {
		return sponsorMapper.getSponByMemberNo(memberNo);
	}

	@Override
	public void insertSponsor(Sponsor sponsor) {
		sponsorMapper.insertSponsor(sponsor);
	}


	@Override
	public void updateSponsor(Sponsor sponsor) {
		sponsorMapper.updateSponsor(sponsor);
	}

	@Override
	public void deleteSponsor(Sponsor sponsor) {
		sponsorMapper.deleteSponsor(sponsor);
	}

}
