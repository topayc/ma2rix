package com.ma2rix.music.service.interfaces;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.ma2rix.music.model.domain.Genre;

@Transactional
public interface GenreService {
	
	public int getGenreCount();
	public ArrayList<Genre> getAllGenres();
	public Genre getGenreByGenreNo(int genreNo);
	public void insertGenre(Genre genre);
	public void updateGenre(Genre genre);
	public void deleteGenre(int genreNo);
}
