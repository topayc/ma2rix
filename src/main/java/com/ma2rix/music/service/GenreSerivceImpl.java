package com.ma2rix.music.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma2rix.music.dao.interfaces.GenreDao;
import com.ma2rix.music.model.domain.Genre;
import com.ma2rix.music.service.interfaces.GenreService;

@Service
public class GenreSerivceImpl implements GenreService {
	
	
	@Autowired
	private GenreDao genreDao;
	
	@Override
	public ArrayList<Genre> getAllGenres() {
		return genreDao.getAllGenres();
	}

	@Override
	public Genre getGenreByGenreNo(int genreNo) {
		return genreDao.getGenreByGenreNo(genreNo);
	}

	@Override
	public void insertGenre(Genre genre) {
		genreDao.insertGenre(genre);
	}

	@Override
	public void updateGenre(Genre genre) {
		genreDao.updateGenre(genre);
	}

	@Override
	public void deleteGenre(int genreNo) {
		genreDao.deleteGenre(genreNo);
	}

	@Override
	public int getGenreCount() {
		return genreDao.getGenreCount();
	}
	
}
