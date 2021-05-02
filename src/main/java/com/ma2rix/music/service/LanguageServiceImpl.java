package com.ma2rix.music.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma2rix.music.dao.interfaces.LanguageDao;
import com.ma2rix.music.model.domain.Language;
import com.ma2rix.music.service.interfaces.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService {
	@Autowired LanguageDao lDao;
	
	@Override
	public int getProvidedLanguageCount() {
		return lDao.getProvidedLanguageCount();
	}

	@Override
	public ArrayList<Language> getAllLanguages() {
		return lDao.getAllLanguages();
	}

	@Override
	public Language getLanguageByLanguageNo(int languageNo) {
		return lDao.getLanguageByLanguageNo(languageNo);
	}

	@Override
	public void insertLanguage(Language language) {
		lDao.insertLanguage(language);
	}

	@Override
	public void updateLanguage(Language language) {
		lDao.updateLanguage(language);
	}

	@Override
	public void deletelanguage(int languageNo) {
		lDao.deletelanguage(languageNo);
	}
}
