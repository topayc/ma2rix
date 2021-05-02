package com.ma2rix.music.dao.interfaces;

import java.util.ArrayList;

import com.ma2rix.music.model.domain.Language;

public interface LanguageDao {
	public int getProvidedLanguageCount();
	public ArrayList<Language> getAllLanguages();
	public Language getLanguageByLanguageNo(int languageNo);
	public void insertLanguage(Language language);
	public void updateLanguage(Language language);
	public void deletelanguage(int languageNo);
}
