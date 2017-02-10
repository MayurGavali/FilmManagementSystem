package com.flp.fms.view;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
 * Servlet implementation class UpdatingServlet
 */
public class UpdatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IFilmService filmService=new FilmServiceImpl();
		Film film1=new Film();
		film1.setFilm_id(Integer.parseInt(request.getParameter("filmid")));
		film1.setTitle(request.getParameter("filmtitle"));
		film1.setDescription(request.getParameter("filmdescription"));
		System.out.println(request.getParameter("releasedate"));
		Date date=new Date(request.getParameter("releasedate"));
		film1.setReleaseYear(date);	
		film1.setRentalDuration(new Date(request.getParameter("rentaldate")));
		film1.setLength(Integer.parseInt(request.getParameter("filmduration")));
		String [] actrlist=request.getParameterValues("actors");
		List<Actor> actrs=new ArrayList<>();
		for(String act:actrlist)
		{
			Actor actor1=new Actor();
			actor1.setActor_Id(Integer.parseInt(act));
			actrs.add(actor1);
		}
		//Set actrs=request.getParameter("actors");
		film1.setActors(actrs);
		Double fees=Double.parseDouble(request.getParameter("filmreplacementcost"));
		film1.setReplacement(fees);
		film1.setRatings(Integer.parseInt(request.getParameter("rating")));
		film1.setSpecialFeatures(request.getParameter("filmspecialfeatures"));
		Language lang=new Language();
		lang.setLanguage_Id(Integer.parseInt(request.getParameter("language")));
		film1.setOriginalLanguage(lang);
		String [] langlist=request.getParameterValues("languages");
		List<Language> langags=new ArrayList<>();
		for(String lang1:langlist)
		{
			Language langs=new Language();
			langs.setLanguage_Id(Integer.parseInt(lang1));
			langags.add(langs);
		}
		film1.setLanguages(langags);
	    Category cat=new Category();
		cat.setCategory_Id(Integer.parseInt(request.getParameter("category")));
		film1.setCategory(cat);	
		Boolean flag=filmService.updateFilm(film1);
		
	}

	

}
