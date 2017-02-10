package com.flp.fms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.flp.fms.dao.FilmDaoImplForList;
import com.flp.fms.dao.IFilmDao;
import com.flp.fms.domain.Category;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;

public class FilmServiceImpl implements IFilmService{

	
	private IFilmDao filmDao=new FilmDaoImplForList();

	public List<Language> getLanguages() {
		
		System.out.println(filmDao.getLanguages());

		return filmDao.getLanguages();
		
	}
public List<Category> getCategory() {
		
		System.out.println(filmDao.getCategory());

		return filmDao.getCategory();
}
	@Override
	public void addFilm(Film film) {
		
		
		filmDao.addFilm(film);
		
	}
	
	

@Override
public ArrayList<Film> getAllFilms() {
	// TODO Auto-generated method stub
	return filmDao.getAllFilms();
}


		


@Override
public Boolean deleteFilm(int filmid) {
	// TODO Auto-generated method stub
	return filmDao.deleteFilm(filmid);
}
@Override
public List<Film> searchFilm(Film film) {
	// TODO Auto-generated method stub
	return filmDao.searchFilm(film);
}

@Override
public Boolean updateFilm(Film film) {
	// TODO Auto-generated method stub
	return filmDao.updateFilm(film);
}


}


	

