package com.flp.fms.view;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.fms.domain.Actor;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;
import com.flp.fms.service.FilmServiceImpl;
import com.flp.fms.service.IFilmService;

/**
 * Servlet implementation class SearchCoreServlet
 */
public class SearchCoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IFilmService filmService=new FilmServiceImpl();
		Film film=new Film();
		if(request.getParameter("byId")!="")
			film.setFilm_id(Integer.parseInt(request.getParameter("byId")));
		if(request.getParameter("byRating")!="")
			film.setRatings(Integer.parseInt(request.getParameter("byRating")));
		if(request.getParameter("byTitle")!="")
			film.setTitle(request.getParameter("byTitle"));
		if(request.getParameter("releasedate")!="")
			film.setReleaseYear(new Date (request.getParameter("releasedate")));	
		List<Actor>actors=new ArrayList<Actor>();
		if(Integer.parseInt(request.getParameter("byActor"))>0)
		{
			Actor actor=new Actor();
			actor.setActor_Id(Integer.parseInt(request.getParameter("byActor")));
			actors.add(actor);
			film.setActors(actors);
		}
	
	
		List<Language> languages=new ArrayList<>();
		if(Integer.parseInt(request.getParameter("byLanguage"))>0)
		{
			Language language=new Language();
			language.setLanguage_Id(Integer.parseInt(request.getParameter("byLanguage")));
			languages.add(language);
			film.setLanguages(languages);
		}
		
		List<Film> films=filmService.searchFilm(film);
		PrintWriter out=response.getWriter();
		if(films.isEmpty())
		{	out.println("<html>");
			out.println("<h2> Results Not found!<h2>");
			out.println("</html>");
		}
		else{
		out.println("<html>");
		out.println("<head>"
				+"<link rel='stylesheet' type='text/css' href='CSS_Style/Styles.css'>"
				+ "</head>"
				+ "<body>"
				+ "<div style='margin-left:500px;'>  </div>"
				+ "<table border=1>"
				+ "<tr>"
				+ "<th> Film Id </th>"
				+ "<th> Name </th>"
				+ "<th>	Description	</th>"
				+ "<th>	Release Year	</th>"
				+ "<th>	Original Language	</th>"
				+ "<th>	Rental Duration	</th>"
				+ "<th> Other Lanugages"
				+ "<th> Actors"
				+ "<th>	Length	</th>"
				+ "<th>	Replacement Cost	</th>"
				+ "<th>	Category	</th>"
				+ "</tr>");
		
			
			for(Film film1:films){
				out.println("<tr>");
				out.println("<td>"+film1.getFilm_id()+"</td>");
				out.println("<td>"+film1.getTitle()+"</td>");
				out.println("<td>"+film1.getDescription()+"</td>");
				out.println("<td>"+film1.getReleaseYear()+"</td>");
				out.println("<td>"+film1.getOriginalLanguage().getLanguageName()+"</td>");
				out.println("<td>"+film1.getRentalDuration()+"</td>");
				List<Language>langs=new ArrayList<>();
				langs=film1.getLanguages();
				out.println("<td>");
				for(Language lang:langs)
					out.println(lang.getLanguageName());
				out.println("</td>");
				
				List<Actor> actors2=new ArrayList<>();
				
			
				actors2=film1.getActors();
				out.println("<td>");
				for(Actor act:actors2)
					out.println(act.getFirstName()+" "+act.getLastName());
				out.println("</td>");
				out.println("<td>"+film1.getLength()+"</td>");
				out.println("<td>"+film1.getReplacement()+"</td>");
				out.println("<td>"+film1.getCategory().getcategory_name()+"</td>");
				out.println("</tr>");
			}
				out.println("</table></body>");
	
				out.println("</html>");
			}
		
		
		
		
	}

}
