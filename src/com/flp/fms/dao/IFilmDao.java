package com.flp.fms.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.flp.fms.domain.Category;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;

public interface IFilmDao {

	public List<Language> getLanguages();
	public List<Category> getCategory();
	
	
	public ArrayList<Film> getAllFilms();
	public List<Film> searchFilm(Film film);
	public Boolean deleteFilm(int filmid);
	void addFilm(Film film);
	Boolean updateFilm(Film film);
	
}
