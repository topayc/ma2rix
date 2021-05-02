package com.ma2rix.music.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.GenreDao;
import com.ma2rix.music.dao.mapper.GenreMapper;
import com.ma2rix.music.model.domain.Genre;

@Repository
public class GenreDaoImpl implements GenreDao {

	@Autowired
	private GenreMapper genreMapper;
	
	@Override
	public ArrayList<Genre> getAllGenres() {
		return genreMapper.getAllGenres();
	}

	@Override
	public Genre getGenreByGenreNo(int genreNo) {
		return genreMapper.getGenreByGenreNo(genreNo);
	}

	@Override
	public void insertGenre(Genre genre) {
		genreMapper.insertGenre(genre);
	}

	@Override
	public void updateGenre(Genre genre) {
		genreMapper.updateGenre(genre);
	}

	@Override
	public void deleteGenre(int genreNo) {
		genreMapper.deleteGenre(genreNo);
	}

	@Override
	public int getGenreCount() {
		return genreMapper.getGenreCount();
	}
}
