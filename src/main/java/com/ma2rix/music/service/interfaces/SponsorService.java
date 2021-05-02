package com.ma2rix.music.service.interfaces;

import org.springframework.transaction.annotation.Transactional;

import com.ma2rix.music.model.domain.Sponsor;

@Transactional
public interface SponsorService {
	public Sponsor getSponBySponsorNo(int SponsorNo);
	public Sponsor getSponByMemberNo(int memberNo);

	public void insertSponsor(Sponsor sponsor);
	public void deleteSponsor(Sponsor sponsor);
	public void updateSponsor(Sponsor sponsor);
}
