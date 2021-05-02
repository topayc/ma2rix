package com.ma2rix.music.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.LanguageDao;
import com.ma2rix.music.dao.mapper.LanguageMapper;
import com.ma2rix.music.model.domain.Language;

@Repository
public class LanguageDaoImpl implements LanguageDao{
	
	@Autowired LanguageMapper lMapper;
	
	@Override
	public int getProvidedLanguageCount() {
		return lMapper.getProvidedLanguageCount();
	}

	@Override
	public ArrayList<Language> getAllLanguages() {
		return lMapper.getAllLanguages();
	}

	@Override
	public Language getLanguageByLanguageNo(int languageNo) {
		return lMapper.getLanguageByLanguageNo(languageNo);
	}

	@Override
	public void insertLanguage(Language language) {
		lMapper.insertLanguage(language);
	}

	@Override
	public void updateLanguage(Language language) {
		lMapper.updateLanguage(language);
	}

	@Override
	public void deletelanguage(int languageNo) {
		lMapper.deletelanguage(languageNo);
	}

}
