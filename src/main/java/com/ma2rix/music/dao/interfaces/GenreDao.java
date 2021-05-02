package com.ma2rix.music.dao.interfaces;

import java.util.ArrayList;

import com.ma2rix.music.model.domain.Genre;

public interface GenreDao {
	
	public int getGenreCount();
	public ArrayList<Genre> getAllGenres();
	public Genre getGenreByGenreNo(int genreNo);
	public void insertGenre(Genre genre);
	public void updateGenre(Genre genre);
	public void deleteGenre(int genreNo);
}
