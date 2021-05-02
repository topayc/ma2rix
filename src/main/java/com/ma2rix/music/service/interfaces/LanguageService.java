package com.ma2rix.music.service.interfaces;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.ma2rix.music.model.domain.Language;

@Transactional
public interface LanguageService {
	public int getProvidedLanguageCount();
	public ArrayList<Language> getAllLanguages();
	public Language getLanguageByLanguageNo(int languageNo);
	public void insertLanguage(Language language);
	public void updateLanguage(Language language);
	public void deletelanguage(int languageNo);
}
