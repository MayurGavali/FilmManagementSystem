package com.flp.fms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.flp.fms.domain.Category;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;

public interface IFilmService {

	public  List<Language> getLanguages();
	public  List<Category> getCategory();
	public void addFilm(Film film);
	public ArrayList<Film> getAllFilms();
	Boolean updateFilm(Film film);
	Boolean deleteFilm(int filmid);
	public List<Film> searchFilm(Film film);
}
