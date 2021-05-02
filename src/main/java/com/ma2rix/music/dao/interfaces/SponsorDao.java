package com.ma2rix.music.dao.interfaces;

import com.ma2rix.music.model.domain.Sponsor;

public interface SponsorDao {
	public Sponsor getSponBySponsorNo(int sponsorNo);
	public Sponsor getSponByMemberNo(int memberNo);

	public void insertSponsor(Sponsor sponsor);
	public void deleteSponsor(Sponsor sponsor);
	public void updateSponsor(Sponsor sponsor);
	
	
}
