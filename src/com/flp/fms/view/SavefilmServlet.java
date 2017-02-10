package com.flp.fms.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.fms.domain.Actor;
import com.flp.fms.domain.Category;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;
import com.flp.fms.service.FilmServiceImpl;
import com.flp.fms.service.IFilmService;

/**
 * Servlet implementation class SaveFilmServlet
 */
public class SavefilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		
		
		IFilmService loginService=new FilmServiceImpl();
		
		Film film=new Film();
		
		Language lang=new Language(); 
		
		
		film.setTitle(request.getParameter("filmtitle"));
		film.setDescription(request.getParameter("filmdescription"));
		film.setLength(Integer.parseInt(request.getParameter("filmlength")));
		
		lang.setLanguage_Id(Integer.parseInt(request.getParameter("orgLang")));
		film.setOriginalLanguage(lang);
		
		ArrayList<Language> languages=new ArrayList<>();
		String[] str=request.getParameterValues("othLang");
		for(String str1:str){
			Language lang1=new Language();  
			lang1.setLanguage_Id(Integer.parseInt(str1));
			languages.add(lang1);
		}
		film.setLanguages(languages);
		
		film.setRatings(Integer.parseInt(request.getParameter("rating")));
		
		
		film.setReplacement(Double.parseDouble(request.getParameter("replacementcost")));
		film.setReleaseYear(new Date(request.getParameter("releasedate")));
		
		film.setRentalDuration(new Date(request.getParameter("rentalduration")));
		
		film.setSpecialFeatures(request.getParameter("specialfeature"));
		
	
		
		 List<Actor> actors=new ArrayList<>();
	
		String[] str3=request.getParameterValues("actor");
		for(String str1:str3){
			Actor actor1=new Actor(); 
			actor1.setActor_Id(Integer.parseInt(str1));
			actors.add(actor1);
		}
		film.setActors(actors);
		
		Category cat1=new Category();
		cat1.setCategory_Id(Integer.parseInt(request.getParameter("category")));
		film.setCategory(cat1);
		
		
	
		
		loginService.addFilm(film);
	}


}		


